/**
 * A demo class for showing multiple ways of using the while loop in Java.
 * Covers:
 * 1. Basic while loop
 * 2. Multiple conditions (AND, OR, NOT)
 * 3. Using continue and break
 * 4. Nested while loops
 * 5. Infinite while loop (with manual break)
 * 6. Reverse countdown loop
 * 7. Practical examples
 */
public class WhileLoopDemo {
    public static void main(String[] args) {

        /** 1. Basic while loop **/
        System.out.println("=== 1. Basic while loop ===");
        int i = 1;
        while (i <= 5) {
            System.out.println("i = " + i);
            i++;
        }

        /** 2. Multiple conditions **/
        System.out.println("\n=== 2. Multiple conditions ===");

        // AND condition
        int a = 1, b = 5;
        while (a <= 5 && b >= 1) {
            System.out.println("a = " + a + ", b = " + b);
            a++;
            b--;
        }

        // OR condition
        int x = 0, y = 10;
        while (x < 3 || y > 8) {
            System.out.println("x = " + x + ", y = " + y);
            x++;
            y--;
        }

        // NOT condition
        int z = 0;
        while (!(z > 3)) { // same as while(z <= 3)
            System.out.println("z = " + z);
            z++;
        }

        /** 3. Using continue and break **/
        System.out.println("\n=== 3. Using continue and break ===");
        int j = 1;
        while (j <= 7) {
            if (j == 3) {
                System.out.println("Skipping 3 with continue");
                j++;
                continue;
            }
            if (j == 6) {
                System.out.println("Breaking at 6");
                break;
            }
            System.out.println("j = " + j);
            j++;
        }

        /** 4. Nested while loops **/
        System.out.println("\n=== 4. Nested while loops (Multiplication Table 1-3) ===");
        int row = 1;
        while (row <= 3) {
            int col = 1;
            while (col <= 3) {
                System.out.print((row * col) + "\t");
                col++;
            }
            System.out.println();
            row++;
        }

        /** 5. Infinite while loop (with manual break) **/
        System.out.println("\n=== 5. Infinite while loop (with manual break) ===");
        int counter = 0;
        while (true) {
            System.out.println("Counter = " + counter);
            counter++;
            if (counter == 3) {
                System.out.println("Stopping infinite loop manually");
                break;
            }
        }

        /** 6. Reverse countdown loop **/
        System.out.println("\n=== 6. Reverse countdown loop ===");
        int countdown = 5;
        while (countdown >= 1) {
            System.out.println("Countdown: " + countdown);
            countdown--;
        }

        /** 7. Practical Examples **/
        System.out.println("\n=== 7. Practical Examples ===");

        // Example A: Sum of first N numbers
        int N = 5, sum = 0, k = 1;
        while (k <= N) {
            sum += k;
            k++;
        }
        System.out.println("Sum of first " + N + " numbers = " + sum);

        // Example B: Print even numbers between 1 and 10
        System.out.print("Even numbers between 1 and 10: ");
        int e = 1;
        while (e <= 10) {
            if (e % 2 == 0) {
                System.out.print(e + " ");
            }
            e++;
        }
        System.out.println();

        // Example C: Factorial of a number
        int factNum = 5, fact = 1, f = 1;
        while (f <= factNum) {
            fact *= f;
            f++;
        }
        System.out.println("Factorial of " + factNum + " = " + fact);
    }
}
