/**
 * SEALED CLASSES IN JAVA
 * -----------------------
 * Introduced in Java 17 (finalized feature).
 *
 * Purpose:
 *   → To restrict which classes can extend or implement a given class or interface.
 *
 * Syntax:
 *   public sealed class ClassName permits SubClass1, SubClass2 { ... }
 *
 * Permitted subtypes must explicitly declare themselves as:
 *   - final       → cannot be subclassed further
 *   - sealed      → can be subclassed, but only by specific permitted classes
 *   - non-sealed  → removes restriction (can be freely subclassed)
 *
 * Benefits:
 *   - Stronger control over class hierarchies
 *   - Enhances API security and readability
 *   - Works perfectly with pattern matching (switch / instanceof)
 */


public class SealedClassesDemo {

    /** ============================================
     *  1. Sealed Class Hierarchy Example
     * ============================================ */

    // Abstract sealed superclass
    abstract sealed static class Shape permits Circle, Rectangle, Triangle {
        public abstract double area();
    }

    // Final subclass — cannot be extended
    static final class Circle extends Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return "Circle(radius=" + radius + ")";
        }
    }

    // Sealed subclass — can be extended by specific classes only
    static sealed class Rectangle extends Shape permits Square, GeneralRectangle {
        protected final double width, height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public String toString() {
            return "Rectangle(width=" + width + ", height=" + height + ")";
        }
    }

    // Final subclass
    static final class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }

        @Override
        public String toString() {
            return "Square(side=" + width + ")";
        }
    }

    // Non-sealed subclass — unrestricted inheritance allowed
    static non-sealed class GeneralRectangle extends Rectangle {
        GeneralRectangle(double width, double height) {
            super(width, height);
        }

        @Override
        public String toString() {
            return "GeneralRectangle(width=" + width + ", height=" + height + ")";
        }
    }

    // Final subclass
    static final class Triangle extends Shape {
        private final double base, height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double area() {
            return 0.5 * base * height;
        }

        @Override
        public String toString() {
            return "Triangle(base=" + base + ", height=" + height + ")";
        }
    }

    /** ============================================
     *  2. Pattern Matching with instanceof
     * ============================================ */
    void printShapeInfo(Shape shape) {
        System.out.print(shape + " → ");
        if (shape instanceof Circle c) {
            System.out.println("Area = " + c.area());
        } else if (shape instanceof Square s) {
            System.out.println("Area = " + s.area());
        } else if (shape instanceof GeneralRectangle gr) {
            System.out.println("Area = " + gr.area());
        } else if (shape instanceof Triangle t) {
            System.out.println("Area = " + t.area());
        } else {
            System.out.println("Unknown shape!");
        }
    }

    /** ============================================
     *  3. Main Method - Demo
     * ============================================ */
    public static void main(String[] args) {
        SealedClassesDemo demo = new SealedClassesDemo();

        System.out.println("=== Java Sealed Classes Demo ===\n");

        /** 1. Sealed Class Hierarchy **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Sealed Class Hierarchy *");
        Shape circle = new Circle(5);
        Shape rect = new Rectangle(4, 6);
        Shape square = new Square(3);
        Shape tri = new Triangle(4, 5);
        Shape genRect = new GeneralRectangle(8, 2);

        demo.printShapeInfo(circle);
        demo.printShapeInfo(rect);
        demo.printShapeInfo(square);
        demo.printShapeInfo(tri);
        demo.printShapeInfo(genRect);
        System.out.println();

        /** 2. Non-Sealed Class Flexibility **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Non-Sealed Example *");

        // Demonstrating subclassing of non-sealed class
        class ColoredRectangle extends GeneralRectangle {
            private final String color;

            ColoredRectangle(double width, double height, String color) {
                super(width, height);
                this.color = color;
            }

            @Override
            public String toString() {
                return "ColoredRectangle(width=" + width + ", height=" + height + ", color=" + color + ")";
            }
        }

        Shape coloredRect = new ColoredRectangle(4, 2, "Blue");
        demo.printShapeInfo(coloredRect);
        System.out.println();

        /** 3. Summary **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Key Takeaways *");
        System.out.println("- Sealed classes restrict inheritance to specific subclasses.");
        System.out.println("- Final subclasses cannot be extended further.");
        System.out.println("- Non-sealed removes restrictions.");
        System.out.println("- Works perfectly with pattern matching for safe type handling.");
    }
}
