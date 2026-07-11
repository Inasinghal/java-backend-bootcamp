# Day 13 Notes — Final, Static keyword

`final` Keyword Complete Notes

1. Final Variable
final int age = 25;

Cannot:

age = 30;   // ❌
2. Final Reference
final Student s = new Student();

Cannot:

s = new Student();   // ❌

Can:

s.name = "Ayush";    // ✅
3. Final Method
final void login(){

}

Child cannot override.

4. Final Class
final class Security {

}

Cannot extend.


`static` Keyword in Java


# 1. What is `static` in Java?

### Definition

`static` is a keyword used to create members that belong to the **class instead of objects**.

A static member is shared among all objects of that class.

---

### Example

```java
class Student {

    String name;              // Instance variable

    static String college;    // Static variable
}
```

Here:

* `name` → separate copy for every object
* `college` → one copy shared by all objects

---

# 2. Why do we need static?

Suppose:

```java
class Employee {

    String company = "Citi";

}
```

Creating 1000 objects:

```java
Employee e1 = new Employee();
Employee e2 = new Employee();
...
```

Each object stores:

```
company = Citi
```

1000 times.

Memory waste.

---

Using static:

```java
class Employee {

    static String company = "Citi";

}
```

Memory:

```
Employee Class

company = Citi
```

Only one copy exists.

---

# 3. Static Variable

A variable declared with `static` is called a static variable.

Example:

```java
class Counter {

    static int count = 0;

}
```

Characteristics:

* Belongs to class
* One copy exists
* Shared by all objects
* Initialized when class loads

---

# Memory Representation

Without static:

```
Heap

Object 1
---------
count


Object 2
---------
count


Object 3
---------
count
```

With static:

```
Method Area / Metaspace

Class
---------
count
```

---

# 4. When is a static variable initialized?

### Answer:

When the class is loaded into memory.

Example:

```java
class Test {

    static int x = 10;

}
```

Flow:

```
Class Loading

↓

Static Variable Initialization

↓

Object Creation
```

---

# 5. Static Variable Example

```java
class Student {

    static String college = "ABC";

}


public class Main {

    public static void main(String[] args){

        Student s1 = new Student();
        Student s2 = new Student();

        s1.college = "XYZ";

        System.out.println(s2.college);
    }
}
```

Output:

```
XYZ
```

Reason:

Both objects share the same static variable.

---

# 6. Static Block

## Definition

A static block is a block of code that executes automatically when the class is loaded.

Syntax:

```java
class Demo {

    static {

        System.out.println("Static Block");

    }

}
```

---

# Why use static blocks?

Used for:

* Complex initialization
* Loading configuration
* Database setup
* Initializing static variables

Example:

```java
class Database {

    static Connection con;

    static {

        con = createConnection();

    }
}
```

---

# 7. Execution Order in Java

Important interview topic:

```
1. Class Loading

2. Static Variables Initialization

3. Static Blocks Execution

4. main() Method

5. Instance Variables Initialization

6. Constructor Execution
```

---

Example:

```java
class Demo {

    static {

        System.out.println("Static");
    }


    Demo(){

        System.out.println("Constructor");

    }


    public static void main(String args[]){

        System.out.println("Main");

        new Demo();

    }
}
```

Output:

```
Static
Main
Constructor
```

---

# 8. Static Method

A method declared using `static` is called a static method.

Example:

```java
class Calculator {

    static int add(int a,int b){

        return a+b;

    }

}
```

Calling:

```java
Calculator.add(10,20);
```

No object required.

---

# 9. Why static methods don't need objects?

Because static methods belong to the class.

Example:

```java
Calculator.add();
```

The JVM can directly access the method using the class name.

---

# 10. Static Method Restrictions

A static method cannot directly access:

## Instance Variables

Wrong:

```java
class Test {

    int x=10;

    static void show(){

        System.out.println(x);

    }

}
```

Compilation Error.

Reason:

No object exists.

---

## Instance Methods

Wrong:

```java
class Test {

    void display(){}

    static void show(){

        display();

    }
}
```

Compilation Error.

---

# 11. Static Method Can Access

Static variable:

```java
static int count;

static void show(){

    System.out.println(count);

}
```

✅ Allowed

---

Static method:

```java
static void print(){

}

static void show(){

    print();

}
```

✅ Allowed

---

# 12. Why is main() method static?

Question:

Why do we write:

```java
public static void main(String[] args)
```

Answer:

> JVM needs to call the main method without creating an object. Since static methods belong to the class, JVM can directly invoke main using the class name.

---

Without static:

JVM would need:

```java
Main obj = new Main();

obj.main();
```

But creating an object requires starting the program first.

Circular dependency.

---

# 13. Instance Method Accessing Static Member

Allowed:

```java
class Demo {

    static int count=10;


    void display(){

        System.out.println(count);

    }
}
```

Reason:

Object can access class-level data.

---

# 14. Static Method Access Rules

| Access                       | Allowed |
| ---------------------------- | ------- |
| Static → Static Variable     | ✅       |
| Static → Static Method       | ✅       |
| Static → Instance Variable   | ❌       |
| Static → Instance Method     | ❌       |
| Instance → Static Variable   | ✅       |
| Instance → Static Method     | ✅       |
| Instance → Instance Variable | ✅       |
| Instance → Instance Method   | ✅       |

---

# 15. Static vs Instance Variable

| Static                       | Instance                       |
| ---------------------------- | ------------------------------ |
| Belongs to class             | Belongs to object              |
| One copy                     | Multiple copies                |
| Created during class loading | Created during object creation |
| Access using class name      | Access using object            |
| Stored with class metadata   | Stored in heap                 |

---

# 16. Static vs Instance Method

| Static Method                        | Instance Method       |
| ------------------------------------ | --------------------- |
| Belongs to class                     | Belongs to object     |
| No object required                   | Object required       |
| Cannot access instance data directly | Can access everything |
| Called using class name              | Called using object   |

---

