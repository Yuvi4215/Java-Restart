/**
 * THREAD CREATION IN JAVA
 * ------------------------
 * ✅ Two main ways to create a thread:
 * 1. Extending the Thread class
 * 2. Implementing the Runnable interface
 *
 * ✅ Methods:
 * - start() → starts a new thread
 * - run()   → defines the code to execute
 * - join()  → waits for a thread to finish
 * - isAlive() → checks if a thread is still running
 * - setName(), getName(), setPriority(), getPriority()
 *
 * Topics Covered:
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 3. Passing parameters to threads
 * 4. Thread priority and lifecycle
 * 5. Real-world concurrent tasks
 */

public class ThreadClassAndRunnableDemo {

    /** ==========================================
     *  1. Extending the Thread class
     * ========================================== */
    static class MyThread extends Thread {
        private String taskName;

        public MyThread(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " - " + taskName + " step " + i);
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            }
            System.out.println(getName() + " finished " + taskName);
        }
    }

    /** ==========================================
     *  2. Implementing Runnable Interface
     * ========================================== */
    static class MyRunnable implements Runnable {
        private String job;

        public MyRunnable(String job) {
            this.job = job;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " executing " + job + " part " + i);
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            }
            System.out.println(Thread.currentThread().getName() + " completed " + job);
        }
    }

    /** ==========================================
     *  3. Real-world Example: Concurrent Printing
     * ========================================== */
    static class Printer implements Runnable {
        private String document;

        public Printer(String document) {
            this.document = document;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started printing " + document);
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " printing page " + i + " of " + document);
                try { Thread.sleep(150); } catch (InterruptedException ignored) {}
            }
            System.out.println(Thread.currentThread().getName() + " finished printing " + document);
        }
    }

    /** ==========================================
     *  4. Main Method
     * ========================================== */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Java Thread Class & Runnable Demo ===\n");

        // ✅ 1. Thread by extending Thread class
        System.out.println("------------------------------------");
        System.out.println("* 1. Extending Thread class *");

        MyThread t1 = new MyThread("Download Task");
        MyThread t2 = new MyThread("Upload Task");

        t1.setName("Downloader-Thread");
        t2.setName("Uploader-Thread");

        t1.start();
        t2.start();

        // Waiting for both threads
        t1.join();
        t2.join();

        // ✅ 2. Thread by implementing Runnable
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Implementing Runnable Interface *");

        Thread r1 = new Thread(new MyRunnable("Data Processing"), "Processor-1");
        Thread r2 = new Thread(new MyRunnable("Logging Task"), "Logger-1");

        r1.start();
        r2.start();

        r1.join();
        r2.join();

        // ✅ 3. Passing Parameters Example
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Passing Parameters to Threads *");

        Thread printThread1 = new Thread(new Printer("Document_A"), "Printer-1");
        Thread printThread2 = new Thread(new Printer("Document_B"), "Printer-2");

        printThread1.start();
        printThread2.start();

        printThread1.join();
        printThread2.join();

        // ✅ 4. Thread Priority and Lifecycle
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Thread Priority and Lifecycle *");

        Thread priorityThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running with priority " +
                    Thread.currentThread().getPriority());
        }, "PriorityThread");

        priorityThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Is thread alive before start? " + priorityThread.isAlive());
        priorityThread.start();
        System.out.println("Is thread alive after start? " + priorityThread.isAlive());

        priorityThread.join();
        System.out.println("Is thread alive after join? " + priorityThread.isAlive());

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Extend Thread class OR implement Runnable to create threads.");
        System.out.println("- start() → launches new thread, run() → defines behavior.");
        System.out.println("- Use join() to wait for thread completion.");
        System.out.println("- Thread priorities range from 1 (MIN) to 10 (MAX).");
        System.out.println("- Always prefer Runnable when possible (supports multiple inheritance).");
    }
}
