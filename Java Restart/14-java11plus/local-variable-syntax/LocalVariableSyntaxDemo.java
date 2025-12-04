import java.util.*;
import java.util.stream.*;

public class LocalVariableSyntaxDemo {

    public static void main(String[] args) {

        System.out.println("=== Java 10+ Local Variable Syntax (var) Demo ===\n");


        // ------------------------------------------------------------
        // 1. Basic var usage
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Basic var usage *");

        var name = "Alice";          // Inferred as String
        var age = 25;                // Inferred as int
        var price = 99.99;           // Inferred as double

        System.out.println("Name: " + name + ", Age: " + age + ", Price: " + price);


        // ------------------------------------------------------------
        // 2. var with objects
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. var with objects *");

        var list = new ArrayList<String>(); // Inferred as ArrayList<String>
        list.add("Java");
        list.add("Python");

        System.out.println("List: " + list);


        // ------------------------------------------------------------
        // 3. var with loops
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. var inside loops *");

        for (var i = 1; i <= 5; i++) {
            System.out.println("Loop index: " + i);
        }

        for (var value : list) {
            System.out.println("For-each value: " + value);
        }


        // ------------------------------------------------------------
        // 4. var with streams
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. var with Streams *");

        var squares = List.of(1, 2, 3, 4, 5)
                          .stream()
                          .map(n -> n * n)
                          .collect(Collectors.toList());

        System.out.println("Squares: " + squares);


        // ------------------------------------------------------------
        // 5. var with Lambda parameters (Java 11+)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. var with Lambda parameters (Java 11+) *");

        // Useful when adding annotations to lambda parameter
        var names = List.of("Bob", "Alex", "John");

        names.stream()
             .map((var s) -> s.toUpperCase())
             .forEach(System.out::println);


        // ------------------------------------------------------------
        // 6. var with Generics
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. var with Generics *");

        var map = new HashMap<String, Integer>(); // Type inferred automatically
        map.put("A", 1);
        map.put("B", 2);

        System.out.println("Map: " + map);


        // ------------------------------------------------------------
        // 7. What var CANNOT do
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 7. Restrictions of var *");

        System.out.println("Cannot use var without initialization.");
        System.out.println("Cannot use var for fields or method parameters.");
        System.out.println("Cannot assign null to var (type cannot be inferred).");

        // ❌ var x;                 // ERROR: no initializer
        // ❌ var nothing = null;     // ERROR: cannot infer type
        // ❌ void test(var value);   // ERROR: not allowed in method signature


        // ------------------------------------------------------------
        // 8. var still uses STRONG static typing
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 8. var is NOT dynamic typing *");

        var number = 10;       // type int
        // number = "Hello";   // ❌ ERROR: cannot assign String to int

        System.out.println("number (int): " + number);


        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- var improves readability by reducing boilerplate.");
        System.out.println("- Type is still CHECKED at compile-time.");
        System.out.println("- Works only in local scope: inside methods, blocks, loops.");
        System.out.println("- Helps write clean code with generics and streams.");
        System.out.println("- Cannot be used for method parameters or class fields.");
    }
}
