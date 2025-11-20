import java.util.Optional;

/**
 * OPTIONAL IN JAVA 8
 * -------------------
 * Optional<T> is a container object used to handle null values safely.
 *
 * Why Optional?
 *  - Avoids NullPointerException (NPE)
 *  - Forces developer to handle missing values
 *
 * Methods Covered:
 *  - Optional.empty()
 *  - Optional.of(value)
 *  - Optional.ofNullable(value)
 *  - isPresent(), ifPresent()
 *  - orElse(), orElseGet(), orElseThrow()
 *  - map(), flatMap()
 */

public class OptionalDemo {

    /** Example model class **/
    static class User {
        private String email;

        public User(String email) {
            this.email = email;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }

    /** ================================
     *  1. Creating Optional Objects
     * ================================ */
    static void creationDemo() {
        System.out.println("----------------------------------------");
        System.out.println("* 1. Creating Optional Objects *");

        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nonNullOpt = Optional.of("Hello Optional");
        Optional<String> nullableOpt = Optional.ofNullable(null);

        System.out.println("emptyOpt: " + emptyOpt);
        System.out.println("nonNullOpt: " + nonNullOpt);
        System.out.println("nullableOpt: " + nullableOpt);
    }

    /** ================================
     *  2. Checking & Retrieving Values
     * ================================ */
    static void retrievalDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Checking and Retrieving Values *");

        Optional<String> opt = Optional.ofNullable("Java 8");

        System.out.println("isPresent(): " + opt.isPresent());

        opt.ifPresent(value ->
            System.out.println("ifPresent(): " + value)
        );

        System.out.println("orElse(): " + opt.orElse("Default Value"));
    }

    /** ================================
     *  3. orElse vs orElseGet vs orElseThrow
     * ================================ */
    static void fallbackDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. orElse vs orElseGet vs orElseThrow *");

        Optional<String> emptyOpt = Optional.empty();

        System.out.println("orElse(): " + emptyOpt.orElse("Fallback Value"));

        System.out.println("orElseGet(): " +
                emptyOpt.orElseGet(() -> "Generated Value"));

        try {
            emptyOpt.orElseThrow(() -> new RuntimeException("Value missing!"));
        } catch (Exception e) {
            System.out.println("orElseThrow(): " + e.getMessage());
        }
    }

    /** ================================
     *  4. Using map() and flatMap()
     * ================================ */
    static void mapDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. map() and flatMap() *");

        Optional<String> opt = Optional.of("java");

        Optional<String> upper = opt.map(String::toUpperCase);
        System.out.println("map(): " + upper);

        Optional<Integer> length = opt.map(String::length);
        System.out.println("String length using map(): " + length);

        // flatMap example with nested Optional
        User user = new User("myemail@example.com");

        Optional<String> email = Optional.of(user)
                                         .flatMap(User::getEmail);
        System.out.println("flatMap(): " + email);
    }

    /** ================================
     *  5. Real-world Example: Safe Email Lookup
     * ================================ */
    static void realWorldDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Real-world Example: Safe Email Lookup *");

        User user1 = new User("contact@example.com");
        User user2 = new User(null); // Missing email

        // Safe access without NPE
        String email1 = user1.getEmail().orElse("No Email");
        String email2 = user2.getEmail().orElse("Email Not Provided");

        System.out.println("User1 email: " + email1);
        System.out.println("User2 email: " + email2);
    }

    /** ================================
     *  Main Method
     * ================================ */
    public static void main(String[] args) {

        System.out.println("=== Java 8 Optional Demo ===\n");

        creationDemo();
        retrievalDemo();
        fallbackDemo();
        mapDemo();
        realWorldDemo();

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Optional helps prevent NullPointerException.");
        System.out.println("- Use of() for non-null, ofNullable() when unsure.");
        System.out.println("- isPresent(), ifPresent() help check values safely.");
        System.out.println("- orElse(), orElseGet(), orElseThrow() give fallback options.");
        System.out.println("- map() & flatMap() help transform Optional values cleanly.");
    }
}
