/**
 * PACKAGES IN JAVA
 * -----------------
 * A package is a namespace used to group related classes.
 * It helps:
 *  - avoid name conflicts
 *  - organize code
 *  - control access levels
 *
 * Example folder structure:
 *
 *  src/
 *    com/myapp/models/Person.java
 *    com/myapp/services/GreetingService.java
 *    com/myapp/main/App.java
 *
 * Each Java file begins with:
 *    package com.myapp.models;
 */

public class CreatingPackagesDemo {

    public static void main(String[] args) {

        System.out.println("=== Java Packages Demo (Single File Explanation) ===\n");

        System.out.println("This file shows how multiple packages work, but in ONE file.");
        System.out.println("Below you will see simulated package structures.\n");

        System.out.println("----------------------------------------");
        System.out.println("* 1. Package: com.myapp.models *");
        System.out.println(examplePersonClass());

        System.out.println("----------------------------------------");
        System.out.println("* 2. Package: com.myapp.services *");
        System.out.println(exampleServiceClass());

        System.out.println("----------------------------------------");
        System.out.println("* 3. Package: com.myapp.main (Main App) *");
        System.out.println(exampleMainClass());

        System.out.println("----------------------------------------");
        System.out.println("NOTE: Only ONE package declaration is allowed per .java file.");
        System.out.println("This is a teaching/demo file showing how packages should be structured.");
    }

    // Simulated package blocks for GitHub display:

    static String examplePersonClass() {
        return """
        // File: Person.java
        // package com.myapp.models;

        package com.myapp.models;

        public class Person {
            private String name;
            private int age;

            public Person(String name, int age){
                this.name = name;
                this.age = age;
            }

            public void showInfo() {
                System.out.println("Name: " + name + ", Age: " + age);
            }
        }
        """;
    }

    static String exampleServiceClass() {
        return """
        // File: GreetingService.java
        // package com.myapp.services;

        package com.myapp.services;

        import com.myapp.models.Person;

        public class GreetingService {
            public void greet(Person p) {
                System.out.println("Hello, " + p);
            }
        }
        """;
    }

    static String exampleMainClass() {
        return """
        // File: App.java
        // package com.myapp.main;

        package com.myapp.main;

        import com.myapp.models.Person;
        import com.myapp.services.GreetingService;

        public class App {
            public static void main(String[] args) {
                Person p = new Person("Alice", 25);
                GreetingService service = new GreetingService();
                p.showInfo();
                service.greet(p);
            }
        }
        """;
    }
}
