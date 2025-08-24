import java.io.PrintWriter;


public class PrintStatementsDemo {
    public static void main(String[] args) {
        // 1. System.out.println
        System.out.println("Hello World - println adds a new line automatically");

        // 2. System.out.print
        System.out.print("Hello ");
        System.out.print("World - print does NOT add a new line");
        System.out.println(); // add newline manually

        // 3. System.out.printf (formatted printing)
        System.out.printf("Hello %s, the number is %d%n", "World", 42);

        // 4. String.format (build string first, then print)
        String formatted = String.format("Hello %s - built using String.format", "World");
        System.out.println(formatted);

        // 5. Using PrintWriter (more flexible printing)
        PrintWriter writer = new PrintWriter(System.out, true);
        writer.println("Hello World - from PrintWriter");

        // 6. Printing characters individually
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
     
      
        for (char c : chars) {
            System.out.print(c);
        }
         System.out.println(" - printed char by char using loop");
     
 

        // 7. Using StringBuilder to prepare message before printing
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" World - built with StringBuilder");
        System.out.println(sb.toString());


        // 8. Printing escape sequences
        System.out.println("'Hello\nWorld - with newline'");
        System.out.println("Hello\tWorld - with tab");
        System.out.println("\"Hello World\" - with quotes");
    }
}
