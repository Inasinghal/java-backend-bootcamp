# Topic: Encapsulation, Inheritance, Constructor Chaining, Method Overriding & Runtime Polymorphism

# Encapsulation

Problem Before Encapsulation

Suppose we have

class BankAccount {

    String accountNumber;
    double balance;

}

Now

BankAccount account = new BankAccount();

account.balance = -100000;

# Can someone directly modify the balance?

Yes.

# Can someone assign account.accountNumber = null;

Yes.

There is no control over the data.

# Problems
Data is exposed.
Invalid values can be assigned.
No validation.
Business rules can be violated.
Difficult to maintain.

# Java's Solution

Hide the data by Making variables private

But then...

How do we access it?

Java introduced getters, setters

---

Initially, Java introduced classes to group related data and behavior together. However, object data was still directly accessible, allowing any part of the application to modify it with invalid values, which could violate business rules and leave objects in an inconsistent state. To solve this, Java introduced encapsulation. By making data private, direct access is restricted, and controlled access is provided through methods where business validations can be applied. This ensures that an object's state remains valid, improves maintainability, and protects data integrity.

---

Encapsulation is the process of binding data and the methods that operate on that data into a single unit (class) while restricting direct access to the data using access modifiers and providing controlled access through methods.



---

# 1. What is Inheritance?

### Definition

Inheritance is an OOP concept where one class acquires the properties and methods of another class.

It promotes:

* Code Reusability
* Maintainability
* Extensibility

---

Example

```java
class Employee{

    void login(){
        System.out.println("Login");
    }
}

class Manager extends Employee{

}
```

Manager automatically gets

```
login()
```

---

## Interview Answer

> Inheritance allows a child class to reuse the properties and methods of its parent class, reducing code duplication and establishing an "IS-A" relationship.

---

# 2. Why do we use Inheritance?

Without inheritance

```java
class Manager{

    String name;
    int age;

    void login(){}
}
```

```java
class Developer{

    String name;
    int age;

    void login(){}
}
```

Duplicate code.

With inheritance

```java
class Employee{

    String name;
    int age;

    void login(){}
}

class Manager extends Employee{}

class Developer extends Employee{}
```

---

Initially, multiple classes contained the same repeated code, making applications difficult to maintain because any common logic had to be updated in several places. To solve this, Java introduced inheritance, allowing common properties and methods to be placed in a parent class and reused by multiple child classes, reducing code duplication and improving maintainability. However, inheritance also introduced a limitation: child classes inherited all accessible members of the parent, even when some behaviors were not applicable. This could lead to incorrect inheritance hierarchies and violations of object-oriented design principles. To provide different implementations for common behavior, Java introduced runtime polymorphism through method overriding. Later, abstraction, interfaces, and composition further improved flexibility by allowing developers to expose only the required behavior and avoid unnecessary inheritance.

---

## Interview Question

### Why is inheritance preferred?

Answer

* Avoids duplication
* Easy maintenance
* Easy extension
* Better code organization

---

# 3. IS-A Relationship

```
Dog IS-A Animal

Car IS-A Vehicle

Manager IS-An Employee
```

If this statement is true,

Inheritance can be used.

---

# 4. extends Keyword

```
class Dog extends Animal
```

Means

Dog inherits everything from Animal.

---

# 5. Object Memory in Inheritance

Suppose

```java
Manager m = new Manager();
```

Heap

```
----------------------------

Manager Object

Parent Part

name

salary

login()

logout()

Child Part

approveLeave()

----------------------------
```

Only ONE object is created.

Parent object is NOT created separately.

---

## Interview Question

How many objects are created?

```java
Manager m = new Manager();
```

Answer

Only one object.

---

# 6. Constructor Chaining

Suppose

```java
class Employee{

    Employee(){

        System.out.println("Employee");
    }
}
```

```java
class Manager extends Employee{

    Manager(){

        System.out.println("Manager");
    }
}
```

Output

```
Employee

Manager
```

---

## Rule

Parent constructor always executes first.

---

# 7. Why?

Child cannot exist without Parent.

Construction order

```
Foundation

↓

Ground Floor

↓

First Floor
```

Exactly like

```
Parent

↓

Child
```

---

# 8. Automatic super()

If you write

```java
Manager(){

}
```

Compiler converts it into

```java
Manager(){

    super();

}
```

Automatically.

---

## Interview Question

Do we need to call super()?

Answer

No.

Compiler inserts it automatically.

---

# 9. Why super() must be first?

Wrong

```java
Manager(){

    System.out.println("Hello");

    super();
}
```

Compilation Error.

Reason

Parent must be initialized before child.

---

## Interview Question

Why should super() be first?

Answer

Because parent constructor must complete before child constructor starts.

---

# 10. Parameterized Parent Constructor

Parent

```java
Employee(String name){

}
```

Child

```java
Manager(){

}
```

Compilation Error.

Need

```java
Manager(){

    super("Ayush");
}
```

---

## Rule

If parent has no default constructor,

Child must explicitly call one.

---

# 11. Method Overriding

Parent

```java
class Animal{

    void sound(){

        System.out.println("Animal");
    }
}
```

Child

```java
class Dog extends Animal{

    @Override

    void sound(){

        System.out.println("Dog");
    }
}
```

Same method

Different implementation

---

## Interview Definition

Method overriding means redefining the inherited method in the child class with the same signature.

---

# 12. Why Override?

Common functionality

```
eat()

sleep()
```

Specific functionality

```
Dog → Bark

Cat → Meow

Lion → Roar
```

Only override what changes.

---

# 13. @Override Annotation

Purpose

Compiler verification.

Wrong

```java
@Override

void sounds(){

}
```

Compiler Error.

Without annotation

Creates new method accidentally.

---

## Interview Question

Inheritance allowed child classes to reuse common behavior from a parent class, but different child classes often required different implementations of the same behavior. To solve this, Java introduced polymorphism, allowing child classes to override inherited methods and provide their own implementations. Compile-time polymorphism is achieved through method overloading, where the compiler selects the appropriate method based on the method signature. Runtime polymorphism is achieved through method overriding, where the JVM decides which implementation to execute based on the actual object type at runtime. However, polymorphism still allowed child classes to inherit a default implementation without overriding it. For behaviors that must be implemented by every child class, Java introduced abstraction using abstract classes and abstract methods.

Does @Override change runtime behavior?

Answer

No.

It only helps compiler verify overriding.

---

# 14. Runtime Polymorphism

```java
Animal a = new Dog();

a.sound();
```

Output

```
Dog
```

Not Animal.

---

## Why?

Reference

```
Animal
```

Actual object

```
Dog
```

Runtime chooses Dog implementation.

---

# Interview Definition



Runtime polymorphism means method execution depends on the actual object at runtime rather than the reference type.

During compilation, the compiler only verifies that the reference type (Animal) contains the sound() method. At runtime, the object created on the heap is a Dog. The JVM uses Dynamic Method Dispatch, which looks at the actual object's type and invokes the overridden method from Dog instead of the parent's implementation.

---

# 15. Compile Time vs Runtime

Compile Time

Checks

```
Reference Type
```

Runtime

Executes

```
Actual Object
```

Golden Rule

```
Compile Time

↓

Reference

Runtime

↓

Actual Object
```

---

# 16. Upcasting

```java
Dog d = new Dog();

Animal a = d;
```

Safe.

Automatic.

---

## Why?

Every Dog IS-An Animal.

---

# 17. Downcasting

```java
Animal a = new Dog();

Dog d = (Dog)a;
```

Safe.

Because object is actually Dog.

---

# Unsafe Downcasting

```java
Animal a = new Animal();

Dog d = (Dog)a;
```

Runtime

```
ClassCastException
```

---

# 18. instanceof

Before downcasting

```java
if(a instanceof Dog){

    Dog d=(Dog)a;
}
```

Purpose

Checks whether actual object is Dog.

Avoids

```
ClassCastException
```

---

# 19. Variable Hiding

```java
class Parent{

    int x=10;
}
```

```java
class Child extends Parent{

    int x=20;
}
```

Object contains

```
Parent.x

Child.x
```

Access

```java
super.x
```

Parent variable.

```java
this.x
```

Child variable.

---

# 20. Method Overriding vs Variable Hiding

| Variable       | Method             |
| -------------- | ------------------ |
| Compile Time   | Runtime            |
| Hidden         | Overridden         |
| Uses reference | Uses actual object |

---

# 21. Memory Model

```
Stack

Animal a

↓

Heap

Dog Object

Parent Part

Child Part
```

Only one object.

Reference may be Parent.

Object may be Child.

---

During Child object creation, Java follows this order:

Memory is allocated for the complete Child object.
Instance fields receive default values.
The parent constructor executes.
Child instance fields are initialized.
The child constructor body executes.

---