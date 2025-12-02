package chapters.Chapter09_Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * [ADDED BY ASSISTANT]
 * Generic Class Example
 * Demonstrates type-safe generic container
 */
public class GenericBox<T> {
  private T value;

  public void set(T value) {
    this.value = value;
  }

  public T get() {
    return value;
  }

  public static void main(String[] args) {
    System.out.println("=== Generics Example ===\n");

    // String Box
    GenericBox<String> stringBox = new GenericBox<>();
    stringBox.set("Hello");
    System.out.println("String Box: " + stringBox.get());

    // Integer Box
    GenericBox<Integer> intBox = new GenericBox<>();
    intBox.set(42);
    System.out.println("Integer Box: " + intBox.get());

    // No casting needed!
    String str = stringBox.get(); // Direct use, no cast
    Integer num = intBox.get(); // Direct use, no cast

    System.out.println("\nType safety prevents errors at compile time");
  }
}
