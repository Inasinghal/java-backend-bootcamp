# Java Streams 

## 1. Why Streams Were Introduced

### Problem

Before Streams, data processing was usually done using loops.

Example requirement:

* Keep only adult users
* Convert them to names
* Print those names

Traditional code:

```java
for (User user : users) {
    if (user.getAge() >= 18) {
        String name = user.getName();
        System.out.println(name);
    }
}
```

### Limitation

This code mixes multiple responsibilities:

* Iteration
* Filtering
* Transformation
* Final action

For complex requirements, loops become long and may require temporary collections.

Example:

```java
List<String> names = new ArrayList<>();

for (User user : users) {
    if (user.getAge() >= 18) {
        names.add(user.getName());
    }
}
```

### Java's Solution

Streams allow us to express the processing pipeline declaratively.

```java
users.stream()
     .filter(user -> user.getAge() >= 18)
     .map(User::getName)
     .forEach(System.out::println);
```

This reads like:

```text
Take users
    ↓
Keep adults
    ↓
Convert users to names
    ↓
Print names
```

---

# 2. External Iteration vs Internal Iteration

## External Iteration

In a loop, the developer controls traversal.

```java
for (User user : users) {
    // processing
}
```

The developer decides:

* how to get each element;
* when to move to the next element;
* when to stop.

## Internal Iteration

With Streams, Java controls traversal.

```java
users.stream()
     .filter(User::isActive)
     .toList();
```

The developer only provides the processing logic.

---

# 3. What Is a Stream?

A Stream is a sequence of elements that supports declarative data-processing operations.

Important:

> A Stream is not a data structure.

A collection stores data.

```java
List<User> users;
```

A Stream processes data.

```java
users.stream();
```

Mental model:

```text
Collection = stores data

Stream = processes data
```

---

# 4. Does a Stream Modify the Original Collection?

Normally, no.

```java
List<Integer> numbers = List.of(1, 2, 3);

List<Integer> doubled =
        numbers.stream()
               .map(number -> number * 2)
               .toList();
```

Original:

```text
[1, 2, 3]
```

Result:

```text
[2, 4, 6]
```

The original collection remains unchanged.

However, a Stream operation may still mutate objects if the supplied lambda changes them. That is usually discouraged.

---

# 5. Stream Pipeline Structure

A Stream pipeline usually has three parts:

```text
Source
   ↓
Intermediate operations
   ↓
Terminal operation
```

Example:

```java
users.stream()
     .filter(user -> user.getAge() >= 18)
     .map(User::getName)
     .toList();
```

## Source

```java
users.stream()
```

## Intermediate Operations

```java
filter()
map()
```

## Terminal Operation

```java
toList()
```

---

# 6. Intermediate Operations

Intermediate operations return another Stream.

Examples:

```java
filter()
map()
sorted()
distinct()
limit()
skip()
peek()
```

They do not normally execute immediately.

Example:

```java
Stream<User> adults =
        users.stream()
             .filter(user -> user.getAge() >= 18);
```

The pipeline is built, but processing has not started yet.

---

# 7. Terminal Operations

Terminal operations end the pipeline and trigger execution.

Examples:

```java
forEach()
toList()
collect()
count()
findFirst()
findAny()
anyMatch()
allMatch()
noneMatch()
reduce()
min()
max()
```

After a terminal operation, the Stream is consumed.

---

# 8. `filter()`

## Purpose

`filter()` decides which elements remain in the Stream.

Example:

```java
List<Integer> evenNumbers =
        numbers.stream()
               .filter(number -> number % 2 == 0)
               .toList();
```

Input:

```text
[1, 2, 3, 4, 5, 6]
```

Result:

```text
[2, 4, 6]
```

## Functional Interface Used

`filter()` accepts a `Predicate<T>`.

Pattern:

```text
Input → boolean
```

Conceptually:

```java
Predicate<Integer> isEven =
        number -> number % 2 == 0;
```

For every element, Stream calls:

```java
isEven.test(number);
```

---

# 9. `map()`

## Purpose

`map()` transforms every element into another value.

Example:

```java
List<String> names =
        users.stream()
             .map(User::getName)
             .toList();
```

Type transformation:

```text
Stream<User>
      ↓
Stream<String>
```

## Functional Interface Used

`map()` accepts a `Function<T, R>`.

Pattern:

```text
Input → Output
```

Example:

```java
Function<User, String> getName =
        User::getName;
```

---

# 10. `filter()` vs `map()`

## `filter()`

* Selects elements
* Uses a boolean condition
* May reduce the number of elements
* Usually keeps the same element type

Example:

```java
.filter(user -> user.getAge() >= 18)
```

```text
Stream<User> → Stream<User>
```

## `map()`

* Transforms elements
* Does not decide whether an element remains
* Can change the element type

Example:

```java
.map(User::getName)
```

```text
Stream<User> → Stream<String>
```

---

# 11. Lazy Evaluation

## Problem

Consider:

```java
names.stream()
     .filter(name -> {
         System.out.println("Checking: " + name);
         return name.length() > 3;
     });
```

Nothing is printed.

Why?

Because `filter()` is an intermediate operation.

It only builds the pipeline.

## Definition

> Lazy evaluation means intermediate Stream operations do not execute immediately. They execute only when a terminal operation is invoked.

Example:

```java
names.stream()
     .filter(name -> {
         System.out.println("Checking: " + name);
         return name.length() > 3;
     })
     .toList();
```

Now the terminal operation triggers execution.

---

# 12. Why Lazy Evaluation Is Useful

Lazy evaluation provides:

* Reduced unnecessary computation
* No unnecessary intermediate collections
* Better memory usage
* Pipeline optimization
* Short-circuiting
* Efficient element-by-element processing

Without laziness, Java might need to create a new collection after every operation.

```text
filter
  ↓
temporary list
  ↓
map
  ↓
temporary list
  ↓
limit
  ↓
temporary list
```

Streams avoid this in many cases.

---

# 13. Pipeline Processing

Streams commonly process one element through the pipeline before moving to the next.

Example:

```java
numbers.stream()
       .filter(n -> {
           System.out.println("Filter: " + n);
           return n % 2 == 0;
       })
       .map(n -> {
           System.out.println("Map: " + n);
           return n * 10;
       })
       .toList();
```

For:

```text
[1, 2, 3, 4]
```

Output:

```text
Filter: 1
Filter: 2
Map: 2
Filter: 3
Filter: 4
Map: 4
```

Java does not necessarily process all filtering first and all mapping afterward.

Conceptually:

```text
1 → filter → rejected

2 → filter → accepted → map → 20

3 → filter → rejected

4 → filter → accepted → map → 40
```

---

# 14. Order of Intermediate Operations Matters

Example:

```java
numbers.stream()
       .map(n -> n * 2)
       .filter(n -> n > 2)
       .count();
```

Input:

```text
[1, 2, 3]
```

Processing:

```text
1 → map to 2 → filter false

2 → map to 4 → filter true

3 → map to 6 → filter true
```

Final count:

```text
2
```

Because `map()` appears before `filter()`, mapping happens first.

If the order is reversed, the result or efficiency may change.

---

# 15. Short-Circuiting

Short-circuiting means Stream processing stops when the final answer is already known.

Example:

```java
numbers.stream()
       .filter(n -> {
           System.out.println("Filter: " + n);
           return n % 2 == 0;
       })
       .limit(2)
       .forEach(System.out::println);
```

For:

```text
[1,2,3,4,5,6,7,8,9,10]
```

Output:

```text
Filter: 1
Filter: 2
2
Filter: 3
Filter: 4
4
```

The Stream stops after finding two even numbers.

It does not process `5` to `10`.

---

# 16. Common Short-Circuiting Operations

```java
limit()
findFirst()
findAny()
anyMatch()
allMatch()
noneMatch()
```

## `limit(n)`

Stops after collecting `n` elements.

## `findFirst()`

Stops after finding the first element.

## `findAny()`

Stops after finding any element.

## `anyMatch()`

Stops after the first matching element.

## `allMatch()`

Stops after the first non-matching element.

## `noneMatch()`

Stops after the first matching element.

---

# 17. Why Streams Cannot Be Reused

Example:

```java
Stream<Integer> stream =
        List.of(1, 2, 3, 4).stream();

System.out.println(stream.count());

stream.forEach(System.out::println);
```

First output:

```text
4
```

Then Java throws:

```text
java.lang.IllegalStateException:
stream has already been operated upon or closed
```

## Reason

A Stream represents one traversal over a data source.

After a terminal operation:

* the Stream has been consumed;
* it is closed;
* it cannot be traversed again.

Allowing reuse would require Java to:

* buffer processed data;
* rewind the Stream;
* recreate internal traversal state;
* or re-read the source.

That would increase memory usage and complexity.

Create a new Stream instead:

```java
numbers.stream().count();

numbers.stream().forEach(System.out::println);
```

---

# 18. `forEach()`

## Purpose

Performs an action on every element.

```java
names.stream()
     .forEach(System.out::println);
```

## Functional Interface Used

`forEach()` accepts a `Consumer<T>`.

Pattern:

```text
Input → void
```

Conceptually:

```java
Consumer<String> printer =
        System.out::println;
```

## Why It Is Terminal

It:

* triggers execution;
* consumes the Stream;
* performs a side effect;
* returns `void`.

---

# 19. Avoid Using `forEach()` for Transformation

Bad:

```java
List<String> result = new ArrayList<>();

users.stream()
     .forEach(user -> result.add(user.getName()));
```

Problems:

* external mutable state;
* difficult to reason about;
* unsafe with parallel Streams;
* not declarative.

Better:

```java
List<String> result =
        users.stream()
             .map(User::getName)
             .toList();
```

---

# 20. Collection `forEach()` vs Stream `forEach()`

## Collection `forEach()`

```java
names.forEach(System.out::println);
```

Directly iterates over the collection.

Use when no Stream pipeline is required.

## Stream `forEach()`

```java
names.stream()
     .filter(name -> name.length() > 3)
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

Ends a Stream pipeline.

---

# 21. `forEach()` and Parallel Streams

Sequential:

```java
numbers.stream()
       .forEach(System.out::println);
```

Encounter order is normally preserved.

Parallel:

```java
numbers.parallelStream()
       .forEach(System.out::println);
```

Order is not guaranteed.

Possible output:

```text
3
1
4
2
```

To preserve order:

```java
numbers.parallelStream()
       .forEachOrdered(System.out::println);
```

`forEachOrdered()` may reduce parallel performance.

---

# 22. `peek()` vs `forEach()`

## `peek()`

Intermediate operation.

```java
users.stream()
     .peek(System.out::println)
     .filter(User::isActive)
     .toList();
```

Used mainly for observing or debugging the pipeline.

It does not execute without a terminal operation.

```java
users.stream()
     .peek(System.out::println);
```

Prints nothing.

## `forEach()`

Terminal operation.

```java
users.stream()
     .forEach(System.out::println);
```

Ends the pipeline.

Avoid using `peek()` for important business logic.

---

# 23. `toList()`

Collects Stream elements into a List.

```java
List<Integer> result =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .toList();
```

Important:

`Stream.toList()` returns an unmodifiable list.

```java
result.add(10);
```

Throws:

```text
UnsupportedOperationException
```

---

# 24. `collect()`

`collect()` provides more flexible collection building.

```java
List<String> names =
        users.stream()
             .map(User::getName)
             .collect(Collectors.toList());
```

For an explicitly mutable list:

```java
List<String> names =
        users.stream()
             .map(User::getName)
             .collect(Collectors.toCollection(ArrayList::new));
```

---

# 25. `toList()` vs `Collectors.toList()`

## `Stream.toList()`

```java
stream.toList();
```

* Short syntax
* Returns an unmodifiable list
* Good when mutation is not required

## `Collectors.toList()`

```java
stream.collect(Collectors.toList());
```

* Does not guarantee a specific concrete list type
* Mutability should not be assumed from the contract

## Explicit Mutable List

```java
stream.collect(Collectors.toCollection(ArrayList::new));
```

Use this when you definitely need a mutable `ArrayList`.

---

# 26. Collecting to a Set

```java
Set<String> uniqueNames =
        users.stream()
             .map(User::getName)
             .collect(Collectors.toSet());
```

Specific implementation:

```java
Set<String> sortedNames =
        users.stream()
             .map(User::getName)
             .collect(Collectors.toCollection(TreeSet::new));
```

---

# 27. Joining Strings

```java
String result =
        users.stream()
             .map(User::getName)
             .collect(Collectors.joining(", "));
```

Result:

```text
Ayush, Ina, Rahul
```

With prefix and suffix:

```java
.collect(Collectors.joining(", ", "[", "]"));
```

Result:

```text
[Ayush, Ina, Rahul]
```

---

# 28. `groupingBy()`

Groups elements by a key.

```java
Map<String, List<User>> usersByDepartment =
        users.stream()
             .collect(Collectors.groupingBy(
                     User::getDepartment
             ));
```

Example:

```text
IT → [User1, User2]

HR → [User3]
```

Count by group:

```java
Map<String, Long> countByDepartment =
        users.stream()
             .collect(Collectors.groupingBy(
                     User::getDepartment,
                     Collectors.counting()
             ));
```

---

# 29. `partitioningBy()`

Splits data into two boolean groups.

```java
Map<Boolean, List<User>> usersByAge =
        users.stream()
             .collect(Collectors.partitioningBy(
                     user -> user.getAge() >= 18
             ));
```

Result:

```text
true  → adults
false → minors
```

Difference:

```text
groupingBy()      → many possible groups

partitioningBy()  → exactly true and false groups
```

---

# 30. `mapping()` Inside Grouping

```java
Map<String, List<String>> namesByDepartment =
        users.stream()
             .collect(Collectors.groupingBy(
                     User::getDepartment,
                     Collectors.mapping(
                             User::getName,
                             Collectors.toList()
                     )
             ));
```

Instead of storing full users, this stores only user names in each group.

---

# 31. `toMap()`

```java
Map<Long, User> userMap =
        users.stream()
             .collect(Collectors.toMap(
                     User::getId,
                     Function.identity()
             ));
```

`Function.identity()` means:

```java
user -> user
```

## Duplicate Key Problem

This may throw an exception:

```java
Collectors.toMap(
        User::getDepartment,
        User::getName
);
```

because multiple users may have the same department.

Use a merge function:

```java
Map<String, String> map =
        users.stream()
             .collect(Collectors.toMap(
                     User::getDepartment,
                     User::getName,
                     (existing, replacement) -> existing
             ));
```

Keep the replacement value:

```java
(existing, replacement) -> replacement
```

---

# 32. `count()`

Returns the number of elements.

```java
long count =
        users.stream()
             .filter(User::isActive)
             .count();
```

Return type:

```java
long
```

Why `long`?

Because a Stream may theoretically contain more elements than the maximum `int` value.

---

# 33. `findFirst()`

Returns the first element in encounter order.

```java
Optional<User> user =
        users.stream()
             .filter(User::isActive)
             .findFirst();
```

Returns `Optional<User>` because there may be no matching element.

Example:

```java
User user =
        users.stream()
             .filter(User::isActive)
             .findFirst()
             .orElseThrow();
```

It is short-circuiting.

---

# 34. `findAny()`

Returns any matching element.

```java
Optional<User> user =
        users.stream()
             .filter(User::isActive)
             .findAny();
```

In sequential Streams, it often returns the first element, but this is not guaranteed.

In parallel Streams, it may return whichever element is found first by any worker.

Use:

* `findFirst()` when order matters
* `findAny()` when any result is acceptable

---

# 35. `anyMatch()`

Returns `true` when at least one element matches.

```java
boolean hasAdult =
        users.stream()
             .anyMatch(user -> user.getAge() >= 18);
```

Stops at the first match.

---

# 36. `allMatch()`

Returns `true` when every element matches.

```java
boolean allAdults =
        users.stream()
             .allMatch(user -> user.getAge() >= 18);
```

Stops at the first failure.

---

# 37. `noneMatch()`

Returns `true` when no element matches.

```java
boolean noBlockedUser =
        users.stream()
             .noneMatch(User::isBlocked);
```

Stops at the first matching element.

---

# 38. Empty Stream Match Behavior

For an empty Stream:

```java
Stream<Integer> empty = Stream.empty();
```

## `anyMatch()`

```java
empty.anyMatch(n -> n > 0);
```

Result:

```text
false
```

## `allMatch()`

```java
Stream.<Integer>empty()
      .allMatch(n -> n > 0);
```

Result:

```text
true
```

No element violated the condition.

## `noneMatch()`

```java
Stream.<Integer>empty()
      .noneMatch(n -> n > 0);
```

Result:

```text
true
```

No element matched.

---

# 39. `min()` and `max()`

```java
Optional<Integer> minimum =
        numbers.stream()
               .min(Integer::compareTo);
```

```java
Optional<Integer> maximum =
        numbers.stream()
               .max(Integer::compareTo);
```

Objects:

```java
Optional<User> youngest =
        users.stream()
             .min(Comparator.comparingInt(User::getAge));
```

```java
Optional<User> oldest =
        users.stream()
             .max(Comparator.comparingInt(User::getAge));
```

They return `Optional` because the Stream may be empty.

---

# 40. `reduce()`

## Purpose

Combines many elements into one result.

```text
Many values
    ↓
One value
```

Traditional sum:

```java
int sum = 0;

for (Integer number : numbers) {
    sum += number;
}
```

Stream:

```java
int sum =
        numbers.stream()
               .reduce(0, Integer::sum);
```

---

# 41. Identity and Accumulator

```java
.reduce(0, (a, b) -> a + b)
```

## Identity

```java
0
```

Starting value.

For addition:

```text
0 + x = x
```

## Accumulator

```java
(a, b) -> a + b
```

Combines the current result with the next element.

Example:

```text
0 + 1 = 1
1 + 2 = 3
3 + 3 = 6
6 + 4 = 10
```

---

# 42. Multiplication with `reduce()`

```java
int product =
        numbers.stream()
               .reduce(1, (a, b) -> a * b);
```

Identity is `1` because:

```text
1 × x = x
```

---

# 43. `reduce()` Without Identity

```java
Optional<Integer> sum =
        numbers.stream()
               .reduce(Integer::sum);
```

Returns `Optional<Integer>` because the Stream may be empty.

With identity:

```java
int sum =
        numbers.stream()
               .reduce(0, Integer::sum);
```

An empty Stream returns `0`.

---

# 44. Three-Argument `reduce()`

Especially important in parallel processing.

```java
int total =
        numbers.parallelStream()
               .reduce(
                       0,
                       Integer::sum,
                       Integer::sum
               );
```

Arguments:

```text
identity

accumulator

combiner
```

The combiner combines partial results from different workers.

---

# 45. `collect()` vs `reduce()`

Use `reduce()` for scalar or immutable results:

```java
int total =
        numbers.stream()
               .reduce(0, Integer::sum);
```

Use `collect()` for mutable result containers:

```java
List<String> names =
        users.stream()
             .map(User::getName)
             .collect(Collectors.toList());
```

Do not normally use `reduce()` to build mutable lists.

---

# 46. Primitive Streams

Java provides:

```java
IntStream
LongStream
DoubleStream
```

Example:

```java
int totalAge =
        users.stream()
             .mapToInt(User::getAge)
             .sum();
```

Useful methods:

```java
sum()
average()
min()
max()
count()
summaryStatistics()
```

---

# 47. `average()`

```java
OptionalDouble averageAge =
        users.stream()
             .mapToInt(User::getAge)
             .average();
```

Handle empty Stream:

```java
double average =
        users.stream()
             .mapToInt(User::getAge)
             .average()
             .orElse(0.0);
```

---

# 48. `summaryStatistics()`

```java
IntSummaryStatistics statistics =
        users.stream()
             .mapToInt(User::getAge)
             .summaryStatistics();
```

Provides:

```java
statistics.getCount();
statistics.getSum();
statistics.getMin();
statistics.getMax();
statistics.getAverage();
```

This avoids running multiple Stream pipelines.

---

# 49. Side Effects

A side effect means changing data outside the Stream.

Bad:

```java
int[] total = {0};

numbers.stream()
       .forEach(number -> total[0] += number);
```

Better:

```java
int total =
        numbers.stream()
               .mapToInt(Integer::intValue)
               .sum();
```

External mutable state is especially dangerous in parallel Streams.

---

# 50. Parallel Stream Danger

Bad:

```java
List<Integer> result = new ArrayList<>();

numbers.parallelStream()
       .forEach(result::add);
```

`ArrayList` is not thread-safe.

Possible problems:

* missing elements;
* corrupted state;
* unpredictable results.

Better:

```java
List<Integer> result =
        numbers.parallelStream()
               .map(number -> number * 2)
               .toList();
```

---

# 51. Spring Boot Usage

## Entity to DTO

```java
public List<UserResponse> getActiveUsers() {
    return userRepository.findAll()
            .stream()
            .filter(User::isActive)
            .map(UserMapper::toResponse)
            .toList();
}
```

## Find One User

```java
public User getUserByEmail(String email) {
    return userRepository.findAll()
            .stream()
            .filter(user ->
                    user.getEmail().equalsIgnoreCase(email)
            )
            .findFirst()
            .orElseThrow(() ->
                    new UserNotFoundException("User not found")
            );
}
```

In real applications, prefer database-level filtering:

```java
userRepository.findByEmail(email);
```

## Check Existence

```java
boolean exists =
        users.stream()
             .anyMatch(user ->
                     user.getEmail().equalsIgnoreCase(email)
             );
```

For database data, prefer:

```java
userRepository.existsByEmailIgnoreCase(email);
```

## Calculate Total Money

```java
BigDecimal total =
        orders.stream()
              .map(Order::getAmount)
              .reduce(BigDecimal.ZERO, BigDecimal::add);
```

Use `BigDecimal` instead of `double` for money.

---