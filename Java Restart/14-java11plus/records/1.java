import java.util.*;

/**
 * JAVA RECORDS
 * --------------
 * Records are concise data carriers:
 *  - Immutable by default
 *  - Auto-generate constructor, equals(), hashCode(), and toString()
 *  - Perfect for DTOs, API responses, configurations, etc.
 *
 * Syntax:
 *   record RecordName(Type field1, Type field2) {}
 */

public class RecordsDemo {

    /** ==========================================
     *  1. Basic Record Declaration
     * ========================================== */
    record Person(String name, int age) {}

    /** ==========================================
     *  2. Record with Validation (Compact Constructor)
     * ========================================== */
    record Product(String name, double price) {

        // Compact constructor (no parameter list)
        Product {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative!");
            }
        }
    }

    /** ==========================================
     *  3. Record with Custom Methods
     * ========================================== */
    record Rectangle(double width, double height) {
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
    }

    /** ==========================================
     *  4. Static fields + factory methods inside record
     * ========================================== */
    record Employee(String name, double salary) {
        static double MIN_WAGE = 5000;

        static Employee createIntern(String name) {
            return new Employee(name, MIN_WAGE);
        }
    }

    /** ==========================================
     *  5. Nested Records
     * ========================================== */
    record Address(String city, String country) {}

    record Customer(String name, Address address) {}

    /** ==========================================
     *  Main Method — Demonstration
     * ========================================== */
    public static void main(String[] args) {

        System.out.println("=== Java Records Demo ===\n");

        // ------------------------------------------------------------
        // 1. Basic Record Usage
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Basic Record Usage *");

        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);

        System.out.println(p1);
        System.out.println("Name: " + p1.name());
        System.out.println("Age: " + p1.age());


        // ------------------------------------------------------------
        // 2. Record with Validation
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Record with Validation *");

        Product product = new Product("Laptop", 55000);
        System.out.println(product);

        try {
            new Product("Phone", -1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Triggered: " + e.getMessage());
        }


        // ------------------------------------------------------------
        // 3. Custom Methods in Record
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Custom Methods in Record *");

        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Area = " + rect.area());
        System.out.println("Perimeter = " + rect.perimeter());


        // ------------------------------------------------------------
        // 4. Static Fields & Factory Method
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Static Fields & Factory Method *");

        Employee emp1 = new Employee("John", 8000);
        Employee intern = Employee.createIntern("New Intern");

        System.out.println(emp1);
        System.out.println("Intern: " + intern);


        // ------------------------------------------------------------
        // 5. Nested Records (Address inside Customer)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Nested Records *");

        Address addr = new Address("Mumbai", "India");
        Customer customer = new Customer("Rahul", addr);

        System.out.println(customer);


        // ------------------------------------------------------------
        // 6. Records in Collections
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. Records in Collections *");

        List<Person> people = List.of(
                new Person("Aman", 28),
                new Person("Neha", 22),
                new Person("Raj", 35)
        );

        people.stream()
                .filter(p -> p.age() > 25)
                .forEach(System.out::println);


        // ------------------------------------------------------------
        // Key Takeaways
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Records are immutable data carriers.");
        System.out.println("- They auto-generate constructor & methods.");
        System.out.println("- Useful for DTOs, API responses, immutable objects.");
        System.out.println("- Support custom methods, validation, static fields.");
        System.out.println("- Records reduce boilerplate significantly.");
    }
}
