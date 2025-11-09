/**
 * CUSTOM EXCEPTIONS IN JAVA
 * --------------------------
 * ✅ Why Custom Exceptions?
 * - To handle application-specific errors
 * - More readable & meaningful error messages
 *
 * ✅ Types:
 * - Checked Exception → extends Exception
 * - Unchecked Exception → extends RuntimeException
 *
 * Topics Covered:
 * 1. Creating custom checked exception
 * 2. Creating custom unchecked exception
 * 3. Throwing and handling custom exceptions
 * 4. Real-world examples
 */

import java.util.*;

public class CustomExceptionsDemo {

    /** ==========================================
     *  1. Custom Checked Exception
     *     Must be handled or declared using throws
     * ========================================== */
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    /** ==========================================
     *  2. Custom Unchecked Exception
     *     RuntimeException → no need to handle
     * ========================================== */
    static class InsufficientBalanceException extends RuntimeException {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    /** ==========================================
     *  Method throwing Checked Exception
     * ========================================== */
    static void vote(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is not valid for voting!");
        }
        System.out.println("You are eligible to vote.");
    }

    /** ==========================================
     *  Method throwing Unchecked Exception
     * ========================================== */
    static void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Withdrawal of " + amount + " failed. Available balance: " + balance);
        }
        System.out.println("Withdrawal successful. Remaining balance: " + (balance - amount));
    }

    /** ==========================================
     *  Main Method — Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Custom Exceptions Demo ===\n");

        // ✅ Using Checked Exception
        System.out.println("------------------------------------");
        System.out.println("* 1. Checked Exception (InvalidAgeException) *");
        try {
            vote(16);
        } catch (InvalidAgeException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        try {
            vote(25);
        } catch (InvalidAgeException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // ✅ Using Unchecked Exception
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Unchecked Exception (InsufficientBalanceException) *");
        try {
            withdraw(1000, 1500);  // will throw exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        withdraw(2000, 500);  // success

        // ✅ Extra: Custom object validation example
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Real-life Input Validation Example *");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age to apply for license: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("You must be 18+ to apply for license.");
            }
            System.out.println("License application accepted!");
        } catch (InvalidAgeException e) {
            System.out.println("Validation Failed: " + e.getMessage());
        }

        sc.close();

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Custom exceptions provide meaningful messages.");
        System.out.println("- Checked exception extends Exception → must be handled.");
        System.out.println("- Unchecked exception extends RuntimeException → optional to handle.");
        System.out.println("- Useful for validation, business rules, and safer applications.");
    }
}
