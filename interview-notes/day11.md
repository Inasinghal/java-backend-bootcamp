Top Interview Questions & Answers
Q1. What are the main JVM memory areas?

Answer: The three core memory areas are:

Stack: Stores method calls, local variables, and object references.
Heap: Stores objects and arrays.
Method Area: Stores class metadata, static variables, methods, and constructors.
Q2. Where are objects stored?

Answer: Objects are stored in the Heap.

Q3. Where are object references stored?

Answer: Object references are stored in the Stack (if they are local variables).

Q4. What is stored in the Method Area?

Answer: The Method Area stores:

Class metadata
Static variables
Method bytecode
Constructor bytecode
Field information
Q5. Is the Method Area inside the Heap?

Answer: No. According to the JVM specification, the Method Area is a separate memory area. In modern HotSpot JVMs (Java 8+), it is implemented using Metaspace.

Q6. What happens internally when new Student() is executed?

Answer:

Load the class (if not already loaded).
Allocate memory in the Heap.
Default initialize instance variables.
Execute instance variable initializers.
Execute the constructor.
Assign the reference to the variable.
Q7. Why are instance variables initialized twice (default values, then explicit values)?

Answer: The JVM first ensures every object has a valid state by assigning default values. It then applies the values specified in the class, followed by any changes made in the constructor.

Q8. How many times is a class loaded?

Answer: A class is loaded only once per ClassLoader, no matter how many objects are created.

Q9. Why are static variables shared?

Answer: Static variables belong to the class, so only one copy is created when the class is loaded. All objects access that same copy.

Q10. What is the difference between default initialization and constructor initialization?

Answer: Default initialization is performed automatically by the JVM before any constructor runs. Constructor initialization is the programmer's custom logic that executes afterward to set or modify object state.

Q11. Why don't local variables have default values?

Answer: Local variables are stored in the Stack and must be explicitly initialized by the programmer. This prevents accidental use of undefined values and allows the compiler to catch mistakes.

Q12. Why is understanding JVM memory important for Spring Boot?

Answer: Spring Boot creates and manages many objects (beans). Understanding where classes, objects, static variables, and references live helps explain bean creation, dependency injection, object lifecycle, memory usage, and garbage collection.

"Where are instance variables stored?"

Answer:

Instance variables are stored inside objects in Heap memory. The class only contains information about those variables as part of its blueprint.

"Where are static variables stored?"

Answer:

Static variables belong to the class and are stored with class metadata in Method Area/Metaspace.

"What is stored in Method Area?"

Answer:

Method Area stores class-level information such as class metadata, method bytecode, static variables, and runtime constant pool.