import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * ARRAYS & ARRAYS UTILITY CLASS
 * ------------------------------
 * - Arrays in Java are fixed-length containers for storing elements of the same type.
 * - java.util.Arrays provides many useful static methods to manipulate arrays.
 *
 * Topics covered:
 * 1. Declaring and Initializing Arrays
 * 2. Traversing Arrays
 * 3. Arrays Utility Methods
 * 4. Multi-dimensional Arrays
 * 5. Arrays of Objects
 * 6. Stream operations on Arrays
 */

public class ArraysClassAndUtilities {

    /** ==========================================
     *  1. Basic Declaration and Initialization
     * ========================================== */
    static void basicArraysDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Basic Declaration & Initialization *");

        int[] numbers = {10, 20, 30, 40, 50};
        String[] fruits = new String[]{"Apple", "Banana", "Cherry"};

        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Fruits: " + Arrays.toString(fruits));

        // Modifying an element
        numbers[2] = 99;
        System.out.println("After modification: " + Arrays.toString(numbers));
    }

    /** ==========================================
     *  2. Traversing Arrays
     * ========================================== */
    static void traversingDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Traversing Arrays *");

        int[] nums = {5, 10, 15, 20};

        System.out.print("Using traditional for loop: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.print("Using enhanced for loop: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.print("Using Streams: ");
        IntStream.of(nums).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    /** ==========================================
     *  3. Arrays Utility Methods
     * ========================================== */
    static void arraysUtilityDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Arrays Utility Methods *");

        int[] arr = {3, 1, 5, 2, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Sorting
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        // Binary Search (works only on sorted arrays)
        int index = Arrays.binarySearch(arr, 3);
        System.out.println("Index of 3: " + index);

        // Copying Arrays
        int[] copy = Arrays.copyOf(arr, 7);
        System.out.println("Copied (length 7): " + Arrays.toString(copy));

        // Filling Arrays
        Arrays.fill(copy, 5, 7, 99);
        System.out.println("After fill(): " + Arrays.toString(copy));

        // Comparing Arrays
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("arr equals arr2? " + Arrays.equals(arr, arr2));

        // Converting array to String
        System.out.println("asList(): " + Arrays.asList("A", "B", "C"));
    }

    /** ==========================================
     *  4. Multi-dimensional Arrays
     * ========================================== */
    static void multiDimensionalDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Multi-dimensional Arrays *");

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix using Arrays.deepToString():");
        System.out.println(Arrays.deepToString(matrix));

        System.out.println("Formatted output:");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /** ==========================================
     *  5. Arrays of Objects
     * ========================================== */
    static void objectArrayDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Arrays of Objects *");

        class Student {
            String name;
            int marks;

            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }

            @Override
            public String toString() {
                return name + " (" + marks + ")";
            }
        }

        Student[] students = {
            new Student("Alice", 90),
            new Student("Bob", 85),
            new Student("Charlie", 92)
        };

        System.out.println("Students: " + Arrays.toString(students));

        // Sorting using custom comparator (by marks)
        Arrays.sort(students, (a, b) -> b.marks - a.marks);
        System.out.println("Sorted by marks: " + Arrays.toString(students));
    }

    /** ==========================================
     *  6. Stream Operations on Arrays
     * ========================================== */
    static void streamArrayDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Stream Operations on Arrays *");

        int[] nums = {1, 2, 3, 4, 5, 6};

        long countEven = Arrays.stream(nums)
                               .filter(n -> n % 2 == 0)
                               .count();

        int sum = Arrays.stream(nums)
                        .map(n -> n * 2)
                        .sum();

        System.out.println("Original: " + Arrays.toString(nums));
        System.out.println("Count of even numbers: " + countEven);
        System.out.println("Sum of doubled numbers: " + sum);
    }

    /** ==========================================
     *  Main Method - Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Arrays & Arrays Utility Class Demo ===\n");

        basicArraysDemo();
        traversingDemo();
        arraysUtilityDemo();
        multiDimensionalDemo();
        objectArrayDemo();
        streamArrayDemo();
    }
}
