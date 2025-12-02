import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [ADDED BY ASSISTANT]
 * Lambda and Streams API Example
 * Demonstrates functional programming in Java 8+
 */
public class StreamExample {

    public static void main(String[] args) {
        System.out.println("=== Lambda and Streams Example ===\n");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        System.out.println("1. Even numbers:");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Map - transform elements
        System.out.println("\n2. Squares of numbers:");
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);

        // Reduce - combine elements
        System.out.println("\n3. Sum of all numbers:");
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        // Chain operations
        System.out.println("\n4. Complex operation (filter -> map -> collect):");
        List<Integer> result = numbers.stream()
                .filter(n -> n > 3) // Keep > 3
                .map(n -> n * 10) // Multiply by 10
                .filter(n -> n < 100) // Keep < 100
                .collect(Collectors.toList());
        System.out.println(result);

        // ForEach
        System.out.println("\n5. Print numbers using forEach:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println); // Method reference
    }
}
