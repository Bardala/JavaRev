# Chapter 1: Java Basics

## 📚 Topics Covered

- **Operators** - Arithmetic, logical, relational, bitwise, and assignment operators
- **Control Flow** - If-else, switch statements, loops (for, while, do-while), break, continue
- **Variables & Data Types** - Primitive types, reference types, type casting

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Use all types of Java operators correctly
- ✅ Write conditional statements and loops
- ✅ Understand variable scope and data types
- ✅ Control program flow with break and continue statements

## 📁 Files in This Chapter

- `Operators.java` - Comprehensive operator demonstrations
- `BreakStatement.java` - Break statement usage
- `DoWhile.java` - Do-while loop examples
- `ForLoop.java` - For loop variations and examples
- `Main.java` - Example driver/test file

## 💡 Key Concepts

### Operators

```java
// Arithmetic
int sum = 10 + 5;      // Addition
int diff = 10 - 5;     // Subtraction
int product = 10 * 5;  // Multiplication
int quotient = 10 / 5; // Division

// Logical
boolean result = true && false;  // AND
boolean result2 = true || false; // OR
boolean result3 = !true;         // NOT
```

### Control Flow

```java
// If-else
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}

// Switch
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Other");
}

// For loop
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// While loop
while (condition) {
    // execute code
}

// Do-while loop
do {
    // execute code
} while (condition);
```

## 📝 Practice Exercises

1. Create a program that prints multiplication tables for numbers 1-10
2. Write a program to check if a number is prime
3. Create a calculator that performs basic arithmetic operations
4. Write a program to find the factorial of a number

## 🔗 Related Topics

- Next: Chapter 2 - Object-Oriented Programming
- Prerequisites: None (this is the starting chapter)

---

**Note**: This chapter forms the foundation for all advanced Java concepts. Ensure you have a solid understanding before proceeding to OOP.
