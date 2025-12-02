# Chapter 3: Data Structures

## 📚 Topics Covered

- **Arrays** - Single-dimensional and multi-dimensional arrays
- **ArrayList** - Dynamic arrays and their methods
- **Linked Lists** - Singly and doubly linked lists (basic concepts)
- **Stacks** - LIFO (Last In First Out) data structure
- **Queues** - FIFO (First In First Out) data structure
- **Trees** - Binary trees, BST, tree traversal (basic overview)
- **Graphs** - Basic concepts and representations (overview)

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Work efficiently with arrays and ArrayLists
- ✅ Understand when to use each data structure
- ✅ Implement basic operations on arrays and lists
- ✅ Solve problems using arrays and lists
- ✅ Understand time and space complexity basics

## 📁 Files in This Chapter

- `ArrayMethods.java` - Built-in array methods
- `ArrayListMethods.java` - ArrayList operations and methods
- `problems/ArrayProblems.java` - Array-based problem solving
- `LinkedListBasics.java` - _[ADDED]_ Basic linked list operations
- `StackImplementation.java` - _[ADDED]_ Stack implementation
- `QueueImplementation.java` - _[ADDED]_ Queue implementation
- `README.md` - This file

## 💡 Key Concepts

### Arrays

```java
// Array declaration and initialization
int[] numbers = new int[5];           // Default values: 0
int[] numbers2 = {1, 2, 3, 4, 5};   // Direct initialization

// Multi-dimensional arrays
int[][] matrix = new int[3][3];
matrix[0][0] = 1;

// Array operations
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// Enhanced for loop
for (int num : numbers) {
    System.out.println(num);
}

// Array sorting
Arrays.sort(numbers);

// Array searching
int index = Arrays.binarySearch(numbers, 3);
```

### ArrayList

```java
ArrayList<Integer> list = new ArrayList<>();

// Add elements
list.add(10);
list.add(20);
list.add(30);

// Access elements
int first = list.get(0);

// Remove elements
list.remove(0);

// Size
int size = list.size();

// Iterate
for (Integer num : list) {
    System.out.println(num);
}
```

### Linked List (Basic)

```java
// A simple node structure for linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### Stack (LIFO)

```java
// Using Stack class
Stack<Integer> stack = new Stack<>();

// Push
stack.push(10);
stack.push(20);
stack.push(30);

// Pop
int top = stack.pop();  // 30

// Peek
int peek = stack.peek(); // Doesn't remove

// Check if empty
boolean empty = stack.isEmpty();
```

### Queue (FIFO)

```java
// Using Queue interface with LinkedList
Queue<Integer> queue = new LinkedList<>();

// Enqueue (add)
queue.add(10);
queue.add(20);
queue.add(30);

// Dequeue (remove)
int front = queue.remove();  // 10

// Peek
int head = queue.peek();  // Doesn't remove
```

## 📝 Common Array Problems

1. Find the maximum/minimum element
2. Reverse an array
3. Find duplicate elements
4. Rotate array by k positions
5. Find the second largest element
6. Merge sorted arrays
7. Two-pointer technique problems

## 📊 Time & Space Complexity Reference

| Data Structure | Access | Search | Insertion | Deletion |
| -------------- | ------ | ------ | --------- | -------- |
| Array          | O(1)   | O(n)   | O(n)      | O(n)     |
| ArrayList      | O(1)   | O(n)   | O(n)      | O(n)     |
| Linked List    | O(n)   | O(n)   | O(1)\*    | O(1)\*   |
| Stack          | O(n)   | O(n)   | O(1)      | O(1)     |
| Queue          | O(n)   | O(n)   | O(1)      | O(1)     |

\*After finding the position

## 🔗 Related Topics

- Previous: Chapter 2 - Object-Oriented Programming
- Next: Chapter 4 - Collection Framework
- Related: Chapter 9 - Generics

---

**Note**: This chapter is crucial for understanding algorithm optimization. Study the complexity analysis and practice problems extensively.
