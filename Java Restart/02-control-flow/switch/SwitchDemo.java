// Demos multiple variations of switch statement in Java

/**
 * A demo class to showcase all possible usages of switch statements in Java.
 * Covers:
 * 1. Classic switch with int
 * 2. Fall-through behavior
 * 3. Grouping multiple cases
 * 4. Switch with String
 * 5. Switch with Enum
 * 6. Nested switch
 * 7. Enhanced switch (Java 14+)
 * 8. Switch as an expression (Java 14+)
 * 9. Switch with null (Java 17+)
 */
public class SwitchDemo {

    // Example Enum
    enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

    public static void main(String[] args) {
        int number = 2;
        String fruit = "Apple";
        Day today = Day.SATURDAY;

        /** 1. Classic switch-case with break **/
        System.out.println("=== 1. Classic switch-case ===");
        switch (number) {
            case 1:
                System.out.println("Number is One");
                break;
            case 2:
                System.out.println("Number is Two");
                break;
            case 3:
                System.out.println("Number is Three");
                break;
            default:
                System.out.println("Number is something else");
        }

        /** 2. Switch without break (fall-through) **/
        System.out.println("\n=== 2. Fall-through behavior ===");
        switch (number) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
            default:
                System.out.println("Default executed");
        }

        /** 3. Grouping multiple cases **/
        System.out.println("\n=== 3. Grouping cases ===");
        switch (number) {
            case 1, 2, 3: // Java 12+ allows comma separated cases
                System.out.println("Number is between 1 and 3");
                break;
            default:
                System.out.println("Number is outside 1-3 range");
        }

        /** 4. Switch with String **/
        System.out.println("\n=== 4. Switch with String ===");
        switch (fruit) {
            case "Apple":
                System.out.println("Fruit is Apple");
                break;
            case "Banana":
                System.out.println("Fruit is Banana");
                break;
            default:
                System.out.println("Unknown fruit");
        }

        /** 5. Switch with Enum **/
        System.out.println("\n=== 5. Switch with Enum ===");
        switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                System.out.println("It's a weekday");
                break;
            case SATURDAY, SUNDAY:
                System.out.println("It's the weekend!");
                break;
        }

        /** 6. Nested switch **/
        System.out.println("\n=== 6. Nested switch ===");
        int outer = 1, inner = 2;
        switch (outer) {
            case 1:
                System.out.println("Outer = 1");
                switch (inner) {
                    case 1 -> System.out.println("Inner = 1");
                    case 2 -> System.out.println("Inner = 2");
                }
                break;
            default:
                System.out.println("Outer is not 1");
        }

        /** 7. Enhanced switch (Java 14+) **/
        System.out.println("\n=== 7. Enhanced switch (arrow syntax), (Java 14+) ===");
        switch (fruit) {
            case "Apple" -> System.out.println("Enhanced: Apple");
            case "Banana" -> System.out.println("Enhanced: Banana");
            default -> System.out.println("Enhanced: Unknown fruit");
        }

        /** 8. Switch as an expression (Java 14+) **/
        System.out.println("\n=== 8. Switch as an expression ===");
        String result = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> {
                // 'yield' required when using block body
                yield "Other number";
            }
        };
        System.out.println("Result of switch expression: " + result);

        /** 9. Switch with null (Java 17+) **/
        System.out.println("\n=== 9. Switch with null (Java 17+) ===");
        String name = null;
        try {
            switch (name) {
                case null -> System.out.println("Name is null");
                case "Alice" -> System.out.println("Name is Alice");
                default -> System.out.println("Some other name");
            }
        } catch (NullPointerException e) {
            System.out.println("Older Java versions throw NullPointerException for null in switch");
        }
    }
}
