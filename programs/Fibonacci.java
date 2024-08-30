package programs;

public class Fibonacci {

  static void usingIterative() {
    int num1 = 0, num2 = 1, num3;

    System.out.print(num1 + " " + num2);

    for (int i = 0; i < 8; i++) {
      num3 = num1 + num2;
      num1 = num2;
      num2 = num3;
      System.out.print(" " + num3);
    }
    System.out.println();
  }

  static int num1 = 0, num2 = 1, num3;

  static void usingRecursion(int counts) {
    if (counts == 0)
      return;

    num3 = num1 + num2;
    num1 = num2;
    num2 = num3;

    System.out.print(" " + num3);
    usingRecursion(counts - 1);
  }

  static void recursive(int counts) {
    System.out.print(num1 + " " + num2);
    usingRecursion(counts);
    System.out.println();
  }

  /** Get the num(th) fibonacci number in the series */
  static int anotherApproach(int num) {
    if (num == 0)
      return 0;
    if (num == 1)
      return 1;

    return anotherApproach(num - 1) + anotherApproach(num - 2);
  }

  public static void main(String[] args) {
    usingIterative();
    recursive(8);
    int res = anotherApproach(8);
    System.out.println(res);
  }
}
// 0 1 1