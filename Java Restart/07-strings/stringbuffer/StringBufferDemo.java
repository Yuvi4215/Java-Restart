/**
 * STRINGBUFFER IN JAVA
 * ---------------------
 * - StringBuffer is a mutable sequence of characters.
 * - Unlike String, it can be modified after creation.
 * - It is THREAD-SAFE (synchronized) — suitable for multi-threaded environments.
 * - Similar to StringBuilder but slower due to synchronization.
 *
 * Topics Covered:
 * 1. Declaration & Basic Operations
 * 2. Append, Insert, Replace, Delete
 * 3. Reverse & Capacity
 * 4. Conversions (to String)
 * 5. Difference: String vs StringBuffer
 * 6. Performance Example
 */

public class StringBufferDemo {

    /** ==========================================
     *  1. Declaration & Basic Operations
     * ========================================== */
    static void declarationDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Declaration & Basic Operations *");

        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer(); // Empty buffer (default capacity 16)

        System.out.println("sb1: " + sb1);
        System.out.println("sb2 (empty): " + sb2);
        System.out.println("Initial capacity of sb2: " + sb2.capacity());

        sb2.append("Java");
        System.out.println("After appending: " + sb2);
        System.out.println("New capacity: " + sb2.capacity());
    }

    /** ==========================================
     *  2. Append, Insert, Replace, Delete
     * ========================================== */
    static void modifyDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Append, Insert, Replace, Delete *");

        StringBuffer sb = new StringBuffer("Java");
        System.out.println("Original: " + sb);

        sb.append(" Programming");
        System.out.println("After append(): " + sb);

        sb.insert(5, "Language ");
        System.out.println("After insert(): " + sb);

        sb.replace(5, 13, "is a ");
        System.out.println("After replace(): " + sb);

        sb.delete(5, 9);
        System.out.println("After delete(): " + sb);
    }

    /** ==========================================
     *  3. Reverse & Capacity
     * ========================================== */
    static void reverseCapacityDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Reverse & Capacity *");

        StringBuffer sb = new StringBuffer("OpenAI GPT");
        System.out.println("Original: " + sb);

        sb.reverse();
        System.out.println("After reverse(): " + sb);

        sb.reverse(); // back to original
        System.out.println("Reversed back: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());

        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sb.capacity());
    }

    /** ==========================================
     *  4. Conversions (to String)
     * ========================================== */
    static void conversionDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Conversions (to String) *");

        StringBuffer sb = new StringBuffer("Mutable StringBuffer");
        String str = sb.toString(); // Convert to String

        System.out.println("StringBuffer: " + sb);
        System.out.println("Converted to String: " + str);
    }

    /** ==========================================
     *  5. Difference: String vs StringBuffer
     * ========================================== */
    static void differenceDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Difference: String vs StringBuffer *");

        // Using String
        String str = "Hello";
        str.concat(" World");
        System.out.println("String (immutable): " + str); // Unchanged

        // Using StringBuffer
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("StringBuffer (mutable): " + sb); // Changed
    }

    /** ==========================================
     *  6. Performance Example
     * ========================================== */
    static void performanceDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Performance Example *");

        long startTime, endTime;

        // Using String
        startTime = System.nanoTime();
        String str = "Java";
        for (int i = 0; i < 10000; i++) {
            str += "X";
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by String: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            sb.append("X");
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java StringBuffer Demo ===\n");

        declarationDemo();
        modifyDemo();
        reverseCapacityDemo();
        conversionDemo();
        differenceDemo();
        performanceDemo();
    }
}
