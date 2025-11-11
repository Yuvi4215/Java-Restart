/**
 * CONCURRENCY API IN JAVA (java.util.concurrent)
 * -----------------------------------------------
 * Java Concurrency API provides higher-level threading tools:
 *
 * ✅ ExecutorService – Manage thread pools
 * ✅ Callable + Future – Run tasks that return values
 * ✅ ScheduledExecutorService – Run tasks after delay / periodically
 * ✅ CountDownLatch – Waiting for multiple threads to finish
 * ✅ ConcurrentHashMap – Thread-safe map
 *
 * Benefits:
 * - Easier & safer than manually creating threads
 * - Better performance with thread pools
 * - Avoids low-level thread management
 */

import java.util.*;
import java.util.concurrent.*;

public class ConcurrencyAPIDemo {

    /** ==========================================
     *  1. ExecutorService – Fixed Thread Pool
     * ========================================== */
    static void executorServiceDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. ExecutorService (Thread Pool) *");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is running a task");
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        };

        for (int i = 1; i <= 5; i++) {
            executor.submit(task);
        }

        executor.shutdown(); // no new tasks accepted
        System.out.println("Submitted 5 tasks to thread pool.");
    }

    /** ==========================================
     *  2. Callable + Future – Tasks returning value
     * ========================================== */
    static void callableFutureDemo() throws Exception {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Callable + Future (Returning Values) *");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            Thread.sleep(300);
            return "Callable task completed!";
        };

        Future<String> future = executor.submit(callableTask);

        System.out.println("Waiting for result...");
        String result = future.get(); // blocks until result ready
        System.out.println("Result from Callable: " + result);

        executor.shutdown();
    }

    /** ==========================================
     *  3. ScheduledExecutorService
     * ========================================== */
    static void scheduledExecutorDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. ScheduledExecutorService (Delay & Periodic) *");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // One-time delay
        scheduler.schedule(
                () -> System.out.println("Task executed after 2 seconds delay"),
                2,
                TimeUnit.SECONDS
        );

        // Repeated task every 1 second
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Repeating task: " + System.currentTimeMillis()),
                1,
                1,
                TimeUnit.SECONDS
        );

        try { Thread.sleep(3500); } catch (InterruptedException ignored) {}

        scheduler.shutdown();
    }

    /** ==========================================
     *  4. CountDownLatch – Wait for all threads to finish
     * ========================================== */
    static void latchDemo() throws InterruptedException {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. CountDownLatch (Thread Synchronization) *");

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable worker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " finished.");
            } catch (InterruptedException ignored) {}
            latch.countDown();
        };

        executor.submit(worker);
        executor.submit(worker);
        executor.submit(worker);

        System.out.println("Main thread waiting...");
        latch.await(); // waits until count=0
        System.out.println("All worker threads finished. Main thread resumes.");

        executor.shutdown();
    }

    /** ==========================================
     *  5. ConcurrentHashMap – Thread-safe Map
     * ========================================== */
    static void concurrentMapDemo() throws InterruptedException {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. ConcurrentHashMap (Thread-safe Map) *");

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Runnable writer = () -> {
            for (int i = 1; i <= 5; i++) {
                map.put("Key" + i, i);
            }
        };

        Runnable reader = () -> {
            try { Thread.sleep(200); } catch (Exception ignored) {}
            System.out.println("Map content: " + map);
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Concurrency API Demo ===\n");

        executorServiceDemo();
        callableFutureDemo();
        scheduledExecutorDemo();
        latchDemo();
        concurrentMapDemo();

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- ExecutorService manages thread pools efficiently.");
        System.out.println("- Callable returns values, Future receives results.");
        System.out.println("- ScheduledExecutorService runs delayed/repeating tasks.");
        System.out.println("- CountDownLatch waits for multiple threads.");
        System.out.println("- ConcurrentHashMap is thread-safe without locking entire map.");
    }
}
