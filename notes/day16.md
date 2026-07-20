# Java Functional Programming Notes

## 1. Anonymous Inner Classes

### Problem

Suppose we have an interface:

```java
interface Greeting {
    void sayHello();
}
```

Before Java 8, we usually created a separate implementation class:

```java
class EnglishGreeting implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
```

Then:

```java
Greeting greeting = new EnglishGreeting();
greeting.sayHello();
```

### Limitation

For a small one-time implementation, creating a separate class causes unnecessary boilerplate:

* New class file
* Class name
* Constructor call
* Method override
* More files to maintain

### Java's Solution

Java introduced Anonymous Inner Classes.

```java
Greeting greeting = new Greeting() {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
};
```

This creates an unnamed implementation of `Greeting`.

### Important Meaning

```java
new Greeting() {
    // implementation
}
```

does not create an object directly from the interface.

Interfaces cannot be instantiated.

Java creates an anonymous implementation class and then creates its object.

Conceptually, the compiler generates something similar to:

```java
class Main$1 implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
```

### Why Called Anonymous?

Because the class has no source-level name.

You create and instantiate it in the same place.

### Anonymous Class with Runnable

```java
Runnable task = new Runnable() {

    @Override
    public void run() {
        System.out.println("Task running");
    }
};
```

### Anonymous Class Can Extend a Class

```java
Animal animal = new Animal() {

    @Override
    void sound() {
        System.out.println("Special sound");
    }
};
```

### Anonymous Class Can Implement an Interface

```java
Calculator calculator = new Calculator() {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
};
```

### Limitation of Anonymous Classes

Even though they avoid separate implementation files, they still contain boilerplate:

```java
new InterfaceName() {

    @Override
    public ReturnType method(parameters) {
        // actual logic
    }
};
```

Most of this code is structural. The actual business logic may be only one line.

---

# 2. Lambda Expressions

## Evolution

```text
Implementation Class
        ↓
Anonymous Inner Class
        ↓
Still too much boilerplate
        ↓
Lambda Expression
```

## Problem

Anonymous class:

```java
Runnable task = new Runnable() {

    @Override
    public void run() {
        System.out.println("Task running");
    }
};
```

The useful logic is only:

```java
System.out.println("Task running");
```

### Java's Solution

Lambda expression:

```java
Runnable task =
        () -> System.out.println("Task running");
```

## General Syntax

```java
(parameters) -> implementation
```

Examples:

```java
() -> System.out.println("Hello")
```

```java
name -> System.out.println(name)
```

```java
(a, b) -> a + b
```

```java
(a, b) -> {
    int result = a + b;
    return result;
}
```

---

## Expression Lambda

When the body contains one expression:

```java
Calculator calculator =
        (a, b) -> a + b;
```

Java automatically returns the expression result.

Equivalent block lambda:

```java
Calculator calculator =
        (a, b) -> {
            return a + b;
        };
```

---

## Block Lambda

Used for multiple statements:

```java
Calculator calculator =
        (a, b) -> {
            System.out.println("Calculating");
            return a + b;
        };
```

For non-void methods, use `return` inside a block lambda.

---

## Parameter Rules

### No parameters

```java
() -> System.out.println("Hello")
```

### One parameter

Parentheses are optional:

```java
name -> System.out.println(name)
```

Also valid:

```java
(name) -> System.out.println(name)
```

### Multiple parameters

Parentheses are required:

```java
(a, b) -> a + b
```

---

## Lambda Is Not Executed Immediately

```java
Runnable task =
        () -> System.out.println("Running");
```

This only stores the behavior.

It executes when:

```java
task.run();
```

---

## Lambda Requires a Target Type

A lambda does not have an independent type.

This is invalid:

```java
var task = () -> System.out.println("Hello");
```

The compiler needs a functional-interface target:

```java
Runnable task =
        () -> System.out.println("Hello");
```

The target interface tells the compiler:

* Number of parameters
* Parameter types
* Return type
* Checked exceptions

---

## Lambda Does Not Work with Every Interface

Suppose:

```java
interface Demo {
    void print();
    void show();
}
```

This is invalid:

```java
Demo demo = () -> System.out.println("Hello");
```

Why?

Because the compiler cannot determine whether the lambda implements:

```java
print()
```

or:

```java
show()
```

A lambda needs exactly one abstract method.

---

# 3. Functional Interfaces

## Problem

Lambda needs one clearly identifiable method.

If an interface has multiple abstract methods, lambda assignment becomes ambiguous.

## Java's Solution

A Functional Interface is an interface containing exactly one abstract method.

Example:

```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}
```

Lambda:

```java
Greeting greeting =
        () -> System.out.println("Hello");
```

---

## Important Definition

A functional interface may contain:

* One abstract method
* Any number of default methods
* Any number of static methods
* Methods inherited from `Object`

Example:

```java
@FunctionalInterface
interface Greeting {

    void sayHello();

    default void printMessage() {
        System.out.println("Default method");
    }

    static void info() {
        System.out.println("Static method");
    }
}
```

This is still a functional interface because it has only one abstract method.

---

## `@FunctionalInterface`

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

### What the Annotation Does

It tells the compiler:

> Ensure this interface always remains functional.

If someone later adds another abstract method:

```java
void print();
```

the compiler reports an error.

### Important Interview Point

`@FunctionalInterface` does not make an interface functional.

An interface becomes functional because it has exactly one abstract method.

The annotation only gives compiler protection.

---

## Why Functional Interfaces Exist

Not mainly to reduce code.

The deeper reason is:

> A lambda needs one unambiguous abstract method whose implementation it can provide.

The functional interface provides the required method signature.

---

# 4. Built-in Functional Interfaces

Developers repeatedly created similar interfaces:

```java
interface CheckUser {
    boolean check(User user);
}
```

```java
interface PrintUser {
    void print(User user);
}
```

```java
interface CreateUser {
    User create();
}
```

```java
interface ConvertUser {
    String convert(User user);
}
```

Java standardized common behavioral patterns.

The four major interfaces are:

* `Predicate<T>`
* `Consumer<T>`
* `Supplier<T>`
* `Function<T, R>`

---

# 5. Predicate<T>

## Pattern

```text
Input → boolean
```

Used when checking a condition.

## Abstract Method

```java
boolean test(T value);
```

## Example

```java
Predicate<Integer> isEven =
        number -> number % 2 == 0;
```

Usage:

```java
boolean result = isEven.test(10);
```

Output:

```text
true
```

## More Examples

```java
Predicate<String> startsWithA =
        name -> name.startsWith("A");
```

```java
Predicate<User> isAdult =
        user -> user.getAge() >= 18;
```

## Common Stream Use

```java
users.stream()
     .filter(user -> user.getAge() >= 18);
```

`filter()` accepts a `Predicate`.

---

# 6. Consumer<T>

## Pattern

```text
Input → no output
```

Used when consuming or performing an action on a value.

## Abstract Method

```java
void accept(T value);
```

## Example

```java
Consumer<String> printer =
        name -> System.out.println(name);
```

Usage:

```java
printer.accept("Ayush");
```

## More Examples

```java
Consumer<User> printUser =
        user -> System.out.println(user.getName());
```

```java
Consumer<String> saveLog =
        message -> logService.save(message);
```

## Common Stream Use

```java
names.forEach(name -> System.out.println(name));
```

`forEach()` accepts a `Consumer`.

---

# 7. Supplier<T>

## Pattern

```text
No input → output
```

Used when generating or supplying a value.

## Abstract Method

```java
T get();
```

## Example

```java
Supplier<User> userSupplier =
        () -> new User();
```

Usage:

```java
User user = userSupplier.get();
```

## More Examples

```java
Supplier<Double> randomNumber =
        () -> Math.random();
```

```java
Supplier<String> defaultName =
        () -> "Guest";
```

## Common Java Use

```java
optionalUser.orElseGet(() -> new User());
```

`orElseGet()` accepts a `Supplier`.

---

# 8. Function<T, R>

## Pattern

```text
Input → transformed output
```

Used to convert one value into another.

## Abstract Method

```java
R apply(T value);
```

## Example

```java
Function<String, Integer> lengthFinder =
        text -> text.length();
```

Usage:

```java
Integer length = lengthFinder.apply("Ayush");
```

## More Examples

```java
Function<User, String> getName =
        user -> user.getName();
```

```java
Function<String, Integer> parser =
        text -> Integer.parseInt(text);
```

## Common Stream Use

```java
users.stream()
     .map(user -> user.getName());
```

`map()` accepts a `Function`.

---

# 9. Built-in Functional Interface Summary

| Interface       | Input | Output    | Method     | Main Purpose      |
| --------------- | ----- | --------- | ---------- | ----------------- |
| `Predicate<T>`  | `T`   | `boolean` | `test()`   | Check a condition |
| `Consumer<T>`   | `T`   | `void`    | `accept()` | Perform an action |
| `Supplier<T>`   | None  | `T`       | `get()`    | Generate a value  |
| `Function<T,R>` | `T`   | `R`       | `apply()`  | Transform a value |

---

# 10. Why Java Uses Different Functional Interfaces

Java could have created something like:

```java
interface Universal {
    Object execute(Object input);
}
```

But this would create several problems.

## Loss of Type Safety

A filter needs a boolean:

```java
Boolean result =
        (Boolean) universal.execute(user);
```

This requires casting and may fail at runtime.

## Meaningless Input for Supplier

A supplier takes no input.

With a universal interface, developers might need:

```java
execute(null);
```

## Meaningless Return for Consumer

A consumer returns nothing.

With a universal interface, it might return:

```java
return null;
```

## Poor Readability

Compare:

```java
Predicate<User>
```

with:

```java
Universal
```

`Predicate<User>` clearly communicates:

```text
User → boolean
```

Different interfaces make APIs:

* Type-safe
* Self-documenting
* Readable
* Compile-time checked
* Easier to understand

---

# 11. Functional Interfaces in Streams

```java
users.stream()
     .filter(user -> user.getAge() >= 18)
     .map(user -> user.getName())
     .forEach(name -> System.out.println(name));
```

## `filter`

```java
user -> user.getAge() >= 18
```

Input:

```text
User
```

Output:

```text
boolean
```

Therefore:

```java
Predicate<User>
```

## `map`

```java
user -> user.getName()
```

Input:

```text
User
```

Output:

```text
String
```

Therefore:

```java
Function<User, String>
```

## `forEach`

```java
name -> System.out.println(name)
```

Input:

```text
String
```

Output:

```text
void
```

Therefore:

```java
Consumer<String>
```

---

# 12. Method References

## Problem

Sometimes a lambda contains no new logic.

It only forwards its arguments to an existing method.

Example:

```java
Consumer<String> printer =
        text -> System.out.println(text);
```

The lambda only calls:

```java
System.out.println(text);
```

## Java's Solution

Method reference:

```java
Consumer<String> printer =
        System.out::println;
```

## Meaning

```java
System.out::println
```

means:

> Use the existing `println` method as the implementation of the functional interface.

It does not execute `println` immediately.

The method runs later when:

```java
printer.accept("Ayush");
```

---

# 13. Why Method References Work

Consider:

```java
Consumer<String> printer =
        System.out::println;
```

The compiler first checks the target type:

```java
Consumer<String>
```

Its abstract method is:

```java
void accept(String value);
```

The required shape is:

```text
One String input → no output
```

The compiler checks the referenced method:

```java
System.out.println(String value);
```

The signatures are compatible.

Conceptually:

```java
System.out::println
```

becomes:

```java
value -> System.out.println(value)
```

---

# 14. Types of Method References

## Type 1: Static Method Reference

Lambda:

```java
Function<String, Integer> parser =
        text -> Integer.parseInt(text);
```

Method reference:

```java
Function<String, Integer> parser =
        Integer::parseInt;
```

General syntax:

```java
ClassName::staticMethod
```

Another example:

```java
Function<Integer, Integer> absolute =
        Math::abs;
```

Conceptually:

```java
number -> Math.abs(number)
```

---

## Type 2: Instance Method of a Particular Object

```java
Printer printer = new Printer();
```

Lambda:

```java
Consumer<String> consumer =
        text -> printer.print(text);
```

Method reference:

```java
Consumer<String> consumer =
        printer::print;
```

General syntax:

```java
objectReference::instanceMethod
```

The receiver object already exists.

Example:

```java
Consumer<String> output =
        System.out::println;
```

Here, `System.out` is the particular object.

---

## Type 3: Instance Method of an Arbitrary Object

Lambda:

```java
Function<User, String> getName =
        user -> user.getName();
```

Method reference:

```java
Function<User, String> getName =
        User::getName;
```

General syntax:

```java
ClassName::instanceMethod
```

In this case, the first functional-interface argument becomes the receiver object.

Conceptually:

```java
User::getName
```

means:

```java
user -> user.getName()
```

Another example:

```java
Predicate<String> emptyChecker =
        String::isEmpty;
```

Conceptually:

```java
text -> text.isEmpty()
```

---

## Type 4: Constructor Reference

Lambda:

```java
Supplier<User> supplier =
        () -> new User();
```

Method reference:

```java
Supplier<User> supplier =
        User::new;
```

General syntax:

```java
ClassName::new
```

With a parameterized constructor:

```java
Function<String, User> creator =
        User::new;
```

This requires:

```java
public User(String name) {
    this.name = name;
}
```

Conceptually:

```java
name -> new User(name)
```

---

# 15. When Method References Work

A method reference usually works when:

1. The lambda calls one existing method or constructor.
2. Lambda parameters are directly forwarded.
3. The result is directly returned.
4. The method signature matches the functional interface.

Examples:

```java
x -> Math.abs(x)
```

becomes:

```java
Math::abs
```

```java
user -> user.getName()
```

becomes:

```java
User::getName
```

```java
text -> printer.print(text)
```

becomes:

```java
printer::print
```

```java
() -> new User()
```

becomes:

```java
User::new
```

---

# 16. When Method References Do Not Work

## Multiple Operations

```java
user -> user.getName().toUpperCase()
```

This performs:

1. `getName()`
2. `toUpperCase()`

Neither method alone represents the complete behavior.

These are incomplete:

```java
User::getName
```

```java
String::toUpperCase
```

Keep the lambda:

```java
Function<User, String> f =
        user -> user.getName().toUpperCase();
```

Alternatively, extract the complete operation:

```java
static String uppercaseName(User user) {
    return user.getName().toUpperCase();
}
```

Then:

```java
Function<User, String> f =
        UserUtils::uppercaseName;
```

---

## Additional Calculation

```java
x -> x + 10
```

There is no existing method being called.

So it cannot directly become a method reference.

Similarly:

```java
x -> Math.abs(x) + 10
```

cannot become:

```java
Math::abs
```

because the lambda adds additional logic after calling `abs`.

---

## Modified Arguments

```java
x -> service.process(x + 1)
```

This is not direct forwarding.

The argument is changed before calling the method.

Therefore:

```java
service::process
```

would not have the same behavior.

---

## Multiple Statements

```java
user -> {
    log(user);
    return user.getName();
}
```

This includes more than one operation.

Keep the lambda or extract the complete behavior into one method.

---

## Parameter Count Mismatch

Suppose:

```java
static int add(int a, int b) {
    return a + b;
}
```

This does not match:

```java
Function<Integer, Integer>
```

because `Function` provides one input while `add()` needs two.

But it matches:

```java
BinaryOperator<Integer> operator =
        Calculator::add;
```

because `BinaryOperator` accepts two arguments.

---

## Incompatible Return Type

Suppose:

```java
static User findUser(String id) {
    return new User();
}
```

This cannot implement:

```java
Function<String, Integer>
```

because the functional interface expects `Integer`, but the method returns `User`.

---

## Checked Exception Mismatch

Suppose:

```java
static String readFile(String path) throws IOException {
    // ...
}
```

This may not directly match:

```java
Function<String, String>
```

because `Function.apply()` does not declare `IOException`.

You must handle the checked exception inside a lambda:

```java
Function<String, String> reader = path -> {
    try {
        return readFile(path);
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
};
```

---

## Inaccessible Method

A method reference follows normal Java access rules.

A method cannot be referenced if it is inaccessible because of:

* `private`
* package access
* `protected`
* module restrictions

---

## Ambiguous Overloaded Methods

Suppose:

```java
class Printer {

    static void print(String value) {
    }

    static void print(Integer value) {
    }
}
```

This works because the target type provides enough information:

```java
Consumer<String> consumer =
        Printer::print;
```

The compiler chooses:

```java
print(String)
```

But when multiple overloads remain equally applicable, compilation fails because the compiler cannot select one method.

---

# 17. How the Compiler Reasons About Method References

Consider:

```java
Function<String, Integer> length =
        String::length;
```

## Step 1: Find the Target Type

```java
Function<String, Integer>
```

## Step 2: Find Its Abstract Method

```java
Integer apply(String value);
```

The required shape is:

```text
String input → Integer output
```

## Step 3: Resolve the Method Reference

```java
String::length
```

`length()` is an instance method.

Because the class name appears before `::`, this is an arbitrary-object method reference.

## Step 4: Use the First Argument as Receiver

The compiler interprets it conceptually as:

```java
value -> value.length()
```

## Step 5: Check Return Compatibility

`length()` returns:

```java
int
```

The functional interface expects:

```java
Integer
```

Autoboxing makes these compatible.

Therefore, the assignment compiles.

---

# 18. Method References Need Context

This is invalid:

```java
var reference = String::length;
```

The compiler does not know which functional interface the reference should implement.

This works:

```java
Function<String, Integer> reference =
        String::length;
```

This also works:

```java
names.stream()
     .map(String::length);
```

Here, `map()` provides the target functional-interface context.

---

# 19. Parentheses Rule

Correct:

```java
System.out::println
```

Incorrect:

```java
System.out::println()
```

Why?

```java
println()
```

means call the method now.

```java
::println
```

means refer to the method for later execution.

Similarly:

```java
User::new
```

is a constructor reference.

```java
new User()
```

creates the object immediately.

---

# 20. Lambda Versus Method Reference

Lambda:

```java
user -> user.getName()
```

Method reference:

```java
User::getName
```

Both provide the same behavior.

A method reference is useful when it improves readability.

Do not force method references when the lambda is clearer.

Example:

```java
user -> user.getName().toUpperCase()
```

is clearer than creating an unnecessary helper method solely to use `::`.

---

# 21. Reliable Conversion Checklist

Before converting a lambda to a method reference, ask:

## Question 1

Does the body call one existing method or constructor?

If no, keep the lambda.

## Question 2

Are the parameters passed directly?

Good:

```java
x -> service.process(x)
```

Method reference:

```java
service::process
```

Not direct:

```java
x -> service.process(x + 1)
```

## Question 3

Is the result returned directly?

Good:

```java
x -> Math.abs(x)
```

Method reference:

```java
Math::abs
```

Not direct:

```java
x -> Math.abs(x) + 1
```

## Question 4

Do the signatures match?

Check:

* Parameter count
* Parameter types
* Return type
* Static or instance form
* Access level
* Checked exceptions
* Overload ambiguity

---

# 22. Complete Evolution

```text
Implementation Class
        ↓
Too many separate classes
        ↓
Anonymous Inner Class
        ↓
Still too much boilerplate
        ↓
Lambda Expression
        ↓
Lambda requires one abstract method
        ↓
Functional Interface
        ↓
Repeated common functional patterns
        ↓
Built-in Functional Interfaces
        ↓
Lambda only forwards to an existing method
        ↓
Method Reference
```

---

# 23. Final Mental Model

## Anonymous Inner Class

```text
Create a one-time unnamed implementation
```

## Lambda

```text
Provide behavior without class boilerplate
```

## Functional Interface

```text
Defines the exact shape of that behavior
```

## Built-in Functional Interfaces

```text
Standard reusable behavior shapes
```

## Method Reference

```text
Use an existing compatible method as that behavior
```

The most important relationship is:

```text
Functional interface defines the contract
        ↓
Lambda or method reference provides the implementation
```
