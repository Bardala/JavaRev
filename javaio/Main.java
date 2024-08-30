package javaio;

import java.util.Scanner;

/**
 * nextLine(): Reads a whole line of text (string input).
 * nextInt(): Reads an integer.
 * nextFloat(): Reads a float.
 * nextDouble(): Reads a double.
 * nextBoolean(): Reads a boolean.
 */

public class Main {
  static void getMin() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int size = scanner.nextInt();

    if (size <= 0) {
      System.out.println("Invalid array size!");
      scanner.close();
      return;
    }

    int[] arr = new int[size];
    int min = Integer.MAX_VALUE;

    System.out.println("Enter array elements");
    for (int i = 0; i < size; i++) {
      arr[i] = scanner.nextInt();
      min = min > arr[i] ? arr[i] : min;
    }

    System.out.println("Minimum value = " + min);
    scanner.close();
  }

  public static void main(String args[]) {
    getMin();
  }
}
