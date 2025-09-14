/**
 * A demo class covering:
 * 1. Simple void methods
 * 2. Methods with parameters
 * 3. Methods with return values
 */
public class MethodBasics1 {

    /** 1.1 Simple void method without parameters **/
    public static void sayHello() {
        System.out.println("Hello from a simple method!");
    }

    /** 1.2 Void method printing a line multiple times **/
    public static void printLine(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }

    /** 2.1 Method with single parameter **/
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    /** 2.2 Method with multiple parameters **/
    public static void introduceUser(String name, int age) {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }

    /** 2.3 Method with default-like behavior (using null check) **/
    public static void greetWithFallback(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Hello, Guest!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }

    /** 3.1 Method returning an integer **/
    public static int add(int a, int b) {
        return a + b;
    }

    /** 3.2 Method returning a boolean **/
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    /** 3.3 Method returning a string **/
    public static String fullName(String first, String last) {
        return first + " " + last;
    }

    /** 3.4 Method returning nothing (but could use early return) **/
    public static void checkPositive(int num) {
        if (num < 0) {
            System.out.println(num + " is negative.");
            return; // exit early
        }
        System.out.println(num + " is positive.");
    }

    public static void main(String[] args) {
        System.out.println("=== Method Basics Part 1 ===\n");

        /** 1. Void methods **/
        System.out.println("------------------------------------");
        System.out.println("* 1.1 Simple void method without parameters *");
        sayHello();
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 1.2 Void method printing a line multiple times *");
        printLine("Java is fun!", 2);
        System.out.println();

        /** 2. Methods with parameters **/
        System.out.println("------------------------------------");
        System.out.println("* 2.1 Method with single parameter *");
        greetUser("Alice");
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 2.2 Method with multiple parameters *");
        introduceUser("Bob", 25);
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 2.3 Method with default-like behavior *");
        greetWithFallback(null);
        greetWithFallback("Charlie");
        System.out.println();

        /** 3. Methods with return values **/
        System.out.println("------------------------------------");
        System.out.println("* 3.1 Method returning an integer *");
        int sum = add(5, 7);
        System.out.println("Sum of 5 and 7 = " + sum);
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 3.2 Method returning a boolean *");
        System.out.println("Is 10 even? " + isEven(10));
        System.out.println("Is 7 even? " + isEven(7));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 3.3 Method returning a string *");
        System.out.println("Full name = " + fullName("Charlie", "Brown"));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 3.4 Method with early return (void) *");
        checkPositive(8);
        checkPositive(-3);
        System.out.println();
    }
}
