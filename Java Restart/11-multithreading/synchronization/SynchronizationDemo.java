/**
 * SYNCHRONIZATION IN JAVA
 * ------------------------
 * ✅ Synchronization ensures that only one thread accesses shared data at a time.
 * ✅ Prevents race conditions and inconsistent data.
 *
 * Methods:
 * - synchronized method → Locks on the current object
 * - synchronized block → Locks on a specific object
 * - static synchronized → Locks on the class itself
 *
 * Topics Covered:
 * 1. Race condition (without synchronization)
 * 2. Using synchronized methods
 * 3. Using synchronized blocks
 * 4. Static synchronization
 * 5. Real-world example (bank account)
 */

public class SynchronizationDemo {

    /** ==========================================
     *  1. Shared Counter Class (Without Sync)
     * ========================================== */
    static class Counter {
        int count = 0;

        void increment() {
            count++; // not synchronized → may cause race condition
        }
    }

    /** ==========================================
     *  2. Shared Counter (Synchronized Method)
     * ========================================== */
    static class SafeCounter {
        int count = 0;

        synchronized void increment() {
            count++; // synchronized → only one thread at a time
        }
    }

    /** ==========================================
     *  3. Example using synchronized block
     * ========================================== */
    static class BlockSync {
        void printTable(int n) {
            System.out.println(Thread.currentThread().getName() + " trying to access...");
            synchronized (this) { // synchronized block
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + n * i);
                    try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                }
            }
        }
    }

    /** ==========================================
     *  4. Static Synchronization (shared across all instances)
     * ========================================== */
    static class StaticSync {
        static synchronized void display(String msg) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " → " + msg);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }
    }

    /** ==========================================
     *  5. Real-world Example: Bank Account
     * ========================================== */
    static class BankAccount {
        private int balance = 1000;

        // deposit method (synchronized)
        synchronized void deposit(int amount) {
            System.out.println(Thread.currentThread().getName() + " depositing " + amount);
            int newBalance = balance + amount;
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            balance = newBalance;
            System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
        }

        // withdraw method (synchronized)
        synchronized void withdraw(int amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
            if (balance < amount) {
                System.out.println("Insufficient balance for " + Thread.currentThread().getName());
            } else {
                int newBalance = balance - amount;
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                balance = newBalance;
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            }
        }

        public int getBalance() {
            return balance;
        }
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Java Synchronization Demo ===\n");

        // ✅ 1. Race condition (no synchronization)
        System.out.println("------------------------------------");
        System.out.println("* 1. Without Synchronization (Race Condition) *");

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected count: 2000, Actual count: " + counter.count);

        // ✅ 2. With Synchronized Method
        System.out.println("\n------------------------------------");
        System.out.println("* 2. With Synchronized Method *");

        SafeCounter safeCounter = new SafeCounter();
        Thread s1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) safeCounter.increment();
        });
        Thread s2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) safeCounter.increment();
        });

        s1.start();
        s2.start();
        s1.join();
        s2.join();

        System.out.println("Expected count: 2000, Actual count: " + safeCounter.count);

        // ✅ 3. Synchronized Block
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Synchronized Block *");

        BlockSync blockSync = new BlockSync();
        Thread b1 = new Thread(() -> blockSync.printTable(5), "Thread-A");
        Thread b2 = new Thread(() -> blockSync.printTable(10), "Thread-B");

        b1.start();
        b2.start();
        b1.join();
        b2.join();

        // ✅ 4. Static Synchronization
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Static Synchronization *");

        Thread st1 = new Thread(() -> StaticSync.display("Message from T1"), "T1");
        Thread st2 = new Thread(() -> StaticSync.display("Message from T2"), "T2");

        st1.start();
        st2.start();
        st1.join();
        st2.join();

        // ✅ 5. Bank Account Example
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Real-world Example: Bank Account *");

        BankAccount account = new BankAccount();
        Thread d1 = new Thread(() -> account.deposit(500), "Depositor-1");
        Thread w1 = new Thread(() -> account.withdraw(700), "Withdrawer-1");
        Thread w2 = new Thread(() -> account.withdraw(400), "Withdrawer-2");

        d1.start();
        w1.start();
        w2.start();

        d1.join();
        w1.join();
        w2.join();

        System.out.println("Final Account Balance: " + account.getBalance());

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Synchronization prevents race conditions.");
        System.out.println("- synchronized method → locks on current object.");
        System.out.println("- synchronized block → custom lock on object.");
        System.out.println("- static synchronized → locks on class object.");
        System.out.println("- Always release locks quickly to avoid deadlocks.");
    }
}
