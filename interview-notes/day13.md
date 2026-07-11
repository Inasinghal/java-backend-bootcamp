# Top Java Interview Questions & Answers

Final Keyword

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

Static Keyword

## Q1. What is static keyword?

**Answer:**

`static` is used to create class-level members that are shared among all objects of a class.

---

## Q2. Where are static variables stored?

**Answer:**

Static variables are stored with class metadata in the Method Area (Metaspace in modern JVMs).

---

## Q3. How many copies of a static variable exist?

**Answer:**

Only one copy exists per class.

---

## Q4. When is a static variable initialized?

**Answer:**

When the JVM loads the class.

---

## Q5. Can we access static variables using objects?

Example:

```java
Student s = new Student();

s.college;
```

**Answer:**

Yes, but it is not recommended.

Preferred:

```java
Student.college;
```

---

## Q6. Can static methods access non-static variables?

**Answer:**

No.

Because instance variables require an object.

---

## Q7. Can instance methods access static variables?

**Answer:**

Yes.

Because static variables exist independently of objects.

---

## Q8. Why is main() static?

**Answer:**

Because JVM calls it without creating an object.

---

## Q9. Can we overload static methods?

Example:

```java
static void show(int a)

static void show(String b)
```

**Answer:**

Yes.

Method overloading depends on parameters, not static keyword.

---

## Q10. Can we override static methods?

**Answer:**

No.

Static methods are not overridden; they are hidden.

Example:

```java
class Parent {

    static void show(){}

}

class Child extends Parent {

    static void show(){}

}
```

This is method hiding.

---

## Q11. Can static block access instance variables?

**Answer:**

No.

Because no object exists when static block executes.

---

## Q12. How many times does a static block execute?

**Answer:**

Only once when the class is loaded.

---

## Q13. Can we create an object inside a static method?

**Answer:**

Yes.

Example:

```java
static void show(){

    Student s = new Student();

}
```

---

## Q14. Why are utility classes usually static?

Example:

```java
Math.sqrt(25);
```

No object state is required, so static methods are convenient.

---

## Q15. What is the difference between static and final?

| static           | final                 |
| ---------------- | --------------------- |
| Belongs to class | Prevents modification |
| Sharing concept  | Restriction concept   |
| One copy         | Cannot change         |

Example:

```java
static int count;

final int age;
```

---

# ⭐ Must Remember Interview Lines

### Static Variable

> "Static variables belong to the class and have a single shared copy among all objects."

---

### Static Method

> "Static methods belong to the class and can be called without creating an object."

---

### Static Block

> "Static blocks execute once when the class is loaded and are used for static initialization."

---

### main()

> "The JVM calls main without creating an object, therefore main is declared static."





