package chapters.Chapter11_Multithreading;

/**
 * [ADDED BY ASSISTANT]
 * Multithreading Example - Creating and running threads
 * Demonstrates Thread creation using Runnable interface
 */
public class ThreadExample {

  public static void main(String[] args) {
    System.out.println("=== Multithreading Example ===\n");

    // Create threads using lambda
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Thread 1 - " + i);
        try {
          Thread.sleep(1000); // Sleep 1 second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Thread 2 - " + i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    // Start threads (not run!)
    thread1.start();
    thread2.start();

    System.out.println("Main thread continues");
  }
}
