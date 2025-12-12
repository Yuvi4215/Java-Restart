/**
 * IMPORTING PACKAGES IN JAVA
 * ---------------------------
 * Java imports allow us to access classes from other packages.
 *
 * Types of imports:
 *  - Single import: import com.example.Test;
 *  - Wildcard import: import com.example.*;
 *  - Static import: import static java.lang.Math.*;
 *
 * Automatically imported package:
 *  - java.lang (String, Math, System, Thread, Exception...)
 *
 * This file demonstrates imports using simulated package examples
 * while keeping everything inside a single runnable .java file for GitHub.
 */

public class ImportingPackagesDemo {

    public static void main(String[] args) {

        System.out.println("=== Java Import Statements Demo ===\n");

        System.out.println("This file shows how imports work in Java using simulated package examples.\n");

        System.out.println("----------------------------------------");
        System.out.println("* 1. Single-Class Import Example *");
        System.out.println(exampleSingleImport());

        System.out.println("----------------------------------------");
        System.out.println("* 2. Wildcard Import Example *");
        System.out.println(exampleWildcardImport());

        System.out.println("----------------------------------------");
        System.out.println("* 3. Static Import Example *");
        System.out.println(exampleStaticImport());

        System.out.println("----------------------------------------");
        System.out.println("* 4. Fully Qualified Class Name (FQCN) *");
        System.out.println(exampleFQCN());

        System.out.println("----------------------------------------");
        System.out.println("* 5. Auto-imported java.lang package *");
        System.out.println(exampleAutoImport());

        System.out.println("----------------------------------------");
        System.out.println("* Note *");
        System.out.println("Only ONE package declaration allowed in a real Java file.");
        System.out.println("This file is a teaching/demo reference and shows multiple package snippets.");
    }

    // ---------------- Simulated Package Example Snippets ---------------- //

    static String exampleSingleImport() {
        return """
        // Folder: com/myapp/models/Person.java

        package com.myapp.models;

        public class Person {
            private String name;
            public Person(String name) { this.name = name; }
            public void greet() { System.out.println("Hello " + name); }
        }

        ------------------------------------

        // Another file:
        // Folder: com/myapp/main/App.java

        package com.myapp.main;

        import com.myapp.models.Person;   // <--- Single import

        public class App {
            public static void main(String[] args) {
                Person p = new Person("Alice");
                p.greet();
            }
        }
        """;
    }

    static String exampleWildcardImport() {
        return """
        // Using wildcard import:
        // import com.myapp.services.*;

        package com.myapp.services;

        public class LoginService {
            public void login() { System.out.println("Login Successful!"); }
        }

        public class LogoutService {
            public void logout() { System.out.println("Logout Successful!"); }
        }

        ------------------------------------

        package com.myapp.main;

        import com.myapp.services.*;   // <--- Wildcard import (imports all classes)

        public class App {
            public static void main(String[] args) {
                LoginService login = new LoginService();
                LogoutService logout = new LogoutService();
                login.login();
                logout.logout();
            }
        }
        """;
    }

    static String exampleStaticImport() {
        return """
        // Static import example:

        import static java.lang.Math.*;  
        // Now we can call sin(), cos(), pow() WITHOUT Math prefix

        public class Calculator {
            public static void main(String[] args) {
                System.out.println(pow(2, 3));   // instead of Math.pow()
                System.out.println(sqrt(25));    // instead of Math.sqrt()
            }
        }
        """;
    }

    static String exampleFQCN() {
        return """
        // Using a class WITHOUT import (FQCN)
        public class Demo {
            public static void main(String[] args) {
                com.myapp.models.Person p =
                    new com.myapp.models.Person("Bob"); // Fully Qualified Class Name
                p.greet();
            }
        }
        """;
    }

    static String exampleAutoImport() {
        return """
        // java.lang package is automatically imported!

        public class AutoImportDemo {
            public static void main(String[] args) {
                String text = "Hello"; // String comes from java.lang automatically
                System.out.println(text);

                System.out.println(Math.sqrt(16)); // Math is also auto-imported
            }
        }
        """;
    }
}
