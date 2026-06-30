# Day 2 – Interview Questions & Answers

## 1. Difference between `==` and `=`

The `=` operator is the **assignment operator**. It assigns the value on the right-hand side to the variable on the left-hand side.

Example:

```java
int age = 25;
```

Here, `25` is assigned to the variable `age`.

The `==` operator is the **equality operator**. It compares two values and returns a boolean (`true` or `false`).

Example:

```java
int a = 10;
int b = 10;

System.out.println(a == b); // true
```

For primitive types, `==` compares the actual values.

For objects, `==` compares whether both references point to the same object in memory, not whether the contents are equal.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
```

**Interview Tip:** For objects, use `.equals()` when comparing contents.

---

## 2. Difference between `&&` and `&`

Both operators can work with boolean values, but they behave differently.

### `&&` (Logical AND)

* Uses **short-circuit evaluation**.
* If the first condition is `false`, Java does not evaluate the second condition because the result will always be `false`.

Example:

```java
if (age > 18 && isVerified) {
    System.out.println("Eligible");
}
```

### `&` (Bitwise AND / Non-Short-Circuit AND)

* When used with integers, it performs a **bitwise AND**.
* When used with booleans, it evaluates **both conditions**, even if the first one is `false`.

Example:

```java
boolean result = false & checkDatabase();
```

Here, `checkDatabase()` will still execute.

**Interview Tip:** In conditional statements, prefer `&&` because it is more efficient and avoids unnecessary evaluations.

---

## 3. Difference between `||` and `|`

### `||` (Logical OR)

* Uses short-circuit evaluation.
* If the first condition is `true`, Java skips evaluating the second condition because the overall result is already known.

Example:

```java
if (isAdmin || hasPermission) {
    System.out.println("Access Granted");
}
```

### `|` (Bitwise OR / Non-Short-Circuit OR)

* Performs a bitwise OR for integers.
* For booleans, it evaluates **both conditions**, regardless of the first condition's result.

**Interview Tip:** Use `||` in most conditional logic. Use `|` mainly when working with bitwise operations or when you intentionally need both expressions to be evaluated.

---

## 4. What is Short-Circuit Evaluation?

Short-circuit evaluation is an optimization used by the `&&` and `||` operators.

For `&&`:

* If the first condition is `false`, the second condition is not evaluated because the final result can never be `true`.

Example:

```java
if (false && expensiveMethod()) {
}
```

`expensiveMethod()` is never called.

For `||`:

* If the first condition is `true`, the second condition is skipped because the final result is already `true`.

Example:

```java
if (true || expensiveMethod()) {
}
```

Again, `expensiveMethod()` is not executed.

This improves performance and helps prevent errors such as `NullPointerException`.

Example:

```java
if (name != null && name.length() > 5) {
    System.out.println("Valid");
}
```

If `name` is `null`, Java never evaluates `name.length()`, avoiding an exception.

---

## 5. Difference between Pre-Increment and Post-Increment

### Pre-Increment (`++x`)

The variable is incremented **before** its value is used.

Example:

```java
int x = 5;

System.out.println(++x);
```

Output:

```text
6
```

### Post-Increment (`x++`)

The current value is used first, and then the variable is incremented.

Example:

```java
int x = 5;

System.out.println(x++);
```

Output:

```text
5
```

After execution:

```java
System.out.println(x);
```

Output:

```text
6
```

**Interview Tip:** Avoid using `++` inside complex expressions because it can reduce readability.

---

## 6. Why does Integer Division Remove Decimals?

When both operands are integers, Java performs integer division.

Any fractional part is discarded (truncated), not rounded.

Example:

```java
System.out.println(10 / 3);
```

Output:

```text
3
```

To obtain a decimal result, at least one operand must be a floating-point type.

Example:

```java
System.out.println(10.0 / 3);
```

Output:

```text
3.3333333333333335
```

or

```java
System.out.println((double) 10 / 3);
```

---

## 7. What is Operator Precedence?

Operator precedence determines the order in which operators are evaluated in an expression.

Example:

```java
int result = 5 + 2 * 3;
```

Multiplication has higher precedence than addition.

So Java evaluates:

```text
2 * 3 = 6
```

Then:

```text
5 + 6 = 11
```

To change the order, use parentheses.

Example:

```java
int result = (5 + 2) * 3;
```

Output:

```text
21
```

**Interview Tip:** Even if you know the precedence, use parentheses when it improves readability.

---

## 8. Difference between `next()` and `nextLine()`

### `next()`

* Reads only a single word.
* Stops reading when it encounters whitespace (space, tab, or newline).

Example:

Input:

```text
Ayush Srivastava
```

```java
String name = scanner.next();
```

Output:

```text
Ayush
```

### `nextLine()`

* Reads the entire line, including spaces, until the Enter key is pressed.

Example:

Input:

```text
Ayush Srivastava
```

```java
String name = scanner.nextLine();
```

Output:

```text
Ayush Srivastava
```

**Common Pitfall:**

```java
scanner.nextInt();
scanner.nextLine();
```

The `nextLine()` may read the leftover newline from `nextInt()`.

Solution:

```java
scanner.nextInt();
scanner.nextLine(); // Consume leftover newline
String name = scanner.nextLine();
```

---

## 9. When should you use `switch` instead of `if-else`?

Use `switch` when you need to compare a single variable against multiple fixed values.

Example:

```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Invalid");
}
```

Use `if-else` when:

* Comparing ranges (e.g., marks > 90).
* Combining multiple conditions.
* Using logical operators (`&&`, `||`).

Example:

```java
if (marks >= 90) {
    grade = "A";
} else if (marks >= 80) {
    grade = "B";
}
```

**Interview Tip:** Prefer `switch` for fixed-value comparisons because it is often cleaner and easier to maintain.

---

## 10. Explain Modern Switch Expressions in Java

Java introduced enhanced switch expressions to make `switch` more concise and expressive.

Instead of using `case`, `break`, and mutable variables, modern switch uses the `->` syntax.

Example:

```java
int day = 2;

String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Invalid Day";
};

System.out.println(result);
```

### Advantages

* No need for `break`.
* Less boilerplate code.
* Can return a value directly.
* Reduces the risk of accidental fall-through.
* Easier to read and maintain.

Modern switch expressions are recommended in Java 14 and later, including Java 21.


Day 2 – Advanced Interview Follow-up Questions
1. Why is .equals() preferred over == for Strings?

The == operator compares references (memory addresses), while the .equals() method compares the actual contents of the objects.

Example 1
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
Why?

Here, new String() creates two different objects in memory.

s1 ─────► "Java"

s2 ─────► "Java"

Although both objects contain the same text, they have different memory addresses.

Therefore:

s1 == s2

returns false because the references are different.

However,

s1.equals(s2)

returns true because the characters inside both strings are identical.

Example 2 (String Pool)
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);

Output

true

Both variables point to the same String object stored in the String Pool.

Interview Tip

For Strings, always use .equals() when comparing text.

Use == only when you intentionally want to check whether two references point to the exact same object.

2. What is Bitwise AND (&) and where is it used?

The bitwise AND operator works on the binary representation of numbers.

Rule:

1 & 1 = 1

1 & 0 = 0

0 & 1 = 0

0 & 0 = 0

Example

int a = 5;
int b = 3;

System.out.println(a & b);

Binary:

5 = 101

3 = 011

-----------
    001

Output

1
Real-world Uses

Bitwise operators are commonly used in:

Permission flags
Encryption algorithms
Image processing
Network programming
Device drivers
Performance-critical applications
Boolean Example
boolean result = false & checkDatabase();

Even though the first condition is false, checkDatabase() will still execute because & does not short-circuit.

3. Can Short-Circuit Evaluation Prevent a NullPointerException?

Yes.

This is one of the biggest practical advantages of &&.

Example

String name = null;

if (name != null && name.length() > 3) {

    System.out.println("Valid");
}
What Happens?

Java evaluates from left to right.

Step 1

name != null

Result:

false

Since the first condition is false, Java never evaluates

name.length()

Therefore:

No NullPointerException occurs.

What if we use &?
if (name != null & name.length() > 3)

Now Java evaluates both conditions.

name.length()

throws

NullPointerException
Interview Tip

This is why && is preferred in conditional statements.

4. Why does 10 / 3 give 3, but 10 / 3.0 gives 3.333...?

Java decides the type of division based on the operand types.

Integer Division
10 / 3

Both operands are integers.

Output

3

The decimal part is discarded.

Floating Point Division
10 / 3.0

Now one operand is a double.

Java promotes the integer to double.

10.0 / 3.0

Output

3.3333333333333335
Another Example
(double)10 / 3

Output

3.3333333333333335
Interview Tip

Whenever one operand is a floating-point type (float or double), Java performs floating-point division.

5. What is Switch Fall-through, and How Do Modern Switch Expressions Avoid It?
   Classic Switch
   int day = 1;

switch(day){

case 1:

    System.out.println("Monday");

case 2:

    System.out.println("Tuesday");

default:

    System.out.println("Invalid");
}

Output

Monday

Tuesday

Invalid

Why?

There are no break statements.

Execution continues into the next case.

This behavior is called fall-through.

Correct Classic Switch
switch(day){

case 1:

    System.out.println("Monday");

    break;

case 2:

    System.out.println("Tuesday");

    break;

default:

    System.out.println("Invalid");
}

Output

Monday
Modern Switch
String result = switch(day){

case 1 -> "Monday";

case 2 -> "Tuesday";

default -> "Invalid";
};

Advantages

No break
No fall-through
Cleaner syntax
Can return a value
Less error-prone

Modern switch expressions are recommended in Java 21.

6. What is the Difference Between next(), nextLine(), and nextInt()?
   next()

Reads only one word.

Example

Input

Ayush Srivastava
String name = scanner.next();

Output

Ayush

Stops at the first space.

nextLine()

Reads the complete line.

Input

Ayush Srivastava

Output

Ayush Srivastava
nextInt()

Reads only an integer.

Example

Input

25

Output

25
Most Common Interview Question

Why does this fail?

Scanner sc = new Scanner(System.in);

int age = sc.nextInt();

String name = sc.nextLine();

System.out.println(name);
Reason

nextInt() reads only the number.

It leaves the Enter key (\n) in the input buffer.

The next nextLine() immediately consumes that leftover newline and returns an empty string.

Correct Solution
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();

sc.nextLine(); // Consume leftover newline

String name = sc.nextLine();

System.out.println(name);

Now the program works correctly.

Interview Summary
Use .equals() to compare String contents; use == to compare references.
&& and || use short-circuit evaluation; & and | always evaluate both operands (and also perform bitwise operations on integers).
Short-circuit evaluation can prevent NullPointerException.
Integer division discards the fractional part; floating-point division preserves it.
Classic switch can fall through without break; modern switch expressions (->) eliminate accidental fall-through.
next() reads one word, nextLine() reads an entire line, and nextInt() reads an integer while leaving the newline character in the input buffer.