# 22. Important Interview Answers

## What is an Anonymous Inner Class?

An anonymous inner class is an unnamed class declared and instantiated in one expression. It is commonly used for one-time interface implementations or class extensions.

## Why Were Lambdas Introduced?

Lambdas were introduced to reduce the boilerplate of anonymous classes when representing small pieces of behavior.

## Why Does Lambda Require a Functional Interface?

Because the compiler needs exactly one abstract method to determine the lambda's parameter and return types and to know which method the lambda implements.

## Does `@FunctionalInterface` Create a Functional Interface?

No. An interface is functional because it has exactly one abstract method. The annotation only asks the compiler to enforce that rule.

## Why Are Predicate, Consumer, Supplier and Function Separate?

They represent different behavioral contracts:

* Predicate: input to boolean
* Consumer: input to void
* Supplier: no input to output
* Function: input to transformed output

Separate interfaces provide type safety, readability and compile-time checking.

## What Is a Method Reference?

A method reference is a concise way to use an existing compatible method or constructor as the implementation of a functional interface.

## Does a Method Reference Execute Immediately?

No. It stores behavior. The referenced method executes when the functional-interface method is invoked.

## Can Every Lambda Become a Method Reference?

No. It works only when the lambda directly delegates to one compatible existing method or constructor without adding extra logic.

## How Does the Compiler Resolve a Method Reference?

The compiler:

1. Reads the target functional interface.
2. Finds its single abstract method.
3. Determines the required parameter and return types.
4. Searches for a compatible referenced method or constructor.
5. Adapts arguments where required.
6. Checks return type, accessibility, exceptions and overloads.
7. Accepts it or reports a compile-time error.