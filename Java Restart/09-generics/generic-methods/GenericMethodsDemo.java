/**
 * GENERIC METHODS IN JAVA
 * ------------------------
 * ✅ A generic method defines type parameters at method level.
 *
 * Syntax:
 *      <T> returnType methodName(T param)
 *
 * ✅ Benefits:
 * - Works with different data types
 * - Compile-time type safety
 * - No casting required
 *
 * Topics Covered:
 * 1. Simple Generic Method
 * 2. Generic Method with Multiple Types
 * 3. Bounded Generic Methods
 * 4. Generic Method with Arrays
 * 5. Utility Generic Methods
 */

import java.util.*;

public class GenericMethodsDemo {

    /** ==========================================
     *  1. Simple Generic Method
     * ========================================== */
    static <T> void printItem(T item) {
        System.out.println("Item: " + item);
    }

    /** ==========================================
     *  2. Generic Method with Two Types
     * ========================================== */
    static <K, V> void showPair(K key, V value) {
        System.out.println("Key = " + key + ", Value = " + value);
    }

    /** ==========================================
     *  3. Bounded Generic Method (<T extends Number>)
     *  Only numeric types allowed
     * ========================================== */
    static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    /** ==========================================
     *  4. Generic Method to Print Array
     * ========================================== */
    static <T> void printArray(T[] arr) {
        System.out.print("Array: ");
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  5. Generic Method: Find Max of Array
     *     Requires T to be Comparable
     * ========================================== */
    static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    /** ==========================================
     *  6. Generic Swap (for Lists)
     * ========================================== */
    static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /** ==========================================
     *  Main Method — Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Generic Methods Demo ===\n");

        // ✅ 1. Simple generic method
        System.out.println("------------------------------------");
        System.out.println("* 1. Simple Generic Method *");
        printItem("Hello");
        printItem(123);
        printItem(45.67);

        // ✅ 2. Generic method with two types
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Generic Method with Multiple Types *");
        showPair("Language", "Java");
        showPair(101, true);

        // ✅ 3. Bounded generic method
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Bounded Generic Method (<T extends Number>) *");
        System.out.println("Sum of 10 and 20.5 = " + add(10, 20.5));
        System.out.println("Sum of 5 and 6 = " + add(5, 6));

        // ✅ 4. Generic method for arrays
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Generic Method with Arrays *");
        Integer[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"A", "B", "C"};
        printArray(intArr);
        printArray(strArr);

        // ✅ 5. Find max using generic comparable method
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Generic Method: Find Max in Array *");
        Integer[] nums = {10, 50, 20, 90, 40};
        String[] words = {"apple", "banana", "mango"};
        System.out.println("Max from nums: " + findMax(nums));
        System.out.println("Max from words: " + findMax(words));

        // ✅ 6. Swapping values in list
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Generic Swap Method *");
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("Before swap: " + list);
        swap(list, 0, 2);
        System.out.println("After swap: " + list);

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- <T> makes methods work for many data types.");
        System.out.println("- <T extends Number> restricts to numeric values.");
        System.out.println("- <T extends Comparable> allows comparisons.");
        System.out.println("- Avoids casting, improves type safety.");
    }
}
