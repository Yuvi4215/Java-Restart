/**
 * THROW vs THROWS
 * ----------------
 * ✅ throw  -> used to manually throw an exception
 * ✅ throws -> used in method signature to declare exception
 *
 * throw → happens INSIDE method
 * throws → written in METHOD DECLARATION
 *
 * Topics Covered:
 * 1. Using throw to manually throw exceptions
 * 2. Using throws for checked exceptions
 * 3. Multiple throws declaration
 * 4. Real examples: login & division
 */

import java.util.Scanner;

public class ThrowAndThrowsDemo {

    /** ==========================================
     *  1. throw Example — Manually throw exception
     * ========================================== */
    static void validateLogin(String username) {
        if (!username.equals("admin")) {
            // manually throwing unchecked exception
            throw new RuntimeException("Access Denied! Invalid username.");
        }
        System.out.println("Login Successful.");
    }

    /** ==========================================
     *  2. Checked Exception using throws
     *     Method must declare throws or handle it
     * ========================================== */
    static void readFile() throws Exception {
        // Simulating file not found
        throw new Exception("File not found!");
    }

    /** ==========================================
     *  3. Multiple Exceptions in throws
     * ========================================== */
    static int divide(int a, int b) throws ArithmeticException, IllegalArgumentException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        if (a < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed!");
        }
        return a / b;
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== throw vs throws Demo ===\n");

        // ✅ 1. throw demo
        System.out.println("------------------------------------");
        System.out.println("* 1. throw (manual exception) *");

        try {
            validateLogin("guest");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            validateLogin("admin"); // valid
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // ✅ 2. throws demo (checked exception)
        System.out.println("\n------------------------------------");
        System.out.println("* 2. throws (checked exception) *");

        try {
            readFile();
        } catch (Exception e) {
            System.out.println("Exception Handled: " + e.getMessage());
        }

        // ✅ 3. Multiple throws demo
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Multiple exceptions using throws *");

        try {
            System.out.println("Result: " + divide(10, 2));
            System.out.println("Result: " + divide(-5, 2)); // IllegalArgumentException
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            divide(5, 0); // ArithmeticException
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // ✅ 4. Input example
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Real Example with user input *");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to divide 100 by: ");
        int x = sc.nextInt();

        try {
            System.out.println("Result = " + divide(100, x));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- 'throw' is used to manually trigger an exception.");
        System.out.println("- 'throws' declares exceptions a method may cause.");
        System.out.println("- Checked exceptions (Exception) must be handled.");
        System.out.println("- Unchecked exceptions (RuntimeException) are optional.");
    }
}
