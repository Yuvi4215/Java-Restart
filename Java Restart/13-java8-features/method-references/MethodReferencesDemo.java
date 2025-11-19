import java.util.*;
import java.util.function.*;

/**
 * METHOD REFERENCES IN JAVA 8
 * ----------------------------
 * Method references provide a shorthand syntax for calling methods
 * using lambda expressions.
 *
 * Example:
 *   Lambda: (a) -> System.out.println(a)
 *   Method reference: System.out::println
 *
 * Types of Method References:
 * 1. Static method reference           → ClassName::staticMethod
 * 2. Instance method reference         → obj::instanceMethod
 * 3. Constructor reference             → ClassName::new
 * 4. Instance method of arbitrary object → String::toUpperCase
 *
 * Benefits:
 * - Very clean and readable code
 * - Works perfectly with functional interfaces
 */

public class MethodReferencesDemo {

    /** ==========================================
     *  1. Static Method Reference
     * ========================================== */
    static void printUpper(String msg) {
        System.out.println(msg.toUpperCase());
    }

    /** ==========================================
     *  2. Instance Method for Demo
     * ========================================== */
    void printLower(String msg) {
        System.out.println(msg.toLowerCase());
    }

    /** ==========================================
     *  Person class used in constructor reference demo
     * ========================================== */
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
            System.out.println("Person created: " + name);
        }
    }

    /** ==========================================
     *  Main Method — Demo
     * ========================================== */
    public static void main(String[] args) {

        System.out.println("=== Java 8 Method References Demo ===\n");

        // ----------------------------------------------------
        // 1. Static Method Reference
        // ----------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Static Method Reference *");

        Consumer<String> staticRef = MethodReferencesDemo::printUpper;
        staticRef.accept("hello world");

        // ----------------------------------------------------
        // 2. Instance Method Reference
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Instance Method Reference *");

        MethodReferencesDemo obj = new MethodReferencesDemo();
        Consumer<String> instanceRef = obj::printLower;
        instanceRef.accept("HELLO JAVA");

        // ----------------------------------------------------
        // 3. Constructor Reference
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Constructor Reference *");

        Function<String, Person> personCreator = Person::new;
        Person p1 = personCreator.apply("Alice");
        Person p2 = personCreator.apply("Bob");

        // ----------------------------------------------------
        // 4. Instance Method of Arbitrary Object
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Instance Method of Arbitrary Object *");

        Function<String, String> toUpper = String::toUpperCase;
        System.out.println(toUpper.apply("method reference"));

        // Sorting using method reference
        List<String> names = Arrays.asList("Charlie", "Alice", "bob", "david");
        System.out.println("Before sorting: " + names);

        names.sort(String::compareToIgnoreCase);

        System.out.println("After sorting: " + names);

        // ----------------------------------------------------
        // 5. Method Reference vs Lambda Comparison
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Method Reference vs Lambda *");

        // Lambda
        Consumer<String> lambdaPrint = s -> System.out.println(s);
        lambdaPrint.accept("Printed via Lambda");

        // Method reference
        Consumer<String> methodRefPrint = System.out::println;
        methodRefPrint.accept("Printed via Method Reference");

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Method references simplify lambda expressions.");
        System.out.println("- Types: static, instance, constructor, arbitrary object.");
        System.out.println("- Useful for cleaner and more readable functional code.");
        System.out.println("- Perfectly integrates with Java 8 functional interfaces.");
    }
}
