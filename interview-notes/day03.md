# Day 3 – Interview Questions & Answers

## 1. Difference between `for`, `while`, and `do-while`

All three loops are used to execute a block of code repeatedly, but they differ in when the condition is checked and when they are most suitable.

| Feature                 | `for`                         | `while`                         | `do-while`                      |
| ----------------------- | ----------------------------- | ------------------------------- | ------------------------------- |
| Condition Check         | Before execution              | Before execution                | After execution                 |
| Executes At Least Once? | No                            | No                              | Yes                             |
| Best Used When          | Number of iterations is known | Number of iterations is unknown | Code must execute at least once |

### `for` Loop Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

### `while` Loop Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

### `do-while` Loop Example

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

**Interview Tip:**
Use `for` when the number of iterations is known. Use `while` when the stopping condition depends on runtime input. Use `do-while` when the loop body must execute at least once.

---

## 2. When should you use a `while` loop instead of a `for` loop?

Use a `while` loop when you **don't know in advance how many times the loop will execute**.

### Example 1: ATM PIN Validation

```java
while (!isPinCorrect) {
    System.out.println("Enter PIN:");
    // Read PIN
}
```

The user may enter the correct PIN on the first attempt or after several attempts.

### Example 2: Reading Until Exit

```java
while (!command.equals("exit")) {
    command = scanner.nextLine();
}
```

The number of iterations depends on user input.

**Interview Tip:** If the number of iterations is known, use `for`; otherwise, use `while`.

---

## 3. What is an Infinite Loop?

An infinite loop is a loop that **never terminates** because its condition always remains `true`.

Example:

```java
while (true) {
    System.out.println("Running...");
}
```

Another example:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

Here, `i` is never incremented, so the condition is always true.

### How to Stop an Infinite Loop?

* Change the loop condition.
* Update the loop variable correctly.
* Use a `break` statement when appropriate.

---

## 4. Difference between `break` and `continue`

### `break`

* Terminates the loop immediately.
* Control moves to the statement after the loop.

Example:

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        break;
    }
    System.out.println(i);
}
```

Output:

```
1
2
```

### `continue`

* Skips the current iteration.
* Continues with the next iteration.

Example:

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

Output:

```
1
2
4
5
```

**Interview Tip:** Think of `break` as **"stop the loop"** and `continue` as **"skip this iteration."**

---

## 5. What is a Nested Loop?

A nested loop is a loop placed inside another loop.

Example:

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 2; j++) {
        System.out.println(i + " " + j);
    }
}
```

Output:

```
1 1
1 2
2 1
2 2
3 1
3 2
```

Nested loops are commonly used for:

* Pattern printing
* Matrix operations
* 2D arrays
* Comparing every element with every other element

---

## 6. Why is Pattern Printing Asked in Interviews?

Pattern printing is **not important because companies expect you to print stars**.

It is asked because it tests:

* Logical thinking
* Understanding of nested loops
* Ability to analyze row-column relationships
* Loop control
* Problem-solving approach

For example:

```
*
**
***
****
```

To solve this, you must understand that:

* Outer loop controls rows.
* Inner loop controls columns.

Interviewers use pattern questions to evaluate your thought process rather than the pattern itself.

---

## 7. What is the Time Complexity of a Single `for` Loop?

Example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop runs `n` times.

Therefore:

```
Time Complexity = O(n)
```

where `n` is the input size.

---

## 8. What is the Time Complexity of Two Nested `for` Loops?

Example:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

Outer loop runs `n` times.

Inner loop also runs `n` times for each outer iteration.

Total operations:

```
n × n = n²
```

Therefore:

```
Time Complexity = O(n²)
```

**Interview Tip:** Nested loops are not always `O(n²)`. The complexity depends on how many times the inner loop runs.

---

## 9. Can a `for` Loop Be Written Without Initialization or Update?

Yes.

All three parts of a `for` loop are optional.

Example:

```java
int i = 1;

for (; i <= 5;) {
    System.out.println(i);
    i++;
}
```

You can even write:

```java
for (;;) {
    System.out.println("Infinite Loop");
}
```

This is equivalent to:

```java
while (true) {
    System.out.println("Infinite Loop");
}
```

**Interview Tip:** Although valid, omitting parts of the `for` loop can reduce readability. Use it only when it improves clarity.

---

## 10. Does a `do-while` Loop Always Execute at Least Once? Why?

Yes.

A `do-while` loop executes its body first and checks the condition afterward.

Example:

```java
int i = 10;

do {
    System.out.println("Hello");
} while (i < 5);
```

Output:

```
Hello
```

Although the condition is false, the loop body executes once because the condition is evaluated after the first iteration.

**Interview Tip:** This is the key difference between `while` and `do-while`.


# Day 3 – Advanced Interview Questions & Answers

---

# 1. What happens if you forget to increment the loop variable?

If the loop variable is never updated, the loop condition may never become false, resulting in an **infinite loop**.

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

### Output

```text
1
1
1
1
1
...
```

The loop never ends because `i` always remains `1`.

### Correct Version

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

### Interview Tip

Always ensure that the loop variable moves toward making the loop condition false.

---

# 2. Can `break` be used outside a loop?

**No.**

The `break` statement can only be used inside:

* `for`
* `while`
* `do-while`
* `switch`

If you write:

```java
break;
```

outside these constructs, the program will not compile.

Example:

```java
public class Demo {

    public static void main(String[] args) {

        break;   // Compile-time Error

    }
}
```

Compiler Error:

```text
break outside switch or loop
```

### Interview Tip

`break` transfers control out of the nearest enclosing loop or switch statement.

---

# 3. Can `continue` be used inside a `switch` statement?

### It depends.

`continue` **cannot** be used in a standalone `switch`.

Example:

```java
switch (day) {

    case 1:
        continue;   // Compile-time Error
}
```

Compiler Error:

```text
continue outside of loop
```

However, if the `switch` is inside a loop, `continue` is perfectly valid.

Example:

```java
for (int i = 1; i <= 5; i++) {

    switch (i) {

        case 3:
            continue;

        default:
            System.out.println(i);
    }
}
```

Output:

```text
1
2
4
5
```

Here, `continue` affects the **loop**, not the `switch`.

### Interview Tip

* `break` can exit a `switch`.
* `continue` only works with loops.

---

# 4. Is a nested loop always `O(n²)`?

**No.**

The time complexity depends on how many times the inner loop executes.

### Example 1

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
    }
}
```

Outer loop: `n`

Inner loop: `n`

Total:

```text
O(n²)
```

---

### Example 2

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 5; j++) {
    }
}
```

Inner loop runs only 5 times.

Total:

```text
n × 5 = O(n)
```

---

### Example 3

```java
for (int i = 1; i < n; i *= 2) {
}
```

Runs:

```text
1
2
4
8
16
...
```

Time Complexity:

```text
O(log n)
```

### Interview Tip

Never assume nested loops are automatically `O(n²)`. Analyze the number of iterations.

---

# 5. Which loop is the fastest: `for`, `while`, or `do-while`?

In most Java programs, there is **no meaningful performance difference** between them.

The Java compiler and the JVM optimize all three effectively.

Choose the loop based on readability and the problem:

* `for` → Known number of iterations.
* `while` → Unknown number of iterations.
* `do-while` → Must execute at least once.

### Interview Tip

The correct answer is **"There is generally no significant performance difference; choose the loop that best expresses the logic."**

---

# 6. What is the difference between `for (;;)` and `while(true)`?

Both create an infinite loop.

### Example

```java
for (;;) {
    System.out.println("Hello");
}
```

and

```java
while (true) {
    System.out.println("Hello");
}
```

Both run forever unless interrupted with a `break`, `return`, exception, or program termination.

### Differences

| `for (;;)`                                                       | `while(true)`                                      |
| ---------------------------------------------------------------- | -------------------------------------------------- |
| Infinite loop with omitted initialization, condition, and update | Infinite loop with a condition that is always true |
| More compact                                                     | Easier to read                                     |
| Common in low-level or legacy code                               | Preferred in modern Java code                      |

### Interview Tip

Functionally, they are equivalent. Most Java developers prefer `while(true)` because it is more readable.

---

# 7. Can you have multiple initialization and update expressions in a `for` loop?

**Yes.**

Separate them with commas.

Example:

```java
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println(i + " " + j);
}
```

Output:

```text
0 10
1 9
2 8
3 7
4 6
```

### Explanation

Initialization:

```java
int i = 0, j = 10;
```

Update:

```java
i++, j--;
```

Both variables are updated after each iteration.

### Interview Tip

Multiple variables are useful when traversing from both ends of an array, such as in reversing an array or checking if a string is a palindrome.
