# Chapter 11: Multithreading and Concurrency

## 📚 Topics Covered

- **Threads** - Creating and running threads
- **Thread Lifecycle** - States and transitions
- **Synchronization** - Thread-safe access to shared resources
- **Locks and Monitors** - Synchronized blocks and methods
- **Thread Safety** - Race conditions and deadlocks
- **Thread Communication** - wait(), notify(), notifyAll()
- **Executor Framework** - Thread pools and task execution
- **Volatile and Atomic** - Atomic operations and visibility

## 🎯 Learning Objectives

By the end of this chapter, you should be able to:

- ✅ Create and run threads
- ✅ Understand thread lifecycle
- ✅ Implement thread synchronization
- ✅ Avoid race conditions and deadlocks
- ✅ Use thread pools effectively
- ✅ Understand volatile and atomic variables
- ✅ Debug multi-threaded applications

## 📁 Files in This Chapter

- `ThreadBasics.java` - _[ADDED]_ Creating threads
- `SynchronizationExample.java` - _[ADDED]_ Thread synchronization
- `ProducerConsumer.java` - _[ADDED]_ Thread communication
- `ExecutorExample.java` - _[ADDED]_ Thread pools
- `DeadlockExample.java` - _[ADDED]_ Common pitfalls
- `README.md` - This file

## 💡 Key Concepts

### Creating Threads - Method 1: Extend Thread

```java
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - " + i);
            try {
                Thread.sleep(1000);  // Sleep 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Usage
MyThread thread1 = new MyThread("Thread 1");
MyThread thread2 = new MyThread("Thread 2");
thread1.start();  // Start execution
thread2.start();
```

### Creating Threads - Method 2: Implement Runnable

```java
class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is running");
    }
}

// Usage
Thread thread = new Thread(new MyRunnable("Thread 1"));
thread.start();

// With lambda (Java 8+)
Thread thread2 = new Thread(() -> {
    System.out.println("Running with lambda");
});
thread2.start();
```

### Thread Lifecycle

```
NEW -> RUNNABLE -> RUNNING -> (BLOCKED/WAITING) -> RUNNABLE -> TERMINATED

NEW        - Thread created but not started
RUNNABLE   - Ready to run, waiting for CPU
RUNNING    - Currently executing
BLOCKED    - Waiting to acquire lock
WAITING    - Waiting for another thread
TERMINATED - Execution complete
```

### Synchronization - Synchronized Methods

```java
public class Counter {
    private int count = 0;

    // Synchronized method - only one thread at a time
    public synchronized void increment() {
        count++;
    }

    // Only one of these can run at a time for same object
    public synchronized int getCount() {
        return count;
    }
}

// Usage
Counter counter = new Counter();
Thread t1 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        counter.increment();
    }
});
Thread t2 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        counter.increment();
    }
});
t1.start();
t2.start();
// Without synchronization, result might be less than 2000
// With synchronization, result is always 2000
```

### Synchronization - Synchronized Blocks

```java
public class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount) {
        // Only synchronize critical section
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
    }

    public int getBalance() {
        synchronized (this) {
            return balance;
        }
    }
}
```

### Thread Communication - Wait and Notify

```java
public class ProducerConsumer {
    private List<Integer> buffer = new ArrayList<>();
    private final int CAPACITY = 5;

    // Producer adds items
    public void produce(int item) throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == CAPACITY) {
                buffer.wait();  // Wait if buffer full
            }
            buffer.add(item);
            System.out.println("Produced: " + item);
            buffer.notifyAll();  // Notify waiting threads
        }
    }

    // Consumer removes items
    public int consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                buffer.wait();  // Wait if buffer empty
            }
            int item = buffer.remove(0);
            System.out.println("Consumed: " + item);
            buffer.notifyAll();  // Notify waiting threads
            return item;
        }
    }
}
```

### Executor Framework - Thread Pool

```java
import java.util.concurrent.*;

// Create thread pool with 5 threads
ExecutorService executor = Executors.newFixedThreadPool(5);

// Submit tasks
for (int i = 0; i < 10; i++) {
    final int num = i;
    executor.submit(() -> {
        System.out.println("Task " + num + " executed by " +
            Thread.currentThread().getName());
    });
}

// Shutdown thread pool
executor.shutdown();
executor.awaitTermination(10, TimeUnit.SECONDS);
System.out.println("All tasks completed");
```

### Callable and Future

```java
import java.util.concurrent.*;

// Callable returns a value
Callable<Integer> task = () -> {
    Thread.sleep(2000);
    return 42;
};

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(task);

try {
    Integer result = future.get();  // Blocks until result available
    System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

executor.shutdown();
```

### Volatile Variables

```java
public class VolatileExample {
    // Volatile ensures all threads see most recent value
    private volatile boolean flag = false;

    public void setFlag() {
        flag = true;  // Visible to all threads immediately
    }

    public boolean getFlag() {
        return flag;  // Gets most recent value from memory
    }
}

// Without volatile, compiler might optimize and cache flag value
```

### Atomic Variables

```java
import java.util.concurrent.atomic.*;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();  // Atomic operation
    }

    public int getCount() {
        return count.get();
    }
}

// Atomic variables provide thread-safe operations without explicit locking
```

## 📊 Thread Pool Types

| Type                        | Purpose               | Threads         |
| --------------------------- | --------------------- | --------------- |
| `newFixedThreadPool(n)`     | Fixed size            | n               |
| `newCachedThreadPool()`     | Variable, reuses idle | Grows as needed |
| `newSingleThreadExecutor()` | Single thread         | 1               |
| `newScheduledThreadPool(n)` | Scheduled tasks       | n               |

## 💡 Common Pitfalls to Avoid

1. ❌ Forgetting to call `start()` instead of `run()`
2. ❌ Deadlocks - holding locks in circular pattern
3. ❌ Race conditions - unsynchronized shared access
4. ❌ Thread starvation - some threads get no CPU time
5. ❌ Memory visibility issues - use `volatile` or `synchronized`

## 📝 Practice Exercises

1. Create a multi-threaded file reader that reads multiple files
2. Implement a thread-safe counter using synchronization
3. Create a producer-consumer example with wait/notify
4. Implement a thread pool for batch processing
5. Solve the "Dining Philosophers" problem

## 🔗 Related Topics

- Previous: Chapter 10 - Lambda and Streams
- Next: Chapter 12 - Algorithms and Problem Solving
- Related: Chapter 8 - Immutability (thread-safety)

---

**Note**: _[ADDED BY ASSISTANT]_ Multithreading is critical for performance in modern applications but also introduces complexity. Understanding concurrency is essential for writing robust server-side Java code and handling high-load scenarios.
