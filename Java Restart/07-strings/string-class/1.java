/**
 * STRING CLASS IN JAVA
 * --------------------
 * Strings in Java are:
 * - Immutable (cannot be changed after creation)
 * - Objects of class java.lang.String
 *
 * Topics Covered:
 * 1. Declaration & Initialization
 * 2. String Immutability
 * 3. Common String Methods
 * 4. Comparison: == vs equals()
 * 5. Substring, Split, Join
 * 6. String Formatting & Conversion
 */

import java.util.Arrays;

public class StringClassDemo {

    /** ==========================================
     *  1. Declaration & Initialization
     * ========================================== */
    static void declarationDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Declaration & Initialization *");

        // Literal
        String s1 = "Hello";
        // Using new keyword
        String s2 = new String("World");
        // Concatenation
        String s3 = s1 + " " + s2;
        // Empty string
        String s4 = "";

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3 (concatenated): " + s3);
        System.out.println("Empty string: \"" + s4 + "\" (length = " + s4.length() + ")");
    }

    /** ==========================================
     *  2. String Immutability
     * ========================================== */
    static void immutabilityDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. String Immutability *");

        String str = "Java";
        System.out.println("Original String: " + str);
        str.concat(" Programming");
        System.out.println("After concat(): " + str + " (unchanged!)");

        String newStr = str.concat(" Programming");
        System.out.println("New String (assigned): " + newStr);
    }

    /** ==========================================
     *  3. Common String Methods
     * ========================================== */
    static void stringMethodsDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Common String Methods *");

        String text = "  Java Programming Language  ";
        System.out.println("Original: \"" + text + "\"");

        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: \"" + text.trim() + "\"");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Character at index 5: " + text.charAt(5));
        System.out.println("Index of 'g': " + text.indexOf('g'));
        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));
        System.out.println("Starts with 'Java'? " + text.trim().startsWith("Java"));
        System.out.println("Ends with 'Language'? " + text.trim().endsWith("Language"));
        System.out.println("Contains 'Program'? " + text.contains("Program"));
        System.out.println("Replace 'Java' → 'Python': " + text.replace("Java", "Python"));
    }

    /** ==========================================
     *  4. Comparison: == vs equals()
     * ========================================== */
    static void comparisonDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Comparison: == vs equals() *");

        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        System.out.println("a == b → " + (a == b));           // true (same string pool reference)
        System.out.println("a == c → " + (a == c));           // false (different object)
        System.out.println("a.equals(b) → " + a.equals(b));   // true (content same)
        System.out.println("a.equals(c) → " + a.equals(c));   // true (content same)
    }

    /** ==========================================
     *  5. Substring, Split, Join
     * ========================================== */
    static void substringSplitJoinDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Substring, Split, Join *");

        String sentence = "Java is fun and powerful!";
        System.out.println("Original: " + sentence);

        String sub = sentence.substring(5, 15);
        System.out.println("Substring (5,15): " + sub);

        String[] words = sentence.split(" ");
        System.out.println("Split by spaces: " + Arrays.toString(words));

        String joined = String.join("-", "Learn", "Java", "Easily");
        System.out.println("Joined string: " + joined);
    }

    /** ==========================================
     *  6. String Formatting & Conversion
     * ========================================== */
    static void formattingConversionDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. String Formatting & Conversion *");

        int age = 25;
        double salary = 52345.678;
        String name = "Alice";

        // Using String.format()
        String formatted = String.format("Name: %s | Age: %d | Salary: %.2f", name, age, salary);
        System.out.println("Formatted String: " + formatted);

        // Using printf
        System.out.printf("Printf example: %-10s %3d years old earns $%.1f%n", name, age, salary);

        // Conversions
        int num = Integer.parseInt("123");
        String numStr = String.valueOf(456);
        System.out.println("String to int: " + num);
        System.out.println("int to String: " + numStr);
    }

    /** ==========================================
     *  Main Method - Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java String Class Demo ===\n");

        declarationDemo();
        immutabilityDemo();
        stringMethodsDemo();
        comparisonDemo();
        substringSplitJoinDemo();
        formattingConversionDemo();
    }
}
