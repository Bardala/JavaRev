# Chapter 10: Lambda Expressions and Streams (Java 8+)

## 📚 Topics Covered

- **Lambda Expressions** - Anonymous functions and concise syntax
- **Functional Interfaces** - Interfaces with single abstract method
- **Built-in Functional Interfaces** - Consumer, Supplier, Predicate, Function
- **Streams API** - Functional data processing
- **Stream Operations** - Filter, map, reduce, collect
- **Intermediate vs Terminal Operations** - Stream processing pipeline
- **Parallel Streams** - Multi-threaded stream processing

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Write lambda expressions
- ✅ Understand functional interfaces
- ✅ Use the Streams API for data processing
- ✅ Chain stream operations
- ✅ Understand lazy evaluation in streams
- ✅ Use parallel streams for performance

## 📁 Files in This Chapter

- `LambdaBasics.java` - _[ADDED]_ Lambda expression introduction
- `FunctionalInterfaces.java` - _[ADDED]_ Built-in functional interfaces
- `StreamAPI.java` - _[ADDED]_ Stream operations and examples
- `AdvancedStreams.java` - _[ADDED]_ Collectors and complex operations
- `ParallelStreams.java` - _[ADDED]_ Multi-threaded stream processing
- `README.md` - This file

## 💡 Key Concepts

### Lambda Expressions

```java
// Traditional approach - Anonymous class
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// Lambda expression
Runnable lambdaRunnable = () -> System.out.println("Hello");

// Lambda with parameters
Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);

// Lambda with body
Comparator<Integer> comp2 = (a, b) -> {
    System.out.println("Comparing " + a + " and " + b);
    return Integer.compare(a, b);
};
```

### Functional Interfaces

```java
// Single Abstract Method Interface (SAM)
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);
}

// Lambda implementation
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

int result1 = add.calculate(5, 3);      // 8
int result2 = multiply.calculate(5, 3); // 15
```

### Built-in Functional Interfaces

```java
// Predicate - Returns boolean
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4));  // true
System.out.println(isEven.test(5));  // false

// Function - Transform input to output
Function<String, Integer> stringLength = str -> str.length();
Integer length = stringLength.apply("Hello");  // 5

// Consumer - Accept input, return nothing
Consumer<String> printer = str -> System.out.println(str);
printer.accept("Hello");

// Supplier - Return value without input
Supplier<String> greeting = () -> "Hello";
String msg = greeting.get();  // "Hello"
```

### Streams - Basic Operations

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Filter - Keep elements matching predicate
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());  // [2, 4]

// Map - Transform elements
List<Integer> doubled = numbers.stream()
    .map(n -> n * 2)
    .collect(Collectors.toList());  // [2, 4, 6, 8, 10]

// Reduce - Combine elements
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);  // 15

int product = numbers.stream()
    .reduce(1, (a, b) -> a * b);  // 120
```

### Chaining Stream Operations

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
    .filter(n -> n > 2)        // [3, 4, 5, 6]
    .map(n -> n * n)            // [9, 16, 25, 36]
    .filter(n -> n < 30)        // [9, 16, 25]
    .collect(Collectors.toList());

System.out.println(result);  // [9, 16, 25]
```

### Stream Operations Classification

```java
List<String> words = Arrays.asList("Hello", "Stream", "API");

// Intermediate operations (return Stream)
Stream<String> intermediatePart = words.stream()
    .filter(w -> w.length() > 3)     // Keep words > 3 chars
    .map(String::toUpperCase);       // Convert to uppercase

// Terminal operations (return final result)
long count = intermediatePart.count();  // 3

// ForEach - Terminal operation
words.stream()
    .filter(w -> w.length() > 3)
    .forEach(System.out::println);
```

### Collectors

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice");

// To List
List<String> list = names.stream()
    .distinct()
    .collect(Collectors.toList());

// To Set
Set<String> set = names.stream()
    .collect(Collectors.toSet());

// To Map
Map<Integer, String> lengthMap = names.stream()
    .distinct()
    .collect(Collectors.toMap(String::length, Function.identity()));

// Counting
long count = names.stream()
    .collect(Collectors.counting());

// Joining
String joined = names.stream()
    .collect(Collectors.joining(", "));  // "Alice, Bob, Charlie, Alice"
```

### Parallel Streams

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

// Sequential - processes one element at a time
long sum1 = numbers.stream()
    .map(n -> n * n)
    .reduce(0L, Long::sum);

// Parallel - processes elements in parallel
long sum2 = numbers.parallelStream()
    .map(n -> n * n)
    .reduce(0L, Long::sum);

// Performance improves on large datasets
```

### Method References

```java
List<String> words = Arrays.asList("Hello", "Stream", "API");

// Traditional lambda
words.forEach(w -> System.out.println(w));

// Method reference (cleaner)
words.forEach(System.out::println);

// Constructor reference
List<String> copy = words.stream()
    .map(String::new)
    .collect(Collectors.toList());

// Static method reference
List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5);
nums.sort(Integer::compare);
```

## 📊 Stream Common Operations

| Operation     | Type         | Example                                |
| ------------- | ------------ | -------------------------------------- |
| `filter()`    | Intermediate | `.filter(x -> x > 5)`                  |
| `map()`       | Intermediate | `.map(x -> x * 2)`                     |
| `flatMap()`   | Intermediate | `.flatMap(x -> x.getItems().stream())` |
| `distinct()`  | Intermediate | `.distinct()`                          |
| `sorted()`    | Intermediate | `.sorted()`                            |
| `forEach()`   | Terminal     | `.forEach(System.out::println)`        |
| `collect()`   | Terminal     | `.collect(Collectors.toList())`        |
| `reduce()`    | Terminal     | `.reduce(0, (a,b) -> a+b)`             |
| `count()`     | Terminal     | `.count()`                             |
| `findFirst()` | Terminal     | `.findFirst()`                         |
| `anyMatch()`  | Terminal     | `.anyMatch(x -> x > 5)`                |

## 💡 Best Practices

1. ✅ Use streams for data processing pipelines
2. ✅ Keep lambda expressions concise
3. ✅ Use method references when appropriate
4. ✅ Use parallel streams only for large datasets
5. ✅ Understand lazy evaluation in streams
6. ✅ Avoid modifying external state in lambdas

## 📝 Practice Exercises

1. Filter employees by salary and collect their names
2. Group students by their grades using Collectors.groupingBy()
3. Find the longest string in a list using streams
4. Calculate sum and average using reduce()
5. Implement custom filtering with multiple conditions

## 🔗 Related Topics

- Previous: Chapter 9 - Generics
- Next: Chapter 11 - Multithreading
- Related: Chapter 4 - Collection Framework

---

**Note**: _[ADDED BY ASSISTANT]_ Lambda and Streams are transformative features in Java 8+. They enable functional programming paradigms and make code more concise and readable. Essential for modern Java development.
