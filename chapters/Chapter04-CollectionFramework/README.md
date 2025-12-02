# Chapter 4: Collection Framework

## 📚 Topics Covered

- **Collection Interface** - Root interface for all collections
- **List Interface** - Ordered collections (ArrayList, LinkedList, Vector)
- **Set Interface** - Unordered, unique collections (HashSet, LinkedHashSet, TreeSet)
- **Map Interface** - Key-value pairs (HashMap, LinkedHashMap, TreeMap)
- **Queue Interface** - FIFO collections (Queue, Deque, PriorityQueue)
- **Iterator** - Traversing collections
- **Comparable & Comparator** - Custom sorting

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Choose the right collection type for your use case
- ✅ Use List, Set, and Map interfaces effectively
- ✅ Implement custom sorting with Comparator
- ✅ Traverse collections using iterators
- ✅ Understand performance characteristics of each collection type
- ✅ Use the Collections utility class

## 📁 Files in This Chapter

- `CollectionInterface.java` - Collection interface basics
- `list/arrayListClass/ArrayListClass.java` - ArrayList implementation
- `list/linkedListClass/LinkedListClass.java` - LinkedList implementation
- `set/HashSetClass.java` - HashSet implementation
- `set/LinkedHashSetClass.java` - LinkedHashSet (maintains insertion order)
- `map/mapInterface.java` - Map implementations
- `TreeMapExample.java` - _[ADDED]_ TreeMap (sorted map)
- `ComparatorExample.java` - _[ADDED]_ Custom sorting with Comparator
- `IteratorExample.java` - _[ADDED]_ Iterator usage
- `README.md` - This file

## 💡 Key Concepts

### List Interface

```java
// ArrayList - Dynamic array, fast random access
List<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add("Banana");
arrayList.add(0, "Cherry");  // Insert at index

// LinkedList - Doubly-linked list, fast insertion/deletion
List<String> linkedList = new LinkedList<>();
linkedList.add("Apple");
linkedList.addFirst("Mango");
linkedList.addLast("Orange");
```

### Set Interface

```java
// HashSet - No order, no duplicates, fastest
Set<Integer> hashSet = new HashSet<>();
hashSet.add(10);
hashSet.add(20);
hashSet.add(10);  // Duplicate, won't be added

// LinkedHashSet - Maintains insertion order
Set<Integer> linkedHashSet = new LinkedHashSet<>();

// TreeSet - Sorted order, no duplicates
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(30);
treeSet.add(10);
treeSet.add(20);  // Will be sorted: 10, 20, 30
```

### Map Interface

```java
// HashMap - Key-value pairs, no order
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);
map.get("Alice");  // 25
map.containsKey("Charlie");  // false
map.remove("Bob");

// Iterate
for (String key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}

// LinkedHashMap - Maintains insertion order
Map<String, Integer> linkedMap = new LinkedHashMap<>();

// TreeMap - Sorted by keys
Map<String, Integer> treeMap = new TreeMap<>();
```

### Iterator

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");

// Using Iterator
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

// Using enhanced for loop
for (String element : list) {
    System.out.println(element);
}
```

### Comparable & Comparator

```java
// Comparable - Compare objects of same class
class Student implements Comparable<Student> {
    String name;
    int marks;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }
}

// Comparator - Compare objects without implementing Comparable
Comparator<Student> byName = new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
};

// Lambda version (Java 8+)
Comparator<Student> byMarks = (s1, s2) -> Integer.compare(s1.marks, s2.marks);

// Sorting
Collections.sort(students, byName);
```

### Queue Interface

```java
// Queue - FIFO
Queue<Integer> queue = new LinkedList<>();
queue.add(10);      // add to rear
queue.offer(20);    // alternative
queue.remove();     // remove from front
queue.poll();       // alternative

// PriorityQueue - Orders by priority
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(30);
pq.add(10);
pq.add(20);
pq.peek();  // 10 (minimum)

// Deque - Double-ended queue
Deque<Integer> deque = new LinkedList<>();
deque.addFirst(10);
deque.addLast(20);
```

## 📊 Collection Type Comparison

| Collection    | Order        | Duplicates  | Null    | Thread-Safe | Best For           |
| ------------- | ------------ | ----------- | ------- | ----------- | ------------------ |
| ArrayList     | Yes (Index)  | Yes         | Yes     | No          | Fast access        |
| LinkedList    | Yes (Index)  | Yes         | Yes     | No          | Insertion/Deletion |
| HashSet       | No           | No          | Yes (1) | No          | Uniqueness check   |
| LinkedHashSet | Yes (Insert) | No          | Yes (1) | No          | Ordered uniqueness |
| TreeSet       | Yes (Sorted) | No          | No      | No          | Sorted unique      |
| HashMap       | No           | Values: Yes | Keys: 1 | No          | Fast lookup        |
| LinkedHashMap | Yes (Insert) | Values: Yes | Keys: 1 | No          | Ordered key-value  |
| TreeMap       | Yes (Sorted) | Values: Yes | No      | No          | Sorted key-value   |

## 📝 Practice Exercises

1. Create a program to find unique elements in a list using HashSet
2. Sort a list of employees by salary using Comparator
3. Count word frequencies using HashMap
4. Implement an LRU cache using LinkedHashMap
5. Create a priority queue for task scheduling

## 🔗 Related Topics

- Previous: Chapter 3 - Data Structures
- Next: Chapter 5 - String Handling
- Related: Chapter 2 - OOP (Comparable, Comparator)

---

**Note**: Understanding when to use each collection type is crucial for writing efficient Java code. Refer to the comparison table when choosing data structures.
