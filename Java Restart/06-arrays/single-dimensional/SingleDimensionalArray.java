import java.util.Arrays;
import java.util.Scanner;

/**
 * SINGLE-DIMENSIONAL ARRAYS
 * -------------------------
 * - A one-dimensional array stores elements in a linear sequence.
 * - Every element can be accessed using its index.
 *
 * Topics Covered:
 * 1. Declaration & Initialization
 * 2. Accessing and Modifying Elements
 * 3. Traversing Arrays
 * 4. Common Operations (Sum, Avg, Min, Max)
 * 5. String and Char Arrays
 * 6. Default Values & Edge Cases
 */

public class SingleDimensionalArray {

    /** ==========================================
     *  1. Declaration & Initialization
     * ========================================== */
    static void declarationAndInitialization() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Declaration & Initialization *");

        // Method 1: Declaration + Initialization
        int[] numbers = {10, 20, 30, 40, 50};

        // Method 2: Declare first, initialize later
        int[] marks;
        marks = new int[5]; // All elements default to 0

        // Method 3: Using 'new' keyword directly
        String[] fruits = new String[]{"Apple", "Banana", "Cherry"};

        // Printing all
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Marks (default values): " + Arrays.toString(marks));
        System.out.println("Fruits: " + Arrays.toString(fruits));

        // Modifying element
        marks[2] = 88;
        System.out.println("Marks after modification: " + Arrays.toString(marks));
    }

    /** ==========================================
     *  2. Accessing & Modifying Elements
     * ========================================== */
    static void accessingElements() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Accessing & Modifying Elements *");

        int[] arr = {5, 10, 15, 20};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Access individual elements
        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[arr.length - 1]);

        // Modify
        arr[1] = 99;
        System.out.println("After modification: " + Arrays.toString(arr));

        // Edge case: IndexOutOfBounds
        try {
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access index 10 → " + e.getMessage());
        }
    }

    /** ==========================================
     *  3. Traversing Arrays
     * ========================================== */
    static void traversingArray() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Traversing Arrays *");

        int[] nums = {2, 4, 6, 8, 10};

        System.out.print("Using for loop: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.print("\nUsing enhanced for loop: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.print("\nUsing while loop: ");
        int i = 0;
        while (i < nums.length) {
            System.out.print(nums[i] + " ");
            i++;
        }
        System.out.println();
    }

    /** ==========================================
     *  4. Common Operations (Sum, Avg, Min, Max)
     * ========================================== */
    static void commonOperations() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Common Operations (Sum, Avg, Min, Max) *");

        int[] data = {4, 7, 1, 9, 3, 8};

        int sum = 0, min = data[0], max = data[0];
        for (int n : data) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }

        double average = (double) sum / data.length;

        System.out.println("Array: " + Arrays.toString(data));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    /** ==========================================
     *  5. String and Char Arrays
     * ========================================== */
    static void stringAndCharArrays() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. String and Char Arrays *");

        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("Names: " + Arrays.toString(names));

        // Char array example
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        System.out.println("Vowels: " + Arrays.toString(vowels));

        // Convert String to Char array
        String word = "HELLO";
        char[] letters = word.toCharArray();
        System.out.println("Word: " + word + " → " + Arrays.toString(letters));

        // Rebuild string from char array
        String rebuilt = new String(letters);
        System.out.println("Rebuilt String: " + rebuilt);
    }

    /** ==========================================
     *  6. Default Values & Edge Cases
     * ========================================== */
    static void defaultValuesDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Default Values & Edge Cases *");

        int[] ints = new int[3];
        double[] doubles = new double[3];
        boolean[] bools = new boolean[3];
        String[] strings = new String[3];

        System.out.println("Default int values: " + Arrays.toString(ints));
        System.out.println("Default double values: " + Arrays.toString(doubles));
        System.out.println("Default boolean values: " + Arrays.toString(bools));
        System.out.println("Default String values: " + Arrays.toString(strings));
    }

    /** ==========================================
     *  Main Method - Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Single-Dimensional Array Demo ===\n");

        declarationAndInitialization();
        accessingElements();
        traversingArray();
        commonOperations();
        stringAndCharArrays();
        defaultValuesDemo();
    }
}
