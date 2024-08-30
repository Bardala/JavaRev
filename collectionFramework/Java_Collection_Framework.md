
# Java Collection Framework

The Java Collection Framework provides a set of interfaces and classes that support operations on collections of objects. It is one of the most powerful features of Java, enabling developers to handle groups of objects with ease. This framework includes several classes and interfaces that offer different functionalities, making it easy to store, retrieve, and manipulate collections of data.

## Key Interfaces in the Collection Framework

### 1. **Collection Interface**
The `Collection` interface is the root of the collection hierarchy. It defines general operations that all collections support, such as adding, removing, and querying elements. It is a part of the `java.util` package.

```java
Collection<E> collection = new ArrayList<E>();
collection.add("Element 1");
collection.add("Element 2");
System.out.println("Collection: " + collection);
```

### 2. **List Interface**
The `List` interface extends the `Collection` interface and represents an ordered collection (also known as a sequence). Lists allow duplicate elements and provide positional access.

```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");
System.out.println("List: " + list);
```

#### Common Implementations of List:
- `ArrayList`: A resizable array implementation of the `List` interface.
- `LinkedList`: A doubly-linked list implementation.
- `Vector`: A synchronized resizable array implementation.

### 3. **Set Interface**
The `Set` interface extends `Collection` and represents a collection that does not allow duplicate elements. It models the mathematical set abstraction.

```java
Set<String> set = new HashSet<>();
set.add("One");
set.add("Two");
set.add("Three");
set.add("One"); // Duplicate element, won't be added
System.out.println("Set: " + set);
```

#### Common Implementations of Set:
- `HashSet`: Implements a set using a hash table.
- `LinkedHashSet`: Maintains insertion order using a linked list.
- `TreeSet`: Implements a set using a tree structure and sorts the elements.

### 4. **Queue Interface**
The `Queue` interface extends `Collection` and is designed for holding elements prior to processing. Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner.

```java
Queue<String> queue = new LinkedList<>();
queue.add("Task 1");
queue.add("Task 2");
queue.add("Task 3");
System.out.println("Queue: " + queue);
System.out.println("Removed: " + queue.poll());
System.out.println("Queue after poll: " + queue);
```

#### Common Implementations of Queue:
- `PriorityQueue`: A priority queue, where elements are ordered by their natural ordering or by a comparator.
- `LinkedList`: Can also be used as a queue.

### 5. **Map Interface**
The `Map` interface does not extend the `Collection` interface but is part of the Java Collection Framework. It represents a collection of key-value pairs, where each key maps to exactly one value.

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");
System.out.println("Map: " + map);
System.out.println("Value for key 2: " + map.get(2));
```

#### Common Implementations of Map:
- `HashMap`: Implements a map using a hash table.
- `LinkedHashMap`: Maintains the insertion order of entries.
- `TreeMap`: Implements a map using a tree structure and sorts the keys.

## Collection Utility Class

The `Collections` class provides static methods that operate on or return collections. It consists of polymorphic algorithms that operate on collections, such as sorting and searching.

```java
List<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
Collections.sort(list);
System.out.println("Sorted List: " + list);
```

## Conclusion

The Java Collection Framework is a powerful tool that simplifies the handling of collections of objects. By using the various interfaces and classes provided, developers can create and manipulate dynamic collections of data efficiently and effectively.
