---

# 📘 Day 10 Notes – Core Java OOP (Class, Object, Constructors & Variables)

---

Initially, applications were developed using Procedural Programming, where data and functions were separate, and functions directly operated on shared data. As applications became larger, this approach became difficult to maintain, reuse, secure, and extend because there was no proper way to group related data and behavior. To solve this, Java introduced Classes, which group related properties and methods together and act as a blueprint for creating objects. A class itself does not occupy heap memory until an object is created. An object is a runtime instance of a class with its own state and behavior. During object creation, the JVM loads the class if required, allocates memory for the object in the heap, initializes instance variables with default values, executes the constructor, and finally stores the object's reference in a reference variable on the stack.

---

# 1. Object-Oriented Programming (OOP)

### What is OOP?

OOP is a programming paradigm where we solve problems using **objects**.

An object contains:

* Data (Variables)
* Behavior (Methods)

Example:

```java
class Student {
    String name;
    void study() {
        System.out.println("Studying...");
    }
}
```

---

# 2. Class

### Definition

A class is a blueprint/template used to create objects.

Example

```java
class Student {

}
```

A class itself occupies memory only when it is loaded by the JVM.

---

# 3. Object

Object = Instance of a class.

```java
Student s = new Student();
```

Memory

```
Stack
-----
s
|
↓

Heap
------------
Student Object
------------
```

---

# 4. Stack vs Heap

## Stack

Stores

* Local variables
* Method calls
* References

Characteristics

* Fast
* Automatically destroyed
* LIFO

---

## Heap

Stores

* Objects
* Instance variables

Characteristics

* Shared memory
* Managed by Garbage Collector

---

# 5. Constructor

Definition

A constructor initializes an object.

Syntax

```java
Student() {

}
```

Rules

* Same name as class
* No return type
* Automatically called during object creation

---

# Default Constructor

```java
Student() {

}
```

---

# Parameterized Constructor

```java
Student(String name) {
    this.name = name;
}
```

---

# Constructor Overloading

Multiple constructors with different parameters.

```java
Student()

Student(String name)

Student(String name, int age)
```

---

# Constructor Chaining

Using `this()` to call another constructor.

```java
Student() {
    this("Unknown");
}

Student(String name) {
    this.name = name;
}
```

Rules

* `this()` must be the first statement.
* Used to avoid duplicate initialization logic.

---

# Infinite Constructor Chaining

```java
Student() {
    this(10);
}

Student(int x) {
    this();
}
```

Result

```
StackOverflowError
```

Reason

Constructors keep calling each other endlessly.

---

# 6. `this` Keyword

`this` refers to the current object.

Example

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Without `this`

```java
name = name;
```

Both refer to the local parameter.

Using

```java
this.name = name;
```

distinguishes the instance variable from the parameter.

---

# 7. Local Variables

Declared inside methods.

```java
void display() {

    int age = 20;
}
```

Properties

* Stored in Stack
* Must be initialized
* Destroyed after method ends

---

# 8. Instance Variables

Declared inside class but outside methods.

```java
class Student {

    int age;
}
```

Properties

* Stored inside object (Heap)
* Default initialized
* One copy per object

---

# 9. Static Variables

Belong to the class.

```java
class Student {

    static String college = "ABC";
}
```

Properties

* Stored once per class
* Shared by all objects
* Better accessed using

```java
Student.college
```

instead of

```java
student.college
```

---

# Memory Diagram

```
                 Method Area

Student.class

college = ABC
      ▲
      │

Heap

Student 1
----------
name = Ayush

Student 2
----------
name = Rahul

Stack

main()

s1

s2
```

---

# Local vs Instance vs Static

| Feature         | Local            | Instance        | Static                 |
| --------------- | ---------------- | --------------- | ---------------------- |
| Declared Inside | Method           | Class           | Class                  |
| Memory          | Stack            | Heap            | Method Area            |
| Lifetime        | Method execution | Object lifetime | Program/Class lifetime |
| Default Value   | ❌ No             | ✅ Yes           | ✅ Yes                  |
| Shared          | ❌                | ❌               | ✅                      |

---

# Constructor vs Method

| Constructor          | Method                    |
| -------------------- | ------------------------- |
| Initializes object   | Performs work             |
| Same name as class   | Any name                  |
| No return type       | Has return type or `void` |
| Called automatically | Called explicitly         |

---

# `this` vs `static`

| `this`                    | `static`               |
| ------------------------- | ---------------------- |
| Current object            | Current class          |
| Used inside object        | Shared by all objects  |
| Access instance variables | Access class variables |

---

# Important Rules

### Constructor cannot be

* static
* final
* abstract

### Constructor can be

* private
* overloaded

---

# Static Variable

One copy

```
Student.college
```

Instance Variable

Many copies

```
Student1.name

Student2.name

Student3.name
```

---

The Real Problem
Till now, you can create objects:

Student s1 = new Student();
But…

Who initializes the data?
Who ensures object is valid?
What if object is incomplete?

If not handled properly:

Objects remain empty
Bugs increase
System becomes unreliable
The Shift
Constructor = The first thing that runs when object is created

It ensures:

✔ Object is initialized
✔ Required data is set
✔ Object is usable

What is a Constructor?
What is constructor ? -
It is used to create an instance(initialize the instance variable).

It’s similar to method except :

Name is same as class
No return type (not even void)
Cannot be static or final or abstract, synchronized.
Called automatically using new keyword
class Student {
    Student() {
        System.out.println("Object Created");
    }
}
Now few questions which may comes to your mind is:

Constructor is used to create an instance, but till now we learned whenever new keyword is found, an object has been created. So is new is helping us to create a object or constructor ?

Short answer:

new → creates the object (allocates memory)

Constructor → initializes the object

It is important that Initialization happens immediately at the time of creation. Because:

— Java ensures object is ready to use from day 1

— If constructor was not called: Object would exist but not initialized (Dangerous state)

Why constructor name is same as of class name and has no return type ?

Because Java needs a way to identify constructors clearly

Imagine if names were different:

class Student {
void init() {}
}

Is this a method or constructor? Confusion!

Java’s Solution (Rule):

Same name as class

No return type

This removes ambiguity completely

Why it cannot be inherited?

Constructors are responsible for initializing an object's state during its creation. Unlike normal methods, constructors are tied to the specific class whose object is being created. A child object should initialize its own state using its own constructor, while Java automatically invokes the parent constructor using super() to initialize the inherited part of the object. Since the parent's state is already initialized through constructor chaining, inheriting constructors would be unnecessary and could also create ambiguity about which constructor should initialize which part of the object. Therefore, constructors are not inherited.

Why constructor cannot be final ?

Constructors are different from usual methods & cannot be inherited. So it doesn’t make sense to make them final because final is used
to prevent overriding. If constructors cannot be inherited then there is no requirement for final

Why constructor cannot be abstract?

Since for abstract method , the responsibility of implementation is of child class .But constructors can’t even be inherited so no point of
making them abstract·

Why constructor cannot be static ?

Static belongs to class. Constructor works on object. If constructor was static: It won’t be able to initialize the instance variable

Next Question for You. Can we define constructor in interface ?

Why It’s Preferred
Ensures object is always valid
Makes code testable
Improves design
Prevents null issues
Types of Constructors
Default Constructor

Provided by Java automatically
Only created if you don’t define any constructor
Assigns default values: int → 0, String → null
No-Argument Constructor

Constructor with no parameters (but written by you)

class Student {
    Student() {
        System.out.println("No-arg constructor");
    }
}
Parameterized Constructor

It takes arguments and assign the instance variables with those
parameters. We can initialize one or multiple instance variables using a
parameterized constructor. For the variables where we don’t provide
any argument, they’ll be instantiated with default values.

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

Student s = new Student("XYZ") // this will be assigned to name variable
Note: Whenever you define any constructor manually, default constructor is not added. So, you have to pass value while creating object.

Constructor Overloading
Multiple constructors with different parameters

class Student {
    Student() {}

    Student(String name) {}
    Student(String name, int age) {}
}
Rule:

Only parameters must differ

Private Constructor (Advanced but Important)
Restricts object creation from outside. We can create a private constructor & no one outside the class will be able to call the constructor. This is used usually in Singleton design pattern. To create on object of a class having private constructor, we can create another static method to create the object & then call that method using class name .

class Singleton {
    private Singleton() {}

    static Singleton getInstance() {
        return new Singleton();
    }

Advantages:

Can validate before creating the object.
Can cache and return an existing object.
Can return different implementations.
Can implement Singleton.
Hides object creation from the caller.


Constructor Chaining
It means that we can call one constructor in other constructor. This is done using this() & Super(). To chain a constructor within the same class , this() is used.

Using this()

class Student {
    Student() {
        this("Default");
    }

    Student(String name) {
        System.out.println(name);
    }
}

// Here we called other constructor within a constructor using this ()
Using super()

class A {
    A() {
        System.out.println("A");
    }
}

class B extends A {
    B() {
        super();
        System.out.println("B");
    }
}
Key Rules

Must be first statement
Java adds super() automatically if we explicitly don’t add
Super() in child constructor
If parent has parameterized constructor → you must call it manually
Example: Service Layer
class UserService {
    private UserRepository repo;

    UserService(UserRepository repo) {
        this.repo = repo;
    }
}