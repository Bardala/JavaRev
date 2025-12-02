# Chapter 12: Algorithms and Problem Solving

## 📚 Topics Covered

- **Sorting Algorithms** - Bubble sort, merge sort, quick sort
- **Searching Algorithms** - Linear search, binary search
- **Recursion** - Recursive problem solving
- **Dynamic Programming** - Optimization with memoization
- **Graph Algorithms** - BFS, DFS, shortest path
- **String Algorithms** - Pattern matching, anagrams
- **Problem-Solving Techniques** - Two pointers, sliding window, greedy

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Implement and understand various sorting algorithms
- ✅ Choose appropriate algorithms for problems
- ✅ Solve problems using recursion
- ✅ Apply dynamic programming techniques
- ✅ Understand time and space complexity
- ✅ Optimize solutions for performance
- ✅ Solve LeetCode-style coding problems

## 📁 Files in This Chapter

- `BubbleSort.java` - Bubble sort implementation
- `Fibonacci.java` - Fibonacci with recursion
- `ReverseLinkedList.java` - Linked list operations
- `SortingAlgorithms.java` - _[ADDED]_ All common sorting algorithms
- `SearchingAlgorithms.java` - _[ADDED]_ Search implementations
- `DynamicProgramming.java` - _[ADDED]_ DP examples
- `GraphAlgorithms.java` - _[ADDED]_ BFS, DFS implementations
- `StringProblems.java` - Various string problems
- `ArrayProblems.java` - Various array problems
- `README.md` - This file

## 💡 Key Concepts

### Sorting Algorithms

#### Bubble Sort - O(n²)

```java
public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

#### Merge Sort - O(n log n)

```java
public class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
```

#### Quick Sort - O(n log n) average

```java
public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
```

### Searching Algorithms

#### Linear Search - O(n)

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

#### Binary Search - O(log n) (requires sorted array)

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```

### Recursion

#### Fibonacci - O(2^n) naive, O(n) with memoization

```java
// Naive recursion - very slow
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// With memoization
public static int fibonacciMemo(int n, Map<Integer, Integer> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) {
        return memo.get(n);
    }

    int result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
    memo.put(n, result);
    return result;
}

// Usage
Map<Integer, Integer> memo = new HashMap<>();
int result = fibonacciMemo(40, memo);  // Much faster
```

#### Factorial - O(n)

```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

### Dynamic Programming

#### Coin Change - Min coins for amount

```java
public static int minCoins(int[] coins, int amount) {
    int[] dp = new int[amount + 1];

    // Initialize with max value
    for (int i = 1; i <= amount; i++) {
        dp[i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
}
```

### Two-Pointer Technique

#### Sum of Two Numbers

```java
public static int[] twoSum(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return new int[]{arr[left], arr[right]};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{};
}
```

### Sliding Window

#### Max Sum Subarray of Size K

```java
public static int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0, windowSum = 0;

    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;

    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

## 📊 Algorithm Complexity Reference

| Algorithm     | Time Complexity | Space Complexity | Best For                    |
| ------------- | --------------- | ---------------- | --------------------------- |
| Bubble Sort   | O(n²)           | O(1)             | Small arrays, nearly sorted |
| Merge Sort    | O(n log n)      | O(n)             | General purpose, stable     |
| Quick Sort    | O(n log n) avg  | O(log n)         | General purpose, in-place   |
| Linear Search | O(n)            | O(1)             | Unsorted data               |
| Binary Search | O(log n)        | O(1)             | Sorted data                 |
| Hash Table    | O(1) avg        | O(n)             | Lookups                     |

## 📝 Common LeetCode Problem Types

1. **Array Problems** - Two sum, contains duplicate, best time to buy stock
2. **String Problems** - Palindrome, anagrams, longest substring
3. **Linked List** - Reverse, merge, cycle detection
4. **Tree/Graph** - Traversal, level order, path sum
5. **Dynamic Programming** - Fibonacci, climbing stairs, house robber
6. **Greedy** - Interval scheduling, activity selection

## 💡 Problem-Solving Strategy

1. ✅ Understand the problem thoroughly
2. ✅ Identify patterns and similar problems
3. ✅ Start with brute force solution
4. ✅ Optimize step by step
5. ✅ Test edge cases
6. ✅ Consider time and space trade-offs

## 📝 Practice Resources

- LeetCode.com (Free tier available)
- HackerRank.com
- CodeSignal.com
- InterviewBit.com

## 🔗 Related Topics

- Previous: Chapter 11 - Multithreading
- All previous chapters (foundation)

---

**Note**: _[ADDED BY ASSISTANT]_ Algorithm mastery is crucial for technical interviews and writing efficient code. Start with understanding complexity analysis, then practice solving problems systematically. Focus on recognizing patterns rather than memorizing solutions.
