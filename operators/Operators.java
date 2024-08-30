package operators;

import java.util.Scanner;

/*
 * All types of operators in Java are mentioned below:
  *Arithmetic Operators
  *Unary Operators
  *Assignment Operator
  *Relational Operators
  *Logical Operators
  *Ternary Operator
  *Bitwise Operators
  *Shift Operators
  *instance of operator
 */
public class Operators {
  class ArithmeticOperator {
    static void main() {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter the first number: ");
      double num1 = sc.nextDouble();

      System.out.print("Enter the second number: ");
      double num2 = sc.nextDouble();

      double sum = num1 + num2;
      double difference = num1 - num2;
      double product = num1 * num2;
      double quotient = num1 / num2;
      int module = (int) (num1 % num2);

      System.out.println("The sum of the two numbers is: " + sum);
      System.out.println("The difference of the two numbers is: " + difference);
      System.out.println("The product of the two numbers is: " + product);
      System.out.println("The quotient of the two numbers is: " + quotient);
      System.out.println("The module of the two numbers is: " + module);

      sc.close();
    }
  }

  /**
   * Java unary operators are the types that need only one operand to perform any
   * operation like increment, decrement, negation, etc. It consists of various
   * arithmetic, logical and other operators that operate on a single operand
   */
  class UnaryOperators {
    public static void main() {
      Scanner sc = new Scanner(System.in);

      // Uncomment this block for user input
      // System.out.print("Enter a number: ");
      // int num = sc.nextInt();

      // Initialize num
      int num = -10;

      // Unary plus
      int result = +num;
      System.out.println("The value of result after unary plus is: " + result);

      // Unary minus
      result = -num;
      System.out.println("The value of result after unary minus is: " + result);

      // Pre-increment
      result = ++num;
      System.out.println("The value of result after pre-increment is: " + result);

      // Post-increment
      result = num++;
      System.out.println("The value of result after post-increment is: " + result);

      // Pre-decrement
      result = --num;
      System.out.println("The value of result after pre-decrement is: " + result);

      // Post-decrement
      result = num--;
      System.out.println("The value of result after post-decrement is: " + result);

      // Not operator !
      Boolean bool = true;
      System.out.println("The value after Not operator is: " + !bool);

      // Bitwise Operator ~ : This unary operator returns the one’s complement
      // representation of the input value or operand
      int binary = 0b10001;
      int onesComplement = ~binary;

      // 11111111111111111111111111101110
      System.out.println("The value after Bitwise operator is:" + Integer.toBinaryString(onesComplement));

      // Close the scanner
      sc.close();
    }
  }

  public class ShiftOperator {
    static void main() {
      int number = 8; // Binary: 1000

      // Signed Left Shift
      int leftShift = number << 2; // Binary: 100000 (32 in decimal)
      System.out.println("Left Shift (8 << 2): " + leftShift);

      // Signed Right Shift
      int rightShift = number >> 2; // Binary: 10 (2 in decimal)
      System.out.println("Right Shift (8 >> 2): " + rightShift);

      // Unsigned Right Shift
      int unsignedRightShift = number >>> 2; // Binary: 10 (2 in decimal)
      System.out.println("Unsigned Right Shift (8 >>> 2): " + unsignedRightShift);

      // Demonstrating with negative number
      int negativeNumber = -8; // Binary: 11111111111111111111111111111000 (32-bit representation)

      // Signed Right Shift with negative number
      int negativeRightShift = negativeNumber >> 2; // Binary: 11 111111111111111111111111111110 (-2 in decimal)
      System.out.println("Right Shift (-8 >> 2): " + negativeRightShift);

      // Unsigned Right Shift with negative number
      int negativeUnsignedRightShift = negativeNumber >>> 2; // Binary: 00 111111111111111111111111111110 (1073741822 in
                                                             // decimal)
      System.out.println("Unsigned Right Shift (-8 >>> 2): " + negativeUnsignedRightShift);
    }
  }

  public static void main(String[] args) {
    Boolean bool = false;
    if (bool) {
      ArithmeticOperator.main();
      UnaryOperators.main();
    }
    System.out.println();

    ShiftOperator.main();
  }
}
