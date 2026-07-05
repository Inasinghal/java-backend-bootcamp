Absolutely. Since your target is **Java Backend Developer (6 YOE)**, your notes should contain **interview-quality answers**, not one-liners.

Below is the **complete Array Interview Notes (Part 1)** that I recommend you keep. We'll add to these notes as we progress through the Array module.

---

# Java Arrays Interview Notes

---

## 1. What is an Array?

**Answer:**

An array is a **fixed-size, index-based data structure** that stores multiple elements of the **same data type** in **contiguous memory locations**.

Example:

```java
int[] numbers = {10, 20, 30, 40};
```

### Key Characteristics

* Fixed size
* Same data type
* Contiguous memory
* Index starts from 0
* Fast random access

---

## 2. Why do we need Arrays?

Without arrays:

```java
int a = 10;
int b = 20;
int c = 30;
```

For thousands of values, this becomes unmanageable.

Arrays allow us to:

* Store multiple values under one variable.
* Iterate easily.
* Apply algorithms efficiently.

---

## 3. Why are Arrays Fixed Size?

Memory for the entire array is allocated when the array is created.

Example:

```java
int[] arr = new int[5];
```

The JVM allocates memory for exactly five integers.

Since the memory block is contiguous, its size cannot be expanded later.

---

## 4. Why do Arrays store only one data type?

Because every element occupies the same amount of memory.

Example:

```java
int[]
```

Every integer occupies 4 bytes.

This allows the JVM to calculate the address of any element directly.

Mixed data types would require different memory layouts, making direct indexing impossible.

---

## 5. Why does Array Indexing start from 0?

The JVM calculates an element's address using:

```text
Address = Base Address + (Index × Size of Element)
```

For the first element:

```text
Base + (0 × Size)
```

No offset is needed.

Starting from 0 simplifies address calculation and improves performance.

---

## 6. What is Contiguous Memory?

Contiguous memory means all array elements are stored in consecutive memory locations.

Example:

```text
1000
1004
1008
1012
```

This enables constant-time access.

---

## 7. Why is Array Access O(1)?

The JVM computes the memory address directly instead of searching.

Formula:

```text
Base Address + (Index × Size)
```

No iteration is required.

---

## 8. Where are Arrays stored?

The **array object** is stored in the **Heap**.

The **reference variable** is stored where it is declared.

Example:

```java
int[] arr = new int[5];
```

Memory:

```text
Stack                Heap

arr  ----------->   Array Object
```

---

## 9. Are Arrays Objects?

Yes.

Arrays are objects created using the `new` keyword.

Example:

```java
int[] arr = new int[5];
```

Arrays inherit from `Object`.

They have properties like:

```java
arr.length
```

---

## 10. What are the Default Values?

| Type    | Default Value |
| ------- | ------------- |
| int     | 0             |
| double  | 0.0           |
| float   | 0.0f          |
| boolean | false         |
| char    | '\u0000'      |
| String  | null          |
| Object  | null          |

---

## 11. What happens when an invalid index is accessed?

Example:

```java
arr[10];
```

The JVM throws:

```text
ArrayIndexOutOfBoundsException
```

because the index is outside the valid range.

---

## 12. What is the valid index range?

```
0
```

to

```
length - 1
```

Example:

```java
int[] arr = new int[5];
```

Valid:

```
0–4
```

---

## 13. What is the difference between `length` and `length()`?

### Array

```java
arr.length
```

`length` is a field provided by the JVM.

---

### String

```java
str.length()
```

`length()` is a method of the `String` class.

---

## 14. Why is `length` a field but `String.length()` a method?

Arrays are built into the Java language and managed directly by the JVM, so their size is exposed as a field.

`String` is a regular Java class, so it exposes its size through a method.

---

## 15. Can Arrays store Objects?

Yes.

Example:

```java
Student[] students = new Student[10];
```

Each element stores a reference to a `Student` object.

---

## 16. Can Arrays store Primitive Types?

Yes.

Example:

```java
int[]
double[]
char[]
boolean[]
```

Arrays can store both primitives and object references.

---

## 17. Difference between Primitive Array and Object Array

Primitive:

```java
int[] arr;
```

Stores actual values.

---

Object:

```java
Student[] students;
```

Stores references to objects.

---

## 18. Are Arrays Mutable?

Yes.

Example:

```java
arr[0] = 100;
```

The contents can be modified.

However,

```java
arr = new int[10];
```

creates a completely new array object.

---

## 19. How many objects are created?

Example:

```java
int[] arr = new int[5];
```

Only **one array object** is created.

The integers inside are elements, not separate objects.

---

## 20. What does an Array Variable store?

Example:

```java
int[] arr = {1,2,3};
```

The variable stores a **reference** to the array object.

It does **not** store the elements directly.

---

## 21. What happens here?

```java
int[] a = {10,20};

int[] b = a;
```

Both variables refer to the same array object.

Changing one affects the other.

---

## 22. Predict the Output

```java
int[] a = {10,20};

int[] b = a;

b[0] = 100;

System.out.println(a[0]);
```

Output:

```
100
```

Reason:

Both references point to the same array.

---

## 23. Predict the Output

```java
int[] a = {10,20};

int[] b = a;

b = new int[]{1,2};

System.out.println(a[0]);
```

Output:

```
10
```

Reason:

`b` now points to a new array.

`a` still points to the original array.

---

## 24. How are Arrays passed to Methods?

Java is **pass-by-value**.

When an array is passed, the **reference value** is copied.

Both references point to the same array object.

---

## 25. Is Java Pass-by-Reference?

No.

Java is always **pass-by-value**.

For objects and arrays, the value being copied is the reference.

---

## 26. Can Arrays grow dynamically?

No.

Their size is fixed once created.

Use `ArrayList` if dynamic resizing is needed.

---

## 27. Difference between Arrays and ArrayList

| Arrays                         | ArrayList                                           |
| ------------------------------ | --------------------------------------------------- |
| Fixed size                     | Dynamic size                                        |
| Stores primitives and objects  | Stores objects (use wrapper classes for primitives) |
| Faster                         | Slightly slower due to resizing and object overhead |
| Built into Java                | Part of Collections Framework                       |
| No built-in add/remove methods | Rich API (`add`, `remove`, `contains`, etc.)        |

---

## 28. Time Complexities

| Operation                    | Complexity |
| ---------------------------- | ---------- |
| Access                       | O(1)       |
| Update                       | O(1)       |
| Traverse                     | O(n)       |
| Linear Search                | O(n)       |
| Binary Search (sorted array) | O(log n)   |
| Find Max/Min                 | O(n)       |
| Reverse                      | O(n)       |

---

## 29. Why are Arrays faster than Linked Lists for random access?

Arrays store elements in contiguous memory, allowing direct address calculation.

Linked Lists require traversing nodes sequentially.

Therefore:

* Array access → O(1)
* Linked List access → O(n)

---

## 30. Common Array Exceptions

* `ArrayIndexOutOfBoundsException`
* `NegativeArraySizeException`
* `NullPointerException` (when the array reference is `null`)

---

# ⭐ Must-Remember Interview Points

* Arrays are **objects** in Java.
* Arrays are stored in the **Heap**.
* Local array references are stored on the **Stack**.
* Arrays are **fixed-size**.
* Arrays use **contiguous memory**.
* Array indexing starts from **0**.
* Java is **always pass-by-value**.
* Passing an array copies the **reference value**, not the array itself.
* Array access is **O(1)** due to direct address calculation.
* `length` is a **field**, not a method.
* Arrays can store **both primitive values and object references**.

Excellent idea. These notes will become your **Java Interview Handbook**. By December, you'll have a single document containing 500+ interview questions.

Below are **all the important Array Traversal & Operations interview questions with interview-ready answers**.

---

# Java Arrays - Module 2 Interview Questions & Answers

---

## 1. What is array traversal?

**Answer:**

Array traversal is the process of visiting every element of an array exactly once to perform operations such as searching, counting, updating, or calculating values.

Example:

```java
int[] arr = {10,20,30};

for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
```

---

## 2. Why is array traversal O(n)?

Because every element is visited exactly once.

If an array contains **n** elements, the loop executes **n** times.

Therefore:

**Time Complexity = O(n)**

---

## 3. Which loops can be used to traverse an array?

* `for`
* Enhanced `for`
* `while`
* `do-while`

The `for` loop is the most commonly used.

---

## 4. Difference between `for` and enhanced `for` loop?

| for Loop                          | Enhanced for Loop       |
| --------------------------------- | ----------------------- |
| Has index                         | No index                |
| Can modify array elements         | Mainly used for reading |
| Can traverse forward and backward | Forward only            |
| More flexible                     | Simpler and cleaner     |

---

## 5. When should you use an enhanced `for` loop?

Use it when:

* You only need to read elements.
* The index is not required.
* You want cleaner, more readable code.

Example:

```java
for(int num : arr){
    System.out.println(num);
}
```

---

## 6. Can an enhanced `for` loop modify array elements?

No.

Example:

```java
int[] arr = {10,20,30};

for(int num : arr){
    num = 100;
}
```

Output:

```text
[10,20,30]
```

`num` is a copy of each element, so modifying it does not change the array.

---

## 7. How do you modify array elements?

Use an indexed loop.

```java
for(int i=0;i<arr.length;i++){
    arr[i] *= 2;
}
```

---

## 8. Why do we use `i < arr.length`?

The valid indices are:

```text
0 to length - 1
```

Using

```java
i <= arr.length
```

tries to access an invalid index and throws an exception.

---

## 9. What exception occurs if you use `i <= arr.length`?

```text
ArrayIndexOutOfBoundsException
```

---

## 10. Why do arrays start at index 0?

Because the JVM calculates the memory address using:

```text
Address = Base Address + (Index × Size of Element)
```

The first element has an offset of `0`, making address calculation simple and efficient.

---

## 11. How do you calculate the sum of an array?

```java
int sum = 0;

for(int num : arr){
    sum += num;
}
```

Time Complexity:

```text
O(n)
```

---

## 12. How do you calculate the average?

```java
double average = (double)sum / arr.length;
```

Type casting is necessary to preserve decimal values.

---

## 13. Why is type casting required while calculating average?

Without casting:

```java
5 / 2
```

Output:

```text
2
```

With casting:

```java
(double)5 / 2
```

Output:

```text
2.5
```

Casting forces floating-point division.

---

## 14. How do you find the maximum element?

```java
int max = arr[0];

for(int num : arr){
    if(num > max){
        max = num;
    }
}
```

---

## 15. Why should `max` be initialized with `arr[0]`?

Because it works correctly for:

* Positive numbers
* Negative numbers
* Mixed values

Initializing with `0` fails for arrays containing only negative numbers.

---

## 16. How do you find the minimum element?

```java
int min = arr[0];

for(int num : arr){
    if(num < min){
        min = num;
    }
}
```

---

## 17. How do you count even numbers?

```java
int count = 0;

for(int num : arr){
    if(num % 2 == 0)
        count++;
}
```

---

## 18. How do you count odd numbers?

```java
if(num % 2 != 0)
```

---

## 19. How do you count positive numbers?

```java
if(num > 0)
```

---

## 20. How do you count negative numbers?

```java
if(num < 0)
```

---

## 21. How do you count zeros?

```java
if(num == 0)
```

---

## 22. How do you count the frequency of an element?

```java
int count = 0;

for(int num : arr){
    if(num == target)
        count++;
}
```

Time Complexity:

```text
O(n)
```

---

## 23. Can arrays be traversed in reverse?

Yes.

```java
for(int i=arr.length-1;i>=0;i--){
    System.out.println(arr[i]);
}
```

---

## 24. What is the time complexity of reverse traversal?

```text
O(n)
```

---

## 25. Can an array have size 0?

Yes.

```java
int[] arr = new int[0];
```

It creates an empty array.

Output:

```java
System.out.println(arr.length);
```

```
0
```

---

## 26. Can an array have a negative size?

No.

Example:

```java
int[] arr = new int[-5];
```

Throws:

```text
NegativeArraySizeException
```

---

## 27. Does `arr.length` change?

No.

Array size is fixed after creation.

---

## 28. What does `arr.length` return?

The total number of elements the array can hold.

Example:

```java
int[] arr = new int[10];
```

```
arr.length = 10
```

---

## 29. Difference between

```java
int[] arr = new int[5];
```

and

```java
int[] arr = {0,0,0,0,0};
```

Both create an array of length 5 with all elements initialized to 0.

Difference:

* `new int[5]` uses default initialization by the JVM.
* `{0,0,0,0,0}` explicitly provides the values.

---

## 30. What happens when you print an array directly?

```java
int[] arr = new int[5];

System.out.println(arr);
```

Output:

```text
[I@6d06d69c
```

Explanation:

* `[I` means an array of `int`.
* `@` separates the type from the hash code.
* The hexadecimal value is the object's hash code representation, **not** the memory address.

To print contents:

```java
System.out.println(Arrays.toString(arr));
```

---

## 31. Which is faster: `for` or enhanced `for`?

For arrays, the performance difference is negligible.

Choose:

* `for` when you need the index or want to modify elements.
* Enhanced `for` for readability when only reading values.

---

## 32. Can `int[]` store `null`?

No.

```java
int[] arr = new int[5];

arr[0] = null;
```

Compilation error.

Primitive types cannot hold `null`.

---

## 33. Can `String[]` store `null`?

Yes.

```java
String[] names = new String[3];
```

Initially:

```text
[null, null, null]
```

You can also assign:

```java
names[0] = null;
```

---

## 34. What is the default value of an `int[]`?

```text
0
```

---

## 35. What is the default value of a `boolean[]`?

```text
false
```

---

## 36. What is the default value of a `char[]`?

```text
'\u0000'
```

---

## 37. What is the default value of a `String[]`?

```text
null
```

---

## 38. If an array has one million elements but only ten are used, is memory allocated for all one million elements?

Yes.

```java
int[] arr = new int[1000000];
```

The JVM allocates memory for all one million elements immediately.

Arrays are fixed-size and contiguous in memory.

---

## 39. Can an enhanced `for` loop traverse backwards?

No.

It always traverses from the first element to the last.

Use an indexed `for` loop for reverse traversal.

---

## 40. Why is enhanced `for` loop called "enhanced"?

Because it simplifies iteration by automatically visiting each element without requiring an index variable.

---

# ⭐ Quick Revision (Must Remember)

* Array traversal = visiting every element once.
* Traversal complexity = **O(n)**.
* Access by index = **O(1)**.
* Use `for` when you need indexes or modifications.
* Use enhanced `for` for read-only iteration.
* Arrays are fixed-size.
* Arrays can have size `0`.
* Negative size throws `NegativeArraySizeException`.
* Valid indices: `0` to `length - 1`.
* Arrays of primitive types cannot store `null`.
* Arrays of object references can store `null`.
* `arr.length` is a field and never changes.
* Printing an array directly prints its type and hash code representation, not its contents.
* Use `Arrays.toString()` to print array contents.
* The JVM allocates memory for the entire array when it is created.


# Java Searching (Linear Search) – Interview Notes

These are concise, interview-ready answers that you can revise before interviews.

---

# 1. What is Searching?

**Answer:**

Searching is the process of finding whether a target element exists in a collection (such as an array, list, tree, or database) and, if it exists, determining its position.

---

# 2. What is Linear Search?

**Answer:**

Linear Search is a sequential searching algorithm that checks each element one by one until the target is found or the end of the collection is reached.

---

# 3. How does Linear Search work?

**Answer:**

It starts from the first element and compares each element with the target.

* If found, it returns the index.
* If the entire array is traversed and the element is not found, it returns `-1`.

---

# 4. Why is Linear Search O(n)?

**Answer:**

In the worst case, every element is compared with the target exactly once. Therefore, the number of comparisons grows linearly with the number of elements (n), resulting in **O(n)** time complexity.

---

# 5. What is the best-case time complexity?

**Answer:**

**O(1)**

When the target is found at the first index.

---

# 6. What is the worst-case time complexity?

**Answer:**

**O(n)**

When:

* The target is the last element, or
* The target does not exist.

---

# 7. What is the average-case time complexity?

**Answer:**

**O(n)**

On average, about half of the elements are checked, but the complexity remains linear.

---

# 8. What is the space complexity?

**Answer:**

**O(1)**

Only a few variables are used, and no additional data structure is required.

---

# 9. Why do we return `-1`?

**Answer:**

Array indices start from `0`, so `-1` can never be a valid index. It is conventionally used to indicate that the element was not found.

---

# 10. Can Linear Search work on an unsorted array?

**Answer:**

Yes.

Linear Search checks every element one by one, so the array does not need to be sorted.

---

# 11. Can Binary Search work on an unsorted array?

**Answer:**

No.

Binary Search requires the array to be sorted because it eliminates half of the search space after each comparison.

---

# 12. What happens if there are duplicate elements?

**Answer:**

It depends on the implementation.

* The basic implementation returns the first matching element.
* If we continue searching after a match, we can find all occurrences.

---

# 13. Can Linear Search find the first occurrence?

**Answer:**

Yes.

The standard implementation naturally returns the first occurrence because it stops at the first match.

---

# 14. Can Linear Search find all occurrences?

**Answer:**

Yes.

Instead of returning immediately, continue traversing the array and record every matching index.

---

# 15. Why do we use `.equals()` for Strings instead of `==`?

**Answer:**

`==` compares object references (memory addresses), whereas `.equals()` compares the actual contents of the String. Therefore, String values should always be compared using `.equals()`.

---

# 16. Is Linear Search a stable algorithm?

**Answer:**

Stability is a property of **sorting algorithms**, not searching algorithms. Therefore, Linear Search is generally not described as stable or unstable.

---

# 17. Can Linear Search be implemented recursively?

**Answer:**

Yes.

Linear Search can be implemented recursively by checking one element in each recursive call until the target is found or the array ends.

However, the iterative approach is preferred because it avoids recursive overhead and uses constant stack space.

---

# 18. Can Linear Search be faster than Binary Search?

**Answer:**

Yes.

If the target is the first element, Linear Search finds it in one comparison (**O(1)**), whereas Binary Search may require more comparisons.

However, Binary Search is much faster on average and in the worst case for sorted arrays.

---

# 19. Which search algorithm should you choose?

**Answer:**

* **Sorted Array:** Binary Search
* **Unsorted Array:** Linear Search

Binary Search requires sorted data, while Linear Search works regardless of order.

---

# 20. Difference between Searching and Sorting?

| Searching                  | Sorting                               |
| -------------------------- | ------------------------------------- |
| Finds an element           | Arranges elements in a specific order |
| Returns existence or index | Reorders the collection               |
| Example: Linear Search     | Example: Bubble Sort, Merge Sort      |

---

# 21. If an array contains one million elements and the target is the first element, what is the time complexity?

**Answer:**

**O(1)**

Time complexity depends on the number of operations performed, not on the input size.

---

# 22. Can Binary Search have O(1) time complexity?

**Answer:**

Yes.

If the target is already at the middle index during the first comparison, Binary Search completes in **O(1)** time.

---

# 23. Should you always use Binary Search for a sorted array?

**Answer:**

No.

For very small arrays, Linear Search may be simpler and equally efficient because the overhead of Binary Search may not provide any practical benefit.

For large sorted datasets, Binary Search is preferred.

---

# 24. What is the difference between Searching and Lookup?

| Searching                                       | Lookup                                                  |
| ----------------------------------------------- | ------------------------------------------------------- |
| Finds an element by checking possible locations | Directly accesses an element using a known key or index |
| May require multiple comparisons                | Usually O(1)                                            |
| Example: Linear Search                          | Example: `arr[index]`, `HashMap.get(key)`               |

---

# 25. Does Binary Search guarantee finding the first occurrence of a duplicate element?

**Answer:**

No.

The standard Binary Search returns any matching occurrence.

To find the first or last occurrence, the algorithm must be modified.

---

# 26. Which search algorithm would you choose for different input sizes?

| Dataset                   | Recommended Algorithm | Reason                                        |
| ------------------------- | --------------------- | --------------------------------------------- |
| 10 elements               | Linear Search         | Simpler and negligible performance difference |
| 100 sorted elements       | Binary Search         | Faster than Linear Search                     |
| 1,000,000 sorted elements | Binary Search         | O(log n) is significantly faster than O(n)    |

---

# 27. What are the advantages of Linear Search?

**Answer:**

* Simple to implement.
* Works on both sorted and unsorted arrays.
* No preprocessing or sorting required.
* Suitable for small datasets.

---

# 28. What are the disadvantages of Linear Search?

**Answer:**

* Inefficient for large datasets.
* Worst-case time complexity is O(n).
* Slower than Binary Search on sorted data.

---

# 29. When should you use Linear Search?

**Answer:**

Use Linear Search when:

* The data is unsorted.
* The dataset is small.
* Simplicity is more important than performance.
* The collection changes frequently, making sorting impractical.

---

# 30. When should you avoid Linear Search?

**Answer:**

Avoid Linear Search when:

* The dataset is very large.
* The data is already sorted.
* Fast repeated searches are required.

In such cases, Binary Search or hashing-based structures are usually better choices.

---

# ⭐ Quick Revision (Must Remember)

* Searching = Finding an element and its position.
* Linear Search checks elements sequentially.
* Works on both sorted and unsorted arrays.
* Best Case: **O(1)**
* Average Case: **O(n)**
* Worst Case: **O(n)**
* Space Complexity: **O(1)**
* Returns `-1` if the element is not found.
* Standard implementation returns the **first occurrence**.
* Can be implemented iteratively or recursively.
* `.equals()` compares String contents; `==` compares references.
* Binary Search requires sorted data.
* Linear Search is ideal for small or unsorted datasets.

# Module 3.2 – Binary Search Interview Notes (Complete)

These are interview-ready notes that you can revise before Java Backend interviews.

---

# 1. What is Binary Search?

**Answer:**

Binary Search is an efficient searching algorithm that works on **sorted data**. It follows the **Divide and Conquer** approach by repeatedly dividing the search space into two halves until the target element is found or the search space becomes empty.

---

# 2. Why is Binary Search faster than Linear Search?

**Answer:**

Binary Search is faster because it eliminates half of the remaining search space after every comparison. Therefore, its worst-case time complexity is **O(log n)**, whereas Linear Search may need to examine every element, resulting in **O(n)** time complexity.

---

# 3. What is the prerequisite for Binary Search?

**Answer:**

The array (or collection) must be **sorted**.

---

# 4. Why must the array be sorted?

**Answer:**

The array must be sorted so that after comparing the middle element with the target, we can determine which half cannot contain the target and safely discard it. Without sorting, we cannot decide which half to eliminate.

---

# 5. What is Divide and Conquer?

**Answer:**

Divide and Conquer is an algorithmic technique where a problem is repeatedly divided into smaller subproblems until the solution is found.

In Binary Search:

* Divide → Split the search space into two halves.
* Conquer → Continue searching only in the relevant half.

---

# 6. Why do we use `low` and `high`?

**Answer:**

`low` and `high` represent the current search boundaries.

After every comparison, these boundaries are updated to reduce the search space.

Example:

```text
low = 0
high = 8
```

After one iteration:

```text
low = 5
high = 8
```

Now Binary Search only searches between indices 5 and 8.

---

# 7. Why do we calculate the middle index?

**Answer:**

The middle index is calculated so that we can compare the target with the middle element and eliminate half of the remaining search space in every iteration.

---

# 8. Why do we use `while(low <= high)` instead of `while(low < high)`?

**Answer:**

Using `low <= high` ensures that the last remaining element is also checked.

If we use `low < high`, then a single-element search space would never be examined.

---

# 9. What is the best-case time complexity?

**Answer:**

**O(1)**

When the target is already the middle element.

---

# 10. What is the average-case time complexity?

**Answer:**

**O(log n)**

On average, Binary Search eliminates half of the search space at every step.

---

# 11. What is the worst-case time complexity?

**Answer:**

**O(log n)**

Even in the worst case, Binary Search keeps halving the remaining search space.

---

# 12. Why is the worst case O(log n)?

**Answer:**

Each comparison reduces the search space by half.

The number of times a collection of size `n` can be divided by 2 until only one element remains is `log₂(n)`.

Therefore, the worst-case complexity is **O(log n)**.

---

# 13. What is the space complexity?

### Iterative Binary Search

**O(1)**

Only three variables are used:

* low
* high
* mid

---

### Recursive Binary Search

**O(log n)**

Because each recursive call is stored on the call stack.

---

# 14. Can Binary Search work on a descending sorted array?

**Answer:**

Yes.

The comparison logic changes because the array is sorted in descending order.

---

# 15. What happens if the element is not found?

**Answer:**

The loop terminates when:

```java
low > high
```

The algorithm returns:

```java
-1
```

to indicate that the element does not exist.

---

# 16. What are the advantages of Binary Search?

**Answer:**

* Very fast for large datasets.
* Worst-case time complexity is **O(log n)**.
* Eliminates half of the search space in every iteration.
* Uses constant extra memory in the iterative implementation.

---

# 17. What are the disadvantages of Binary Search?

**Answer:**

* Requires sorted data.
* Sorting itself may take additional time.
* Not suitable for linked lists because they do not support efficient random access.

---

# 18. Why is Binary Search not suitable for Linked Lists?

**Answer:**

Binary Search requires direct access to the middle element.

Arrays support random access in **O(1)** time.

Linked Lists require traversal from the head node to reach the middle element, which takes **O(n)** time.

Therefore, Binary Search loses its efficiency on linked lists.

---

# 19. What is random access?

**Answer:**

Random access means accessing any element directly using its index in constant time.

Example:

```java
arr[5]
```

takes **O(1)** time.

Arrays and `ArrayList` support random access.

Linked Lists do not.

---

# 20. If an array has 1024 elements, what is the maximum number of comparisons?

**Answer:**

**10 comparisons**

Because:

```text
2¹⁰ = 1024
```

---

# 21. If an array has 1,000,000 elements, approximately how many comparisons are required?

**Answer:**

Approximately **20 comparisons**.

Because:

```text
2²⁰ = 1,048,576
```

---

# 22. Can Binary Search find the first occurrence of duplicate elements?

**Answer:**

No.

The standard Binary Search returns any matching occurrence.

To find the first occurrence, the algorithm must be modified.

---

# 23. Can Binary Search find the last occurrence?

**Answer:**

Not using the standard implementation.

A modified Binary Search is required.

---

# 24. Why is Binary Search called a Divide and Conquer algorithm?

**Answer:**

Because after every comparison it divides the search space into two halves and continues searching in only one half.

---

# 25. Why is Linear Search not Divide and Conquer?

**Answer:**

Linear Search checks elements one by one sequentially.

It never reduces the search space.

---

# 26. Can Binary Search be implemented recursively?

**Answer:**

Yes.

Binary Search can be implemented both iteratively and recursively.

---

# 27. Which implementation is preferred?

**Answer:**

The iterative implementation is generally preferred because:

* It avoids recursive call overhead.
* It uses **O(1)** extra space.
* It avoids stack overflow for very large inputs.

---

# 28. What is the space complexity of recursive Binary Search?

**Answer:**

**O(log n)**

Because recursive calls are stored on the call stack.

---

# 29. Why does Binary Search require random access?

**Answer:**

Binary Search repeatedly accesses the middle element.

Random access allows direct retrieval of any index in **O(1)** time.

Without random access, finding the middle becomes inefficient.

---

# 30. Can Binary Search be used on an `ArrayList`?

**Answer:**

Yes.

`ArrayList` is backed by an array and supports random access in **O(1)** time.

---

# 31. Can Binary Search have O(1) time complexity?

**Answer:**

Yes.

If the target is already the middle element during the first comparison, Binary Search completes in one comparison.

---

# 32. Should you always use Binary Search on a sorted array?

**Answer:**

Not necessarily.

For very small arrays, Linear Search may be simpler and equally efficient because the overhead of Binary Search is not significant.

For large sorted datasets, Binary Search is preferred.

---

# 33. Why is Binary Search unsuitable for unsorted arrays?

**Answer:**

Without sorting, we cannot determine which half of the array may contain the target.

The elimination logic of Binary Search becomes invalid.

---

# 34. What is the stopping condition in Binary Search?

**Answer:**

The algorithm stops when:

* The target is found.
* Or `low > high`, indicating the element is not present.

---

# 35. What happens if we forget to update `low` or `high`?

**Answer:**

The search space does not shrink, resulting in an **infinite loop**.

---

# 36. Why do we update `low = mid + 1` instead of `low = mid`?

**Answer:**

Because `mid` has already been checked.

If we use `low = mid`, the same middle element may be checked repeatedly, leading to an infinite loop.

---

# 37. Why do we update `high = mid - 1` instead of `high = mid`?

**Answer:**

For the same reason.

The middle element has already been processed and should not be considered again.

---

# 38. Can Binary Search return multiple occurrences?

**Answer:**

No.

The standard Binary Search returns only one matching index.

To return all occurrences, additional logic or modified Binary Search is required.

---

# 39. Why is Binary Search considered efficient?

**Answer:**

Because the search space is reduced by half after every comparison, allowing it to search extremely large datasets in very few comparisons.

---

# 40. What is the safest way to calculate the middle index?

**Answer:**

Instead of:

```java
int mid = (low + high) / 2;
```

use:

```java
int mid = low + (high - low) / 2;
```

This avoids integer overflow when `low` and `high` are very large.

---

# ⭐ Quick Revision (Must Remember)

* Binary Search works **only on sorted data**.
* It follows the **Divide and Conquer** approach.
* Best Case: **O(1)**
* Average Case: **O(log n)**
* Worst Case: **O(log n)**
* Iterative Space Complexity: **O(1)**
* Recursive Space Complexity: **O(log n)**
* Uses `low`, `high`, and `mid`.
* Stop when `low > high`.
* Return `-1` if the element is not found.
* Arrays and `ArrayList` support Binary Search because they provide **O(1) random access**.
* Linked Lists are not suitable for Binary Search.
* Standard Binary Search does **not** guarantee the first or last occurrence.
* Use `low + (high - low) / 2` to avoid integer overflow.

# Most Important Interview Pattern

If an interviewer asks:
“Find the first/last occurrence of an element in a sorted array with duplicates.”

The expected thought process is:
* Use Binary Search
* When found, store index
* Move left for first occurrence
* Move right for last occurrence
* Return stored answer


First Occurrence: Save answer, move left when arr[mid] == target.
Lower Bound: Save answer, move left when arr[mid] >= target.
Upper Bound: Save answer, move left when arr[mid] > target.
Floor Algorithm: Save answer(value), move right when arr[mid] <= target
Ceil Alogirthm: same as lower bound but retruuns value

8. Search Insert Position

If target exists

Return index.

Else

Return the position where it should be inserted.

9. Rotated Sorted Array Search

Observation

One half is always sorted.

Steps

Find sorted half.

Check if target belongs there.

Search accordingly.
10. Find Minimum in Rotated Array

Observation

Minimum lies in the unsorted half.

If left half is sorted

Minimum = left element

Search right.

Else

Search left.
11. Rotation Count

Rotation count equals the index of the minimum element.

Example

4 5 6 7 1 2 3

Minimum = 1

Index = 4

Rotated 4 times.
12. Search in Rotated Array with Duplicates

Extra condition

if(nums[low] == nums[mid] && nums[mid] == nums[high]){
    low++;
    high--;
}

This removes ambiguity caused by duplicates.

Binary Search Pattern
low
high
mid

↓

Find sorted half

↓

Discard half

↓

Repeat
Binary Search Complexity Summary
Problem	Complexity
Binary Search	O(log n)
First Occurrence	O(log n)
Last Occurrence	O(log n)
Count Occurrences	O(log n)
Lower Bound	O(log n)
Upper Bound	O(log n)
Search Insert Position	O(log n)
Rotated Search	O(log n)
Find Minimum	O(log n)
Rotation Count	O(log n)