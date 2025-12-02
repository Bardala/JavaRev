package chapters.Chapter11_Multithreading;

/**
 * [ADDED BY ASSISTANT]
 * Thread Synchronization Example
 * Demonstrates synchronized methods for thread-safe operations
 */
public class SynchronizedCounter {
  private int count = 0;

  // Synchronized method ensures only one thread at a time
  public synchronized void increment() {
    count++;
  }

  public synchronized int getCount() {
    return count;
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("=== Thread Synchronization Example ===\n");

    SynchronizedCounter counter = new SynchronizedCounter();

    // Create multiple threads incrementing the counter
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 5000; i++) {
        counter.increment();
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 5000; i++) {
        counter.increment();
      }
    });

    t1.start();
    t2.start();

    // Wait for threads to complete
    t1.join();
    t2.join();

    System.out.println("Final count: " + counter.getCount());
    System.out.println("Expected: 10000");
    System.out.println("Synchronized ensures correct result!");
  }
}
