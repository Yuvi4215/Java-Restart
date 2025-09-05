/**
 * A demo showing multiple ways of using the classic for loop in Java.
 * Covers:
 * 1. Basic for loop
 * 2. Multiple initializations and updates
 * 3. Using continue and break
 * 4. Nested for loops
 * 5. Infinite for loop (with manual break)
 * 6. Reverse for loop
 * 7. Practical examples
 */
public class ForLoopDemo {
    public static void main(String[] args) {

        /** 1. Basic for loop **/
        System.out.println("=== 1. Basic for loop ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        /** 2. Multiple initializations and updates **/
        System.out.println("\n=== 2. Multiple initializations and updates ===");
        for (int i = 1, j = 5; i <= 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }

        /** 3. Using continue and break **/
        System.out.println("\n=== 3. Using continue and break ===");
        for (int i = 1; i <= 7; i++) {
            if (i == 3) {
                System.out.println("Skipping 3 with continue");
                continue;
            }
            if (i == 6) {
                System.out.println("Breaking at 6");
                break;
            }
            System.out.println("i = " + i);
        }

        /** 4. Nested for loops **/
        System.out.println("\n=== 4. Nested for loops (Multiplication Table 1-3) ===");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.print((row * col) + "\t");
            }
            System.out.println();
        }

        /** 5. Infinite for loop (with manual break) **/
        System.out.println("\n=== 5. Infinite for loop (with manual break) ===");
        int counter = 0;
        for (;;) { // no condition = infinite loop
            System.out.println("Counter = " + counter);
            counter++;
            if (counter == 3) {
                System.out.println("Stopping infinite loop manually");
                break;
            }
        }

        /** 6. Reverse for loop **/
        System.out.println("\n=== 6. Reverse for loop (countdown) ===");
        for (int i = 5; i >= 1; i--) {
            System.out.println("Countdown: " + i);
        }

        /** 7. Practical Examples **/
        System.out.println("\n=== 7. Practical Examples ===");

        // Example A: Sum of first N numbers
        int N = 5, sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        System.out.println("A. Sum of first " + N + " numbers = " + sum);

        // Example B: Printing only even numbers
        System.out.println("B. Even numbers between 1 and 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Example C: Factorial of a number
        int factNum = 5;
        int fact = 1;
        for (int i = 1; i <= factNum; i++) {
            fact *= i;
        }
        System.out.println("C. Factorial of " + factNum + " = " + fact);
    }
}
