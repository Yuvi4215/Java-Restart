/**
 * SEALED CLASSES IN JAVA
 * -----------------------
 * Finalized in Java 17.
 *
 * Purpose:
 *   → Control and restrict inheritance.
 *   → Maintain predictable class hierarchies.
 *   → Improve domain modelling & API security.
 *
 * Rules:
 *   - A sealed class/interface must declare permitted subclasses.
 *   - Permitted subclasses must be:
 *       • final       → cannot be subclassed further
 *       • sealed      → restricted further
 *       • non-sealed  → open to any subclassing
 *
 * Enhanced Features (Java 21+):
 *   - Pattern Matching for Switch
 *   - Improved instanceof matching
 */

// Combined Mega-File: All Sealed Class Examples in One Place
// ------------------------------------------------------------
// Java 21+ features included: sealed classes, sealed interfaces,
// pattern matching switch, records, guards.

public class SealedClassesMegaDemo {

    /* ============================================================
     * 1. Sealed Class Hierarchy (Shapes)
     * ============================================================ */

    abstract sealed static class Shape permits Circle, Rectangle, Triangle { 
        public abstract double area(); 
    }

    static final class Circle extends Shape {
        private final double radius;
        Circle(double radius) { this.radius = radius; }
        public double area() { return Math.PI * radius * radius; }
        public String toString() { return "Circle(r=" + radius + ")"; }
    }

    static sealed class Rectangle extends Shape permits Square, FlexibleRectangle {
        protected final double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        public double area() { return w * h; }
        public String toString() { return "Rectangle(" + w + "×" + h + ")"; }
    }

    static final class Square extends Rectangle {
        Square(double side) { super(side, side); }
        public String toString() { return "Square(" + w + ")"; }
    }

    static non-sealed class FlexibleRectangle extends Rectangle {
        FlexibleRectangle(double w, double h) { super(w, h); }
        public String toString() { return "FlexibleRect(" + w + "×" + h + ")"; }
    }

    static final class Triangle extends Shape {
        private final double b, h;
        Triangle(double b, double h) { this.b = b; this.h = h; }
        public double area() { return 0.5 * b * h; }
        public String toString() { return "Triangle(" + b + ", " + h + ")"; }
    }

    /* ============================================================
     * 2. Pattern Matching on Shapes
     * ============================================================ */

    void printShapeInfo(Shape s) {
        String out = switch (s) {
            case Circle c -> c + " → area=" + c.area();
            case Square sq -> sq + " → area=" + sq.area();
            case FlexibleRectangle fr -> fr + " → area=" + fr.area();
            case Rectangle r -> r + " → area=" + r.area();
            case Triangle t -> t + " → area=" + t.area();
        };
        System.out.println(out);
    }

    /* ============================================================
     * 3. Sealed Interface Example (PaymentStatus)
     * ============================================================ */

    sealed interface PaymentStatus permits Success, Failed, Pending { }

    record Success(String txnId) implements PaymentStatus { }
    record Failed(String reason) implements PaymentStatus { }

    non-sealed static class Pending implements PaymentStatus {
        private final String refId;
        Pending(String refId) { this.refId = refId; }
        public String refId() { return refId; }
        public String toString() { return "Pending(ref=" + refId + ")"; }
    }

    void printStatus(PaymentStatus ps) {
        switch (ps) {
            case Success s -> System.out.println("Success: " + s.txnId());
            case Failed f -> System.out.println("Failed: " + f.reason());
            case Pending p -> System.out.println("Pending: " + p.refId());
        }
    }

    /* ============================================================
     * 4. Sealed Abstract Class + Strategy Pattern Example
     * ============================================================ */

    abstract sealed static class DiscountStrategy permits NoDiscount, FlatDiscount, PercentageDiscount {
        public abstract double apply(double amount);
    }

    static final class NoDiscount extends DiscountStrategy {
        public double apply(double amount) { return amount; }
    }

    static final class FlatDiscount extends DiscountStrategy {
        private final double off;
        FlatDiscount(double off) { this.off = off; }
        public double apply(double amount) { return amount - off; }
    }

    static final class PercentageDiscount extends DiscountStrategy {
        private final double pct;
        PercentageDiscount(double pct) { this.pct = pct; }
        public double apply(double amount) { return amount * (1 - pct/100); }
    }

    /* ============================================================
     * 5. Enum-like Behavior using Sealed Types
     * ============================================================ */

    sealed interface Command permits Start, Stop, Restart { }
    record Start() implements Command { }
    record Stop() implements Command { }
    record Restart() implements Command { }

    void runCommand(Command cmd) {
        switch (cmd) {
            case Start s -> System.out.println("Starting…");
            case Stop st -> System.out.println("Stopping…");
            case Restart r -> System.out.println("Restarting…");
        }
    }

    /* ============================================================
     * 6. Sealed Records Example (Shapes2)
     * ============================================================ */

    sealed interface Shape2 permits Circle2, Rect2 { }

    record Circle2(double r) implements Shape2 { }
    record Rect2(double w, double h) implements Shape2 { }

    /* ============================================================
     * 7. Pattern Matching Switch + Guards
     * ============================================================ */

    void analyze(Shape s) {
        switch (s) {
            case Circle c when c.area() > 50 -> System.out.println("Large circle!");
            case Circle c -> System.out.println("Circle OK");
            case Rectangle r when r.w == r.h -> System.out.println("This is actually a square!");
            case Rectangle r -> System.out.println("Rectangle area=" + r.area());
            case Triangle t -> System.out.println("Triangle area=" + t.area());
        }
    }

    /* ============================================================
     * MAIN – Run All Examples
     * ============================================================ */

    public static void main(String[] args) {
        SealedClassesMegaDemo d = new SealedClassesMegaDemo();

        System.out.println("=== SHAPE EXAMPLES ===");
        d.printShapeInfo(new Circle(5));
        d.printShapeInfo(new Rectangle(4, 6));
        d.printShapeInfo(new Square(3));
        d.printShapeInfo(new Triangle(4, 5));
        d.printShapeInfo(new FlexibleRectangle(10, 2));

        System.out.println("\n=== SEALED INTERFACE (PAYMENTS) ===");
        d.printStatus(new Success("TXN123"));
        d.printStatus(new Failed("Insufficient funds"));
        d.printStatus(new Pending("REF998"));

        System.out.println("\n=== STRATEGY EXAMPLE ===");
        DiscountStrategy ds1 = new FlatDiscount(50);
        DiscountStrategy ds2 = new PercentageDiscount(10);
        System.out.println(ds1.apply(500));
        System.out.println(ds2.apply(500));

        System.out.println("\n=== COMMANDS ===");
        d.runCommand(new Start());
        d.runCommand(new Restart());

        System.out.println("\n=== GUARD EXAMPLE ===");
        d.analyze(new Circle(10));
        d.analyze(new Rectangle(4, 4));
    }
}

