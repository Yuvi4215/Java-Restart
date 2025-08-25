
public class VariablesAndTypesDemo {
    public static void main(String[] args) {
        System.out.println("=== Primitive Data Types ===");

        // 1. byte (8-bit, -128 to 127)
        byte b1 = 100;               // direct assignment
        byte b2; b2 = 120;           // declaration then initialization
        System.out.println("byte: " + b1 + ", " + b2);

        // 2. short (16-bit, -32,768 to 32,767)
        short s1 = 30000;
        short s2; s2 = -12345;
        System.out.println("short: " + s1 + ", " + s2);

        // 3. int (32-bit, default integer type)
        int i1 = 100000;
        int i2 = 0xFF;               // hexadecimal
        int i3 = 0b1010;             // binary
        int i4 = 1_000_000;          // underscores for readability
        System.out.println("int: " + i1 + ", " + i2 + ", " + i3 + ", " + i4);

        // 4. long (64-bit, needs 'L' suffix for literals)
        long l1 = 10000000000L;      // decimal
        long l2 = 0xFFFF_FFFFL;      // hex with underscore
        System.out.println("long: " + l1 + ", " + l2);

        // 5. float (32-bit, needs 'f' suffix)
        float f1 = 3.14f;
        float f2 = (float) 2.718;    // casting double to float
        System.out.println("float: " + f1 + ", " + f2);

        // 6. double (64-bit, default floating point type)
        double d1 = 3.14159265359;
        double d2 = 1.2e3;           // scientific notation (1200.0)
        System.out.println("double: " + d1 + ", " + d2);

        // 7. char (16-bit Unicode character)
        char c1 = 'A';               // single character
        char c2 = 66;                // ASCII/Unicode value
        char c3 = '\u03A9';          // Unicode literal (Ω)
        System.out.println("char: " + c1 + ", " + c2 + ", " + c3);

        // 8. boolean (true / false)
        boolean flag1 = true;
        boolean flag2 = false;
        System.out.println("boolean: " + flag1 + ", " + flag2);

        System.out.println("\n=== Non-Primitive Data Types ===");

        // 9. String
        String str1 = "Hello World";  // direct assignment
        String str2 = new String("Hello Again"); // using constructor
        System.out.println("String: " + str1 + " | " + str2);

        // 10. Arrays
        int[] arr1 = {1, 2, 3};       // inline initialization
        int[] arr2 = new int[3];      // fixed size, default values
        arr2[0] = 10; arr2[1] = 20; arr2[2] = 30;
        System.out.println("Array: arr1[0]=" + arr1[0] + ", arr2[1]=" + arr2[1]);

        // 11. Wrapper Classes (reference types for primitives)
        Integer intObj = Integer.valueOf(100);
        Double doubleObj = Double.valueOf(3.14);
        Boolean boolObj = Boolean.TRUE;
        System.out.println("Wrapper: " + intObj + ", " + doubleObj + ", " + boolObj);

        // 12. Object (base type of all classes)
        Object obj = new Object();
        System.out.println("Object: " + obj.toString());

        // 13. var (Java 10+ type inference)
        var inferredInt = 42;
        var inferredString = "Type inferred string";
        System.out.println("var: " + inferredInt + ", " + inferredString);

        // 14. final variables (constants)
        final double PI = 3.14159;
        final int MAX_VALUE;
        MAX_VALUE = 999; // can assign only once
        System.out.println("final: PI=" + PI + ", MAX_VALUE=" + MAX_VALUE);

        // 15. null reference
        String nullStr = null;
        System.out.println("null String reference: " + nullStr);
    }
}
