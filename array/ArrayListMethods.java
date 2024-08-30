package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListMethods {

  public static void main(String[] args) {
    // Creating an ArrayList
    ArrayList<String> cars = new ArrayList<>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    // Accessing Elements
    System.out.println(cars.get(0)); // Outputs: Volvo

    // Modifying Elements
    cars.set(0, "Opel");
    System.out.println(cars.get(0)); // Now outputs: Opel

    // Removing Elements
    cars.remove(0);
    System.out.println(cars); // Outputs: [BMW, Ford, Mazda]

    // ArrayList Size
    System.out.println(cars.size()); // Outputs: 3

    // Iterating through ArrayList
    for (String car : cars) {
      System.out.println(car);
    }

    // Sorting ArrayList
    Collections.sort(cars);
    System.out.println(cars); // Outputs: [BMW, Ford, Mazda]

    // Sorting with Comparator
    cars.sort(Comparator.reverseOrder());
    System.out.println(cars); // Outputs: [Mazda, Ford, BMW]

    // Copying ArrayList
    ArrayList<String> newCars = new ArrayList<>(cars);
    System.out.println(newCars); // Outputs: [Mazda, Ford, BMW]

    // Checking if ArrayList contains an element
    boolean hasFord = cars.contains("Ford");
    System.out.println(hasFord); // Outputs: true

    // Clearing ArrayList
    cars.clear();
    System.out.println(cars); // Outputs: []

    // Converting ArrayList to Array
    String[] carsArray = newCars.toArray(new String[0]);
    for (String car : carsArray) {
      System.out.println(car);
    }

    // Converting Array to ArrayList
    List<String> carList = List.of(carsArray);
    ArrayList<String> carsFromList = new ArrayList<>(carList);
    System.out.println(carsFromList); // Outputs: [Mazda, Ford, BMW]
  }
}
