import java.util.Arrays;
import java.util.Scanner;

/**
 * =============================================================================
 *                       MULTI-DIMENSIONAL ARRAYS IN JAVA
 * =============================================================================
 *
 * A multi-dimensional array is simply an array whose elements are themselves
 * arrays. Java supports N-dimensional arrays (2D, 3D, ...), and each dimension
 * can have variable length (also known as "jagged" or "ragged" arrays).
 *
 * Why Multi-Dimensional Arrays?
 * ------------------------------
 * ✔ Represent tabular data (rows/columns)  
 * ✔ Store matrices (math/ML problems)  
 * ✔ Create board games (chess, sudoku)  
 * ✔ Model grids, pixels, maps, coordinates  
 *
 * Topics Covered:
 * ----------------
 * 1.  What is a 2D Array?
 * 2.  Declaration & Initialization Methods
 * 3.  Traversing 2D Arrays (Nested Loops & Enhanced For)
 * 4.  Arrays.deepToString() vs Arrays.toString()
 * 5.  Taking User Input (Dynamic Matrix)
 * 6.  Jagged Arrays (Unequal Row Sizes)
 * 7.  Default Values in Multi-D Arrays
 * 8.  Edge Cases & Best Practices
 * 9.  3D Arrays (Bonus)
 * 10. Memory Representation (How JVM Stores Them)
 *
 * Each section is demonstrated with code + explanation.
 */
public class MultiDimensionalArray {

    /* =========================================================================
     * 1. WHAT IS A 2D ARRAY?
     * =========================================================================
     * A 2D array = array of arrays.
     *
     * Example Layout:
     *      int[][] arr = {
     *          {1, 2, 3},
     *          {4, 5, 6}
     *      };
     *
     * Visually:
     *      Row0 → [1, 2, 3]
     *      Row1 → [4, 5, 6]
     *
     * NOTE:
     * Java does NOT store these in a continuous block.
     * Each row is a separate array → gives flexibility for jagged arrays.
     */

    /* =========================================================================
     * 2. DECLARATION & INITIALIZATION
     * ========================================================================= */
    static void declarationAndInitialization() {
        System.out.println("--------------------------------------------------");
        System.out.println("* 2. Declaration & Initialization *\n");

        // Method 1: Static initialization (recommended for fixed data)
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Method 2: Dynamic initialization
        int[][] matrix2 = new int[3][3]; // Allocates 3 rows × 3 columns
        matrix2[0][0] = 10;
        matrix2[1][1] = 20;
        matrix2[2][2] = 30;

        // Method 3: Only rows known (used in jagged arrays)
        int[][] matrix3 = new int[3][]; // columns will be assigned later
        matrix3[0] = new int[]{5, 6};
        matrix3[1] = new int[]{7, 8, 9};
        matrix3[2] = new int[]{10};

        System.out.println("Matrix 1 (static): " + Arrays.deepToString(matrix1));
        System.out.println("Matrix 2 (dynamic): " + Arrays.deepToString(matrix2));
        System.out.println("Matrix 3 (partial init - jagged): " + Arrays.deepToString(matrix3));
    }

    /* =========================================================================
     * 3. TRAVERSING WITH LOOPS (NESTED + ENHANCED FOR)
     * ========================================================================= */
    static void traversingWithLoops() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 3. Traversing a 2D Array *\n");

        int[][] matrix = {
                {11, 22, 33},
                {44, 55, 66},
                {77, 88, 99}
        };

        System.out.println("Using Nested For-Loops:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nUsing Enhanced For-Loop:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    /* =========================================================================
     * 4. Arrays.deepToString()
     * =========================================================================
     * Arrays.toString() → NOT suitable for multi-dimensional arrays
     * Arrays.deepToString() → prints nested structures fully
     */
    static void deepToStringDemo() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 4. Arrays.deepToString() *\n");

        String[][] data = {
                {"Alice", "Bob"},
                {"Charlie", "Diana"},
                {"Eve", "Frank"}
        };

        System.out.println("Deep Print: " + Arrays.deepToString(data));
    }

    /* =========================================================================
     * 5. USER INPUT EXAMPLE (DYNAMIC MATRIX)
     * ========================================================================= */
    static void userInputExample() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 5. User Input Example (2x2 Matrix) *\n");

        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[2][2];

        System.out.println("Enter 4 numbers for a 2x2 matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix Entered:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Deep String: " + Arrays.deepToString(matrix));
    }

    /* =========================================================================
     * 6. JAGGED ARRAYS (UNEQUAL ROW LENGTHS)
     * ========================================================================= */
    static void jaggedArrayDemo() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 6. Jagged Arrays (Unequal Rows) *\n");

        int[][] jagged = new int[4][]; // Only row count fixed

        jagged[0] = new int[]{1};
        jagged[1] = new int[]{2, 3};
        jagged[2] = new int[]{4, 5, 6};
        jagged[3] = new int[]{7, 8, 9, 10};

        System.out.println("Jagged Array (deep print): " + Arrays.deepToString(jagged));

        System.out.println("\nFormatted Output:");
        for (int[] row : jagged) {
            for (int n : row) System.out.print(n + " ");
            System.out.println();
        }
    }

    /* =========================================================================
     * 7. DEFAULT VALUES & EDGE CASES
     * =========================================================================
     *
     * Default Values:
     *  int[][] arr = new int[3][4];
     *
     * → All elements = 0 (for int)
     *
     * Other types:
     *  boolean → false
     *  char → '\u0000'
     *  Objects → null
     *
     * Edge Cases:
     *  - Accessing arr[i][j] when arr[i] is null → NullPointerException
     *  - Jagged arrays may have different row sizes → always check row length
     */
    static void defaultValuesDemo() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 7. Default Values Demo *\n");

        int[][] arr = new int[3][4]; // all values = 0
        System.out.println("3x4 matrix default values:");
        System.out.println(Arrays.deepToString(arr));
    }

    /* =========================================================================
     * 8. 3D ARRAYS (BONUS SECTION)
     * ========================================================================= */
    static void threeDimensionalArray() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("* 8. 3D Arrays (Bonus) *\n");

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

        System.out.println("3D Array (deep print): " + Arrays.deepToString(cube));

        System.out.println("\nIterating 3D array:");
        for (int[][] matrix : cube) {
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            System.out.println("-- Layer End --");
        }
    }

    /* =========================================================================
     * MAIN METHOD
     * ========================================================================= */
    public static void main(String[] args) {

        System.out.println("=========== JAVA MULTI-DIMENSIONAL ARRAY DEMO ==========\n");

        declarationAndInitialization();
        traversingWithLoops();
        deepToStringDemo();
        // Uncomment if running interactively
        // userInputExample();
        jaggedArrayDemo();
        defaultValuesDemo();
        threeDimensionalArray();

        System.out.println("\n===================== END OF DEMO ======================");
    }
}
