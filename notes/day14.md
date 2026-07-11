# 📘 Day 15A Notes – Abstraction & Abstract Classes

# 1. What is Abstraction?

### Definition

> **Abstraction is the process of exposing only the essential functionality while hiding unnecessary implementation details from the client code.**

### Simple Definition (Interview)

> Abstraction tells **WHAT an object can do**, not **HOW it does it**.

---

# Real Life Example

### Car

You drive a car using:

* Accelerator
* Brake
* Steering

You don't know:

* Fuel injection
* Engine timing
* ECU programming

The engine implementation exists but is hidden from the driver.

This is abstraction.

---

# Java Example

```java
interface Payment {

    void pay();

}
```

Implementation:

```java
class UPIPayment implements Payment {

    public void pay(){

        // Validate PIN
        // Encrypt data
        // Bank API
        // Debit amount
        // Send SMS

    }

}
```

Client code:

```java
Payment payment = new UPIPayment();

payment.pay();
```

Client only knows:

```text
pay()
```

It doesn't need to know the internal implementation.

---

# Important Point ⭐⭐⭐

Many students think:

> Abstraction means nobody can see implementation.

❌ Wrong.

Correct understanding:

> **Abstraction means client code does not need to know implementation details.**

The implementation still exists and developers can read it if needed.

---

# How Java Achieves Abstraction

Java provides two ways:

1. Abstract Class
2. Interface

---

# 2. Abstract Class

Definition:

> An abstract class is a class that cannot be instantiated and may contain both abstract and concrete methods.

Syntax

```java
abstract class Animal {

}
```

---

# Why Abstract Class?

Suppose:

```text
Dog
Cat
Cow
```

All have:

* eat()
* sleep()

Different:

* sound()

Instead of writing:

```text
eat()
sleep()
```

inside every class,

Create:

```java
abstract class Animal {

    void eat(){}

    void sleep(){}

    abstract void sound();

}
```

---

# 3. Abstract Method

Definition

A method without implementation.

Syntax

```java
abstract void sound();
```

No body.

Child class must implement it.

Example

```java
abstract class Animal{

    abstract void sound();

}
```

```java
class Dog extends Animal{

    void sound(){

        System.out.println("Bark");

    }

}
```

---

# 4. Rules of Abstract Class

## Rule 1

Cannot create object.

Wrong

```java
Animal a = new Animal();
```

Compilation Error

---

## Rule 2

Can contain:

✔ Constructors

✔ Variables

✔ Normal methods

✔ Static methods

✔ Final methods

✔ Abstract methods

---

## Rule 3

If child doesn't implement abstract method,

child must also be abstract.

Wrong

```java
class Dog extends Animal{

}
```

Correct

```java
abstract class Dog extends Animal{

}
```

OR

```java
class Dog extends Animal{

    void sound(){}

}
```

---

## Rule 4

Abstract method cannot be

```java
private abstract
```

Reason

Private methods cannot be overridden.

---

## Rule 5

Abstract method cannot be

```java
final abstract
```

Reason

abstract → must override

final → cannot override

Contradiction.

---

# 5. Constructors in Abstract Class

Yes.

Abstract classes can have constructors.

Example

```java
abstract class Animal{

    Animal(){

        System.out.println("Animal");

    }

}
```

Child

```java
class Dog extends Animal{

    Dog(){

        System.out.println("Dog");

    }

}
```

Output

```text
Animal
Dog
```

Reason

Constructor chaining.

---

# 6. JVM Memory

When class loads

```java
abstract class Animal{

}
```

Method Area

Stores:

* Class metadata
* Constructors
* Method information
* Static members

No object created.

---

Object creation

```java
Dog d = new Dog();
```

Heap

```text
Dog Object

----------------

Animal part

Dog part
```

Stack

```text
d

↓

Dog Object
```

---

# 7. Runtime Polymorphism

```java
Animal a = new Dog();
```

Reference Type

```text
Animal
```

Actual Object

```text
Dog
```

Compile Time

Checks

```java
sound();
```

inside Animal.

Runtime

Calls

```java
Dog.sound()
```

---

# 8. Abstraction Using Reference Type ⭐⭐⭐

Suppose

```java
interface Animal{

    void sound();

}
```

```java
class Dog implements Animal{

    public void sound(){}

    public void eat(){}

}
```

Now

```java
Animal a = new Dog();
```

Allowed

```java
a.sound();
```

Not Allowed

```java
a.eat();
```

Reason

Reference type decides visible methods.

This is one way Java exposes only required functionality.

---

# Golden Rule ⭐⭐⭐⭐⭐

Reference Type

↓

Decides

What you can access.

Actual Object

↓

Decides

Which overridden method executes.

---

# Memory Diagram

```
                Heap

      ---------------------
      | Dog Object        |
      |-------------------|
      | sound()           |
      | eat()             |
      ---------------------
               ▲
               |
         Animal Reference

Visible:

✔ sound()

Hidden:

✘ eat()
```

# 📘 Day 15B – Interfaces (Interview Notes)

# 1. What is an Interface?

## Definition

An interface is a contract that defines **what a class must do**, but not **how it does it**.

It specifies behavior that implementing classes must provide.

---

## Interview Definition ⭐⭐⭐

> An interface is a contract in Java that achieves abstraction by exposing only required operations while allowing multiple implementations.

---

# 2. Why do we need Interfaces?

Without Interface

```java
class OrderService {

    UPIPayment payment = new UPIPayment();

}
```

Problems

* Tight coupling
* Difficult to replace implementation
* Poor maintainability

---

Using Interface

```java
interface Payment {

    void pay();

}
```

```java
class UPIPayment implements Payment {

    public void pay() {

        System.out.println("UPI Payment");

    }

}
```

```java
class CreditCardPayment implements Payment {

    public void pay() {

        System.out.println("Card Payment");

    }

}
```

Client

```java
Payment payment = new UPIPayment();

payment.pay();
```

Tomorrow

```java
Payment payment = new CreditCardPayment();

payment.pay();
```

No other code changes required.

---

# Benefits

* Loose Coupling
* Runtime Polymorphism
* Flexibility
* Easier Testing
* Easier Maintenance
* Supports Dependency Injection

---

# 3. Syntax

```java
interface Animal {

}
```

---

# 4. Declaring Methods

```java
interface Animal {

    void sound();

}
```

Internally Java treats it as

```java
public abstract void sound();
```

Therefore every interface method is **public abstract** by default.

---

# 5. Implementing Interface

```java
interface Animal {

    void sound();

}
```

```java
class Dog implements Animal {

    public void sound() {

        System.out.println("Bark");

    }

}
```

Important

Implementation must be **public** because interface method is public.

---

# 6. Interface Variables

Example

```java
interface Config {

    int MAX = 100;

}
```

Internally

```java
public static final int MAX = 100;
```

Meaning

* public
* static
* final

Cannot modify

```java
Config.MAX = 200;
```

Compilation Error

---

# 7. Can We Create Interface Object?

Wrong

```java
Animal a = new Animal();
```

Compilation Error

Reason

Interface is only a contract.

---

Correct

```java
Animal a = new Dog();
```

---

# 8. Reference Type and Abstraction

Example

```java
interface Animal {

    void sound();

}
```

```java
class Dog implements Animal {

    public void sound() {

        System.out.println("Bark");

    }

    public void eat() {

        System.out.println("Eating");

    }

}
```

Reference

```java
Animal a = new Dog();
```

Allowed

```java
a.sound();
```

Not Allowed

```java
a.eat();
```

Reason

Reference type decides accessible methods.

This is how Java exposes only required functionality.

---

# Golden Rule ⭐⭐⭐⭐⭐

Reference Type

↓

Decides

What methods are visible.

Object Type

↓

Decides

Which overridden method executes.

---

# 9. Multiple Interface Implementation

Example

```java
interface Flyable {

    void fly();

}
```

```java
interface Swimmable {

    void swim();

}
```

```java
class Duck implements Flyable, Swimmable {

    public void fly() {

    }

    public void swim() {

    }

}
```

Allowed.

---

# Why?

Java does not support multiple inheritance of classes.

But it supports multiple inheritance of contracts.

---

# 10. Diamond Problem

Wrong

```java
class C extends A, B {

}
```

Not allowed.

Reason

Ambiguity.

---

Interfaces solve this because they originally contained only abstract methods.

---

# 11. Same Method in Two Interfaces

```java
interface A {

    void show();

}
```

```java
interface B {

    void show();

}
```

```java
class C implements A, B {

    public void show() {

        System.out.println("C");

    }

}
```

Works perfectly.

One implementation satisfies both contracts.

---

# 12. Default Methods (Java 8)

Syntax

```java
interface Payment {

    default void refund() {

        System.out.println("Refund");

    }

}
```

Purpose

Backward compatibility.

Allows adding new methods without breaking existing implementations.

---

Usage

```java
class UPIPayment implements Payment {

}
```

```java
UPIPayment payment = new UPIPayment();

payment.refund();
```

Output

```
Refund
```

---

# Default Method Override

```java
interface A {

    default void show() {

        System.out.println("A");

    }

}
```

```java
class B implements A {

    public void show() {

        System.out.println("B");

    }

}
```

Output

```
B
```

---

# Default Method Conflict

```java
interface A {

    default void show() {

    }

}
```

```java
interface B {

    default void show() {

    }

}
```

```java
class C implements A, B {

}
```

Compilation Error

Reason

Ambiguity.

Solution

Override

```java
public void show() {

}
```

---

# 13. Static Methods in Interface

Example

```java
interface Calculator {

    static void add() {

        System.out.println("Add");

    }

}
```

Calling

```java
Calculator.add();
```

Correct.

Wrong

```java
class Demo implements Calculator {

}

Demo.add();
```

Compilation Error.

Static interface methods are not inherited.

---

# 14. Private Methods (Java 9)

Example

```java
interface Payment {

    private void validate() {

    }

}
```

Purpose

Reuse common code inside default and static methods.

Cannot be called outside interface.

---

# 15. Functional Interface

Definition

An interface having exactly one abstract method.

Example

```java
@FunctionalInterface
interface Calculator {

    int add(int a, int b);

}
```

Used for

* Lambda Expressions
* Streams API
* Method References

Can contain

* Default methods
* Static methods

But only one abstract method.

---

# 16. Marker Interface

Definition

Interface with no methods.

Example

```java
interface Serializable {

}
```

Purpose

Provides metadata to JVM/framework.

Examples

* Serializable
* Cloneable
* Remote

---

# 17. Interface Memory

When interface loads

Method Area contains

* Interface metadata
* Method declarations
* Default methods
* Static methods

No object created.

---

# 18. Real Spring Boot Example

```java
interface UserService {

    void saveUser(User user);

}
```

Implementation

```java
class UserServiceImpl implements UserService {

    public void saveUser(User user) {

        validateUser();
        encryptPassword();
        saveToDatabase();

    }

}
```

Controller

```java
UserService service;

service.saveUser(user);
```

Controller doesn't care about implementation.

This is abstraction.

---

# 19. Interface Rules

✔ Cannot instantiate interface

✔ Interface methods are public abstract by default

✔ Variables are public static final

✔ Multiple interfaces allowed

✔ Static methods allowed

✔ Default methods allowed

✔ Private methods allowed (Java 9)

✔ Functional interfaces supported

✔ Marker interfaces supported

✘ Constructors not allowed

---

# 20. Abstract Class vs Interface (Quick Comparison)

| Feature              | Abstract Class | Interface             |
| -------------------- | -------------- | --------------------- |
| Keyword              | abstract class | interface             |
| Constructor          | Yes            | No                    |
| Instance Variables   | Yes            | No                    |
| Static Variables     | Yes            | Yes                   |
| Abstract Methods     | Yes            | Yes                   |
| Concrete Methods     | Yes            | Default & Static      |
| Multiple Inheritance | No             | Yes                   |
| Relationship         | IS-A           | Contract / Capability |

