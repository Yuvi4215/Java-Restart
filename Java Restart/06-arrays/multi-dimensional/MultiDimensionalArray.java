import java.util.Arrays;
import java.util.Scanner;

/**
 * MULTI-DIMENSIONAL ARRAYS
 * ------------------------
 * - A 2D array is an array of arrays.
 * - Each "row" can contain another array (which may vary in size).
 *
 * Topics Covered:
 * 1. Declaring & Initializing 2D Arrays
 * 2. Traversing with Nested Loops
 * 3. Arrays.deepToString()
 * 4. User Input Example
 * 5. Jagged Arrays
 * 6. 3D Arrays (Bonus)
 */

public class MultiDimensionalArray {

    /** ==========================================
     *  1. Declaration & Initialization
     * ========================================== */
    static void declarationAndInitialization() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Declaration & Initialization *");

        // Method 1: Static initialization
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Method 2: Dynamic initialization
        int[][] matrix2 = new int[2][3]; // 2 rows, 3 columns
        matrix2[0][0] = 10;
        matrix2[0][1] = 20;
        matrix2[1][2] = 30;

        // Print using Arrays.deepToString()
        System.out.println("Matrix 1: " + Arrays.deepToString(matrix1));
        System.out.println("Matrix 2: " + Arrays.deepToString(matrix2));
    }

    /** ==========================================
     *  2. Traversing with Nested Loops
     * ========================================== */
    static void traversingWithLoops() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Traversing with Nested Loops *");

        int[][] matrix = {
            {11, 22, 33},
            {44, 55, 66},
            {77, 88, 99}
        };

        System.out.println("Formatted Matrix Output:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nEnhanced For Loop:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    /** ==========================================
     *  3. Using Arrays.deepToString()
     * ========================================== */
    static void deepToStringDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Using Arrays.deepToString() *");

        String[][] names = {
            {"Alice", "Bob"},
            {"Charlie", "Diana"},
            {"Eve", "Frank"}
        };

        System.out.println("2D String Array:");
        System.out.println(Arrays.deepToString(names));
    }

    /** ==========================================
     *  4. User Input Example (2x2 Matrix)
     * ========================================== */
    static void userInputExample() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. User Input Example (2x2 Matrix) *");

        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[2][2];

        System.out.println("Enter 4 numbers for a 2x2 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("You entered:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("Matrix as String: " + Arrays.deepToString(matrix));
    }

    /** ==========================================
     *  5. Jagged Arrays (Unequal Rows)
     * ========================================== */
    static void jaggedArrayDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Jagged Arrays (Unequal Rows) *");

        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{3, 4, 5};
        jagged[2] = new int[]{6, 7, 8, 9};

        System.out.println("Jagged Array using deepToString:");
        System.out.println(Arrays.deepToString(jagged));

        System.out.println("Formatted output:");
        for (int[] row : jagged) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    /** ==========================================
     *  6. 3D Arrays (Bonus)
     * ========================================== */
    static void threeDimensionalArray() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. 3D Arrays (Bonus) *");

        int[][][] cube = {
            {
                {1, 2, 3},
                {4, 5, 6}
            },
            {
                {7, 8, 9},
                {10, 11, 12}
            }
        };

        System.out.println("3D Array using Arrays.deepToString():");
        System.out.println(Arrays.deepToString(cube));

        System.out.println("Iterating through 3D array:");
        for (int[][] matrix : cube) {
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            System.out.println("--- Layer End ---");
        }
    }

    /** ==========================================
     *  Main Method - Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Multi-Dimensional Arrays Demo ===\n");

        declarationAndInitialization();
        traversingWithLoops();
        deepToStringDemo();

        // For user input section, uncomment if running interactively
        // userInputExample();

        jaggedArrayDemo();
        threeDimensionalArray();
    }
}
