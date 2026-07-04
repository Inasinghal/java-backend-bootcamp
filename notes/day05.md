Problem Before Arrays

Suppose HR asks you to store marks of 5 employees.

Without arrays:

int emp1 = 85;
int emp2 = 90;
int emp3 = 76;
int emp4 = 95;
int emp5 = 88;

Now HR says:

"Actually we have 50,000 employees."

Will you write?

int emp50000;

Obviously not.

There has to be a better way.

The Solution
int[] marks = {85,90,76,95,88};

Now one variable stores multiple values.

Definition (Interview)

An array is a fixed-size, index-based data structure that stores multiple elements of the same data type in contiguous memory locations.

Let's break the definition
1️⃣ Fixed Size
int[] arr = new int[5];

Memory:

+----+----+----+----+----+
|    |    |    |    |    |
+----+----+----+----+----+

Five boxes.

Can Java magically add a sixth?

No.

Arrays cannot grow after creation.

This is why collections like ArrayList exist.

2️⃣ Same Data Type

Valid

int[] numbers = {1,2,3,4};

Valid

String[] names = {"Ayush","Rahul"};

Invalid

int[] arr = {1,"Hello",true};

Every element must have the same declared type.

Java assigns every element an index.

Index

0 1 2 3 4

Example

int[] arr = {10,20,30,40,50};

Memory

Index

0   1   2   3   4

+---+---+---+---+---+

10 20 30 40 50

Access

System.out.println(arr[2]);

Java assigns every element an index.

Index

0 1 2 3 4

Example

int[] arr = {10,20,30,40,50};

Memory

Index

0   1   2   3   4

+---+---+---+---+---+

10 20 30 40 50

Access

System.out.println(arr[2]);

Why Does Index Start from 0?

This is one of the most common interview questions.

Let's understand it properly.

Suppose an integer occupies 4 bytes.

Imagine the first element is stored at memory address 1000.

Index      Address

0          1000

1          1004

2          1008

3          1012

The formula used by the JVM is:

Address = Base Address + (Index × Size of Element)

For arr[0]

1000 + (0 × 4)

=

1000

For arr[3]

1000 + (3 × 4)

=

1012

Because the first element requires zero offset, indexing starts at 0.

Contiguous Memory

This is the most important property of arrays.

Imagine apartments.

Flat 101

Flat 102

Flat 103

Flat 104

Every flat is next to the previous one.

Arrays work exactly like this.

1000

1004

1008

1012

1016

The elements are stored continuously.

That's called

Contiguous Memory Allocation

Why is this important?

Suppose you want:

arr[500]

Java does not check all previous 499 elements.

Instead it directly calculates:

Base + (500 × 4)

Instantly.

This is why array access is O(1).

How does Java know the base address of an array?

The short answer is:

The JVM allocates memory for the array on the heap and stores a reference to the first element. That reference acts like the base address.

Step 1: You write
int[] arr = new int[5];

This looks like one statement, but internally several things happen.

Step 2: JVM allocates memory

Suppose each int takes 4 bytes.

The JVM finds a free block in the heap.

Imagine it chooses memory starting at address 1000.

Heap Memory

1000
1004
1008
1012
1016

It stores:

1000 → 0
1004 → 0
1008 → 0
1012 → 0
1016 → 0
Step 3: What is arr?

Many beginners think:

arr

↓

10
20
30

❌ Wrong.

Actually:

Stack

arr

↓

1000

The variable arr doesn't store the array itself.

It stores a reference (similar to a pointer, but Java doesn't expose pointers).

That reference points to the array object on the heap.

Default Values
int[] arr = new int[5];

Output

0 0 0 0 0

Why?

Because Java initializes array elements automatically.

Three Ways to Create Arrays
Method 1
int[] arr = new int[5];
Method 2
int[] arr = {10,20,30};
Method 3
int[] arr = new int[]{10,20,30};
