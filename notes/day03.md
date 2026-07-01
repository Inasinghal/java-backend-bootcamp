Control Flow: 
Defines order in which your program executes code.
But real-world programs don’t work like that.

Sometimes you want to:

Skip steps
Repeat steps
Choose between options

That’s where control flow comes in.

Java has 3 main types of control flow:
1. Decision Making - if, if-else, if-else-if, nested-if, switch
2. Iterative - for, while(Use while when the number of iterations is unknown.), do-while(A do-while loop executes the body at least once, even if the condition is false.)
3. Branching - break(Stops the loop immediately), continue(skips current iteration)


Use switch when:

You compare one variable
With multiple constant values
What Kind of Values Can Be Used in switch?

This is where beginners often get confused 👇

Allowed Types

You can use switch with:
byte
short
int
char
String (very commonly used)
enum (advanced but important)

Not Allowed
float
double
long

Because switch works with exact matching, and floating-point numbers are not precise.

This is the most important concept in switch.

Without break, Java does something called:

Fall-Through Behavior

It keeps executing the next cases, even if they don’t match.
Modern Switch (Java 14+)

Java introduced a cleaner version:

Arrow Syntax (->)

int day = 2;
switch (day) {
case 1 -> System.out.println("Monday");
case 2 -> System.out.println("Tuesday");
default -> System.out.println("Invalid day");
}
No break needed
No fall-through
Cleaner & safer

yield Statement (Advanced but Powerful)

yield is used when:

-> You want to return a value
-> And your case has multiple statements

Example with yield

int day = 2;

String result = switch (day) {
case 1 -> "Monday";
case 2 -> {
System.out.println("Processing...");
yield "Tuesday";
}
default -> "Invalid";
};
Why yield?

Because arrow syntax expects one expression, but when you write:

case 2 -> {
// multiple lines
}
You must explicitly return a value using yield

Without yield → Error
