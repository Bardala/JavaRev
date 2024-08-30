package string;

/**
 * *compare(),concat(),equals(),split(),length(),replace(),compareTo(),intern(),substring()
 */

/**
 * we can create strings in Java by using these three classes.
 * * String
 * * StringBuffer
 * * StringBuilder
 */

/**
 * 1. char charAt(int index) It returns char value for the particular index
 * 2 int length() It returns string length
 * 3 static String format(String format, Object... args) It returns a formatted
 * string.
 * 4 static String format(Locale l, String format, Object... args) It returns
 * formatted string with given locale.
 * 5 String substring(int beginIndex) It returns substring for given begin
 * index.
 * 6 String substring(int beginIndex, int endIndex) It returns substring for
 * given begin index and end index.
 * 7 boolean contains(CharSequence s) It returns true or false after matching
 * the sequence of char value.
 * 8 static String join(CharSequence delimiter, CharSequence... elements) It
 * returns a joined string.
 * 9 static String join(CharSequence delimiter, Iterable<? extends CharSequence>
 * elements) It returns a joined string.
 * 10 boolean equals(Object another) It checks the equality of string with the
 * given object.
 * 11 boolean isEmpty() It checks if string is empty.
 * 12 String concat(String str) It concatenates the specified string.
 * 13 String replace(char old, char new) It replaces all occurrences of the
 * specified char value.
 * 14 String replace(CharSequence old, CharSequence new) It replaces all
 * occurrences of the specified CharSequence.
 * 15 static String equalsIgnoreCase(String another) It compares another string.
 * It doesn't check case.
 * 16 String[] split(String regex) It returns a split string matching regex.
 * 17 String[] split(String regex, int limit) It returns a split string matching
 * regex and limit.
 * 18 String intern() It returns an interned string.
 * 19 int indexOf(int ch) It returns the specified char value index.
 * 20 int indexOf(int ch, int fromIndex) It returns the specified char value
 * index starting with given index.
 * 21 int indexOf(String substring) It returns the specified substring index.
 * 22 int indexOf(String substring, int fromIndex) It returns the specified
 * substring index starting with given index.
 * 23 String toLowerCase() It returns a string in lowercase.
 * 24 String toLowerCase(Locale l) It returns a string in lowercase using
 * specified locale.
 * 25 String toUpperCase() It returns a string in uppercase.
 * 26 String toUpperCase(Locale l) It returns a string in uppercase using
 * specified locale.
 * 27 String trim() It removes beginning and ending spaces of this string.
 * 28 static String valueOf(int value) It converts given type into string. It is
 * an overloaded method.
 */
public class Main {

  static void intro() {
    String s1 = "Welcome";
    String s2 = "Welcome";// It doesn't create a new instance

    String s3 = new String("This is s3 variable");

    char[] ch = { 'h', 'e', 'l', 'l', 'o' };
    String fromCharArr = new String(ch);

    System.out.println(fromCharArr);

    String str = "Hi, Iam Islam";
    System.out.println(str.charAt(0));
    System.out.println();
  }

  static void immutableString() {
    String name = "Islam";
    name.concat("Bardala"); // This will create a new object in the (String Constant Pool) in the Heap.
    System.out.println(name); // Islam, because strings are immutable in Java.

    String fullName = name.concat(name);
    System.out.println(fullName); // Islam Bardala

    String newName = new String("Islam");
    // * In this case, JVM will create a new string object in normal (non-pool)
    // heap memory, and literal "Islam" will be placed in the string constant pool,
    // the variable will refer to the object in a heap(non-pool).

    System.out.println("Does new String declaration create new object? " + (newName != name));
    System.out.println();
  }

  /**
   * charAt(int index), return char
   * length(), return int
   * concat(String str), return String
   * indexOf(String str), return int
   * substring(int beginIndex, int endIndex), return String
   * substring(int beginIndex), return String
   * contains(CharSequence s), return boolean
   * equals(Object anObject), return boolean
   * equalsIgnoreCase(String anotherString), return boolean
   * join(CharSequence delimiter, CharSequence... elements), return String
   * replace(CharSequence target, CharSequence replacement), return String
   */
  static void stringMethods() {
    String greeting = new String("Hello, I am Islam Bardala.");
    System.out.println(greeting.charAt(0));

    System.out.println(greeting.length());

    String concatenation = "ali" + "mhmd";
    // converted into
    (new StringBuilder()).append("ali").append("mhmd").toString();

    String s1 = new String("Hello"); // String 1
    String s2 = new String(" World"); // String 2
    String s = String.format("%s%s", s1, s2); // String 3 to store the result
    System.out.println(s.toString()); // Displays result

    System.out.println(concatenation);
    concatenation = concatenation + 34 + " address" + 23 + 32;
    System.out.println(concatenation);

    String newGreeting = greeting.concat(" I am a software engineer.");
    System.out.println(newGreeting);

    System.out.println(newGreeting.indexOf(" I am a soft"));

    String oldGreeting = newGreeting.substring(0, 26);
    System.out.println(oldGreeting);
    String greetingNewPart = newGreeting.substring(26);
    System.out.println(greetingNewPart);

    System.out.println(newGreeting.contains(oldGreeting));

    System.out.println("Does oldGreeting equal greeting? " + (greeting.equals(oldGreeting))); // true
    System.out.println("Does the new Greeting equal the old greeting? " + (newGreeting.equals(oldGreeting))); // false
    String lowercaseName = "islam bardala";
    String name = lowercaseName;
    String uppercaseName = "Islam Bardala";

    System.out.println("Check equality with ignoring case? " + (lowercaseName.equalsIgnoreCase(uppercaseName)));
    System.out.println(name.compareTo(lowercaseName)); // 0
    System.out.println(name.compareTo(uppercaseName)); // 32
    System.out.println(uppercaseName.compareTo(name)); // -32
    System.out.println(uppercaseName.compareTo("")); // 13

    String joinedGreetings = String.join(" **Separator** ", oldGreeting, greetingNewPart, greeting);
    // Hello, I am Islam Bardala. **Separator** I am a software engineer.
    // **Separator** Hello, I am Islam Bardala.
    System.out.println(joinedGreetings);

    String greetingWithoutSpaces = newGreeting.replace(" ", "");
    String removeSeparator = joinedGreetings.replace(" **Separator** ", "");
    System.out.println(greetingWithoutSpaces);
    System.out.println(removeSeparator);

  }

  /**
   * Note: Java StringBuffer class is thread-safe i.e. multiple threads cannot
   * access it simultaneously. So it is safe and will result in an order.
   */
  static void stringBuffer() {
    System.out.println();

    StringBuffer str = new StringBuffer("This is string is mutable");
    System.out.println(str);

    str.append(", changing it.");
    System.out.println(str);

    String string = "This is String";
    StringBuffer buffer = new StringBuffer(string); // making this string mutable

    StringBuffer buffer2 = new StringBuffer(string);
    System.out.println("Check string buffer equality: " + (buffer == buffer2)); // false
  }

  /**
   * Java StringBuilder class is used to create mutable (modifiable) String. The
   * Java StringBuilder class is same as StringBuffer class except that it is
   * non-synchronized. It is available since JDK 1.5.
   */
  static void stringBuilder() {
    System.out.println();

    StringBuilder builder = new StringBuilder("I am a string builder");
    // builder = "This is a string not a stringbuilder so this gives error";
  }

  public static void main(String args[]) {
    intro();
    immutableString();
    stringMethods();
    stringBuffer();
    stringBuilder();

    ConcatTest.run();
    // Time taken by Concating with String: 113ms
    // Time taken by Concating with StringBuffer: 0ms

    System.out.println();

    BufferBuilderSpeedTest.run();
  }
}

class ConcatTest {
  public static String concatWithString() {
    String t = "Java";
    for (int i = 0; i < 10000; i++) {
      t = t + "Tpoint";
    }
    return t;
  }

  public static String concatWithStringBuffer() {
    StringBuffer sb = new StringBuffer("Java");
    for (int i = 0; i < 10000; i++) {
      sb.append("Tpoint");
    }
    return sb.toString();
  }

  public static void run() {
    long startTime = System.currentTimeMillis();
    concatWithString();
    System.out.println("Time taken by Concating with String: " + (System.currentTimeMillis() - startTime) + "ms");
    startTime = System.currentTimeMillis();
    concatWithStringBuffer();
    System.out
        .println("Time taken by Concating with  StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}

class BufferBuilderSpeedTest {
  public static void run() {
    long startTime = System.currentTimeMillis();
    StringBuffer sb = new StringBuffer("Java");
    for (int i = 0; i < 10000; i++) {
      sb.append("Tpoint");
    }
    System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
    startTime = System.currentTimeMillis();
    StringBuilder sb2 = new StringBuilder("Java");
    for (int i = 0; i < 10000; i++) {
      sb2.append("Tpoint");
    }
    System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}