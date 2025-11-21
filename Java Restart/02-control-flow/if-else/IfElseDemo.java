/**
 * IF-ELSE CONTROL FLOW IN JAVA
 * ------------------------------
 * Covers:
 * 1. Simple if
 * 2. if-else
 * 3. else-if ladder
 * 4. Nested if
 * 5. Multiple conditions using && and ||
 * 6. Ternary operator
 * 7. Real-world examples
 */

public class IfElseDemo {

    public static void main(String[] args) {

        System.out.println("=== Java If-Else Demo ===\n");

        // ----------------------------------------------------
        // 1. Simple If
        // ----------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Simple if *");

        int age = 20;
        if (age >= 18) {
            System.out.println("You are an adult.");
        }

        // ----------------------------------------------------
        // 2. if-else
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. if-else *");

        int marks = 45;
        if (marks >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // ----------------------------------------------------
        // 3. else-if ladder
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. else-if ladder *");

        int score = 85;

        if (score >= 90) {
            System.out.println("Grade: A+");
        } else if (score >= 80) {
            System.out.println("Grade: A");
        } else if (score >= 70) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: C");
        }

        // ----------------------------------------------------
        // 4. Nested If
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Nested if *");

        boolean hasID = true;
        age = 19;

        if (hasID) {
            System.out.println("ID Verified.");
            if (age >= 18) {
                System.out.println("Entry Allowed.");
            } else {
                System.out.println("Entry Denied. Underage.");
            }
        } else {
            System.out.println("No ID. Access Denied.");
        }

        // ----------------------------------------------------
        // 5. Multiple Conditions (&& and ||)
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Multiple Conditions (&& and ||) *");

        int x = 10;
        int y = 20;

        if (x > 5 && y > 10) {
            System.out.println("Both conditions are true (using &&).");
        }

        if (x > 100 || y > 15) {
            System.out.println("At least one condition is true (using ||).");
        }

        // ----------------------------------------------------
        // 6. Ternary Operator
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. Ternary Operator *");

        int number = 7;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number " + number + " is " + result);

        // ----------------------------------------------------
        // 7. Real-world Example: Login Check
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 7. Real-world Example *");

        String username = "admin";
        String password = "1234";

        if (username.equals("admin")) {
            if (password.equals("1234")) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Invalid Password.");
            }
        } else {
            System.out.println("User not found.");
        }

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- if-else controls flow based on conditions.");
        System.out.println("- Use else-if for multiple conditions.");
        System.out.println("- Use && (AND) and || (OR) for combining conditions.");
        System.out.println("- Ternary operator is a short form of if-else.");
        System.out.println("- Nested if allows deeper decision-making logic.");

        // ----------------------------------------------------
        // 8. Example: Even or Odd
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 8. Even or Odd *");

        int n = 11;
        if (n % 2 == 0) {
            System.out.println(n + " is Even");
        } else {
            System.out.println(n + " is Odd");
        }

        // ----------------------------------------------------
        // 9. Example: Leap Year Check
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 9. Leap Year Check *");

        int year = 2024;
        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

        // ----------------------------------------------------
        // 10. Example: Largest of Three Numbers
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 10. Largest of Three Numbers *");

        int a = 15, b = 22, c = 9;
        if (a >= b && a >= c) {
            System.out.println("Largest: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("Largest: " + b);
        } else {
            System.out.println("Largest: " + c);
        }

        // ----------------------------------------------------
        // 11. Example: Character Type Check
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 11. Character Type Check *");

        char ch = 'A';
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(ch + " is Uppercase Alphabet");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch + " is Lowercase Alphabet");
        } else if (ch >= '0' && ch <= '9') {
            System.out.println(ch + " is a Digit");
        } else {
            System.out.println(ch + " is a Special Character");
        }

        // ----------------------------------------------------
        // 12. Example: Electricity Bill Calculation
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 12. Electricity Bill Calculation *");

        int units = 180;
        double bill;

        if (units <= 100) {
            bill = units * 5;
        } else if (units <= 200) {
            bill = 100 * 5 + (units - 100) * 7;
        } else {
            bill = 100 * 5 + 100 * 7 + (units - 200) * 10;
        }

        System.out.println("Total Bill: ₹" + bill);

        // ----------------------------------------------------
        // 13. Example: Discount Calculator
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 13. Discount Calculator *");

        double price = 850;
        double finalPrice;

        if (price > 1000) {
            finalPrice = price * 0.90;
        } else if (price > 500) {
            finalPrice = price * 0.95;
        } else {
            finalPrice = price;
        }

        System.out.println("Original Price: " + price);
        System.out.println("Final Price: " + finalPrice);

        // ----------------------------------------------------
        // 14. Example: Temperature Classifier
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 14. Temperature Check *");

        int temp = 32;
        if (temp < 0) {
            System.out.println("Freezing Cold");
        } else if (temp <= 20) {
            System.out.println("Cold Weather");
        } else if (temp <= 35) {
            System.out.println("Normal Weather");
        } else {
            System.out.println("Hot Weather");
        }

        // ----------------------------------------------------
        // 15. Example: Positive, Negative or Zero
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 15. Positive / Negative / Zero *");

        int numberCheck = -5;
        if (numberCheck > 0) {
            System.out.println(numberCheck + " is Positive");
        } else if (numberCheck < 0) {
            System.out.println(numberCheck + " is Negative");
        } else {
            System.out.println(numberCheck + " is Zero");
        }
    }
}
