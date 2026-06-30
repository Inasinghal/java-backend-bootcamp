So far, you’ve learned:

Variables (how data is stored)
Data types (what kind of data)
Memory (stack vs heap)
But one important question remains:

How does Java actually use this data?

That’s where operators come in.

What is an Operator?

An operator is a symbol that performs an action on values.

int a = 10;
int b = 5;
int result = a + b;
+ is the operator (action)
  a, b are operands (values)

Types of Operators in Java (Complete List)

Java has 9 types of operators:

Arithmetic
Unary
Assignment
Relational (Comparison)
Logical
Bitwise
Shift
Ternary
instanceof
We’ll go step by step — from basic to advanced.

Arithmetic Operators (Basic Math)

Example

int a = 10, b = 3;

System.out.println(a + b); // 13
System.out.println(a / b); // 3
System.out.println(a % b); // 1
Important: Integer Division

System.out.println(5 / 2); // 2
Decimal part is removed because both are integers.

2. Unary Operators (Single Value)


Example

int x = 5;
x++; // 6
++x; // 7
Pre vs Post (VERY IMPORTANT)

int x = 5;

System.out.println(x++); // 5
System.out.println(++x); // 7
x++ → use first, then increase
++x → increase first, then use

3. Assignment Operators


Example

int a = 10;
a += 5; // 15
a *= 2; // 30
4. Relational Operators (Comparison)


Example

System.out.println(10 > 5); // true
Always returns true/false

5. Logical Operators


Example

boolean isAdult = true;
boolean hasID = false;
System.out.println(isAdult && hasID); // false
Short-Circuit (Important)

if (false && check())
check() won’t run → saves time

6. Bitwise Operators (Core Understanding)

Before learning this, remember:

Computers store numbers in binary

5 = 00000101
3 = 00000011


5 = 00000101
3 = 00000011
— — — — — —

AND (&) → Common bits

Result = 00000001 → 1

Only keeps bits where both are 1

OR (|) → Combine bits

Result = 00000111 → 7

Turns ON bits

XOR (^) → Difference

Rule: Same → 0; Different → 1

Result = 00000110 → 6

NOT (~) → Flip bits

5 → 00000101
~5 → 11111010 → -6

Uses 2’s complement internally

7. Shift Operators (Most Confusing — Now Made Easy)

Shift operators move bits left or right


Left Shift (<<)

Example

5 << 1 = 10
5 << 2 = 20
Why?

5 = 00000101
Shift left → 00001010 = 10

Rule a << n = a × (2^n)

Where to Use?

Fast multiplication (n << 1 => n * 2)
2. Create bit masks (1 << i) => Only i-th bit becomes 1

Right Shift (>>)

Example

5 >>1 = 2
Why?

5 = 00000101
Shift left → 00000010 = 2

Rule a >> n = a / (2^n)

Where to Use?

Fast division (n >> 1 => n/2)
2. Traverse bits

while (n > 0) {
int bit = n & 1;
n = n >> 1;
}

Unsigned Right Shift (>>>)

Ignores sign, fills with 0

Used in low-level programming (rare for beginners)

8. Ternary Operator

? :if-else shortcut

Example

String result = (age >= 18) ? "Adult" : "Minor";

9. instanceof Operator

if (obj instanceof String)

Checks object type

Operator Precedence (Finally Clear)

What it means? Which operation runs first

Example

int result = 10 + 5 * 2;

Answer = 20 (not 30)

Easy Order

()
Unary
* / %
+ -
Comparison
Logical
Assignment
Golden Rule

Use brackets when confused

(10 + 5) * 2 = 30

PART 2 — Bitwise in DSA (Must-Do Problems)

Even/Odd
n & 1
2. Check i-th bit

(n & (1 << i)) != 0
3. Set bit

n | (1 << i)
4. Clear bit

n & ~(1 << i)
5. Toggle bit

n ^ (1 << i)
6. Count set bits

while (n > 0) {
n = n & (n - 1);
count++;
}
7. Power of 2

n > 0 && (n & (n - 1)) == 0
8. Single number

res ^= num;
9. Missing number — Use XOR

10. Two unique numbers — Split using bit

11. Subsets

for (int mask = 0; mask < (1 << n); mask++)
12. Reverse bits — Shift logic

13. Count bits (DP)

dp[i] = dp[i >> 1] + (i & 1);


Scanner is a predefined class in Java used to take input from the user. It is present in the java.util package and supports different types of input such as integers, strings, float values, and characters. The Scanner class makes input handling simple and user-friendly in Java programs.

Used to read user input from keyboard.
Supports different data types like int, double, String, etc.
Uses methods such as nextInt(), nextLine(), and nextDouble().

Important Points about Scanner Class
System.in is used for keyboard input; File object is used for file input.
Use nextXYZ() methods for numeric inputs like nextInt(), nextShort(), etc.
Use nextLine() to read a full string/line.
Use next().charAt(0) to read a single character.
Always close the Scanner object after use.
Scanner reads input as tokens (words separated by spaces). Example: "How are you" -> "How", "are", "you".
