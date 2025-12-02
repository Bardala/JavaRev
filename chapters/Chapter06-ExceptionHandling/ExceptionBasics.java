package chapters.Chapter06_ExceptionHandling;

/**
 * [ADDED BY ASSISTANT]
 * Exception Handling Basics
 * Demonstrates try-catch-finally blocks, multiple catch blocks, and throws
 */
public class ExceptionBasics {

  // Method that throws checked exception
  public static void readFile(String filename) throws java.io.IOException {
    java.nio.file.Files.readAllLines(
        java.nio.file.Paths.get(filename));
  }

  // Method that handles exceptions
  public static void divideNumbers(int a, int b) {
    try {
      int result = a / b;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Cannot divide by zero!");
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    } finally {
      System.out.println("Operation completed");
    }
  }

  // Multiple catch blocks
  public static void parseNumber(String str) {
    try {
      int num = Integer.parseInt(str);
      System.out.println("Parsed: " + num);
    } catch (NumberFormatException e) {
      System.out.println("Invalid number format");
    } catch (NullPointerException e) {
      System.out.println("String is null");
    }
  }

  public static void main(String[] args) {
    System.out.println("=== Exception Handling Examples ===\n");

    System.out.println("1. Division by zero:");
    divideNumbers(10, 0);

    System.out.println("\n2. Parse number:");
    parseNumber("123");
    parseNumber("abc");
    parseNumber(null);

    System.out.println("\nExecution completed successfully");
  }
}
