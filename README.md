# HDFC Life Claim Amount Algorithms

A plain Java console application demonstrating array manipulation,
two-pointer algorithms, sliding window techniques, recursive binary
search, and custom exception handling.

## Seed Data

The claim amounts are:

25000, 18000, 42000, 15000, 31000, 9000

The data is loaded using `add()` into a raw `int[]`.

---

## Complexity Table

| Method | Time Complexity | Extra Space |
|---|---:|---:|
| ClaimAmountStore.add() | O(1) | O(1) |
| ClaimAmountStore.insert() | O(n) | O(1) |
| ClaimAmountStore.delete() | O(n) | O(1) |
| ClaimAmountStore.toArray() | O(n) | O(n) |
| PairSumSolver.bruteForce() | O(n²) | O(1) |
| PairSumSolver.twoPointer() | O(n log n) | O(n) |
| PalindromeChecker.isPalindrome() | O(d) | O(d) |
| PartitionSolver.partition() | O(n) | O(n) |
| SlidingWindowSolver.maxSum() | O(n) | O(1) |
| UniqueSubstringSolver.longestUniqueSubstring() | O(n) average | O(n) |
| BinarySearcher.search() | O(log n) | O(log n) |

Here `n` is the number of claim amounts and `d` is the number of
digits in the number.

---

## Algorithm Notes

### Array Insert and Delete

Insertion shifts elements to the right and deletion shifts elements
to the left. Both operations modify the same raw array in place.

Insertion and deletion take O(n) time and O(1) extra space.

### Pair Sum

Two implementations are provided.

The brute-force implementation checks every possible pair and takes
O(n²) time.

The two-pointer implementation sorts a copy of the array and then
uses two pointers. Sorting dominates the running time, resulting in
O(n log n) time.

### Palindrome

The palindrome checker uses two pointers from the beginning and end
of the digit representation. It does not reverse the number.

### Partition

The partition algorithm uses the required Hoare-style two-pointer
algorithm around pivot 20000.

Values less than or equal to the pivot are placed on the left and
values greater than the pivot are placed on the right.

### Sliding Window

The first window is summed once. Each subsequent window adds the new
right element and subtracts the element that leaves the window.

This gives O(n) time.

### Longest Unique Substring

A sliding window and HashSet are used. When a duplicate character is
found, characters are removed from the left until the window becomes
unique again.

### Recursive Binary Search

The array is sorted first. The binary search recursively searches
either the left or right half.

It takes O(log n) time and O(log n) extra space due to the recursive
call stack.

---

## Why use two-pointer / sliding-window techniques?

For large datasets, brute-force solutions can become expensive.

For example, with 1,000,000 claim amounts, a brute-force pair-sum
algorithm requires O(n²) comparisons, which can be extremely large.

The sort-and-two-pointer approach reduces the search phase to O(n)
after sorting, with total complexity O(n log n).

Similarly, the sliding-window algorithm avoids recalculating every
window from scratch and therefore runs in O(n) time.
