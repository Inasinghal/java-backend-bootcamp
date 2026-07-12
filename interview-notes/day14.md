# Abstract Class Interview Questions & Answers

## Q1. What is abstraction?

**Answer:**

Abstraction is the process of exposing only required functionality while hiding unnecessary implementation details from client code.

---

## Q2. How is abstraction achieved in Java?

**Answer:**

Using:

* Abstract Classes
* Interfaces

---

## Q3. Can we create object of abstract class?

No.

---

## Q4. Can abstract class have constructor?

Yes.

Constructors initialize parent part of child object.

---

## Q5. Can abstract class have normal methods?

Yes.

---

## Q6. Can abstract class have static methods?

Yes.

---

## Q7. Can abstract class have final methods?

Yes.

---

## Q8. Can abstract class have variables?

Yes.

Both instance and static variables.

---

## Q9. Can abstract class have abstract methods?

Yes.

---

## Q10. Can abstract method be private?

No.

Private methods cannot be overridden.

---

## Q11. Can abstract method be final?

No.

abstract → must override

final → cannot override

---

## Q12. If child doesn't implement abstract method?

Child must be abstract.

---

## Q13. Why constructor runs in abstract class?

Because child object contains parent part.

---

## Q14. What happens when abstract class loads?

Only class metadata is loaded into Method Area (Metaspace).

No object is created.

---

## Q15. What is the difference between reference type and object type?

Reference type determines **what methods are accessible at compile time**.

Object type determines **which overridden method executes at runtime**.

Example:

```java
Animal a = new Dog();
```

Reference = Animal

Object = Dog

---

## Q16. Explain

```java
Animal a = new Dog();
```

This demonstrates:

* Inheritance
* Abstraction
* Runtime Polymorphism

---

## Q17. What is the biggest benefit of abstraction?

It reduces coupling by allowing client code to depend on a contract instead of a concrete implementation.

---

# Quick Revision (2 Minutes)

* Abstraction = **WHAT**, not **HOW**
* Achieved using Abstract Classes and Interfaces
* Abstract class cannot be instantiated
* Abstract class can have constructors, variables, normal/static/final methods
* Abstract method has no body
* Child must implement abstract methods or become abstract
* `private abstract` ❌
* `final abstract` ❌
* `Animal a = new Dog();`

    * Reference type → accessible methods
    * Object type → runtime method execution

---

# ⭐ Interview Tip

If an interviewer asks:

> **"What is abstraction?"**

Avoid saying only:

> "Hiding implementation details."

Instead say:

> **Abstraction exposes only the required operations to client code while hiding unnecessary implementation details behind a contract. In Java, it is achieved using abstract classes and interfaces, allowing code to depend on abstractions rather than concrete implementations.**

This answer is much stronger and demonstrates a deeper understanding.

---

---

# Interview Questions & Answers

## Q1. What is an Interface?

An interface is a contract that specifies behavior without implementation.

---

## Q2. Why use Interface?

To achieve abstraction, loose coupling and runtime polymorphism.

---

## Q3. Can we create interface object?

No.

---

## Q4. Can interface have constructor?

No.

---

## Q5. Can interface have variables?

Yes.

Only public static final.

---

## Q6. Can interface have normal methods?

Before Java 8

No.

Java 8+

Default and Static methods allowed.

---

## Q7. Can interface have private methods?

Yes.

Since Java 9.

---

## Q8. Why multiple interfaces are allowed?

Interfaces define contracts, not implementation.

Hence no multiple inheritance issue.

---

## Q9. Can one class implement multiple interfaces?

Yes.

---

## Q10. Difference between extends and implements?

extends

Used for class inheritance.

implements

Used for implementing interface.

---

## Q11. Can interface extend another interface?

Yes.

```java
interface A {

}

interface B extends A {

}
```

---

## Q12. Can abstract class implement interface?

Yes.

If it doesn't implement methods,

it must remain abstract.

---

## Q13. What is Functional Interface?

Interface with exactly one abstract method.

---

## Q14. What is Marker Interface?

Interface with zero methods.

Used to provide metadata.

---

## Q15. Can static interface methods be inherited?

No.

Must call

```java
InterfaceName.method();
```

---

## Q16. What happens if two interfaces have same default method?

Compilation Error.

Override required.

---

## Q17. Explain

```java
Animal a = new Dog();
```

Reference Type

Animal

Accessible methods determined by Animal.

Actual Object

Dog

Overridden method execution determined by Dog.

---

## Q18. When should we use Interface?

When unrelated classes share common capability or when designing loosely coupled systems.

---

# Interview Tip ⭐⭐⭐⭐⭐

If asked

**"Why do Spring Boot developers use interfaces everywhere?"**

Answer:

Spring Boot uses interfaces to achieve loose coupling, dependency injection, runtime polymorphism and easier testing. Business logic depends on contracts rather than concrete implementations, making applications easier to extend and maintain.

---

"An abstract class is used when related classes share common state and implementation. It can contain constructors, instance variables, abstract methods, and concrete methods. It provides partial implementation and serves as a base class.

An interface defines a contract that unrelated classes can implement. It supports multiple inheritance of type, and from Java 8 onward, it can contain default and static methods. All interface variables are implicitly public static final.

I would use an abstract class for a Vehicle hierarchy because all vehicles share common properties and behavior. I would use an interface like Flyable or Payment because different unrelated classes can provide their own implementation while following the same contract."

---

### Suppose an interface has a default method, and a superclass also has a concrete method with the same signature.

### Which method will be executed, and why?

Java follows the rule:

Class wins over interface.

If a superclass provides a concrete implementation and an interface provides a default method with the same signature, the superclass method is inherited.

The interface's default method is ignored in this case.

