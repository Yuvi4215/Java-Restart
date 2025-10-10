/**
 * Inheritance:
 * - Enables one class to acquire properties (fields) and behaviors (methods) of another class.
 * - Promotes code reuse and logical hierarchy.
 * 
 * Syntax: 
 *     class ChildClass extends ParentClass { ... }
 * 
 * Java supports:
 *  - Single inheritance (a class can extend only one class)
 *  - Multilevel inheritance
 *  - Hierarchical inheritance (one parent, multiple children)
 */
public class InheritanceDemo {

    /** =========================================
     *  1. Base Class (Parent)
     * ========================================= */
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
            System.out.println("Animal constructor called for " + name);
        }

        void eat() {
            System.out.println(name + " is eating...");
        }

        void sleep() {
            System.out.println(name + " is sleeping...");
        }
    }

    /** =========================================
     *  2. Derived Class (Single Inheritance)
     * ========================================= */
    static class Dog extends Animal {

        Dog(String name) {
            super(name); // call parent constructor
            System.out.println("Dog constructor called for " + name);
        }

        // Dog has its own behavior
        void bark() {
            System.out.println(name + " says: Woof! Woof!");
        }

        // Method overriding
        @Override
        void eat() {
            System.out.println(name + " is eating dog food (overridden).");
        }
    }

    /** =========================================
     *  3. Multilevel Inheritance
     * ========================================= */
    static class Puppy extends Dog {
        int age;

        Puppy(String name, int age) {
            super(name);
            this.age = age;
            System.out.println("Puppy constructor called for " + name + " (Age: " + age + ")");
        }

        void play() {
            System.out.println(name + " (puppy) is playing happily!");
        }

        @Override
        void eat() {
            System.out.println(name + " (puppy) is drinking milk (overridden again).");
        }
    }

    /** =========================================
     *  4. Hierarchical Inheritance
     * ========================================= */
    static class Cat extends Animal {
        Cat(String name) {
            super(name);
            System.out.println("Cat constructor called for " + name);
        }

        void meow() {
            System.out.println(name + " says: Meow!");
        }

        @Override
        void sleep() {
            System.out.println(name + " is sleeping curled up on the couch.");
        }
    }

    /** =========================================
     *  5. Demonstrating super keyword
     * ========================================= */
    static class Lion extends Animal {
        String region;

        Lion(String name, String region) {
            super(name); // call parent constructor
            this.region = region;
        }

        @Override
        void eat() {
            super.eat(); // call parent version
            System.out.println(name + " hunts in " + region + ".");
        }
    }

    /** =========================================
     *  6. Main Method (Demo)
     * ========================================= */
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demo ===\n");

        /** 1. Single Inheritance **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Single Inheritance *");
        Dog dog = new Dog("Buddy");
        dog.eat();
        dog.bark();
        dog.sleep();
        System.out.println();

        /** 2. Multilevel Inheritance **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Multilevel Inheritance *");
        Puppy puppy = new Puppy("Max", 2);
        puppy.eat(); // overridden in Puppy
        puppy.play();
        puppy.bark(); // inherited from Dog
        puppy.sleep(); // inherited from Animal
        System.out.println();

        /** 3. Hierarchical Inheritance **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Hierarchical Inheritance *");
        Cat cat = new Cat("Whiskers");
        cat.meow();
        cat.eat();   // from Animal
        cat.sleep(); // overridden in Cat
        System.out.println();

        /** 4. Using super keyword **/
        System.out.println("------------------------------------");
        System.out.println("* 4. super Keyword *");
        Lion lion = new Lion("Simba", "African Savannah");
        lion.eat(); // calls parent + own version
        lion.sleep();
        System.out.println();

        /** 5. Access Modifiers Note **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Access Modifiers Note *");
        System.out.println("Private members of a superclass are NOT inherited.");
        System.out.println("Protected and public members ARE accessible in subclasses.");
        System.out.println("Constructors are NEVER inherited, but can be called via 'super()'.");
    }
}
