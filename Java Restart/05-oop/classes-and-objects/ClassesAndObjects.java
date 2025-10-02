/**
 * A class is a blueprint for creating objects.
 * An object is an instance of a class, representing real-world entities.
 */
public class ClassesAndObjects {

    /** ================================
     *  1. Simple Class Definition
     * ================================ */
    static class Car {
        // Fields (properties/attributes)
        String brand;
        String color;
        int speed;

        // Default constructor
        Car() {
            this.brand = "Unknown";
            this.color = "White";
            this.speed = 0;
        }

        // Parameterized constructor
        Car(String brand, String color, int speed) {
            this.brand = brand;
            this.color = color;
            this.speed = speed;
        }

        // Methods (behaviors)
        void drive() {
            System.out.println(brand + " is driving at " + speed + " km/h.");
        }

        void repaint(String newColor) {
            System.out.println("Repainting " + brand + " from " + color + " to " + newColor);
            this.color = newColor; // using 'this' keyword
        }
    }

    /** ================================
     *  2. Another Example Class
     * ================================ */
    static class Student {
        String name;
        int age;

        // Constructor
        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method
        void introduce() {
            System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
        }
    }

    /** ================================
     *  3. Main Method (Demo)
     * ================================ */
    public static void main(String[] args) {
        System.out.println("=== Classes and Objects Demo ===\n");

        /** 1. Creating Car objects **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Creating Objects of Car Class *");
        Car car1 = new Car(); // using default constructor
        car1.drive();
        car1.repaint("Red");
        car1.drive();

        Car car2 = new Car("Tesla", "Black", 120); // parameterized constructor
        car2.drive();
        System.out.println();

        /** 2. Creating Student objects **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Creating Objects of Student Class *");
        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 22);

        s1.introduce();
        s2.introduce();
        System.out.println();

        /** 3. Multiple Objects Interaction **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Multiple Objects Interaction *");
        Car car3 = new Car("BMW", "Blue", 80);
        Student s3 = new Student("Charlie", 25);

        System.out.println(s3.name + " owns a " + car3.color + " " + car3.brand + ".");
        car3.drive();
        s3.introduce();
        System.out.println();
    }
}
