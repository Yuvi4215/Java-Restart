/**
 * A demo for showing multiple ways of using the do-while loop in Java.
 * Covers:
 * 1. Basic do-while
 * 2. Guarantee execution at least once
 * 3. Using break and continue
 * 4. Nested do-while loops
 * 5. Infinite do-while (with manual break)
 * 6. Practical example: summing numbers
 * 7. Multiple conditions in while
 */
public class DoWhileLoopDemo {
    public static void main(String[] args) {
        /** 1. Basic do-while loop **/
        System.out.println("=== 1. Basic do-while loop ===");
        int i = 1;
        do {
            System.out.println("i = " + i);
            i++;
        } while (i <= 5);

        /** 2. Guarantee execution at least once **/
        System.out.println("\n=== 2. Executes at least once even if condition is false ===");
        int x = 10;
        do {
            System.out.println("This prints even though x=10 (condition false)");
        } while (x < 5);

        /** 3. Using break and continue **/
        System.out.println("\n=== 3. Using break and continue ===");
        int y = 1;
        do {
            if (y == 3) {
                System.out.println("Skipping 3 using continue");
                y++;
                continue;
            }
            if (y == 5) {
                System.out.println("Breaking at 5");
                break;
            }
            System.out.println("y = " + y);
            y++;
        } while (y <= 10);

        /** 4. Nested do-while loops **/
        System.out.println("\n=== 4. Nested do-while loops (multiplication table 1-3) ===");
        int row = 1;
        do {
            int col = 1;
            do {
                System.out.print((row * col) + "\t");
                col++;
            } while (col <= 3);
            System.out.println();
            row++;
        } while (row <= 3);

        /** 5. Infinite do-while (with break) **/
        System.out.println("\n=== 5. Infinite do-while (controlled with break) ===");
        int counter = 0;
        do {
            System.out.println("Counter = " + counter);
            counter++;
            if (counter == 3) {
                System.out.println("Stopping loop manually");
                break;
            }
        } while (true);

        /** 6. Practical Example: Summing first N numbers **/
        System.out.println("\n=== 6. Practical Example: Sum of first 5 numbers ===");
        int n = 1, sum = 0;
        do {
            sum += n;
            n++;
        } while (n <= 5);
        System.out.println("Sum of first 5 numbers = " + sum);

        /** 7. Multiple conditions in do-while **/
        System.out.println("\n=== 7. Multiple conditions in do-while ===");

        int a = 1, b = 5;
        do {
            System.out.println("a = " + a + ", b = " + b);
            a++;
            b--;
        } while (a <= 5 && b >= 1);  // AND condition
        System.out.println();
        int m = 0, k = 10;
        do {
            System.out.println("m = " + m + ", k = " + k);
            m++;
            k--;
        } while (m < 3 || k > 8);     // OR condition
        System.out.println();
        int z = 0;
        do {
            System.out.println("z = " + z);
            z++;
        } while (!(z > 3));           // NOT condition
    }
}
