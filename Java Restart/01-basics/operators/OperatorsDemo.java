/*
Arithmetic → + - * / %
Unary → ++ -- - !
Assignment → = += -= *= /= %=
Relational → == != > < >= <=
Logical → && || !
Bitwise → & | ^ ~ << >> >>>
Ternary → ?:
instanceof
Type casting
*/


public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println("-------------- a=10 and b=5  ---------------");

        // 1. Arithmetic Operators
        System.out.println("=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // 2. Unary Operators
        System.out.println("\n=== Unary Operators ===");
        int x = 5;
        System.out.println("x = " + x);
        System.out.println("++x = " + (++x)); // pre-increment
        System.out.println("x++ = " + (x++)); // post-increment
        System.out.println("After x++: " + x);
        System.out.println("--x = " + (--x)); // pre-decrement
        System.out.println("x-- = " + (x--)); // post-decrement
        System.out.println("After x--: " + x);
        System.out.println("Unary minus (-x) = " + (-x));
        System.out.println("Logical NOT (!true) = " + (!true));

        // 3. Assignment Operators
        System.out.println("\n=== Assignment Operators ===");
        int y = 10;
        System.out.println("y = " + y);
        y += 5; System.out.println("y += 5 -> " + y);
        y -= 3; System.out.println("y -= 3 -> " + y);
        y *= 2; System.out.println("y *= 2 -> " + y);
        y /= 4; System.out.println("y /= 4 -> " + y);
        y %= 3; System.out.println("y %= 3 -> " + y);

        // 4. Relational Operators
        System.out.println("\n=== Relational Operators ===");
        System.out.println("a == b -> " + (a == b));
        System.out.println("a != b -> " + (a != b));
        System.out.println("a > b -> " + (a > b));
        System.out.println("a < b -> " + (a < b));
        System.out.println("a >= b -> " + (a >= b));
        System.out.println("a <= b -> " + (a <= b));

        // 5. Logical Operators
        System.out.println("\n=== Logical Operators ===");
        boolean cond1 = true, cond2 = false;
        System.out.println("cond1 && cond2 -> " + (cond1 && cond2));
        System.out.println("cond1 || cond2 -> " + (cond1 || cond2));
        System.out.println("!cond1 -> " + (!cond1));

        // 6. Bitwise Operators
        System.out.println("\n=== Bitwise Operators ===");
        int m = 6, n = 3; // binary: m=110, n=011
        System.out.println("m & n -> " + (m & n)); // AND
        System.out.println("m | n -> " + (m | n)); // OR
        System.out.println("m ^ n -> " + (m ^ n)); // XOR
        System.out.println(" ~m  -> " + (~m));       // NOT
        System.out.println("m << 1 -> " + (m << 1)); // left shift
        System.out.println("m >> 1 -> " + (m >> 1)); // right shift
        System.out.println("m >>> 1 -> " + (m >>> 1)); // unsigned right shift

        // 7. Ternary Operator
        System.out.println("\n=== Ternary Operator ===");
        int max = (a > b) ? a : b;
        System.out.println("Max of a and b is " + max);

        // 8. instanceof Operator
        System.out.println("\n=== instanceof Operator ===");
        String str = "Hello";
        System.out.println("str instanceof String -> " + (str instanceof String));

        // 9. Type Cast Operator
        System.out.println("\n=== Type Cast Operator ===");
        double pi = 3.14159;
        int intPi = (int) pi; // narrowing
        System.out.println("Double pi = " + pi);
        System.out.println("After casting to int: " + intPi);
    }
}
