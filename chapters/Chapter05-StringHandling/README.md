# Chapter 5: String Handling

## 📚 Topics Covered

- **String Class** - Immutable strings, string pool
- **String Methods** - charAt, substring, length, toUpperCase, toLowerCase, etc.
- **String Concatenation** - concat, +, StringBuilder
- **String Comparison** - equals, compareTo, equalsIgnoreCase
- **String Parsing** - Converting strings to other types
- **StringBuilder & StringBuffer** - Mutable string alternatives
- **Regular Expressions** - Pattern matching and text processing

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Understand string immutability and the string pool
- ✅ Use string methods effectively
- ✅ Choose between String, StringBuilder, and StringBuffer
- ✅ Perform string manipulation tasks efficiently
- ✅ Use regular expressions for pattern matching
- ✅ Solve string-based problems

## 📁 Files in This Chapter

- `Main.java` - String basics and methods
- `problems/StringProblems.java` - String-based problems
- `StringBuilderVsString.java` - _[ADDED]_ Performance comparison
- `RegexExamples.java` - _[ADDED]_ Regular expression usage
- `StringParsingExamples.java` - _[ADDED]_ Type conversion and parsing
- `README.md` - This file

## 💡 Key Concepts

### String Creation and Immutability

```java
// String literals - stored in string pool
String s1 = "Hello";
String s2 = "Hello";  // Points to same object in pool
System.out.println(s1 == s2);  // true (same reference)

// Using new keyword - creates new object in heap
String s3 = new String("Hello");
String s4 = new String("Hello");
System.out.println(s3 == s4);  // false (different objects)
System.out.println(s3.equals(s4));  // true (same content)

// Immutability
String original = "Java";
String modified = original.concat(" is great");
// original is still "Java"
```

### Common String Methods

```java
String str = "Hello Java";

// Length and character access
int len = str.length();           // 11
char ch = str.charAt(0);          // 'H'

// Case conversion
String upper = str.toUpperCase(); // "HELLO JAVA"
String lower = str.toLowerCase(); // "hello java"

// Substring
String sub = str.substring(0, 5);     // "Hello"
String sub2 = str.substring(6);       // "Java"

// Contains and search
boolean contains = str.contains("Java");    // true
int index = str.indexOf("Java");            // 6
int lastIndex = str.lastIndexOf("a");       // 10

// Replace
String replaced = str.replace("Java", "Python");  // "Hello Python"
String replaced2 = str.replaceAll("a", "");      // "Hello Jv"

// Trim
String trimmed = "  Hello  ".trim();  // "Hello"

// Split
String[] words = str.split(" ");  // ["Hello", "Java"]

// Comparison
boolean equals = str.equals("Hello Java");        // true
boolean equalsIgnore = str.equalsIgnoreCase("hello java");  // true
int compare = str.compareTo("Hello World");       // negative
```

### String Concatenation Performance

```java
// String concatenation - creates new objects
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;  // Creates 1000 new String objects - SLOW!
}

// StringBuilder - efficient for multiple concatenations
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Single object - FAST!
}
String result = sb.toString();

// StringBuilder vs StringBuffer
// StringBuilder - faster, not thread-safe
// StringBuffer - thread-safe, slightly slower
```

### Regular Expressions (Regex)

```java
// Email validation
String email = "user@example.com";
String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
boolean isValidEmail = email.matches(emailPattern);

// Phone number validation
String phone = "123-456-7890";
String phonePattern = "\\d{3}-\\d{3}-\\d{4}";
boolean isValidPhone = phone.matches(phonePattern);

// Extract numbers
String text = "I have 5 apples and 3 oranges";
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());  // 5, 3
}

// Replace with regex
String text2 = "Hello123World456";
String result = text2.replaceAll("\\d", "");  // "HelloWorld"
```

### String Parsing

```java
// String to int
String numStr = "123";
int num = Integer.parseInt(numStr);
int num2 = Integer.valueOf(numStr);  // Returns Integer object

// String to double
double decimal = Double.parseDouble("3.14");

// String to boolean
boolean flag = Boolean.parseBoolean("true");

// Number to String
String str1 = String.valueOf(123);
String str2 = Integer.toString(456);
String str3 = "" + 789;  // String concatenation
```

## 📝 Common String Problems

1. Check if a string is a palindrome
2. Reverse a string
3. Count character frequencies
4. Find the longest substring without repeating characters
5. Anagram checker
6. First unique character
7. String rotation

## 📚 Regex Patterns Reference

| Pattern  | Meaning                            |
| -------- | ---------------------------------- |
| `.`      | Any single character               |
| `*`      | Zero or more of previous           |
| `+`      | One or more of previous            |
| `?`      | Zero or one of previous            |
| `{n}`    | Exactly n times                    |
| `[abc]`  | Character set (a or b or c)        |
| `[^abc]` | Not in character set               |
| `\d`     | Digit (0-9)                        |
| `\w`     | Word character (a-z, A-Z, 0-9, \_) |
| `\s`     | Whitespace                         |
| `^`      | Start of string                    |
| `$`      | End of string                      |

## 🔗 Related Topics

- Previous: Chapter 4 - Collection Framework
- Next: Chapter 6 - Exception Handling
- Related: Chapter 7 - Input/Output

---

**Note**: Strings are fundamental in Java. Practice string manipulation and regex patterns extensively as they appear in almost every real-world application.
