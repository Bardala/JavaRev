# Chapter 9: Generics

## 📚 Topics Covered

- **Generic Types** - Type parameters and type safety
- **Generic Classes** - Creating generic classes
- **Generic Methods** - Generic method definitions
- **Bounded Types** - Upper and lower bounds
- **Wildcards** - Using ? in generic types
- **Type Erasure** - How Java implements generics
- **Generic Inheritance** - Extending generic classes

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Understand why generics are important
- ✅ Create and use generic classes
- ✅ Write generic methods
- ✅ Use bounded type parameters
- ✅ Use wildcards effectively
- ✅ Avoid casting errors with generics

## 📁 Files in This Chapter

- `GenericClass.java` - _[ADDED]_ Generic class implementation
- `GenericMethods.java` - _[ADDED]_ Generic method examples
- `BoundedTypes.java` - _[ADDED]_ Bounded type parameters
- `WildcardExample.java` - _[ADDED]_ Wildcard usage
- `README.md` - This file

## 💡 Key Concepts

### Why Generics?

```java
// Without generics - type casting required, errors possible
List list = new ArrayList();
list.add("Hello");
list.add(42);  // No error at compile time
String name = (String) list.get(0);  // OK
String num = (String) list.get(1);   // ClassCastException at runtime!

// With generics - type safety
List<String> list = new ArrayList<>();
list.add("Hello");
list.add(42);  // Compilation error!
String name = list.get(0);  // No casting needed
```

### Generic Classes

```java
// Define generic class
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

// Usage
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String str = stringBox.get();  // No casting

Box<Integer> intBox = new Box<>();
intBox.set(42);
Integer num = intBox.get();  // No casting
```

### Multiple Type Parameters

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

// Usage
Pair<String, Integer> pair = new Pair<>("age", 25);
String key = pair.getKey();
Integer value = pair.getValue();
```

### Generic Methods

```java
// Generic method in non-generic class
public class Utilities {
    // Method that works with any type
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // Generic method with multiple type parameters
    public static <K, V> void printMap(K key, V value) {
        System.out.println(key + " : " + value);
    }
}

// Usage
Integer[] nums = {1, 2, 3};
Utilities.printArray(nums);

String[] strs = {"a", "b", "c"};
Utilities.printArray(strs);

Utilities.printMap("Name", "John");
```

### Bounded Type Parameters

```java
// Upper bound - T must be a Number or subclass
public class NumericBox<T extends Number> {
    private T value;

    public double doubleValue() {
        return value.doubleValue();  // Number has this method
    }
}

// Multiple bounds
public static <T extends Number & Comparable> void compare(T a, T b) {
    if (a.doubleValue() > b.doubleValue()) {
        System.out.println("a is greater");
    }
}

// Usage
NumericBox<Integer> intBox = new NumericBox<>();
NumericBox<String> stringBox = new NumericBox<>();  // Error! String not Number
```

### Lower Bounded Wildcards

```java
// Upper bound wildcard - ? extends Type
public void processList(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}

// Can read any Number
List<Integer> intList = Arrays.asList(1, 2, 3);
processList(intList);  // OK

List<Double> doubleList = Arrays.asList(1.5, 2.5);
processList(doubleList);  // OK
```

### Lower Bounded Wildcards

```java
// Lower bound wildcard - ? super Type
public void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}

// Can add Integer to list of Integer or Object
List<Integer> intList = new ArrayList<>();
addNumbers(intList);  // OK

List<Number> numList = new ArrayList<>();
addNumbers(numList);  // OK
```

### Unbounded Wildcards

```java
// Wildcard - ? (accept any type)
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}

// Works with any List
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();
printList(stringList);  // OK
printList(intList);     // OK
```

### Generic Inheritance

```java
// Extending generic class
public class IntegerBox extends Box<Integer> {
    // Inherits Box with T = Integer
}

// Generic class extending another generic class
public class ComparableBox<T extends Comparable<T>> extends Box<T> {
    public int compareTo(ComparableBox<T> other) {
        return this.get().compareTo(other.get());
    }
}
```

### Type Erasure

```java
// At runtime, generic type information is erased
List<String> stringList = new ArrayList<String>();
List<Integer> intList = new ArrayList<Integer>();

// At runtime, both are just List
System.out.println(stringList.getClass() == intList.getClass());  // true!

// This is why:
// List<String>[] array = new List<String>[10];  // Error!
// Cannot create arrays of parameterized types due to type erasure
```

## 📊 Wildcard Reference

| Syntax             | Meaning            | Usage                |
| ------------------ | ------------------ | -------------------- |
| `<T>`              | Type parameter     | Generic class/method |
| `<?>`              | Any type           | Read-only            |
| `<? extends Type>` | Type or subclass   | Producer             |
| `<? super Type>`   | Type or superclass | Consumer             |

## 💡 Best Practices

1. ✅ Use generics to write type-safe code
2. ✅ Avoid raw types (use `List<T>` not `List`)
3. ✅ Use wildcards when type doesn't matter
4. ✅ Use bounded types to enforce constraints
5. ✅ Suppress warnings only when necessary

## 📝 Practice Exercises

1. Create a generic `Stack<T>` class
2. Implement a generic `Comparator` for custom comparison
3. Write a generic method to find maximum in a list
4. Create a generic `Pair` class with getter methods
5. Implement generic inheritance with a `Repository<T>` class

## 🔗 Related Topics

- Previous: Chapter 8 - Serialization and Immutability
- Next: Chapter 10 - Lambda and Streams
- Related: Chapter 4 - Collection Framework

---

**Note**: _[ADDED BY ASSISTANT]_ Generics are essential for writing type-safe Java code and are heavily used in the Collections Framework. This knowledge is critical for advanced Java programming.
