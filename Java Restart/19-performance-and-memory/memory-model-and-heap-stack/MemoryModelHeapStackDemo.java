// Demonstrates Java Memory Model, Heap, and Stack behavior

/**
 * JAVA MEMORY MODEL (JMM) & HEAP vs STACK
 * ---------------------------------------
 * Java Memory Model defines:
 *  - How threads interact through memory
 *  - Visibility, ordering, and atomicity rules
 *
 * Memory Areas (High Level):
 *  - Stack (Thread-specific)
 *  - Heap (Shared)
 *  - Method Area / Metaspace
 *
 * This demo focuses on:
 *  - Heap vs Stack
 *  - Object allocation
 *  - Method calls
 *  - Reference behavior
 */

public class MemoryModelHeapStackDemo {

    static int staticCounter = 0; // Stored in Method Area / Metaspace

    static class Person {
        int id;          // stored inside object (heap)
        String name;     // reference stored in heap object

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void display() {
            int localVar = 10; // stored in stack
            System.out.println("Person{id=" + id + ", name=" + name + "}, localVar=" + localVar);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Java Memory Model: Heap vs Stack ===\n");

        // ------------------------------------------------------------
        // 1. Stack Memory (Method Calls & Local Variables)
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Stack Memory *");

        int a = 5;   // primitive stored in stack
        int b = 10;  // primitive stored in stack

        System.out.println("Stack variables: a=" + a + ", b=" + b);


        // ------------------------------------------------------------
        // 2. Heap Memory (Objects)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Heap Memory (Objects) *");

        Person p1 = new Person(101, "Rahul");  // object in heap, reference in stack
        Person p2 = new Person(102, "Priya");

        p1.display();
        p2.display();


        // ------------------------------------------------------------
        // 3. Reference Behavior
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Reference Behavior *");

        Person p3 = p1; // p3 points to same heap object as p1
        p3.name = "Amit";

        System.out.println("After modifying p3.name:");
        p1.display(); // reflects change
        p3.display();


        // ------------------------------------------------------------
        // 4. Method Call Stack Frames
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Method Call Stack Frames *");

        calculateSum(3, 4);


        // ------------------------------------------------------------
        // 5. Static Variables (Method Area / Metaspace)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Static Memory *");

        staticCounter++;
        staticCounter++;

        System.out.println("Static Counter value: " + staticCounter);


        // ------------------------------------------------------------
        // 6. String Memory (Heap + String Pool)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. String Memory *");

        String s1 = "Java";              // String pool
        String s2 = "Java";              // Same pool reference
        String s3 = new String("Java");  // New heap object

        System.out.println("s1 == s2 : " + (s1 == s2)); // true
        System.out.println("s1 == s3 : " + (s1 == s3)); // false
        System.out.println("s1.equals(s3): " + s1.equals(s3));


        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Stack stores method calls & local variables.");
        System.out.println("- Heap stores objects & instance variables.");
        System.out.println("- References live in stack, objects live in heap.");
        System.out.println("- Static variables live in method area / metaspace.");
        System.out.println("- Understanding memory helps prevent bugs & leaks.");
    }

    // ------------------------------------------------------------
    // Helper Method (Stack Frame Example)
    // ------------------------------------------------------------
    static void calculateSum(int x, int y) {
        int sum = x + y; // x, y, sum all live in stack
        System.out.println("Sum = " + sum);
    }
}
