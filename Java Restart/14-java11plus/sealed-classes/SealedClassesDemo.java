import java.util.*;

/**
 * SEALED CLASSES (Java 17+)
 * --------------------------
 * Sealed classes/interfaces let you control which classes are allowed to extend them.
 *
 * Rules:
 * - sealed class A permits B, C, D
 * - subclasses must be: final, sealed, or non-sealed
 *
 * Benefits:
 * - Restricts inheritance hierarchy
 * - Improves safety and program structure
 * - Works great with pattern matching & switch expressions
 */

public class SealedClassesDemo {

    /* ============================================================
     * 1. Sealed base class with permitted subclasses
     * ============================================================ */
    sealed abstract static class Shape permits Circle, Rectangle, Triangle {}

    // Final: no further subclassing
    static final class Circle extends Shape {
        double radius;
        Circle(double radius) { this.radius = radius; }
    }

    // Sealed again: only Square can extend Rectangle
    static sealed class Rectangle extends Shape permits Square {
        double width, height;
        Rectangle(double w, double h) { this.width = w; this.height = h; }
    }

    // Final subclass
    static final class Square extends Rectangle {
        Square(double side) { super(side, side); }
    }

    // Non-sealed: Triangle can be extended by any class
    static non-sealed class Triangle extends Shape {
        double base, height;
        Triangle(double b, double h) { this.base = b; this.height = h; }
    }

    // Since Triangle is non-sealed, this subclass is allowed
    static class RightTriangle extends Triangle {
        RightTriangle(double b, double h) { super(b, h); }
    }


    /* ============================================================
     * 2. Sealed Interface Example
     * ============================================================ */
    sealed interface Vehicle permits Car, Bike {}

    record Car(String model) implements Vehicle {}
    record Bike(String type) implements Vehicle {}


    /* ============================================================
     * 3. Pattern Matching Method for Shapes
     * ============================================================ */
    static void printShapeDetails(Shape shape) {
        System.out.println("Processing shape using pattern matching...");

        if (shape instanceof Circle c) {
            System.out.println("Circle with radius = " + c.radius);
        }
        else if (shape instanceof Rectangle r) {
            System.out.println("Rectangle width = " + r.width + ", height = " + r.height);
        }
        else if (shape instanceof Triangle t) {
            System.out.println("Triangle base = " + t.base + ", height = " + t.height);
        }
    }


    /* ============================================================
     * 4. Exhaustive switch (Java 17+) with sealed types
     * ============================================================ */
    static String areaType(Shape s) {
        return switch (s) {
            case Circle c -> "Area = " + (Math.PI * c.radius * c.radius);
            case Rectangle r -> "Area = " + (r.width * r.height);
            case Triangle t -> "Area = " + (0.5 * t.base * t.height);
            // No default required — sealed class ensures exhaustiveness!
        };
    }


    /* ============================================================
     * 5. Main Demo
     * ============================================================ */
    public static void main(String[] args) {

        System.out.println("=== Java Sealed Classes Demo ===\n");

        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Creating Sealed Type Objects *");

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape square = new Square(5);
        Shape triangle = new Triangle(3, 7);
        Shape rightTriangle = new RightTriangle(6, 8);

        printShapeDetails(circle);
        printShapeDetails(square);
        printShapeDetails(triangle);

        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Exhaustive switch with sealed classes *");

        System.out.println(areaType(circle));
        System.out.println(areaType(rectangle));
        System.out.println(areaType(triangle));

        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Sealed Interface Example *");

        Vehicle car = new Car("Honda City");
        Vehicle bike = new Bike("Mountain Bike");

        System.out.println(car);
        System.out.println(bike);

        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Key Takeaways *");

        System.out.println("- Sealed classes restrict inheritance.");
        System.out.println("- Subclasses must be final, sealed, or non-sealed.");
        System.out.println("- Works beautifully with pattern matching.");
        System.out.println("- Improves safety, readability, and domain modeling.");
        System.out.println("- Useful for fixed hierarchies like shapes, vehicles, states.");
    }
}
