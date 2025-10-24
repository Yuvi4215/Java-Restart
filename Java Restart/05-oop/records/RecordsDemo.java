/**
 * RECORDS in Java:
 * ----------------
 * - Introduced in Java 16 (finalized feature).
 * - Simplify creation of data-holding classes.
 * - Automatically provides:
 *    → private final fields
 *    → constructor
 *    → getters (called "accessors")
 *    → equals(), hashCode(), toString()
 *
 * Syntax:
 *    public record RecordName(Type field1, Type field2, ...) { }
 *
 * Records are immutable — once created, their fields cannot change.
 */

public class RecordsDemo {

    /** ========================================
     *  1. Basic Record Declaration
     * ======================================== */
    record Person(String name, int age) {}

    /** ========================================
     *  2. Record with Custom Constructor
     * ======================================== */
    record Student(String name, int marks) {
        // Compact constructor for validation
        Student {
            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100");
            }
        }
    }

    /** ========================================
     *  3. Record with Methods
     * ======================================== */
    record Rectangle(double width, double height) {
        // Method inside record
        double area() {
            return width * height;
        }

        // Override toString for custom print
        @Override
        public String toString() {
            return "Rectangle [width=" + width + ", height=" + height + ", area=" + area() + "]";
        }
    }

    /** ========================================
     *  4. Record with Nested Object
     * ======================================== */
    record Address(String city, String country) {}

    record Employee(String name, Address address) {
        String fullAddress() {
            return name + " lives in " + address.city() + ", " + address.country();
        }
    }

    /** ========================================
     *  5. Demonstrating Equality & Immutability
     * ======================================== */
    static void demonstrateEquality() {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.hashCode() = " + p1.hashCode());
    }

    /** ========================================
     *  6. Main Method - Demo
     * ======================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Records Demo ===\n");

        /** 1. Basic Record **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Basic Record *");
        Person p = new Person("John", 25);
        System.out.println("Name: " + p.name());
        System.out.println("Age: " + p.age());
        System.out.println("toString(): " + p);
        System.out.println();

        /** 2. Record with Custom Constructor **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Record with Validation *");
        Student s1 = new Student("Emma", 90);
        System.out.println("Student: " + s1);
        try {
            Student s2 = new Student("Jake", 150); // Invalid marks
        } catch (Exception e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
        System.out.println();

        /** 3. Record with Methods **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Record with Methods *");
        Rectangle rect = new Rectangle(5, 4);
        System.out.println(rect);
        System.out.println("Area (via method): " + rect.area());
        System.out.println();

        /** 4. Record with Nested Object **/
        System.out.println("------------------------------------");
        System.out.println("* 4. Record with Nested Object *");
        Address addr = new Address("New York", "USA");
        Employee emp = new Employee("Alice", addr);
        System.out.println("Employee: " + emp);
        System.out.println(emp.fullAddress());
        System.out.println();

        /** 5. Equality and Immutability **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Equality & Immutability *");
        demonstrateEquality();
        System.out.println();

        /** 6. Immutability Check **/
        System.out.println("------------------------------------");
        System.out.println("* 6. Immutability Check *");
        // The following line would cause compile-time error:
        // p.name = "David";  // ❌ Cannot assign value to record field
        System.out.println("Record fields are final and cannot be modified.");
    }
}
