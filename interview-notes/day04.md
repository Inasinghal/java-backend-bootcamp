Great idea. Building your own **Interview Notes** is one of the best things you can do over the next 5 months. Before every interview, you'll revise these instead of reading an entire Java book.

Below are the **most important Day 4 questions** with concise, interview-ready answers.

---

# 📒 Java Interview Notes – Day 4 (Methods)

## 1. What is a method?

**Answer:**

A method is a reusable block of code that performs a specific task. It helps improve code reusability, readability, maintainability, and modularity.

---

## 2. Why do we use methods?

**Answer:**

Methods are used to:

* Avoid code duplication.
* Improve code readability.
* Make code easier to test and debug.
* Promote code reusability.
* Break large problems into smaller, manageable tasks.

---

## 3. What is the syntax of a method?

```java
accessModifier static returnType methodName(parameters) {
    // method body
}
```

Example:

```java
public static int add(int a, int b) {
    return a + b;
}
```

---

## 4. What is the difference between a method and a function?

**Answer:**

In Java, everything belongs to a class, so Java has **methods**, not standalone functions. In languages like C or Python, functions can exist independently.

---

## 5. What is the difference between parameters and arguments?

| Parameters                                  | Arguments                             |
| ------------------------------------------- | ------------------------------------- |
| Variables declared in the method definition | Values passed when calling the method |

Example:

```java
void add(int a, int b) { }   // a and b are parameters

add(10, 20);                 // 10 and 20 are arguments
```

---

## 6. Difference between `void` and non-`void` methods?

| void                               | Non-void                                   |
| ---------------------------------- | ------------------------------------------ |
| Returns nothing                    | Returns a value                            |
| No value is expected by the caller | Caller can store or use the returned value |

---

## 7. What does the `return` statement do?

**Answer:**

The `return` statement:

* Ends the execution of the method.
* Returns a value to the caller (if the method is non-void).

---

## 8. Can a method have multiple `return` statements?

**Answer:**

Yes. A method can contain multiple `return` statements, but only one of them executes during a single method call.

---

## 9. Can a method return multiple values?

**Answer:**

Not directly.

A Java method returns only one value, but multiple values can be returned using:

* Arrays
* Objects
* Collections (`List`, `Map`)
* Records (Java 16+)

---

## 10. Can a method return another method?

**Answer:**

No.

A method cannot directly return another method. It can return objects, functional interfaces, or lambda expressions.

---

## 11. What is method overloading?

**Answer:**

Method overloading means defining multiple methods with the same name but different parameter lists (number, type, or order of parameters).

---

## 12. Rules for method overloading

A method can be overloaded by changing:

* Number of parameters
* Type of parameters
* Order of parameter types

It **cannot** be overloaded by changing only the return type.

---

## 13. Can methods be overloaded by changing only the return type?

**Answer:**

No.

The compiler identifies overloaded methods using the method signature (method name + parameter list), not the return type.

---

## 14. Can `main()` be overloaded?

**Answer:**

Yes.

You can overload `main()`, but the JVM always starts execution from:

```java
public static void main(String[] args)
```

---

## 15. Can a method call another method?

**Answer:**

Yes.

Methods commonly call other methods to reuse logic and keep code modular.

---

## 16. Can a method call itself?

**Answer:**

Yes.

This is called **recursion**.

---

## 17. What is recursion?

**Answer:**

Recursion is a technique in which a method calls itself to solve a problem by breaking it into smaller subproblems.

---

## 18. What is a base case?

**Answer:**

A base case is the stopping condition in a recursive method. It prevents infinite recursion.

---

## 19. What happens if recursion has no base case?

**Answer:**

The method keeps calling itself until the call stack is exhausted, resulting in a `StackOverflowError`.

---

## 20. What is a local variable?

**Answer:**

A local variable is declared inside a method, constructor, or block and can only be accessed within that scope.

---

## 21. What is variable scope?

**Answer:**

Scope defines where a variable can be accessed. A local variable is only visible inside the block in which it is declared.

---

## 22. Where are local variables stored?

**Answer:**

Local variables are stored in the **stack memory**.

---

## 23. Is Java pass-by-value or pass-by-reference?

**Answer:**

Java is **pass-by-value**.

It passes a copy of the value (or a copy of the object reference), so changes to the parameter itself do not affect the original variable.

---

## 24. Explain pass-by-value with an example

```java
static void change(int x) {
    x = 100;
}

public static void main(String[] args) {
    int a = 10;
    change(a);
    System.out.println(a);
}
```

Output:

```text
10
```

Reason:

The method receives a copy of `a`, not the original variable.

---

## 25. What is the difference between printing and returning?

**Printing (`System.out.println`)**

* Displays the value on the console.
* Cannot be reused by the caller.

**Returning (`return`)**

* Sends the value back to the caller.
* The caller can store, modify, or use the value further.

---

## 26. Why is returning a value better than printing it?

**Answer:**

Returning makes methods reusable because the caller decides what to do with the result (store it, display it, or pass it to another method). Printing ties the method to console output.

---

## 27. Can a `void` method contain `return;`?

**Answer:**

Yes.

A `void` method can use `return;` to exit the method early, but it cannot return a value.

---

## 28. Why doesn't this compile?

```java
static int test() {
}
```

**Answer:**

Because a method with return type `int` must return an integer value on every execution path.

---

## 29. Why doesn't this compile?

```java
return 10;
System.out.println("Hello");
```

**Answer:**

The statement after `return` is unreachable, so the compiler reports an **Unreachable statement** error.

---

## 30. Why should methods be small?

**Answer:**

Small methods are:

* Easier to understand.
* Easier to test.
* Easier to debug.
* Easier to reuse.
* Easier to maintain.

Ideally, a method should perform **one specific task**.

---

# ⭐ Top 10 Questions to Revise Before Every Interview

1. What is a method?
2. Why do we use methods?
3. Parameters vs Arguments.
4. `void` vs Non-`void` methods.
5. Method Overloading.
6. Can `main()` be overloaded?
7. Java Pass-by-Value.
8. Recursion and Base Case.
9. Local Variable vs Scope.
10. Why is `return` better than `System.out.println()`?