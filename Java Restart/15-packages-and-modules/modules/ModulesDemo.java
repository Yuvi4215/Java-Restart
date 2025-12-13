/**
 * JAVA MODULE SYSTEM (JPMS) – Java 9+
 * -----------------------------------
 * A module is a higher-level grouping than packages.
 *
 * Why Modules?
 *  - Strong encapsulation
 *  - Explicit dependencies
 *  - Better maintainability
 *  - Reliable configuration
 *
 * Key File:
 *  - module-info.java
 *
 * This file explains modules using simulated examples
 * because real modules require multiple files and folders.
 */

public class ModulesDemo {

    public static void main(String[] args) {

        System.out.println("=== Java Module System (JPMS) Demo ===\n");

        System.out.println("----------------------------------------");
        System.out.println("* 1. What is a Module? *");
        System.out.println("""
        A module is a named collection of packages.
        It explicitly declares:
          - What it exports (public APIs)
          - What it requires (dependencies)
        """);

        System.out.println("----------------------------------------");
        System.out.println("* 2. Basic Module Structure *");
        System.out.println(moduleStructure());

        System.out.println("----------------------------------------");
        System.out.println("* 3. module-info.java Syntax *");
        System.out.println(moduleInfoExample());

        System.out.println("----------------------------------------");
        System.out.println("* 4. requires vs exports *");
        System.out.println(requiresExportsExample());

        System.out.println("----------------------------------------");
        System.out.println("* 5. Using Services (uses / provides) *");
        System.out.println(serviceModuleExample());

        System.out.println("----------------------------------------");
        System.out.println("* 6. Benefits of Modules *");
        System.out.println("""
        ✔ Strong encapsulation (packages are hidden by default)
        ✔ Clear dependency graph
        ✔ Improved security
        ✔ Better performance at startup
        ✔ Ideal for large enterprise applications
        """);

        System.out.println("----------------------------------------");
        System.out.println("* Important Note *");
        System.out.println("""
        • Only ONE module per module-info.java
        • Modules cannot be demonstrated fully in a single .java file
        • This file is a learning reference for GitHub and revision
        """);
    }

    // ---------------- Simulated Examples ---------------- //

    static String moduleStructure() {
        return """
        Example Project Structure:

        myapp.core/
          ├─ module-info.java
          └─ com/myapp/core/App.java

        myapp.service/
          ├─ module-info.java
          └─ com/myapp/service/UserService.java
        """;
    }

    static String moduleInfoExample() {
        return """
        // module-info.java (Basic)

        module myapp.core {
            exports com.myapp.core;
        }
        """;
    }

    static String requiresExportsExample() {
        return """
        // module-info.java with dependency

        module myapp.app {
            requires myapp.core;
            exports com.myapp.app;
        }

        Meaning:
        - requires → depends on another module
        - exports  → makes packages accessible to other modules
        """;
    }

    static String serviceModuleExample() {
        return """
        // Service Provider Example

        module myapp.payment {
            exports com.myapp.payment.api;
            provides com.myapp.payment.api.PaymentService
                with com.myapp.payment.impl.UPIPayment;
        }

        module myapp.checkout {
            requires myapp.payment;
            uses com.myapp.payment.api.PaymentService;
        }
        """;
    }
}
