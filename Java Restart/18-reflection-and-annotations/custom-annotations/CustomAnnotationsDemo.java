// Demonstrates custom annotations and reflection in Java

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * CUSTOM ANNOTATIONS IN JAVA
 * ---------------------------
 * An annotation is metadata added to Java code.
 * It does NOT change program logic directly.
 *
 * Used heavily in:
 *  - Spring Framework
 *  - Hibernate / JPA
 *  - REST APIs
 *  - Validation & Security
 *
 * Steps to create & use custom annotations:
 * 1. Define annotation
 * 2. Apply annotation
 * 3. Read annotation using Reflection
 */

/* ============================================================
 * 1. Defining a Custom Annotation
 * ============================================================ */

// @Retention defines how long annotation is available
@Retention(RetentionPolicy.RUNTIME)

// @Target defines where annotation can be applied
@Target(ElementType.METHOD)

// Custom annotation definition
@interface AuditLog {
    String action();                 // mandatory element
    String role() default "USER";    // optional element
}

/* ============================================================
 * 2. Applying Custom Annotation
 * ============================================================ */
class BankService {

    @AuditLog(action = "OPEN_ACCOUNT", role = "ADMIN")
    public void openAccount() {
        System.out.println("Opening bank account...");
    }

    @AuditLog(action = "TRANSFER_MONEY")
    public void transferMoney() {
        System.out.println("Transferring money...");
    }

    public void checkBalance() {
        System.out.println("Checking balance...");
    }
}

/* ============================================================
 * 3. Reading Annotation using Reflection
 * ============================================================ */
public class CustomAnnotationsDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== Custom Annotations & Reflection Demo ===\n");

        BankService service = new BankService();

        // Get all methods of BankService
        Method[] methods = service.getClass().getDeclaredMethods();

        for (Method method : methods) {

            // Check if method has @AuditLog annotation
            if (method.isAnnotationPresent(AuditLog.class)) {

                AuditLog audit = method.getAnnotation(AuditLog.class);

                System.out.println("----------------------------------------");
                System.out.println("Method Name : " + method.getName());
                System.out.println("Action      : " + audit.action());
                System.out.println("Role        : " + audit.role());

                // Invoke method
                method.invoke(service);
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Annotations provide metadata, not logic.");
        System.out.println("- Custom annotations are created using @interface.");
        System.out.println("- RetentionPolicy.RUNTIME is required for reflection.");
        System.out.println("- Reflection reads annotation data at runtime.");
        System.out.println("- Used extensively in Spring & enterprise frameworks.");
    }
}
