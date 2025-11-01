/**
 * STRINGBUILDER IN JAVA
 * ----------------------
 * - StringBuilder is a mutable sequence of characters.
 * - Introduced in Java 5 as a faster alternative to StringBuffer.
 * - NOT synchronized → not thread-safe but faster in single-threaded use.
 *
 * Topics Covered:
 * 1. Declaration & Basic Operations
 * 2. Append, Insert, Replace, Delete
 * 3. Reverse & Capacity
 * 4. Conversion to String
 * 5. Difference: String, StringBuffer, StringBuilder
 * 6. Performance Comparison
 */

public class StringBuilderDemo {

    /** ==========================================
     *  1. Declaration & Basic Operations
     * ========================================== */
    static void declarationDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Declaration & Basic Operations *");

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder(); // Default capacity = 16

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

        StringBuilder sb = new StringBuilder("Java");
        System.out.println("Original: " + sb);

        sb.append(" Builder");
        System.out.println("After append(): " + sb);

        sb.insert(5, "String ");
        System.out.println("After insert(): " + sb);

        sb.replace(5, 11, "Powerful ");
        System.out.println("After replace(): " + sb);

        sb.delete(5, 15);
        System.out.println("After delete(): " + sb);
    }

    /** ==========================================
     *  3. Reverse & Capacity
     * ========================================== */
    static void reverseCapacityDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Reverse & Capacity *");

        StringBuilder sb = new StringBuilder("OpenAI GPT");
        System.out.println("Original: " + sb);

        sb.reverse();
        System.out.println("After reverse(): " + sb);

        sb.reverse(); // Back to original
        System.out.println("Reversed back: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());

        sb.ensureCapacity(40);
        System.out.println("After ensureCapacity(40): " + sb.capacity());
    }

    /** ==========================================
     *  4. Conversion to String
     * ========================================== */
    static void conversionDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Conversion to String *");

        StringBuilder sb = new StringBuilder("Mutable Builder");
        String str = sb.toString();

        System.out.println("StringBuilder: " + sb);
        System.out.println("Converted to String: " + str);
    }

    /** ==========================================
     *  5. Difference Between String, StringBuffer, StringBuilder
     * ========================================== */
    static void differenceDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Difference Between String, StringBuffer, StringBuilder *");

        // String (immutable)
        String str = "Hello";
        str.concat(" World");
        System.out.println("String (immutable): " + str);

        // StringBuffer (mutable & synchronized)
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer (mutable, thread-safe): " + sbf);

        // StringBuilder (mutable & faster, non-synchronized)
        StringBuilder sbd = new StringBuilder("Hello");
        sbd.append(" World");
        System.out.println("StringBuilder (mutable, fast, non-thread-safe): " + sbd);
    }

    /** ==========================================
     *  6. Performance Comparison
     * ========================================== */
    static void performanceDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Performance Comparison *");

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
        StringBuffer sbf = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            sbf.append("X");
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++) {
            sbd.append("X");
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java StringBuilder Demo ===\n");

        declarationDemo();
        modifyDemo();
        reverseCapacityDemo();
        conversionDemo();
        differenceDemo();
        performanceDemo();
    }
}
