// ----------------------
// Abstract Class Example
// ----------------------

public class Abstraction {
    public static void main(String[] args) {

        // Using abstract class
        Shape circle = new Circle("Blue", 5);
        Shape rectangle = new Rectangle("Green", 4, 6);

        circle.displayColor();
        System.out.println("Circle Area: " + circle.area());

        rectangle.displayColor();
        System.out.println("Rectangle Area: " + rectangle.area());

        System.out.println("------------------------------");

        // Using interface
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();
        car.stop();

        bike.start();
        bike.stop();
    }
}



// Abstract class: cannot be instantiated directly
abstract class Shape {
    String color;

    // Constructor
    Shape(String color) {
        this.color = color;
    }

    // Abstract method (no body → must be overridden by child classes)
    abstract double area();

    // Concrete method (already implemented, can be reused by subclasses)
    void displayColor() {
        System.out.println("Shape Color: " + color);
    }
}

// Circle class inherits Shape
class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementing abstract method
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class inherits Shape
class Rectangle extends Shape {
    double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Implementing abstract method
    @Override
    double area() {
        return length * width;
    }
}

// ----------------------
// Interface Example
// ----------------------

interface Vehicle {
    void start();   // abstract by default
    void stop();    // abstract by default
}

// Car implements Vehicle interface
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}

// Bike implements Vehicle interface
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started.");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped.");
    }
}


