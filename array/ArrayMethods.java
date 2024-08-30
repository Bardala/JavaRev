package array;

import java.util.Arrays;
import java.util.List;

public class ArrayMethods {

  public static void main(String[] args) {
    // Creating Arrays
    String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
    int[] numbers = { 10, 20, 30, 40 };

    // Accessing Array Elements
    System.out.println(cars[0]); // Outputs: Volvo

    // Modifying Array Elements
    cars[0] = "Opel";
    System.out.println(cars[0]); // Now outputs: Opel

    // Array Length
    System.out.println(cars.length); // Outputs: 4

    // Sorting Arrays
    int[] unsortedNumbers = { 5, 3, 8, 1 };
    Arrays.sort(unsortedNumbers);
    System.out.println(Arrays.toString(unsortedNumbers)); // Outputs: [1, 3, 5, 8]

    // Binary Search
    int index = Arrays.binarySearch(unsortedNumbers, 3);
    System.out.println(index); // Outputs: 1

    // Copying Arrays
    int[] copiedNumbers = Arrays.copyOf(unsortedNumbers, unsortedNumbers.length);
    System.out.println(Arrays.toString(copiedNumbers)); // Outputs: [1, 3, 5, 8]

    // Comparing Arrays
    int[] numbers2 = { 1, 3, 5, 8 };
    boolean isEqual = Arrays.equals(unsortedNumbers, numbers2);
    System.out.println(isEqual); // Outputs: true

    // Filling Arrays
    int[] filledArray = new int[5];
    Arrays.fill(filledArray, 7);
    System.out.println(Arrays.toString(filledArray)); // Outputs: [7, 7, 7, 7, 7]

    // Parallel Sorting
    Arrays.parallelSort(unsortedNumbers);
    System.out.println(Arrays.toString(unsortedNumbers)); // Outputs: [1, 3, 5, 8]

    // Splitting Arrays
    int[] rangeArray = Arrays.copyOfRange(unsortedNumbers, 1, 3);
    System.out.println(Arrays.toString(rangeArray)); // Outputs: [3, 5]

    // Converting Arrays to Lists
    List<String> carList = Arrays.asList(cars);
    System.out.println(carList); // Outputs: [Opel, BMW, Ford, Mazda]
  }
}
