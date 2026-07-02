Methods:
A method is a reusable block of code that performs a specific task.
Instead of writing the same code multiple times, you write it once and call it whenever needed.

Syntax of a Method
A method is a function written inside a class.
Since Java is ar Object Oriented language, we need to write the method inside same class
dataType name () {
// Method body
}

Variable Arguments (Varargs): A function with Vararg can be created in Java
using the following Syntax:
public static void foo (int ..arr) {
// arr is available here as int[] arr
}
fo can be called with zero or more arguments like this:
foo (7) foo(7,8,9) foo(1,2,7,8,9)

Recursion
A function in Java can call itself. Such calling of function by itself is called recursion
Example: Factorial of a number
factorial (n) = n * factorial(n-1)