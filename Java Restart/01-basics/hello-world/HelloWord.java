
public class HelloWord {

    // 1. Classic Hello World
    public static void main(String[] args) {
        System.out.println("Hello World - classic main method");

        // 2. Using another method
        helloFromMethod();

        // 3. Using anonymous inner class with Runnable
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World - from anonymous class Runnable");
            }
        };
        r.run();

        // 4. Using Lambda expression
        Runnable lambda = () -> System.out.println("Hello World - from lambda Runnable");
        lambda.run();

        // 5. Using String concatenation
        String part1 = "Hello";
        String part2 = " World - concatenated string";
        System.out.println(part1 + part2);

        // 6. Using printf
        System.out.printf("%s%n", "Hello World - using printf");

        // 7. Using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" World - from StringBuilder");
        System.out.println(sb);
    }

    // Separate method
    public static void helloFromMethod() {
        System.out.println("Hello World - from a separate method");
    }

    // 8. Static block (runs before main)
    static {
        System.out.println("Hello World - from static block");
    }
}
