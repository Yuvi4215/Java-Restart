/**
 * A demo class covering:
 * 1. Method Overloading (same method name, different parameters)
 * 2. Varargs (flexible number of arguments)
 * 3. Combining overloading + varargs
 * 4. Special cases and rules
 */
 
public class OverloadingAndVarargs {

    /**
     *  1. Method Overloading
     **/

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static String multiply(String s, int times) {
        return s.repeat(times);  // repeat string n times (Java 11+)
    }

    /**
     *  2. Varargs Examples
     **/

    // Sum of integers (varargs)
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // Concatenate strings (varargs)
    public static String concat(String... words) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append(" ");
        return sb.toString().trim();
    }

    /**
     *  3. Overloading + Varargs
     **/

    // Greet with no arguments
    public static void greet() {
        System.out.println("Hello!");
    }

    // Greet with single argument
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Greet with multiple names (varargs)
    public static void greet(String... names) {
        System.out.println("Hello to all: ");
        for (String name : names) {
            System.out.println(" - " + name);
        }
    }

    /**
     *  4. Notes and Edge Cases
     **/

    // Overloading with different parameter order
    public static void showInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void showInfo(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }

    // Overloading resolution: exact match is preferred over varargs
    public static void printValue(int x) {
        System.out.println("Single int value: " + x);
    }

    public static void printValue(int... values) {
        System.out.println("Multiple ints (varargs):");
        for (int v : values) System.out.print(v + " ");
        System.out.println();
    }

    /**
     *  Main Method (Demo)
     **/
    public static void main(String[] args) {
        System.out.println("=== Overloading and Varargs Demo ===\n");

        /** 1. Method Overloading **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Method Overloading *");
        System.out.println("multiply(int, int): 5 * 7 = " + multiply(5, 7));
        System.out.println("multiply(double, double): 2.5 * 4.2 = " + multiply(2.5, 4.2));
        System.out.println("multiply(String, int): 'Hi' * 3 = " + multiply("Hi", 3));
        System.out.println();

        /** 2. Varargs **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Varargs Methods *");
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
        System.out.println("concat(\"Java\", \"is\", \"awesome\") = " + concat("Java", "is", "awesome"));
        System.out.println();

        /** 3. Overloading + Varargs **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Overloading + Varargs *");
        greet();
        greet("Alice");
        greet("Bob", "Charlie", "Diana");
        System.out.println();

        /** 4. Edge Cases **/
        System.out.println("------------------------------------");
        System.out.println("* 4. Parameter Order Overloading *");
        showInfo("Alice", 25);
        showInfo(30, "Bob");
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 5. Varargs vs Exact Match *");
        printValue(10);            // exact match → calls printValue(int)
        printValue(1, 2, 3, 4);    // varargs version
        System.out.println();
    }
}
