# Topic: Inheritance, Constructor Chaining, Method Overriding & Runtime Polymorphism

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