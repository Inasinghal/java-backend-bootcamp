Day 6 Notes – Array Manipulation & Two Pointer Patterns

---

# 1. Reverse Array

## Algorithm

```
left = 0
right = n - 1

while(left < right)

swap

left++
right--
```

---

## Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

## Pattern

Two Pointer (Opposite Direction)

---

# 2. Check if Array is Sorted

Traverse once.

If

```java
arr[i] > arr[i+1]
```

Return false.

Else

Return true.

---

Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

# 3. Move Zeroes

Pattern

Read Pointer

Write Pointer

Algorithm

```
Read every element.

If non-zero

Copy to write pointer.

Increment write.

Finally

Fill remaining with zero.
```

---

Optimal Complexity

```
Time O(n)

Space O(1)
```

---

# 4. Remove Duplicates (Sorted Array)

Pattern

Read Pointer

Write Pointer

Algorithm

```
Compare current element with previous.

If different

Write.

Increment write.
```

Complexity

```
O(n)

O(1)
```

---

# 5. Left Rotation by One

Algorithm

```
Save first element

Shift left

Put saved element at end
```

Complexity

```
O(n)

O(1)
```

---

# 6. Left Rotation by K (Optimal)

Algorithm

```
k = k % n

Reverse first k elements

Reverse remaining elements

Reverse whole array
```

Complexity

```
O(n)

O(1)
```

---

# 7. Right Rotation by K (Optimal)

Algorithm

```
k = k % n

Reverse whole array

Reverse first k

Reverse remaining
```

Complexity

```
O(n)

O(1)
```

---

# 8. Merge Two Sorted Arrays (Extra Array)

Pattern

Three pointers

```
i

j

k
```

Algorithm

```
Compare both arrays.

Copy smaller.

Move corresponding pointer.

Copy remaining elements.
```

Complexity

```
Time

O(m+n)

Space

O(m+n)
```

---

# 9. Merge Two Sorted Arrays (Optimal)

Observation

Never merge from front.

Merge from end.

Pointers

```
l = m-1

r = n-1

i = m+n-1
```

Algorithm

```
Compare last elements.

Insert larger element at end.

Move corresponding pointer.

Copy remaining nums2 elements.
```

Complexity

```
Time

O(m+n)

Space

O(1)
```

---

# Array Patterns Learned

| Pattern                  | Problems                       |
| ------------------------ | ------------------------------ |
| Opposite Two Pointers    | Reverse Array                  |
| Read–Write Pointer       | Move Zeroes, Remove Duplicates |
| Two Arrays, Two Pointers | Merge Sorted Arrays            |
| Reversal Algorithm       | Left Rotate K, Right Rotate K  |

---

# Important Interview Questions

1. Why does Reverse Array take only O(n/2) swaps but is written as O(n)?
2. Why are arrays passed by reference in Java?
3. Difference between in-place and out-of-place algorithms?
4. Why use `k = k % n` before rotation?
5. Why does the reversal algorithm work?
6. Why merge from the end in LeetCode 88?
7. Why don't we need to copy remaining elements of `nums1` in the optimal merge?
8. Difference between Read Pointer and Write Pointer?
9. Why is Remove Duplicates possible only because the array is sorted?
10. Which array problems use the Two Pointer pattern?

---

## 🎯 Your Progress

So far, you've completed:

* ✅ Java Fundamentals
* ✅ Arrays (Complete)
* ✅ Binary Search (Complete)
* ✅ Array Manipulation & Two Pointer Patterns (Complete)

That's a very strong foundation. From here, topics like sorting, strings, linked lists, stacks, queues, and trees will build on these same problem-solving patterns rather than introducing completely new ways of thinking.
