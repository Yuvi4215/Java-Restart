/**
 * Polymorphism:
 * - The ability of an object to take many forms.
 * - In Java, it allows methods to have the same name but different behavior.
 *
 * Types:
 * 1. Compile-time (Static) Polymorphism → Method Overloading
 * 2. Runtime (Dynamic) Polymorphism → Method Overriding
 */
public class PolymorphismDemo {

    /** ======================================
     *  1. Compile-time Polymorphism (Overloading)
     * ====================================== */
    static class Calculator {

        // Overloaded methods (same name, different parameters)
        int add(int a, int b) {
            return a + b;
        }

        double add(double a, double b) {
            return a + b;
        }

        int add(int a, int b, int c) {
            return a + b + c;
        }

        String add(String a, String b) {
            return a + b;
        }

        void printAddExamples() {
            System.out.println("Add (int, int): " + add(2, 3));
            System.out.println("Add (double, double): " + add(2.5, 3.5));
            System.out.println("Add (int, int, int): " + add(1, 2, 3));
            System.out.println("Add (String, String): " + add("Hello ", "World"));
        }
    }

    /** ======================================
     *  2. Runtime Polymorphism (Overriding)
     * ====================================== */
    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks: Woof! Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Cat meows: Meow!");
        }
    }

    static class Cow extends Animal {
        @Override
        void sound() {
            System.out.println("Cow moos: Moo!");
        }
    }

    /** ======================================
     *  3. Upcasting and Dynamic Method Dispatch
     * ====================================== */
    static void makeAnimalSound(Animal a) {
        a.sound(); // Runtime decision based on actual object type
    }

    /** ======================================
     *  4. Practical Example: Payment System
     * ====================================== */
    static abstract class Payment {
        abstract void pay(double amount);
    }

    static class CreditCardPayment extends Payment {
        @Override
        void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
        }
    }

    static class PayPalPayment extends Payment {
        @Override
        void pay(double amount) {
            System.out.println("Paid $" + amount + " via PayPal.");
        }
    }

    static class CryptoPayment extends Payment {
        @Override
        void pay(double amount) {
            System.out.println("Paid $" + amount + " in Cryptocurrency.");
        }
    }

    /** ======================================
     *  5. Main Method (Demo)
     * ====================================== */
    public static void main(String[] args) {
        System.out.println("=== Polymorphism in Java Demo ===\n");

        /** 1. Compile-time Polymorphism **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Compile-time Polymorphism (Method Overloading) *");
        Calculator calc = new Calculator();
        calc.printAddExamples();
        System.out.println();

        /** 2. Runtime Polymorphism **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Runtime Polymorphism (Method Overriding) *");
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Cow();

        a1.sound(); // Dog’s version
        a2.sound(); // Cat’s version
        a3.sound(); // Cow’s version
        System.out.println();

        /** 3. Dynamic Method Dispatch & Upcasting **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Dynamic Method Dispatch *");
        Animal ref;
        ref = new Dog();
        ref.sound();
        ref = new Cat();
        ref.sound();
        ref = new Cow();
        ref.sound();
        System.out.println();

        /** 4. Using instanceof **/
        System.out.println("------------------------------------");
        System.out.println("* 4. instanceof Operator *");
        if (a1 instanceof Dog)
            System.out.println("a1 is an instance of Dog");
        if (a2 instanceof Animal)
            System.out.println("a2 is an instance of Animal");
        if (!(a3 instanceof Cat))
            System.out.println("a3 is NOT a Cat");
        System.out.println();

        /** 5. Practical Example: Payment System **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Practical Example: Payment System *");
        Payment p;

        p = new CreditCardPayment();
        p.pay(100.00);

        p = new PayPalPayment();
        p.pay(250.50);

        p = new CryptoPayment();
        p.pay(999.99);

        System.out.println();
    }
}
