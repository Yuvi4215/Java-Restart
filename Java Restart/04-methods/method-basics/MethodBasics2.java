/**
 * A demo class covering:
 * 4. Method overloading
 * 5. Static vs instance methods
 * 6. Practical examples (factorial, palindrome, sum array, etc.)
 */
public class MethodBasics2 {

    /** 4.1 Overloaded sum methods **/
    public static int sum(int a, int b) {
        return a + b;
    }
    public static double sum(double a, double b) {
        return a + b;
    }
    public static String sum(String a, String b) {
        return a + b; // string concatenation
    }

    /** 4.2 Overloaded greet methods **/
    public static void greet() {
        System.out.println("Hello!");
    }
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    public static void greet(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    /** 5. Static vs Instance Methods **/
    public static void staticMethod() {
        System.out.println("This is a static method (called without object).");
    }

    public void instanceMethod() {
        System.out.println("This is an instance method (needs an object).");
    }

    /** 6. Practical Examples **/

    // Factorial method
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    // Sum elements of an array
    public static int sumArray(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        return total;
    }

    // Find maximum element in array
    public static int maxInArray(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("=== Method Basics Part 2 ===\n");

        /** 4. Method overloading **/
        System.out.println("------------------------------------");
        System.out.println("* 4.1 Method Overloading: sum() *");
        System.out.println("Sum of ints (5 + 7) = " + sum(5, 7));
        System.out.println("Sum of doubles (2.5 + 3.5) = " + sum(2.5, 3.5));
        System.out.println("Sum of strings (\"Hello\" + \" World\") = " + sum("Hello", " World"));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 4.2 Method Overloading: greet() *");
        greet();
        greet("Alice");
        greet("Bob", 30);
        System.out.println();

        /** 5. Static vs instance methods **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Static vs Instance Methods *");
        staticMethod();
        MethodBasics2 obj = new MethodBasics2();
        obj.instanceMethod();
        System.out.println();

        /** 6. Practical Examples **/
        System.out.println("------------------------------------");
        System.out.println("* 6.1 Factorial Method *");
        System.out.println("Factorial of 5 = " + factorial(5));
        System.out.println("Factorial of 7 = " + factorial(7));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 6.2 Palindrome Check *");
        System.out.println("Is 'level' palindrome? " + isPalindrome("level"));
        System.out.println("Is 'java' palindrome? " + isPalindrome("java"));
        System.out.println("Is 'RaceCar' palindrome? " + isPalindrome("RaceCar"));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 6.3 Sum of Array Elements *");
        int[] arr = {10, 20, 30, 40};
        System.out.println("Array = {10, 20, 30, 40}");
        System.out.println("Sum of array = " + sumArray(arr));
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 6.4 Max Element in Array *");
        System.out.println("Max in array = " + maxInArray(arr));
        System.out.println();
    }
}
