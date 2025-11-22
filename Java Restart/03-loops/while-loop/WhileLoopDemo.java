/**
 * A demo class showing multiple ways of using the while loop in Java.
 * Covers:
 * 1. Basic while loop
 * 2. Multiple conditions (AND, OR, NOT)
 * 3. Continue & break usage
 * 4. Nested while loops
 * 5. Infinite loop with manual break
 * 6. Reverse countdown
 * 7. Practical examples
 * 8–20. Advanced, real-world & pattern-based loops
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

        // AND
        int a = 1, b = 5;
        while (a <= 5 && b >= 1) {
            System.out.println("a = " + a + ", b = " + b);
            a++;
            b--;
        }

        // OR
        int x = 0, y = 10;
        while (x < 3 || y > 8) {
            System.out.println("x = " + x + ", y = " + y);
            x++;
            y--;
        }

        // NOT
        int z = 0;
        while (!(z > 3)) {
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

        /** 5. Infinite loop with manual break **/
        System.out.println("\n=== 5. Infinite while loop (manual break) ===");
        int counter = 0;
        while (true) {
            System.out.println("Counter = " + counter);
            counter++;
            if (counter == 3) {
                System.out.println("Stopping infinite loop manually");
                break;
            }
        }

        /** 6. Reverse countdown **/
        System.out.println("\n=== 6. Reverse countdown ===");
        int countdown = 5;
        while (countdown >= 1) {
            System.out.println("Countdown: " + countdown);
            countdown--;
        }

        /** 7. Practical examples **/
        System.out.println("\n=== 7. Practical Examples ===");

        // A. Sum of first N numbers
        int N = 5, sum = 0, k = 1;
        while (k <= N) {
            sum += k;
            k++;
        }
        System.out.println("Sum of first " + N + " numbers = " + sum);

        // B. Print even numbers
        System.out.print("Even numbers between 1 and 10: ");
        int e = 1;
        while (e <= 10) {
            if (e % 2 == 0) {
                System.out.print(e + " ");
            }
            e++;
        }
        System.out.println();

        // C. Factorial
        int factNum = 5, fact = 1, f = 1;
        while (f <= factNum) {
            fact *= f;
            f++;
        }
        System.out.println("Factorial of " + factNum + " = " + fact);


        /** 8. Menu-driven (simulation) **/
        System.out.println("\n=== 8. Menu-driven loop (simulation) ===");
        int choice = 1;
        while (choice != 0) {
            System.out.println("Menu Choice = " + choice);
            choice++;
            if (choice > 3) choice = 0;
        }

        /** 9. String character traversal **/
        System.out.println("\n=== 9. String character traversal ===");
        String name = "JAVA";
        int idx = 0;
        while (idx < name.length()) {
            System.out.println("Char: " + name.charAt(idx));
            idx++;
        }

        /** 10. Decrement-only loop **/
        System.out.println("\n=== 10. Pure decrement loop ===");
        int d = 10;
        while (d > 0) {
            System.out.print(d + " ");
            d -= 2;
        }
        System.out.println();

        /** 11. Polling simulation **/
        System.out.println("\n=== 11. Polling a resource ===");
        int attempts = 0;
        boolean resourceReady = false;

        while (!resourceReady && attempts < 5) {
            System.out.println("Checking resource... attempt " + attempts);
            attempts++;
            if (attempts == 3) {
                resourceReady = true;
            }
        }
        System.out.println("Resource ready = " + resourceReady);

        /** 12. Input validation **/
        System.out.println("\n=== 12. Data validation using while ===");
        int age = -5;
        while (age < 0 || age > 120) {
            System.out.println("Invalid age: " + age);
            age = 25; // simulated valid input
        }
        System.out.println("Age accepted: " + age);

        /** 13. Complex multi-variable condition **/
        System.out.println("\n=== 13. Complex multi-variable condition ===");
        int p = 1, q = 10, r = 2;
        while ((p < 5 && q > 5) || r == 2) {
            System.out.println("p=" + p + ", q=" + q + ", r=" + r);
            p++;
            q--;
            r++;
        }

        /** 14. Pattern printing **/
        System.out.println("\n=== 14. Triangle pattern ===");
        int rows = 1;
        while (rows <= 5) {
            int stars = 1;
            while (stars <= rows) {
                System.out.print("* ");
                stars++;
            }
            System.out.println();
            rows++;
        }

        /** 15. State flag pattern **/
        System.out.println("\n=== 15. State flag pattern ===");
        boolean running = true;
        int count = 0;
        while (running) {
            System.out.println("Processing step " + count);
            if (count == 4) running = false;
            count++;
        }

        /** 16. Array traversal **/
        System.out.println("\n=== 16. Array traversal ===");
        int[] nums = {3, 6, 9, 12};
        int pIndex = 0;
        while (pIndex < nums.length) {
            System.out.println(nums[pIndex]);
            pIndex++;
        }

        /** 17. Assignment inside condition **/
        System.out.println("\n=== 17. Assignment inside condition ===");
        int t = 0;
        while ((t = t + 1) <= 5) {
            System.out.println("t = " + t);
        }

        /** 18. Manual do-while simulation **/
        System.out.println("\n=== 18. Emulating do-while manually ===");
        int n = 1;
        boolean firstRun = true;
        while (n <= 5 || firstRun) {
            System.out.println("n = " + n);
            n++;
            firstRun = false;
        }

        /** 19. Random number loop **/
        System.out.println("\n=== 19. Random loop until value = 5 ===");
        int value = -1;
        while (value != 5) {
            value = (int)(Math.random() * 10);
            System.out.println("Generated: " + value);
        }

        /** 20. Buffer read simulation **/
        System.out.println("\n=== 20. Buffer read simulation ===");
        int buffer = 100;
        while (buffer > 0) {
            System.out.println("Buffer remaining: " + buffer + " bytes");
            buffer -= 25;
        }
        System.out.println("Buffer empty.");
    }
}
