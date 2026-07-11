Top 15 Interview Questions

### Q1

What is inheritance?

**Answer:** Reusing parent properties and methods using `extends`.

---

### Q2

Why do we use inheritance?

**Answer:** Code reuse, maintainability, extensibility.

---

### Q3

What is an IS-A relationship?

**Answer:** Child can be treated as Parent (e.g., Dog IS-A Animal).

---

### Q4

How many objects are created?

```java
Manager m = new Manager();
```

**Answer:** One object.

---

### Q5

Which constructor executes first?

**Answer:** Parent constructor.

---

### Q6

Who inserts `super()`?

**Answer:** Java compiler.

---

### Q7

Why must `super()` be the first statement?

**Answer:** Parent must be initialized before child.

---

### Q8

What happens if the parent has only a parameterized constructor?

**Answer:** Child must explicitly call it with `super(args)`.

---

### Q9

What is method overriding?

**Answer:** Child provides its own implementation of a parent method with the same signature.

---

### Q10

Why do we use `@Override`?

**Answer:** Compiler verification.

---

### Q11

What is Runtime Polymorphism?

**Answer:** The overridden method is selected based on the actual object at runtime.

---

### Q12

Difference between compile-time and runtime method resolution?

**Answer:**

* Compile time → Reference type
* Runtime → Actual object

---

### Q13

What is upcasting?

**Answer:** Converting a child reference to a parent reference (`Animal a = new Dog();`).

---

### Q14

What is downcasting?

**Answer:** Converting a parent reference back to a child reference (`Dog d = (Dog) a;`).

---

### Q15

Why do we use `instanceof`?

**Answer:** To verify the actual object type before downcasting and avoid `ClassCastException`.

---

## 📚 Roadmap Status

You've now completed:

* ✅ JVM Memory & Object Creation
* ✅ Classes & Objects
* ✅ Constructors
* ✅ `this` keyword
* ✅ Encapsulation
* ✅ Access Modifiers
* ✅ Inheritance
* ✅ Constructor Chaining
* ✅ Method Overriding
* ✅ Runtime Polymorphism
* ✅ Upcasting
* ✅ Downcasting
* ✅ `instanceof`

This gives you a **strong Core Java OOP foundation**. After `final`, we'll continue with **Abstraction**, **Interfaces**, and **Exception Handling**, which complete the core OOP section before moving into Collections and Spring Boot.
