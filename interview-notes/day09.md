# Day 9 – Recursion & Backtracking (Interview Notes)

# Topic 1: What is a Subsequence?

## Definition

A subsequence is a sequence obtained by deleting zero or more elements from an array **without changing the order** of the remaining elements.

Example:

```text
Array: [1,2,3]

Subsequences:
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

For an array of size **n**, the total number of subsequences is:

```text
2^n
```

Reason:

Each element has exactly **2 choices**:

* Include
* Exclude

Total combinations:

```text
2 × 2 × 2 × ... × 2 = 2^n
```

---

# Topic 2: Backtracking

## Definition

Backtracking is a recursive technique where we:

1. Make a choice.
2. Explore that choice recursively.
3. Undo the choice.
4. Explore the next choice.

Template:

```java
Choose

Recursive Call

Undo Choice

Recursive Call
```

Example:

```java
current.add(arr[index]);

find(...);

current.remove(current.size()-1);

find(...);
```

---

# Topic 3: Decision Tree

Every recursion call represents a decision.

For every element:

```text
Take

OR

Don't Take
```

Example:

```text
            []
          /    \
       Take1   Skip1
      /   \      /   \
   Take2 Skip2 Take2 Skip2
```

Every path from root to leaf represents one subsequence.

---

# Topic 4: Why Print at the Base Case?

Wrong Thinking:

```text
Print after every recursive call.
```

Correct Thinking:

Print only after decisions for **all elements** have been made.

Base Case:

```java
if(index == arr.length){
    print();
    return;
}
```

Reason:

Only at the leaf node is one complete subsequence formed.

---

# Topic 5: Backtracking

Suppose:

```text
subarr = []
```

Include:

```text
[1]
```

Include:

```text
[1,2]
```

Explore completely.

Undo:

```text
[1]
```

Explore remaining branch.

Undo:

```text
[]
```

Rule:

Whenever you write

```java
add()
```

you should immediately think

```java
remove()
```

---

# Topic 6: Print All Subsequences

Pattern:

```java
Base Case

↓

Include

↓

Recursive Call

↓

Backtrack

↓

Exclude

↓

Recursive Call
```

Time Complexity:

```text
O(2^n)
```

Auxiliary Space:

```text
O(n)
```

---

# Topic 7: Print Subsequences With Sum = K

Maintain a running sum.

Instead of recalculating the sum at every leaf, pass it as a parameter.

```java
find(arr, k, index, currentList, currentSum)
```

Include:

```java
currentSum + arr[index]
```

Exclude:

```java
currentSum
```

Base Case:

```java
if(index == arr.length){

    if(currentSum == k)
        print();

    return;
}
```

Advantages:

* No repeated sum calculation.
* Cleaner recursion.
* Better time complexity.

---

# Topic 8: Pruning

Applicable only when **all array elements are positive**.

Rule:

```java
if(currentSum > k)
    return;
```

Reason:

Positive numbers can only increase the sum.

If negative numbers are allowed:

Do NOT prune.

Example:

```text
5 + (-2) + (-3) = 0
```

Pruning would incorrectly remove this solution.

---

# Topic 9: currentSum vs target

Two equivalent approaches.

Approach 1:

Maintain

```text
currentSum
```

Include:

```java
currentSum + arr[i]
```

Goal:

```text
currentSum == k
```

---

Approach 2:

Maintain

```text
target
```

Include:

```java
target - arr[i]
```

Goal:

```text
target == 0
```

Both are mathematically equivalent.

---

# Topic 10: Print Only One Valid Subsequence

Return Type:

```java
boolean
```

Base Case:

```java
if(index == arr.length){

    if(currentSum == k){
        print();
        return true;
    }

    return false;
}
```

After Include:

```java
if(find(...))
    return true;
```

If found,

Stop exploring.

This avoids traversing the remaining recursion tree.

---

# Topic 11: Count Subsequences

Return Type:

```java
int
```

Base Case:

```java
if(index == arr.length){

    return currentSum == k ? 1 : 0;
}
```

Recursive Calls:

```java
int include = find(...);

int exclude = find(...);

return include + exclude;
```

Meaning:

Every recursive call returns

"How many valid subsequences did I find?"

---

# Topic 12: Mutable vs Primitive

Primitive:

```java
int currentSum
```

Each recursive call gets its own copy.

No backtracking required.

Object:

```java
ArrayList<Integer>
```

Shared by all recursive calls.

Must backtrack.

```java
add()

↓

remove()
```

---

# Topic 13: Interview Variations

### Print All

Return Type:

```text
void
```

---

### Print One

Return Type:

```text
boolean
```

Return early when found.

---

### Count All

Return Type:

```text
int
```

Return

```java
include + exclude
```

---

### Store All

Return Type:

```text
void
```

Store in

```java
List<List<Integer>>
```

instead of printing.

---

# Topic 14: Distinct Subsequences

Two interpretations:

### Count by Index

Example:

```text
[1,1,1]
```

Target:

```text
2
```

Answers:

```text
Index (0,1)

Index (0,2)

Index (1,2)
```

Count:

```text
3
```

---

### Count by Value

```text
[1,1]
```

appears three times,

but values are identical.

Answer:

```text
1
```

Duplicate handling generally requires:

* Sorting
* Skipping duplicate branches

or

* Using a HashSet

---

# Topic 15: Time Complexity

Generating all subsequences:

```text
O(2^n)
```

Printing all subsequences:

```text
O(n × 2^n)
```

Reason:

Each printed subsequence may contain up to n elements.

Auxiliary Space:

```text
O(n)
```

(Call stack + current subsequence)

---

# Day 9 Master Pattern

```java
Base Case

↓

Choose (Include)

↓

Recursive Call

↓

Undo Choice

↓

Choose (Exclude)

↓

Recursive Call
```

This exact pattern is reused in:

* Subsets
* Combination Sum
* Combination Sum II
* Permutations
* N-Queens
* Sudoku Solver
* Word Search

Learn the pattern once, and adapt it to different interview problems by changing:

* The base case
* The return type (`void`, `boolean`, `int`)
* The state you carry (`currentSum`, `target`, `path`, etc.)
