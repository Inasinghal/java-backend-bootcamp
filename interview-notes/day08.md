Excellent idea. Interview revision after every day is one of the fastest ways to retain concepts.

# 📘 Day 8 – Recursion Interview Questions & Answers

---

## 1. What is recursion?

**Answer:**

Recursion is a programming technique in which a function calls itself to solve a smaller version of the same problem until a base case is reached.

---

## 2. What are the two essential parts of every recursive function?

**Answer:**

* Base Case
* Recursive Case

Example:

```java
int factorial(int n) {
    if (n == 0) return 1;      // Base Case
    return n * factorial(n-1); // Recursive Case
}
```

---

## 3. What is a base case?

**Answer:**

The base case is the stopping condition that prevents infinite recursive calls.

---

## 4. What happens if there is no base case?

**Answer:**

The function keeps calling itself until the call stack overflows, resulting in a **StackOverflowError** in Java.

---

## 5. What is a recursive case?

**Answer:**

The recursive case is the part where the function calls itself with a smaller input.

Example:

```java
sum(n) = n + sum(n-1)
```

---

## 6. Which data structure is used internally for recursion?

**Answer:**

The **Call Stack (Stack)**.

Each recursive call creates a new stack frame.

---

## 7. What is stack unwinding?

**Answer:**

After the base case is reached, recursive calls start returning one by one. This process is called **stack unwinding**.

---

## 8. Can every recursive solution be converted into an iterative one?

**Answer:**

Yes.

Every recursive algorithm can be rewritten using loops, sometimes with an explicit stack.

---

## 9. Which is generally faster: recursion or iteration?

**Answer:**

Iteration is generally faster because recursion has function call overhead and uses additional stack memory.

---

## 10. Which error occurs due to infinite recursion?

**Answer:**

```text
StackOverflowError
```

---

# Output-Based Questions

---

## 11.

```java
void fun(int n) {
    if(n==0) return;
    System.out.print(n+" ");
    fun(n-1);
}
```

Output for `fun(5)`?

**Answer**

```text
5 4 3 2 1
```

---

## 12.

```java
void fun(int n){
    if(n==0) return;
    fun(n-1);
    System.out.print(n+" ");
}
```

Output?

**Answer**

```text
1 2 3 4 5
```

---

## 13.

```java
void fun(int n){
    if(n==0) return;

    System.out.print(n+" ");

    fun(n-1);

    System.out.print(n+" ");
}
```

Output for `fun(3)`?

**Answer**

```text
3 2 1 1 2 3
```

---

## 14.

```java
void fun(int n){
    if(n==0) return;

    System.out.println("Enter "+n);

    fun(n-1);

    System.out.println("Exit "+n);
}
```

Output for `fun(2)`?

**Answer**

```text
Enter 2
Enter 1
Exit 1
Exit 2
```

---

# Coding Questions

---

## 15. Print numbers from 1 to N recursively.

```java
void printTillN(int n){
    if(n==0) return;

    printTillN(n-1);

    System.out.print(n+" ");
}
```

---

## 16. Print numbers from N to 1 recursively.

```java
void printNos(int n){
    if(n==0) return;

    System.out.print(n+" ");

    printNos(n-1);
}
```

---

## 17. Find the sum of first N numbers recursively.

```java
int recurSum(int n){
    if(n==0) return 0;

    return n + recurSum(n-1);
}
```

---

## 18. Find factorial recursively.

```java
int factorial(int n){
    if(n==0 || n==1)
        return 1;

    return n * factorial(n-1);
}
```

---

## 19. Find the nth Fibonacci number recursively.

```java
int fib(int n){
    if(n==0) return 0;
    if(n==1) return 1;

    return fib(n-1)+fib(n-2);
}
```

---

## 20. Reverse an array recursively.

```java
void reverse(int[] arr,int i){

    int n=arr.length;

    if(i>=n-i-1)
        return;

    int temp=arr[i];
    arr[i]=arr[n-i-1];
    arr[n-i-1]=temp;

    reverse(arr,i+1);
}
```

---

## 21. Reverse a string recursively.

```java
void reverse(char[] arr,int i){

    int n=arr.length;

    if(i>=n-i-1)
        return;

    char temp=arr[i];
    arr[i]=arr[n-i-1];
    arr[n-i-1]=temp;

    reverse(arr,i+1);
}
```

---

## 22. Check if an array is sorted recursively.

```java
boolean isSortedRec(int[] arr,int i){

    if(i==arr.length-1)
        return true;

    if(arr[i]>arr[i+1])
        return false;

    return isSortedRec(arr,i+1);
}
```

---

## 23. Check if a string is a palindrome recursively.

```java
boolean isPalindromeRec(String s,int i){

    int n=s.length();

    if(i>=n-i-1)
        return true;

    if(s.charAt(i)!=s.charAt(n-i-1))
        return false;

    return isPalindromeRec(s,i+1);
}
```

---

## 24. Find the largest element recursively.

```java
int largestRec(int[] arr,int i){

    if(i==arr.length-1)
        return arr[i];

    int max=largestRec(arr,i+1);

    return Math.max(max,arr[i]);
}
```

---

# Complexity Questions

### 25. Time and Space Complexity of Factorial Recursion?

**Answer**

Time:

```text
O(n)
```

Space:

```text
O(n)
```

---

### 26. Time Complexity of Fibonacci Recursion?

**Answer**

```text
O(2ⁿ)
```

---

### 27. Why is Fibonacci recursion inefficient?

**Answer:**

Because the same subproblems are solved multiple times.

Example:

```text
fib(5)

↓

fib(4)
fib(3)

↓

fib(3) is calculated again.
fib(2) is calculated multiple times.
```

This overlapping of subproblems is why techniques like dynamic programming can optimize Fibonacci.

---

### 28. Why is recursion space complexity O(n)?

**Answer:**

Each recursive call creates a new stack frame. In the worst case, there are `n` active recursive calls on the call stack.

---

# Pattern Recognition Questions

### 29. When do we print before the recursive call?

**Answer**

When we want output from:

```text
N → 1
```

Example:

```java
print();
recurse();
```

---

### 30. When do we print after the recursive call?

**Answer**

When we want output from:

```text
1 → N
```

Example:

```java
recurse();
print();
```

---

### 31. What are the three recursion patterns you learned today?

**Answer**

1. **Work Before Recursion**

    * Example: Print N → 1

2. **Work After Recursion**

    * Example: Print 1 → N

3. **Reduce → Solve → Combine**

    * Example: Largest element, Sum, Factorial

---

# ⭐ Day 8 Cheat Sheet

| Problem         | Pattern                | Time  | Space |
| --------------- | ---------------------- | ----- | ----- |
| Print 1→N       | Work after recursion   | O(n)  | O(n)  |
| Print N→1       | Work before recursion  | O(n)  | O(n)  |
| Sum of N        | Reduce + Combine       | O(n)  | O(n)  |
| Factorial       | Reduce + Combine       | O(n)  | O(n)  |
| Fibonacci       | Two recursive calls    | O(2ⁿ) | O(n)  |
| Reverse Array   | Two pointers           | O(n)  | O(n)  |
| Reverse String  | Two pointers           | O(n)  | O(n)  |
| Check Sorted    | Compare + Move         | O(n)  | O(n)  |
| Palindrome      | Two pointers + Compare | O(n)  | O(n)  |
| Largest Element | Reduce + Combine       | O(n)  | O(n)  |

