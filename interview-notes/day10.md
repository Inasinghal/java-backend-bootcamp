 🎯 Interview Questions & Answers

## Q1. What is OOP?

**Answer:**

OOP is a programming paradigm where programs are designed using objects that contain both data (fields) and behavior (methods). It improves modularity, reusability, and maintainability.

---

## Q2. Difference between Class and Object?

**Answer:**

A class is a blueprint, while an object is a runtime instance of that class.

---

## Q3. Where are objects stored?

**Answer:**

Objects are stored in the Heap memory.

---

## Q4. Where are local variables stored?

**Answer:**

Stack memory.

---

## Q5. Difference between Stack and Heap?

**Answer:**

Stack stores method calls and local variables, while Heap stores objects and instance variables.

---

## Q6. What is a constructor?

**Answer:**

A constructor is a special member used to initialize an object. It has the same name as the class, has no return type, and is called automatically when an object is created.

---

## Q7. Can constructors be overloaded?

**Answer:**

Yes. A class can have multiple constructors with different parameter lists.

---

## Q8. Can constructors be inherited?

**Answer:**

No. Constructors are not inherited.

---

## Q9. Can constructors be static?

**Answer:**

No. Constructors initialize objects, while `static` members belong to the class.

---

## Q10. Can constructors be private?

**Answer:**

Yes. Private constructors are commonly used in Singleton and Factory patterns.

---

## Q11. What is constructor chaining?

**Answer:**

Constructor chaining is the process of calling one constructor from another using `this()` within the same class.

---

## Q12. What is the `this` keyword?

**Answer:**

`this` refers to the current object and is commonly used to distinguish instance variables from local variables.

---

## Q13. What is an instance variable?

**Answer:**

A variable declared inside a class but outside methods. Each object has its own copy.

---

## Q14. What is a static variable?

**Answer:**

A variable declared using the `static` keyword. It belongs to the class and is shared among all objects.

---

## Q15. Why are static variables shared?

**Answer:**

Because only one copy is created when the class is loaded, and all objects access that same copy.

---

## Q16. Why do local variables require initialization?

**Answer:**

Because Java does not automatically initialize local variables. This prevents accidental use of undefined values and catches bugs at compile time.

---

## Q17. Why do instance variables have default values?

**Answer:**

Because the JVM initializes all instance variables when it creates an object, ensuring every object starts in a valid state.

---

## Q18. What is variable shadowing?

**Answer:**

When a local variable or parameter has the same name as an instance variable, the local variable hides the instance variable. Use `this.variableName` to access the instance variable.

---

# 🎯 Homework

Implement an `Employee` class:

* Instance variables: `name`, `id`
* Static variable: `company`
* Parameterized constructor
* `display()` method

Create three employees, print them, change `Employee.company`, and print them again. Observe which values change and which remain the same.

