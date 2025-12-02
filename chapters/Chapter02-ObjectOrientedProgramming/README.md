# Chapter 2: Object-Oriented Programming (OOP)

## 📚 Topics Covered

- **Classes & Objects** - Class definition, object creation, attributes, methods
- **Constructors** - Default, parameterized, constructor overloading
- **Encapsulation** - Access modifiers, getters, setters
- **Inheritance** - Single inheritance, multi-level inheritance, super keyword
- **Polymorphism** - Method overloading, method overriding, covariant return types
- **Abstraction** - Abstract classes, interfaces, abstract methods
- **Aggregation** - Composition, HAS-A relationships

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Design and create classes with attributes and methods
- ✅ Implement constructors and understand their importance
- ✅ Apply encapsulation principles to protect data
- ✅ Create inheritance hierarchies using extends keyword
- ✅ Implement polymorphic behavior through overloading and overriding
- ✅ Design abstract classes and interfaces
- ✅ Use aggregation to establish HAS-A relationships
- ✅ Understand and apply the super keyword

## 📁 Files in This Chapter

### Core OOP Concepts

- `Constructor.java` - Constructor types and overloading
- `Student.java` - Example class demonstrating basic OOP
- `GetSet.java` - Encapsulation with getters and setters

### Inheritance Folder

- `inheritance/Employee.java` - Base class example
- `inheritance/Programmer.java` - Derived class example
- `inheritance/aggregation/Circle.java` - Example class for aggregation
- `inheritance/aggregation/Operation.java` - Aggregation demonstration

### Polymorphism Folder

- `polymorphism/overloading/Adder.java` - Method overloading
- `polymorphism/overriding/Bank.java` - Method overriding
- `polymorphism/covariantReturnType/Sub.java` - Covariant return type examples
- `polymorphism/superKeyword/Dog.java` - Super keyword usage

### Abstraction Folder

- `abstraction/abstractClass/Animal.java` - Abstract class example
- `abstraction/abstractClass/Lion.java` - Concrete implementation
- `abstraction/javaInterface/MainInterface.java` - Interface implementation

## 💡 Key Concepts

### Classes and Objects

```java
public class Student {
    // Attributes (instance variables)
    private String name;
    private int age;
    private double gpa;

    // Constructor
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Methods
    public void display() {
        System.out.println("Name: " + name);
    }
}

// Object creation
Student student = new Student("John", 20, 3.5);
```

### Inheritance

```java
// Parent class
public class Employee {
    protected String name;
    protected double salary;
}

// Child class
public class Programmer extends Employee {
    private String programmingLanguage;

    // Child class inherits all members of parent
}
```

### Polymorphism - Overloading

```java
public class Adder {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```

### Polymorphism - Overriding

```java
public class Animal {
    public void sound() {
        System.out.println("Some sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof woof!");
    }
}
```

### Abstract Classes and Interfaces

```java
// Abstract class
public abstract class Animal {
    public abstract void sound();

    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Interface
public interface Drawable {
    void draw();
}

// Implementation
public class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
```

### Encapsulation

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

## 📝 Practice Exercises

1. Design a `Vehicle` class hierarchy with `Car`, `Bike`, and `Bus` subclasses
2. Create a `Shape` interface with multiple implementations (Circle, Rectangle, Triangle)
3. Implement method overloading in a `Calculator` class
4. Create a `BankAccount` class demonstrating encapsulation
5. Design an `Animal` hierarchy using abstract classes

## 🔗 Related Topics

- Previous: Chapter 1 - Java Basics
- Next: Chapter 3 - Data Structures
- Related: Chapter 4 - Collection Framework

---

**Note**: OOP is fundamental to Java. Ensure you thoroughly understand all four pillars (Encapsulation, Inheritance, Polymorphism, Abstraction) before moving forward.
