package OOP.polymorphism.overloading;

/**
 * There are two ways to overload the method in java
 * 
 * By changing number of arguments
 * By changing the data type
 */
public class Adder {
  public static int add(int num1, int num2) {
    return num1 + num2;
  }

  /** overloading by changing number of parameters */
  public static int add(int num1, int num2, int num3) {
    return num1 + num2 + num3;
  }

  /** Overloading by changing the data type */
  public static double add(double num1, double num2, double num3) {
    return num1 + num2 + num3;
  }

  public static int add(long num1, long num2) {
    return (int) (num1 + num2);
  }
  /**
   * In java, method overloading is not possible by changing the return type of
   * the method only because of ambiguity. Let's see how ambiguity may occur:
   */
  // public static double add(int num1, int num2) {
  // return 0;
  // }
}