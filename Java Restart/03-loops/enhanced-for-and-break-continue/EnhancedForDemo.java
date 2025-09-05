/**
 * A demo showing enhanced-for (for-each) loop in Java
 * with examples of break and continue.
 * Covers:
 * 1. Basic enhanced-for loop with array
 * 2. Enhanced-for with collections (ArrayList)
 * 3. Using continue to skip elements
 * 4. Using break to exit early
 * 5. Nested enhanced-for loops
 * 6. Enhanced-for with multiple data types
 */
import java.util.*;

public class EnhancedForDemo {
    public static void main(String[] args) {
        /** 1. Basic enhanced-for with array **/
        System.out.println("=== 1. Enhanced-for with array ===");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }

        /** 2. Enhanced-for with collection **/
        System.out.println("\n=== 2. Enhanced-for with collection ===");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        /** 3. Using continue (skip specific element) **/
        System.out.println("\n=== 3. Using continue (skip 'Banana') ===");
        for (String fruit : fruits) {
            if (fruit.equals("Banana")) {
                continue; // skip this iteration
            }
            System.out.println("Fruit: " + fruit);
        }

        /** 4. Using break (stop when element found) **/
        System.out.println("\n=== 4. Using break (stop at 'Cherry') ===");
        for (String fruit : fruits) {
            if (fruit.equals("Cherry")) {
                System.out.println("Found Cherry, stopping loop");
                break; // exit loop
            }
            System.out.println("Fruit: " + fruit);
        }

        /** 5. Nested enhanced-for loops **/
        System.out.println("\n=== 5. Nested enhanced-for (2D array) ===");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        /** 6. Enhanced-for with multiple data types **/
        System.out.println("\n=== 6. Enhanced-for with different data types ===");
        char[] letters = {'A', 'B', 'C'};
        for (char ch : letters) {
            System.out.println("Letter: " + ch);
        }

        boolean[] flags = {true, false, true};
        for (boolean flag : flags) {
            System.out.println("Flag: " + flag);
        }
    }
}

