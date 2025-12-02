# Chapter 8: Serialization and Immutability

## 📚 Topics Covered

- **Serialization** - Converting objects to byte streams
- **Deserialization** - Reconstructing objects from byte streams
- **Serializable Interface** - Making objects serializable
- **SerialVersionUID** - Version control for serialized objects
- **Immutable Objects** - Creating objects that cannot be modified
- **Final Keyword** - Restricting modifications
- **Benefits of Immutability** - Thread-safety, caching

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Serialize and deserialize Java objects
- ✅ Implement the Serializable interface correctly
- ✅ Create immutable classes
- ✅ Understand serialVersionUID and versioning
- ✅ Use immutable objects for thread-safety
- ✅ Understand when to use serialization

## 📁 Files in This Chapter

- `Employee.java` - Serializable object example (both chapters)
- `SerializationExample.java` - _[ADDED]_ Basic serialization/deserialization
- `ImmutableClass.java` - _[ADDED]_ Creating truly immutable classes
- `SerialVersionUIDExample.java` - _[ADDED]_ Handling versioning
- `README.md` - This file

## 💡 Key Concepts

### Serialization

```java
import java.io.*;

// Make class serializable
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private double salary;
    private transient String password;  // Won't be serialized

    // Constructor, getters, setters
}

// Serializing an object
Employee emp = new Employee("John", 30, 50000);
try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("employee.dat"))) {
    oos.writeObject(emp);
    System.out.println("Object serialized");
} catch (IOException e) {
    e.printStackTrace();
}

// Deserializing an object
try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("employee.dat"))) {
    Employee loadedEmp = (Employee) ois.readObject();
    System.out.println(loadedEmp.getName());
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

### SerialVersionUID

```java
public class Student implements Serializable {
    // Unique version ID for this class
    // Change when class structure changes
    private static final long serialVersionUID = 1L;

    private String name;
    private int rollNumber;

    // If you add/remove fields, increment serialVersionUID
    // Otherwise, JVM will throw InvalidClassException
}
```

### Transient Keyword

```java
public class BankAccount implements Serializable {
    private String accountNumber;
    private double balance;

    // These won't be serialized
    private transient String pin;           // Sensitive data
    private transient int failedLoginAttempts;

    // These will be serialized
    private String ownerName;
}
```

### Immutable Classes

```java
// Final class - cannot be extended
public final class ImmutablePoint {
    // Private final fields
    private final int x;
    private final int y;

    // Constructor (only way to set values)
    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Only getters, no setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // For mutable objects, return copy
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

// Usage
ImmutablePoint p1 = new ImmutablePoint(5, 10);
// p1.x = 20;  // Compilation error!
```

### Immutable Collection Handling

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public final class Person {
    private final String name;
    private final List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        // Create defensive copy and make unmodifiable
        this.hobbies = Collections.unmodifiableList(
            new ArrayList<>(hobbies));
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;  // Safe - can't be modified
    }
}
```

## 📊 Serialization Considerations

| Aspect            | Details                                                |
| ----------------- | ------------------------------------------------------ |
| **Usage**         | Saving objects to disk, network transmission           |
| **File Size**     | Larger than text formats (JSON, XML)                   |
| **Security**      | Not secure for untrusted sources                       |
| **Performance**   | Moderate overhead during serialization                 |
| **Compatibility** | Tied to Java language, use JSON/XML for cross-platform |

## 📊 Immutability Checklist

- ✅ Declare class as `final` (prevent overriding)
- ✅ Make all fields `private final`
- ✅ Initialize all fields in constructor
- ✅ Don't provide any setter methods
- ✅ Return defensive copies for mutable objects
- ✅ Override `equals()` and `hashCode()` if needed

## 💡 Benefits of Immutability

1. **Thread-Safety** - No synchronization needed
2. **Caching** - Can safely cache immutable objects
3. **Predictability** - Behavior doesn't change after creation
4. **Performance** - Can be optimized by JVM
5. **Simplicity** - Easier to reason about code

## 📝 Common Immutable Classes in Java

- `String` - Text data
- `Integer`, `Double`, `Boolean` - Wrapper classes
- `LocalDate`, `LocalTime` - Date/time (Java 8+)
- `UUID` - Unique identifiers
- `URL` - Web addresses

## 📝 Practice Exercises

1. Create a serializable `Person` class and save/load it
2. Make an immutable `Money` class with currency support
3. Create a `Student` class and handle serialVersionUID changes
4. Implement deep copy for immutable objects containing lists
5. Compare serialization sizes between different object types

## 🔗 Related Topics

- Previous: Chapter 7 - Input/Output
- Next: Chapter 9 - Generics
- Related: Chapter 2 - OOP (encapsulation)

---

**Note**: _[ADDED BY ASSISTANT]_ Serialization is crucial for persistence and network communication. Immutability is increasingly important in concurrent programming. Both topics are essential for production Java code.
