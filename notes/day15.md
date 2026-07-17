# Java Backend Bootcamp – Module 2 (Advanced OOP Notes)

# 1. Composition vs Inheritance

## Why was Inheritance introduced?

* Promote code reusability.
* Establish an IS-A relationship.
* Allow child classes to reuse parent code.

### Problem with Inheritance

* Creates tight coupling.
* Changes in the parent may affect all child classes.
* Incorrect inheritance can violate LSP.
* Difficult to extend without modifying existing code.

## Composition

### Definition

Composition represents a HAS-A relationship where one class contains another class as a member.

Example:

```java
class PaymentService {

    private Payment payment;

}
```

### Advantages

* Loose Coupling
* Better Flexibility
* Easy to replace implementations
* Follows Open/Closed Principle
* Works naturally with Dependency Injection

### Interview Answer

> Composition is preferred over inheritance because it promotes loose coupling and flexibility. Instead of depending on a parent implementation, a class depends on an abstraction, making it easier to replace implementations without modifying existing code.

---

# 2. Wrapper Classes

## Problem

Primitive data types are not objects.

Collections, Generics, Streams and many Java APIs work with objects.

## Solution

Java introduced Wrapper Classes.

Examples

* int → Integer
* double → Double
* char → Character
* boolean → Boolean

## Autoboxing

Automatic conversion

```java
Integer x = 10;
```

Compiler converts

```java
Integer x = Integer.valueOf(10);
```

## Unboxing

Automatic conversion

```java
Integer x = 10;

int y = x;
```

Compiler converts

```java
int y = x.intValue();
```

## Integer Cache

Range

```text
-128 to 127
```

Frequently used Integer objects are reused.

## parseInt()

Returns

```java
int
```

Used when calculations are required.

## valueOf()

Returns

```java
Integer
```

Used when an object is required.

### Interview Question

Why did Java introduce Wrapper Classes?

Answer:

Because primitives are not objects, Wrapper Classes allow primitive values to participate in object-oriented features like Collections, Generics and Streams.

---

# 3. Enums

## Problem

Using String constants still allows invalid values.

```java
status = "HELLO";
```

## Solution

Enums provide a fixed set of predefined values with compile-time type safety.

Example

```java
enum Status {

    ACTIVE,
    INACTIVE,
    SUSPENDED

}
```

## Advantages

* Type Safety
* Readability
* Fixed Constants
* Can contain fields
* Can contain constructors
* Can contain methods

## Important Methods

### values()

Returns all enum constants.

### valueOf()

Converts String to Enum constant.

Throws IllegalArgumentException if no match exists.

### ordinal()

Returns zero-based position.

Never use for business logic.

### name()

Returns exact enum constant name.

## Important Points

* Enum objects are created only once by the JVM.
* Cannot create enum objects using `new`.
* Every enum extends `java.lang.Enum`.
* Enums can implement interfaces.
* Enums cannot extend another class.

### Spring Boot Usage

* OrderStatus
* PaymentStatus
* UserRole
* TransactionStatus

---

# 4. Nested Classes

## Why Nested Classes?

Some helper classes belong only to one outer class.

### Types

## Static Nested Class

* Belongs to class.
* No outer object required.
* Can use all access modifiers.

Creation

```java
Outer.Inner obj = new Outer.Inner();
```

---

## Inner Class

* Belongs to object.
* Requires outer object.
* Can access outer class private members.

Creation

```java
Outer outer = new Outer();

Outer.Inner inner = outer.new Inner();
```

---

## Local Inner Class

* Declared inside a method.
* Scope limited to that method.
* Cannot have access modifiers.

---

## Anonymous Inner Class

* No class name.
* One-time implementation.
* Commonly replaced by Lambda Expressions for Functional Interfaces.

## Access Modifiers Summary

| Type          | public | protected | private |
| ------------- | :----: | :-------: | :-----: |
| Static Nested |    ✅   |     ✅     |    ✅    |
| Inner         |    ✅   |     ✅     |    ✅    |
| Local Inner   |    ❌   |     ❌     |    ❌    |
| Anonymous     |    ❌   |     ❌     |    ❌    |

---

# 5. SOLID Principles

## S – Single Responsibility Principle

A class should have only one reason to change.

Spring Example

* Controller
* Service
* Repository

Each has one responsibility.

---

## O – Open/Closed Principle

Software entities should be open for extension but closed for modification.

Achieved using

* Interfaces
* Abstraction
* Polymorphism
* Composition

---

## L – Liskov Substitution Principle

Child classes should be replaceable for parent classes without breaking program behavior.

Wrong Example

Bird → Ostrich

Rectangle → Square

Use composition/interfaces when inheritance is inappropriate.

---

## I – Interface Segregation Principle

Clients should not be forced to depend on interfaces they do not use.

Instead of

```java
Machine
```

Create

* Printer
* Scanner
* Fax

---

## D – Dependency Inversion Principle

High-level modules should not depend on low-level modules.

Both should depend on abstractions.

Achieved using

* Interfaces
* Composition
* Dependency Injection

Spring Boot uses this principle through the IoC Container and Dependency Injection.

---

# 6. Complete Concept Flow

```text
Procedural Programming
        ↓
OOP
        ↓
Class & Object
        ↓
Encapsulation
        ↓
Inheritance
        ↓
Polymorphism
        ↓
Abstraction
        ↓
Interface
        ↓
Composition
        ↓
Wrapper Classes
        ↓
Enums
        ↓
Nested Classes
        ↓
SOLID
        ↓
Dependency Injection
        ↓
Spring Boot
```

---

