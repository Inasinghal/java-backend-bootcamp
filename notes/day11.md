# Day 11 – JVM Memory & Object Creation (Interview Notes)

# 1. JVM Memory Structure

The JVM divides memory into different areas, each serving a specific purpose.

```text
                JVM Memory
                     │
     ┌───────────────┼────────────────┐
     │               │                │
   Stack           Heap          Method Area
(Thread-wise)     (Shared)        (Shared)
```

---

# 2. Stack Memory

## Purpose

Stores:

* Method calls (Stack Frames)
* Local variables
* Object references

Example

```java
Student s = new Student();
int age = 20;
```

Memory

```text
Stack

main()

------------------
s  --------┐
age = 20   │
-----------│------
            │
            ▼
```

### Characteristics

* One stack per thread
* Very fast
* Automatically destroyed when method returns
* Uses LIFO (Last In First Out)

---

# 3. Heap Memory

## Purpose

Stores:

* Objects
* Arrays
* Instance variables

Example

```java
Student s = new Student();
```

Memory

```text
Heap

------------------------
Student Object

name = "Ayush"

age = 25
------------------------
```

### Characteristics

* Shared among all threads
* Managed by Garbage Collector
* Objects live here until they become unreachable

---

# 4. Method Area

## Purpose

Stores class-level information.

Example

```java
class Student {

    static String college = "ABC";

    int age;

    Student() {}

    void display() {}
}
```

Method Area

```text
Student.class

Static Variables
----------------
college = "ABC"

Methods
-------
display()

Constructors
------------
Student()

Field Metadata
--------------
age
```

### Characteristics

* Shared by all objects
* Stores class metadata
* Stores static variables
* Stores method bytecode
* Stores constructor bytecode
* Does NOT store objects

---

# 5. Stack vs Heap vs Method Area

| Feature    | Stack                       | Heap              | Method Area    |
| ---------- | --------------------------- | ----------------- | -------------- |
| Stores     | Local variables, references | Objects           | Class metadata |
| Shared     | No                          | Yes               | Yes            |
| Lifetime   | Method execution            | Object lifetime   | Class lifetime |
| Managed By | JVM                         | Garbage Collector | JVM            |

---

# 6. Class Loading

Java source code is first compiled into bytecode.

```text
Student.java

      ↓

javac

      ↓

Student.class

      ↓

JVM

      ↓

Class Loader

      ↓

Method Area
```

A class is loaded only once by a ClassLoader.

---

# 7. What Happens When We Execute

```java
Student s = new Student();
```

Execution Order

### Step 1

Load Student.class (if not already loaded).

### Step 2

Allocate memory in Heap.

### Step 3

Default initialize all instance variables.

Examples:

* int → 0
* double → 0.0
* boolean → false
* char → '\u0000'
* Object → null

### Step 4

Execute instance variable initializers and instance initializer blocks.

Example

```java
int age = 25;
String name = "Unknown";
```

### Step 5

Execute constructor.

Example

```java
Student() {
    age = 30;
}
```

### Step 6

Assign the object reference to the variable.

```java
Student s = ...
```

---

# 8. Object Creation Timeline

```text
new Student()

        │
        ▼

1. Load Class

        ▼

2. Allocate Heap Memory

        ▼

3. Default Initialization

        ▼

4. Instance Variable Initialization

        ▼

5. Constructor Execution

        ▼

6. Reference Assignment
```

---

# 9. Default Initialization

Given:

```java
class Student {

    int age;

    boolean passed;

    String name;
}
```

After object creation:

```text
age = 0

passed = false

name = null
```

The JVM performs this automatically.

---

# 10. Instance Variable Initialization

Example

```java
class Student {

    int age = 25;
}
```

After default initialization:

```text
age = 0
```

Instance variable initialization changes it to:

```text
age = 25
```

---

# 11. Constructor Execution

Example

```java
class Student {

    int age = 25;

    Student() {
        age = 30;
    }
}
```

Final value:

```text
age = 30
```

The constructor always runs after instance variable initialization.

---

# 12. Static Variables

Static variables belong to the class, not to objects.

Example

```java
class Student {

    static int count = 1;
}
```

Only one copy exists regardless of how many objects are created.

---

# 13. Important Memory Visualization

```java
Student s1 = new Student();
Student s2 = new Student();
```

Memory

```text
Method Area

Student.class

static count

display()

constructor()

--------------------------

Heap

Student Object 1

Student Object 2

--------------------------

Stack

main()

s1 ---------> Object 1

s2 ---------> Object 2
```

---

# 14. Golden Rules

* Objects are stored in Heap.
* References are stored in Stack.
* Class information is stored in Method Area.
* A class is loaded only once.
* Static variables are shared by all objects.
* Constructors initialize objects after default and instance initialization.
* Local variables do not receive default values.
* Instance variables receive default values from the JVM.

---

# 15. Common Interview Mistakes

❌ Thinking Method Area is inside Heap.

✔ Method Area is a separate JVM memory area (implemented as Metaspace in modern HotSpot JVMs).

❌ Thinking constructors run before default initialization.

✔ Default initialization happens first.

❌ Thinking every object has its own static variable.

✔ Static variables belong to the class and are shared.

---

# Revision Formula

Remember this sequence:

Class Loading

↓

Heap Allocation

↓

Default Initialization

↓

Instance Variable Initialization

↓

Constructor Execution

↓

Reference Assignment
