# Java Streams 

# Interview Questions and Answers

## 1. What is the Stream API?

> The Stream API is used to process sequences of data declaratively through operations such as filtering, mapping, sorting, matching, reduction, and collection.

---

## 2. Is a Stream a data structure?

> No. A Stream does not store data. It processes data from a source such as a collection, array, file, or generated sequence.

---

## 3. What is the difference between a Collection and a Stream?

> A Collection stores elements, while a Stream processes elements. A Collection can usually be traversed multiple times, while a Stream is consumed after one terminal operation.

---

## 4. What is external iteration?

> External iteration means the developer controls traversal using loops or iterators.

---

## 5. What is internal iteration?

> Internal iteration means the Stream controls traversal, while the developer provides only the processing behavior.

---

## 6. What are the parts of a Stream pipeline?

> A Stream pipeline contains a source, zero or more intermediate operations, and one terminal operation.

---

## 7. What are intermediate operations?

> Intermediate operations transform or configure a Stream and return another Stream. Examples include `filter`, `map`, `sorted`, `distinct`, `limit`, and `skip`.

---

## 8. What are terminal operations?

> Terminal operations trigger pipeline execution and produce a final result or side effect. Examples include `toList`, `collect`, `forEach`, `count`, `findFirst`, `reduce`, and matching operations.

---

## 9. What is lazy evaluation?

> Lazy evaluation means intermediate operations are not executed immediately. They are executed only when a terminal operation is invoked.

---

## 10. Why did Java use lazy evaluation?

> Lazy evaluation avoids unnecessary computation and intermediate collections, enables pipeline optimization, reduces memory usage, and supports short-circuiting.

---

## 11. What is pipeline processing?

> Pipeline processing means an element commonly moves through the required intermediate operations before the next element is processed.

---

## 12. Does Stream always process every element?

> No. Short-circuiting operations such as `limit`, `findFirst`, and `anyMatch` may stop processing early.

---

## 13. What is short-circuiting?

> Short-circuiting means Stream execution stops as soon as the final answer is known.

---

## 14. Difference between `filter()` and `map()`?

> `filter()` decides which elements remain based on a boolean condition. `map()` transforms each remaining element into another value.

---

## 15. Which functional interface does `filter()` use?

> `filter()` uses `Predicate<T>` because it needs an input and returns a boolean.

---

## 16. Which functional interface does `map()` use?

> `map()` uses `Function<T, R>` because it transforms an input value into an output value.

---

## 17. Which functional interface does `forEach()` use?

> `forEach()` uses `Consumer<T>` because it accepts an element and returns nothing.

---

## 18. Why can a Stream be used only once?

> A Stream represents a single traversal over a data source. A terminal operation consumes and closes it. Reusing it would require buffering or resetting traversal state, which would increase complexity and memory usage.

---

## 19. Which exception occurs when reusing a Stream?

```text
java.lang.IllegalStateException:
stream has already been operated upon or closed
```

---

## 20. Why is `forEach()` a terminal operation?

> It triggers Stream execution, consumes the Stream, performs a side effect, and does not return another Stream.

---

## 21. Why should `forEach()` not be used to build collections?

> It introduces external mutable state, reduces readability, and may become unsafe in parallel Streams. `map()` with `toList()` or `collect()` is preferred.

---

## 22. Difference between Collection `forEach()` and Stream `forEach()`?

> Collection `forEach()` directly iterates over collection elements. Stream `forEach()` terminates a Stream pipeline after intermediate operations.

---

## 23. Difference between `peek()` and `forEach()`?

> `peek()` is intermediate and mainly used for observing or debugging pipeline elements. `forEach()` is terminal and ends the pipeline.

---

## 24. Does `peek()` execute without a terminal operation?

> No. Because Streams are lazy, `peek()` does not execute unless a terminal operation triggers the pipeline.

---

## 25. Is `Stream.toList()` mutable?

> No. `Stream.toList()` returns an unmodifiable list.

---

## 26. Difference between `toList()` and `Collectors.toList()`?

> `Stream.toList()` is shorter and returns an unmodifiable list. `Collectors.toList()` does not guarantee a particular list type or mutability contract. For an explicitly mutable list, use `Collectors.toCollection(ArrayList::new)`.

---

## 27. What is `groupingBy()`?

> `groupingBy()` groups elements based on a classifier function and returns a Map where each key maps to a group of elements.

---

## 28. What is `partitioningBy()`?

> `partitioningBy()` divides elements into two boolean groups: `true` and `false`.

---

## 29. Difference between `groupingBy()` and `partitioningBy()`?

> `groupingBy()` can create many groups, while `partitioningBy()` always creates boolean groups.

---

## 30. What problem can occur with `Collectors.toMap()`?

> Duplicate keys cause an `IllegalStateException` unless a merge function is provided.

---

## 31. What does `Function.identity()` mean?

> It returns the same value it receives. It is equivalent to `value -> value`.

---

## 32. Why does `count()` return `long`?

> Because a Stream may theoretically contain more elements than the maximum value supported by `int`.

---

## 33. Difference between `findFirst()` and `findAny()`?

> `findFirst()` respects encounter order. `findAny()` may return any element and can perform better in parallel Streams.

---

## 34. Why do `findFirst()`, `min()`, and `max()` return `Optional`?

> Because the Stream may be empty, so no value may exist.

---

## 35. Difference between `anyMatch()`, `allMatch()`, and `noneMatch()`?

> `anyMatch()` checks whether at least one element matches. `allMatch()` checks whether every element matches. `noneMatch()` checks whether no element matches.

---

## 36. What does `allMatch()` return for an empty Stream?

> `true`, because there is no element violating the condition.

---

## 37. What does `noneMatch()` return for an empty Stream?

> `true`, because there is no matching element.

---

## 38. What does `anyMatch()` return for an empty Stream?

> `false`, because no element matched.

---

## 39. What is reduction?

> Reduction combines multiple Stream elements into one result, such as a sum, product, maximum, or combined object.

---

## 40. What is the identity value in `reduce()`?

> The identity is the starting value and must not change the result when combined with an element. For addition it is `0`; for multiplication it is `1`.

---

## 41. Why does `reduce()` without identity return `Optional`?

> Because an empty Stream has no value to reduce.

---

## 42. What is the combiner in three-argument `reduce()`?

> The combiner merges partial results, especially when a Stream is processed in parallel.

---

## 43. Difference between `collect()` and `reduce()`?

> `reduce()` is generally used for immutable scalar-like results, while `collect()` is used for mutable result containers such as Lists, Sets, and Maps.

---

## 44. Why are primitive Streams useful?

> Primitive Streams such as `IntStream` avoid repeated boxing and unboxing and provide numeric operations such as `sum`, `average`, and `summaryStatistics`.

---

## 45. Why are side effects discouraged in Streams?

> Side effects make code harder to reason about and can create race conditions or corrupted results in parallel Streams.

---

## 46. Is order guaranteed in parallel `forEach()`?

> No. Use `forEachOrdered()` when encounter order must be preserved.

---

## 47. Why can `forEachOrdered()` reduce parallel performance?

> Preserving encounter order requires additional coordination between parallel workers.

---

## 48. Are Streams always faster than loops?

> No. Streams improve readability and provide optimization opportunities, but for small or simple operations, loops may be equally fast or faster. Parallel Streams also have overhead and should be used only when appropriate.

---

## 49. Should database results always be filtered using Streams?

> No. Filtering should usually happen in the database using repository queries. Loading all records and filtering them in memory wastes database, network, and application resources.

---

## 50. Give a strong interview definition of Streams.

> A Stream is a single-use, lazy, declarative processing pipeline over a sequence of elements. It does not store data. Intermediate operations build the pipeline, and a terminal operation triggers execution and consumes the Stream.

---

# Output-Based Interview Questions

## Question 1

```java
List<Integer> numbers = List.of(1, 2, 3);

numbers.stream()
       .map(n -> {
           System.out.println("Map: " + n);
           return n * 2;
       })
       .filter(n -> {
           System.out.println("Filter: " + n);
           return n > 2;
       })
       .count();
```

### Output

```text
Map: 1
Filter: 2
Map: 2
Filter: 4
Map: 3
Filter: 6
```

Final count:

```text
2
```

---

## Question 2

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

numbers.stream()
       .filter(n -> {
           System.out.println(n);
           return n % 2 == 0;
       });
```

### Output

```text
Nothing
```

Reason: no terminal operation.

---

## Question 3

```java
Stream<Integer> stream =
        List.of(1, 2, 3).stream();

System.out.println(stream.count());

stream.forEach(System.out::println);
```

### Output

```text
3
```

Then:

```text
IllegalStateException
```

---

## Question 4

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5, 6);

numbers.stream()
       .filter(n -> {
           System.out.println("Filter: " + n);
           return n % 2 == 0;
       })
       .limit(2)
       .forEach(System.out::println);
```

### Output

```text
Filter: 1
Filter: 2
2
Filter: 3
Filter: 4
4
```

Processing stops early.

---

## Question 5

```java
List<Integer> result =
        List.of(1, 2, 3, 4, 5)
            .stream()
            .filter(n -> n % 2 != 0)
            .map(n -> n * 10)
            .toList();
```

### Result

```text
[10, 30, 50]
```

---

## Question 6

```java
int result =
        List.of(1, 2, 3, 4, 5)
            .stream()
            .filter(n -> n % 2 != 0)
            .map(n -> n * 10)
            .reduce(0, Integer::sum);
```

### Result

```text
90
```

---

## Question 7

```java
boolean result =
        Stream.<Integer>empty()
              .allMatch(n -> n > 10);
```

### Result

```text
true
```

---

## Question 8

```java
boolean result =
        Stream.<Integer>empty()
              .anyMatch(n -> n > 10);
```

### Result

```text
false
```

---

## Question 9

```java
List<Integer> result =
        Stream.of(1, 2, 3).toList();

result.add(4);
```

### Result

```text
UnsupportedOperationException
```

---

## Question 10

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

numbers.parallelStream()
       .forEach(System.out::println);
```

### Result

All numbers print, but order is not guaranteed.

---

# Final Revision Flow

```text
Collection stores data
        ↓
stream() creates processing pipeline
        ↓
Intermediate operations are added
        ↓
Nothing executes yet
        ↓
Terminal operation is called
        ↓
Lazy pipeline begins execution
        ↓
Elements flow through operations
        ↓
Short-circuiting may stop early
        ↓
Final result or side effect is produced
        ↓
Stream becomes consumed
        ↓
Stream cannot be reused
```
