1. What is Java?
-Java is an Object Oriented Programming languаgе, developed by "Sun Microsystems" of USA in 1991
It was originally called Oak by James Goslin (one of the inventors of Java)
-It is purely object oriented

Back in the 1990s, developers had a major problem.

If you wrote software for:

Windows → it wouldn’t run on Mac
Mac → it wouldn’t run on Linux
Linux → different issues again
Each operating system needed separate code.

Maintaining multiple versions was painful.

Then Java introduced a revolutionary idea: Write Once, Run Anywhere

-It follows hybrid model unlike other languages like c where code is directly compiled to machine code and python where code is interpreted line by line.
In java Here’s what happens:
1. You write Java code.
2. Java compiler converts it into something called bytecode.
3. That bytecode runs on a special engine called the JVM (Java Virtual Machine).
4. The JVM converts it into machine code for your operating system.

5. So instead of writing code for Windows or Mac directly…
You write code for the JVM. And the JVM handles the rest.
That’s how Java becomes platform independent.


2. Why Java is used for backend development
Modern Java includes:

Functional programming (Java 8+)
Stream API
Lambda expressions
Performance improvements
Modern frameworks like Spring Boot

3. JDK vs JRE vs JVM
Your computer does NOT understand .java files.

Computers only understand: Machine Code (0s and 1s)

So Java needs a process to convert your code into something the system can execute.

That process involves:
JDK
JRE
JVM

FLOW- 
Code → Compile → Bytecode → Run → Output
Hello.java  --(Compiler: javac)-->  Hello.class (Bytecode)
Hello.class --(JVM)--> Machine Code --> Output

JDK = Java Development Kit

👉 Used to WRITE and COMPILE code

It includes:

Compiler (javac)
Tools
JRE
👉 Think of JDK as a toolbox for developers


JRE = Java Runtime Environment

👉 Used to RUN Java programs

It includes:

JVM
Libraries
👉 Think of JRE as a setup where your program runs

JVM = Java Virtual Machine

👉 Actually runs your code

Responsibilities:

Executes bytecode
Manages memory
Handles garbage collection
👉 Think of JVM as the engine of Java

JVM acts like a translator between bytecode and your system.

Interview Insight
👉 JVM is platform dependent 👉 Bytecode is platform independent


4. Java Compilation Process
Code → Compile → Bytecode → Run → Output
Hello.java  --(Compiler: javac)-->  Hello.class (Bytecode)
Hello.class --(JVM)--> Machine Code --> Output

5. Bytecode
Hello.java  --(Compiler: javac)-->  Hello.class (Bytecode)->
this is platform independent code which can be run anywhere based on JVM

6. Platform Independence-> comes from JVM which will be diff for diff machines

7. Variables
Container that holds a value actually it point to some memory location where data stored.
  Syntax-  dataType variableName = value;
  
8. Primitive Data Types
A data type tells Java:

What kind of value is stored
How much memory is required
What operations are allowed

Java has two main categories:

Primitive Data Types
Non-Primitive Data Types

Java is Statically typed. Variables must be declared before use.

There are & primitive data types supported by Java.
byte → 
Value ranges from -128 to 127 
Takes 1 byte
Default value is O

Short-> 
Value ranges from -(2^15) to(2^15 -1)
Takes 2 bytes
Default value is O

int->
Value ranges from -(2^31) to(2^31 -1)
Takes 4 bytes
Default Value is 0

float→ 
Takes 4 bytes
Default Value is 0.0f

long-> 
Value ranges from -(2^63) to(2^63 -1)
Takes 8 bytes
Default Value is 0

double→
Takes 8 bytes
Default Value is 0.0d

char->
Value ranges from 0 to 65535 (2^16-1)
Takes 2 bytes → because it supports unicode
Default Value is '\u0000"

boolean →
Value can be true or false
Size depends on JVM
Default value is false

9. Literals in Java
Literals are fixed values assigned to variables.

int a = 10;        // integer literal
double b = 10.5;   // double literal
char c = 'A';      // character literal

10. Type Casting
converting one data type into another.
Implicit Casting (Widening)

Smaller type → larger type

int a = 10;
double b = a;
Automatic
No data loss

Explicit Casting (Narrowing)

Larger type → smaller type

double a = 10.5;
int b = (int) a;
Decimal part is removed.
Data Loss in Casting


11. Comments
// /* */

12. Naming Conventions
for classes- pascal
for methods/varaibles- camelcase