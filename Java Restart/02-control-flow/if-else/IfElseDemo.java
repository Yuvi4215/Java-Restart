// if-else in java

public class IfElseDemo {
    public static void main(String[] args) {
        int number = 10;
        int age = 18;
        boolean isStudent = true;

        System.out.println("=== 1. Simple if ===");
        if (number > 0) {
            System.out.println("Number is positive");
        }

        System.out.println("\n=== 2. if-else ===");
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }

        System.out.println("\n=== 3. if-else if-else ladder ===");
        if (number < 0) {
            System.out.println("Number is negative");
        } else if (number == 0) {
            System.out.println("Number is zero");
        } else {
            System.out.println("Number is positive");
        }

        System.out.println("\n=== 4. Nested if ===");
        if (age >= 18) {
            if (isStudent) {
                System.out.println("You are an adult student");
            } else {
                System.out.println("You are an adult non-student");
            }
        } else {
            System.out.println("You are not an adult yet");
        }

        System.out.println("\n=== 5. Single-line if (without braces) ===");
        if (age >= 18) 
            System.out.println("You can vote"); // one-line body
        else 
            System.out.println("You cannot vote");

        System.out.println("\n=== 6. if with logical operators ===");
        if (age >= 18 && isStudent) {
            System.out.println("Adult student");
        } else if (age >= 18 || isStudent) {
            System.out.println("Either adult OR student");
        } else {
            System.out.println("Neither adult nor student");
        }

        System.out.println("\n=== 7. Nested else-if chain ===");
        int marks = 85;
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }
}
