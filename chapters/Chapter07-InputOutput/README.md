# Chapter 7: Input/Output (I/O)

## 📚 Topics Covered

- **Streams** - Input and output streams
- **File Class** - File operations and properties
- **FileReader & FileWriter** - Character-based I/O
- **BufferedReader & BufferedWriter** - Buffered I/O
- **FileInputStream & FileOutputStream** - Byte-based I/O
- **PrintWriter** - Writing formatted output
- **Scanner** - Reading formatted input
- **Serialization** - Object persistence (covered in Chapter 8)

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Read and write files efficiently
- ✅ Use streams for byte and character I/O
- ✅ Choose appropriate I/O classes for your needs
- ✅ Handle files and directories
- ✅ Process input from console and files
- ✅ Write formatted output

## 📁 Files in This Chapter

- `FileStream.java` - File stream operations
- `Main.java` - I/O examples
- `FileOperations.java` - _[ADDED]_ Creating, deleting, reading file properties
- `BufferedIOExample.java` - _[ADDED]_ Buffered input/output
- `ConsoleInput.java` - _[ADDED]_ Reading from console using Scanner
- `FileLines.java` - _[ADDED]_ Reading and writing files line by line
- `README.md` - This file

## 💡 Key Concepts

### File Class

```java
import java.io.File;

// Create File object
File file = new File("data.txt");

// Check if file exists
if (file.exists()) {
    System.out.println("File exists");
}

// File properties
boolean isFile = file.isFile();      // true if regular file
boolean isDir = file.isDirectory();  // true if directory
long size = file.length();           // File size in bytes
String path = file.getAbsolutePath(); // Full path

// Create file
try {
    if (file.createNewFile()) {
        System.out.println("File created");
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Delete file
if (file.delete()) {
    System.out.println("File deleted");
}

// List directory contents
File dir = new File(".");
File[] files = dir.listFiles();
for (File f : files) {
    System.out.println(f.getName());
}
```

### Reading Files - FileReader

```java
import java.io.FileReader;
import java.io.IOException;

try (FileReader reader = new FileReader("data.txt")) {
    int character;
    while ((character = reader.read()) != -1) {
        System.out.print((char) character);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Reading Files - BufferedReader (Recommended)

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

try (BufferedReader reader = new BufferedReader(
        new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Writing Files - FileWriter

```java
import java.io.FileWriter;
import java.io.IOException;

try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello, ");
    writer.write("World!");
} catch (IOException e) {
    e.printStackTrace();
}
```

### Writing Files - PrintWriter

```java
import java.io.PrintWriter;
import java.io.IOException;

try (PrintWriter writer = new PrintWriter("output.txt")) {
    writer.println("Line 1");
    writer.println("Line 2");
    writer.printf("Number: %d, String: %s%n", 42, "Hello");
} catch (IOException e) {
    e.printStackTrace();
}
```

### Reading Console Input - Scanner

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

System.out.print("Enter your name: ");
String name = scanner.nextLine();

System.out.print("Enter your age: ");
int age = scanner.nextInt();

System.out.print("Enter your salary: ");
double salary = scanner.nextDouble();

scanner.close();  // Don't forget to close
```

### Reading Console Input - BufferedReader

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

BufferedReader reader = new BufferedReader(
    new InputStreamReader(System.in));

System.out.print("Enter text: ");
String text = reader.readLine();

reader.close();
```

### Byte-based I/O

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Read bytes
try (FileInputStream input = new FileInputStream("image.jpg")) {
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1) {
        // Process bytes
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Write bytes
try (FileOutputStream output = new FileOutputStream("output.jpg")) {
    byte[] data = {1, 2, 3, 4, 5};
    output.write(data);
} catch (IOException e) {
    e.printStackTrace();
}
```

## 📊 I/O Streams Comparison

| Class                | Type      | Speed | Best For            |
| -------------------- | --------- | ----- | ------------------- |
| FileReader           | Character | Slow  | Small files         |
| BufferedReader       | Character | Fast  | Text files, lines   |
| FileInputStream      | Byte      | Slow  | Binary files        |
| BufferedInputStream  | Byte      | Fast  | Large binary files  |
| FileWriter           | Character | Slow  | Small text output   |
| PrintWriter          | Character | Fast  | Formatted output    |
| FileOutputStream     | Byte      | Slow  | Binary output       |
| BufferedOutputStream | Byte      | Fast  | Large binary output |

## 💡 Best Practices

1. ✅ Always use try-with-resources for automatic closing
2. ✅ Use BufferedReader/BufferedWriter for better performance
3. ✅ Use PrintWriter for formatted output
4. ✅ Use Scanner for console input
5. ✅ Check file existence before reading
6. ✅ Handle IOException appropriately

## 📝 Practice Exercises

1. Read a file and count the number of lines, words, and characters
2. Copy one file to another
3. Create a simple text editor that can read and write files
4. Merge multiple text files into one
5. Create a program that reads CSV files and processes data

## 🔗 Related Topics

- Previous: Chapter 6 - Exception Handling
- Next: Chapter 8 - Serialization and Immutability
- Related: Chapter 5 - String Handling

---

**Note**: I/O operations are fundamental in real-world Java applications. Always use buffered streams for better performance and try-with-resources for safe resource management.
