// Demonstrates Java String Pool, Interning, and Memory Management

/**
 * JAVA STRING POOL (SCP) & INTERNING MECHANISM
 * --------------------------------------------
 * The String Constant Pool (SCP) is a special memory region inside the Heap.
 * Java uses it to optimize memory by storing only one copy of each literal string.
 *
 * Key Concepts Covered:
 * - Heap vs. String Constant Pool (SCP)
 * - Literal instantiation vs. 'new' keyword
 * - The .intern() method lifecycle
 * - Compile-time Constant Folding (Optimization)
 * - Runtime Concatenation (StringBuilder behavior)
 * - Impact of the 'final' keyword on memory
 *
 * How to Verify:
 * We use '==' to check for Reference Equality (memory address).
 * We use System.identityHashCode() to see the "ID" of the object in memory.
 */

import java.util.Arrays;

public class StringPoolDeepDive {

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("   JAVA STRING POOL & INTERNING: THE COMPLETE REFERENCE");
        System.out.println("==============================================================\n");

        // 1. The Basics: Literals vs New
        demonstrateLiteralsVsNew();

        // 2. The intern() Method Logic
        demonstrateInterning();

        // 3. Compile-Time Optimization (Constant Folding)
        demonstrateCompileTimeConstants();

        // 4. Runtime Concatenation (The Operator trap)
        demonstrateRuntimeConcatenation();

        // 5. The 'final' Keyword Effect (Advanced Interview Question)
        demonstrateFinalVariables();

        // 6. Method Calls (concat, join, format)
        demonstrateStringMethods();

        // 7. Constructor Variations (char[], StringBuilder)
        demonstrateConstructorVariations();
        
        System.out.println("==============================================================");
        System.out.println("   DEMONSTRATION COMPLETE");
        System.out.println("==============================================================");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 1: Literals vs The 'new' Keyword
    // -------------------------------------------------------------------------
    private static void demonstrateLiteralsVsNew() {
        printSectionHeader("1. Literals vs 'new' Keyword");

        // Literals: Go straight to String Constant Pool (SCP)
        String s1 = "Hello";
        String s2 = "Hello";

        // New Keyword: Forces object creation on HEAP (plus creates literal in SCP if missing)
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        analyze("Literal vs Literal (s1, s2)", s1, s2);
        analyze("Literal vs New (s1, s3)", s1, s3);
        analyze("New vs New (s3, s4)", s3, s4);
        
        System.out.println(">>> Note: 'new' always creates a unique object address in Heap.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 2: Manual Interning
    // -------------------------------------------------------------------------
    private static void demonstrateInterning() {
        printSectionHeader("2. Manual Interning (.intern())");

        String heapStr = new String("World"); // Created in Heap
        
        // intern() looks into SCP. 
        // If "World" is there, it returns the SCP reference.
        // If "World" is NOT there, it moves the reference to SCP.
        String internedStr = heapStr.intern(); 
        String literalStr = "World"; // Already in SCP

        analyze("Heap Object vs Interned Result", heapStr, internedStr);
        analyze("Interned Result vs Literal", internedStr, literalStr);
        
        System.out.println(">>> Note: s.intern() returns the canonical reference from the Pool.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 3: Compile-Time Constants (Constant Folding)
    // -------------------------------------------------------------------------
    private static void demonstrateCompileTimeConstants() {
        printSectionHeader("3. Compile-Time Constants (+ Operator)");

        String s1 = "JavaCode";
        
        // "Java" and "Code" are literals.
        // The Compiler sees this as "JavaCode" BEFORE the program even runs.
        // This is called "Constant Folding".
        String s2 = "Java" + "Code"; 
        
        analyze("Literal vs (\"A\" + \"B\")", s1, s2);
        
        System.out.println(">>> Note: Concatenating literals happens at COMPILER time.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 4: Runtime Concatenation
    // -------------------------------------------------------------------------
    private static void demonstrateRuntimeConcatenation() {
        printSectionHeader("4. Runtime Concatenation (Variables)");

        String base = "Java";
        String suffix = "Code";
        String target = "JavaCode";

        // Since 'base' and 'suffix' are variables, the compiler cannot optimize this.
        // JVM uses StringBuilder (or StringConcatFactory) at runtime.
        // Result: A new object on the Heap.
        String computed = base + suffix;

        analyze("Literal vs (var1 + var2)", target, computed);
        
        System.out.println(">>> Note: Concatenating variables creates a NEW Heap object.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 5: The 'final' Variable Exception
    // -------------------------------------------------------------------------
    private static void demonstrateFinalVariables() {
        printSectionHeader("5. The 'final' Variable Edge Case");

        String target = "JavaCode";

        // Regular variables (Mutable references)
        String s1 = "Java";
        String s2 = "Code";
        String resultNormal = s1 + s2; // Heap Object

        // Final variables (Constant references)
        // Compiler treats 'final' strings exactly like literals!
        final String f1 = "Java";
        final String f2 = "Code";
        String resultFinal = f1 + f2; // Pool Object (Optimized!)

        analyze("Standard Variables (+)", target, resultNormal);
        analyze("Final Variables (+)", target, resultFinal);

        System.out.println(">>> Note: 'final' strings are inlined by the compiler, acting like literals.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 6: Other String Methods
    // -------------------------------------------------------------------------
    private static void demonstrateStringMethods() {
        printSectionHeader("6. String Methods (concat, format, etc)");

        String s1 = "JavaCode";
        String part1 = "Java";
        String part2 = "Code";

        // .concat() is a method call, always runs at Runtime -> Heap Object
        String viaConcat = part1.concat(part2);
        
        // String.format() parses format string at Runtime -> Heap Object
        String viaFormat = String.format("%s%s", part1, part2);

        analyze("Literal vs .concat()", s1, viaConcat);
        analyze("Literal vs .format()", s1, viaFormat);
        
        System.out.println(">>> Note: Almost all String methods create new objects on the Heap.");
    }

    // -------------------------------------------------------------------------
    // SCENARIO 7: Constructor Variations
    // -------------------------------------------------------------------------
    private static void demonstrateConstructorVariations() {
        printSectionHeader("7. Constructor Variations");

        String target = "ABC";
        
        // Char Array
        char[] chars = {'A', 'B', 'C'};
        String fromChars = new String(chars); // Heap Object
        
        // StringBuilder
        StringBuilder sb = new StringBuilder("ABC");
        String fromBuilder = sb.toString(); // Heap Object

        analyze("Literal vs new String(char[])", target, fromChars);
        analyze("Literal vs StringBuilder.toString()", target, fromBuilder);
    }

    // -------------------------------------------------------------------------
    // HELPER METHODS
    // -------------------------------------------------------------------------
    
    /**
     * Analyzes two string references to see if they point to the same memory location.
     */
    private static void analyze(String label, String ref1, String ref2) {
        boolean isSameReference = (ref1 == ref2);
        
        // System.identityHashCode gives us a hint of the memory address/object ID
        int id1 = System.identityHashCode(ref1);
        int id2 = System.identityHashCode(ref2);

        System.out.printf("%-35s | Ref Equal? %-5s | IDs: %d vs %d%n", 
                          label, 
                          isSameReference, 
                          id1, 
                          id2);
    }

    private static void printSectionHeader(String title) {
        System.out.println("\n--------------------------------------------------------------");
        System.out.println(title);
        System.out.println("--------------------------------------------------------------");
    }
}
