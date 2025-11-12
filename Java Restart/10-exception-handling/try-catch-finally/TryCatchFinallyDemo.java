/**
 * TRY - CATCH - FINALLY
 * -----------------------
 * ✅ try block:  Code that might throw an exception
 * ✅ catch block: Handles the exception
 * ✅ finally block: Always executes (used for cleanup)
 *
 * Topics Covered:
 * 1. Basic try-catch
 * 2. Multiple catch blocks
 * 3. Nested try-catch
 * 4. finally block execution
 * 5. Checked & unchecked exceptions
 * 6. Real-life examples
 */

import java.util.*;

public class TryCatchFinallyDemo {

    /** ==========================================
     *  1. Basic try-catch Example
     * ========================================== */
    static void basicExample() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Basic try-catch *");

        try {
            int a = 10, b = 0;
            int result = a / b; // throws ArithmeticException
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }

    /** ==========================================
     *  2. Multiple catch blocks
     * ========================================== */
    static void multipleCatchExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Multiple catch blocks *");

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }

    /** ==========================================
     *  3. Nested try-catch Example
     * ========================================== */
    static void nestedTryExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Nested try-catch *");

        try {
            int[] nums = {10, 20, 30};
            System.out.println("Outer try starts");

            try {
                int result = nums[1] / 0; // inner exception
                System.out.println("Result = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }

            System.out.println(nums[5]); // outer exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }

    /** ==========================================
     *  4. finally block Example
     * ========================================== */
    static void finallyExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. finally block *");

        try {
            System.out.println("Opening file...");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("finally block: File closed (always runs).");
        }

        // Example where exception occurs
        try {
            int result = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("finally block runs even after exception.");
        }
    }

    /** ==========================================
     *  5. Checked Exception Example
     * ========================================== */
    static void checkedExceptionExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Checked Exception *");

        try {
            Thread.sleep(500); // throws InterruptedException
            System.out.println("Slept for 500ms successfully.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        } finally {
            System.out.println("Cleaning up after checked exception handling.");
        }
    }

    /** ==========================================
     *  6. Real-world Example (Division + User Input)
     * ========================================== */
    static void realWorldExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Real-world Example (User Input) *");

        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();

            System.out.print("Enter denominator: ");
            int den = sc.nextInt();

            int result = num / den;
            System.out.println("Division Result = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter numbers only.");
        } finally {
            System.out.println("Closing Scanner...");
            sc.close();
        }

        System.out.println("Program safely ended.");
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java try-catch-finally Demo ===\n");

        basicExample();
        multipleCatchExample();
        nestedTryExample();
        finallyExample();
        checkedExceptionExample();
        realWorldExample();

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- try contains risky code that may throw exceptions.");
        System.out.println("- catch handles specific exceptions.");
        System.out.println("- finally always executes (cleanup, close resources).");
        System.out.println("- Multiple catch blocks can handle different errors.");
        System.out.println("- Checked exceptions (like InterruptedException) must be handled.");
    }
}
