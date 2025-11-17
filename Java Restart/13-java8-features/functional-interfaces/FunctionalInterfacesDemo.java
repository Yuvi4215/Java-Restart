import java.util.function.*;

/**
 * FUNCTIONAL INTERFACES IN JAVA 8
 * ---------------------------------
 * A Functional Interface:
 *   - Has exactly ONE abstract method
 *   - Can have default & static methods
 *   - Used with Lambda Expressions & Method References
 *
 * Examples:
 *   - Runnable
 *   - Callable
 *   - Comparator
 *   - Custom interfaces using @FunctionalInterface
 *
 * Java 8 also provides many built-in functional interfaces:
 *   - Predicate<T>
 *   - Function<T, R>
 *   - Consumer<T>
 *   - Supplier<T>
 *
 * Topics Covered:
 * 1. Custom Functional Interface
 * 2. @FunctionalInterface annotation
 * 3. Using Lambdas with custom functional interfaces
 * 4. Built-in Java 8 functional interfaces
 * 5. Passing functional interface as method parameter
 */

public class FunctionalInterfacesDemo {

    /** ==========================================
     *  1. Custom Functional Interface
     * ========================================== */
    @FunctionalInterface
    interface Greeting {
        void sayHello(String name); // single abstract method

        // default method (allowed)
        default void defaultMessage() {
            System.out.println("This is a default method inside a functional interface.");
        }

        // static method (allowed)
        static void staticMessage() {
            System.out.println("This is a static method inside a functional interface.");
        }
    }

    /** ==========================================
     *  2. Custom Functional Interface: Calculator
     * ========================================== */
    @FunctionalInterface
    interface Calculator {
        int operate(int a, int b);
    }

    /** ==========================================
     *  3. Method that accepts a functional interface
     * ========================================== */
    static void operateNumbers(int x, int y, Calculator calc) {
        int result = calc.operate(x, y);
        System.out.println("Operation result: " + result);
    }

    /** ==========================================
     *  Main Method — Demo
     * ========================================== */
    public static void main(String[] args) {

        System.out.println("=== Java 8 Functional Interfaces Demo ===\n");

        // ==========================================
        // 1. Using lambda expression with custom interface
        // ==========================================
        System.out.println("----------------------------------------");
        System.out.println("* 1. Custom Functional Interface with Lambda *");

        Greeting g = (name) -> System.out.println("Hello, " + name + "!");
        g.sayHello("Alice");
        g.defaultMessage();
        Greeting.staticMessage();

        // ==========================================
        // 2. Using lambda for Calculator operations
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Calculator Functional Interface *");

        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator max = (a, b) -> (a > b) ? a : b;

        System.out.println("Add: " + add.operate(5, 3));
        System.out.println("Multiply: " + multiply.operate(5, 3));
        System.out.println("Max: " + max.operate(5, 3));

        // Using method that accepts functional interface
        operateNumbers(10, 20, (x, y) -> x - y);

        // ==========================================
        // 3. Built-in Functional Interfaces (Predicate)
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Predicate<T> — Tests a condition *");

        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));

        // ==========================================
        // 4. Function<T,R> (Input → Output)
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Function<T,R> — Transform values *");

        Function<String, Integer> lengthFunc = (str) -> str.length();
        System.out.println("Length of 'Hello': " + lengthFunc.apply("Hello"));

        // ==========================================
        // 5. Consumer<T> (Takes input, returns nothing)
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Consumer<T> — Consumes and prints *");

        Consumer<String> printer = (msg) -> System.out.println("Printing: " + msg);
        printer.accept("Java 8 Rocks!");

        // ==========================================
        // 6. Supplier<T> (No input, returns value)
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. Supplier<T> — Supplies a value *");

        Supplier<String> supplyTime = () -> "Current Time (ms): " + System.currentTimeMillis();
        System.out.println(supplyTime.get());

        // ==========================================
        // 7. Combining Functional Interfaces
        // ==========================================
        System.out.println("\n----------------------------------------");
        System.out.println("* 7. Combining Functions (andThen) *");

        Function<Integer, Integer> times2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;

        Function<Integer, Integer> combined = times2.andThen(add3);
        System.out.println("Combined function (5 * 2 + 3): " + combined.apply(5));

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Functional interfaces have one abstract method.");
        System.out.println("- @FunctionalInterface ensures correct structure.");
        System.out.println("- Lambdas help write clean, concise code.");
        System.out.println("- Predicate, Function, Consumer, Supplier are essential Java 8 interfaces.");
        System.out.println("- Functional interfaces can be passed as method arguments.");
    }
}
