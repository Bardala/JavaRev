# Chapter 6: Exception Handling

## 📚 Topics Covered

- **Exception Hierarchy** - Checked vs Unchecked exceptions
- **Try-Catch-Finally** - Error handling blocks
- **Throw & Throws** - Throwing and declaring exceptions
- **Custom Exceptions** - Creating your own exception classes
- **Multiple Catch Blocks** - Handling different exceptions
- **Try-with-resources** - Automatic resource management

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Understand the exception hierarchy in Java
- ✅ Use try-catch-finally blocks effectively
- ✅ Handle multiple exceptions gracefully
- ✅ Create and throw custom exceptions
- ✅ Distinguish between checked and unchecked exceptions
- ✅ Use try-with-resources for clean code

## 📁 Files in This Chapter

- `ExceptionBasics.java` - _[ADDED]_ Try-catch-finally fundamentals
- `CustomExceptions.java` - _[ADDED]_ Creating custom exception classes
- `MultipleCatchBlocks.java` - _[ADDED]_ Handling different exception types
- `TryWithResources.java` - _[ADDED]_ Automatic resource management
- `ExceptionPropagation.java` - _[ADDED]_ Using throws keyword
- `README.md` - This file

## 💡 Key Concepts

### Exception Hierarchy

```
Throwable (parent of all errors and exceptions)
├── Error (for critical problems)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
└── Exception (for recoverable errors)
    ├── Checked Exceptions
    │   ├── IOException
    │   ├── SQLException
    │   └── ClassNotFoundException
    └── Unchecked Exceptions (RuntimeException)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        ├── ArithmeticException
        └── ClassCastException
```

### Try-Catch-Finally

```java
try {
    // Code that might throw an exception
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Handle specific exception
    System.out.println("Cannot divide by zero: " + e.getMessage());
} catch (Exception e) {
    // Handle generic exception
    System.out.println("An error occurred: " + e.getMessage());
} finally {
    // Always executes, even if exception occurs
    System.out.println("Cleanup operations");
}
```

### Multiple Catch Blocks (Java 7+)

```java
try {
    // Some code that might throw exception
} catch (IOException | SQLException | ClassNotFoundException e) {
    // Handle multiple exception types
    System.out.println("Error: " + e.getMessage());
}
```

### Custom Exceptions

```java
// Create custom exception
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Throw custom exception
public void withdraw(double amount) throws InsufficientBalanceException {
    if (amount > balance) {
        throw new InsufficientBalanceException("Insufficient balance!");
    }
    balance -= amount;
}

// Handle custom exception
try {
    account.withdraw(5000);
} catch (InsufficientBalanceException e) {
    System.out.println(e.getMessage());
}
```

### Throws Keyword

```java
// Method declares that it throws an exception
public void readFile(String filename) throws IOException {
    FileReader reader = new FileReader(filename);
    // Code that might throw IOException
}

// Caller must handle the exception
try {
    readFile("data.txt");
} catch (IOException e) {
    System.out.println("File error: " + e.getMessage());
}
```

### Try-with-Resources

```java
// Automatically closes resources implementing AutoCloseable
try (FileReader reader = new FileReader("data.txt");
     BufferedReader br = new BufferedReader(reader)) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}
```

## 📊 Checked vs Unchecked Exceptions

| Aspect                    | Checked                             | Unchecked                                 |
| ------------------------- | ----------------------------------- | ----------------------------------------- |
| **Must be caught/thrown** | Yes                                 | No                                        |
| **Examples**              | IOException, SQLException           | NullPointerException, ArithmeticException |
| **When to use**           | Recoverable errors (file not found) | Programming errors                        |
| **Compile check**         | Yes                                 | No                                        |

## 💡 Best Practices

1. ✅ Catch specific exceptions, not generic `Exception`
2. ✅ Don't ignore exceptions silently
3. ✅ Use try-with-resources for automatic cleanup
4. ✅ Create meaningful custom exceptions
5. ✅ Log exceptions with context information
6. ❌ Don't use exceptions for control flow

## 📝 Practice Exercises

1. Create a custom `InvalidAgeException` for age validation
2. Write a program that reads a file with proper exception handling
3. Implement a calculator that throws custom exceptions for invalid operations
4. Create a try-with-resources example for multiple resources

## 🔗 Related Topics

- Previous: Chapter 5 - String Handling
- Next: Chapter 7 - Input/Output
- Related: Chapter 7 - I/O (uses exception handling)

---

**Note**: _[ADDED BY ASSISTANT]_ This chapter was added as it's essential for writing robust Java applications. Exception handling is critical for production code and is often overlooked in beginner tutorials.
