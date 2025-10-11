/**
 * Nested Classes in Java:
 * - Classes defined within another class.
 * 
 * Types:
 * 1. Member Inner Class (Non-static)
 * 2. Static Nested Class
 * 3. Local Inner Class (inside a method)
 * 4. Anonymous Inner Class (no name, used for one-time use)
 * 
 * Why use them?
 * - To logically group classes that are only used in one place.
 * - To increase encapsulation.
 * - To make code more readable and maintainable.
 */
public class NestedAndAnonymousClassesDemo {

    /** =========================================
     *  1. Member Inner Class (Non-Static)
     * ========================================= */
    static class Outer {
        private String outerMessage = "Message from Outer class";

        // Member Inner Class
        class Inner {
            void show() {
                System.out.println("Inner class accessing → " + outerMessage);
            }
        }

        void outerMethod() {
            System.out.println("Outer class method called.");
            Inner inner = new Inner(); // create inner class object
            inner.show();
        }
    }

    /** =========================================
     *  2. Static Nested Class
     * ========================================= */
    static class OuterStatic {
        private static String staticMsg = "Static Message from OuterStatic";
        private String instanceMsg = "Instance Message from OuterStatic";

        // Static Nested Class (does NOT require OuterStatic object)
        static class Nested {
            void display() {
                System.out.println("Accessing: " + staticMsg);
                // System.out.println(instanceMsg); ❌ not allowed — no outer instance
            }
        }

        // Method that creates nested class instance
        void useNested() {
            Nested n = new Nested();
            n.display();
        }
    }

    /** =========================================
     *  3. Local Inner Class (Inside a Method)
     * ========================================= */
    static class Calculator {
        void operate(int a, int b) {
            // Local Inner Class defined inside method
            class Operation {
                void add() {
                    System.out.println("Addition = " + (a + b));
                }

                void multiply() {
                    System.out.println("Multiplication = " + (a * b));
                }
            }

            Operation op = new Operation();
            op.add();
            op.multiply();
        }
    }

    /** =========================================
     *  4. Anonymous Inner Class
     * ========================================= */
    interface Greeting {
        void sayHello();
    }

    /** =========================================
     *  5. Main Method (Demo)
     * ========================================= */
    public static void main(String[] args) {
        System.out.println("=== Nested and Anonymous Classes Demo ===\n");

        /** 1. Member Inner Class **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Member Inner Class *");
        Outer outer = new Outer();
        outer.outerMethod();
        // Or directly access Inner class:
        Outer.Inner innerObj = outer.new Inner();
        innerObj.show();
        System.out.println();

        /** 2. Static Nested Class **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Static Nested Class *");
        OuterStatic.Nested nested = new OuterStatic.Nested();
        nested.display();
        System.out.println();

        /** 3. Local Inner Class **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Local Inner Class *");
        Calculator calc = new Calculator();
        calc.operate(5, 3);
        System.out.println();

        /** 4. Anonymous Inner Class **/
        System.out.println("------------------------------------");
        System.out.println("* 4. Anonymous Inner Class *");

        // Anonymous class implementing an interface
        Greeting g1 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from an Anonymous Inner Class!");
            }
        };
        g1.sayHello();

        // Anonymous class extending a concrete class
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread running from Anonymous Inner Class!");
            }
        };
        t.start();
        System.out.println();

        /** 5. Practical Example **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Practical Example: Button Click Simulation *");

        // Simulate button click using an anonymous listener
        Button button = new Button("Submit");
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button '" + button.getLabel() + "' clicked!");
            }
        });
        button.click();
    }

    /** =========================================
     *  6. Supporting Classes for Practical Example
     * ========================================= */
    interface OnClickListener {
        void onClick();
    }

    static class Button {
        private String label;
        private OnClickListener listener;

        Button(String label) {
            this.label = label;
        }

        String getLabel() {
            return label;
        }

        void setOnClickListener(OnClickListener listener) {
            this.listener = listener;
        }

        void click() {
            if (listener != null)
                listener.onClick();
            else
                System.out.println("No click listener assigned!");
        }
    }
}
