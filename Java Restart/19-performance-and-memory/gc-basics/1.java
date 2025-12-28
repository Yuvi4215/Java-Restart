// Demonstrates Java Garbage Collection (GC) fundamentals

/**
 * GARBAGE COLLECTION (GC) BASICS
 * ------------------------------
 * Garbage Collection is the automatic memory management process
 * in Java that:
 *  - Allocates memory on the heap
 *  - Frees memory of unreachable objects
 *
 * Key Concepts:
 *  - Heap vs Stack
 *  - Eligible for GC
 *  - finalize() (deprecated but important conceptually)
 *  - Runtime memory statistics
 *
 * NOTE:
 *  - GC is handled by JVM
 *  - We can REQUEST GC, but cannot FORCE it
 */

public class GCBasicsDemo {

    // Simple class to observe object lifecycle
    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            // finalize() is deprecated but still useful for understanding GC
            System.out.println("GC is collecting Employee object: " + name);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Java Garbage Collection (GC) Basics ===\n");

        // ------------------------------------------------------------
        // 1. Object Creation (Heap Allocation)
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Object Creation *");

        Employee e1 = new Employee(101, "Rahul");
        Employee e2 = new Employee(102, "Amit");
        Employee e3 = new Employee(103, "Priya");

        System.out.println("3 Employee objects created.\n");


        // ------------------------------------------------------------
        // 2. Making Objects Eligible for Garbage Collection
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 2. Making Objects Eligible for GC *");

        // Case 1: Null reference
        e1 = null;

        // Case 2: Reassign reference
        e2 = new Employee(104, "Suresh");

        // Case 3: Object created inside block
        createTemporaryObject();

        System.out.println("Some objects are now eligible for GC.\n");


        // ------------------------------------------------------------
        // 3. Requesting Garbage Collection
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 3. Requesting Garbage Collection *");

        System.out.println("Requesting JVM to run GC...");
        System.gc();   // Request (not guaranteed)
        Runtime.getRuntime().gc();

        System.out.println("GC requested.\n");


        // ------------------------------------------------------------
        // 4. Memory Information from Runtime
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 4. JVM Memory Information *");

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory  = runtime.freeMemory();
        long usedMemory  = totalMemory - freeMemory;

        System.out.println("Total Memory : " + totalMemory / (1024 * 1024) + " MB");
        System.out.println("Free Memory  : " + freeMemory / (1024 * 1024) + " MB");
        System.out.println("Used Memory  : " + usedMemory / (1024 * 1024) + " MB");


        // ------------------------------------------------------------
        // 5. Important Notes
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Important Notes *");
        System.out.println("""
        • Objects become eligible for GC when no references exist
        • GC runs automatically in background
        • System.gc() is only a request
        • finalize() should NOT be used in production
        • Modern Java uses cleaners & try-with-resources
        """);


        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Java manages memory automatically.");
        System.out.println("- GC frees heap memory of unreachable objects.");
        System.out.println("- Developers should focus on avoiding memory leaks.");
        System.out.println("- Understanding GC helps in performance tuning.");
    }

    // ------------------------------------------------------------
    // Helper method
    // ------------------------------------------------------------
    static void createTemporaryObject() {
        Employee temp = new Employee(105, "Temporary");
        // temp goes out of scope after method ends
    }
}