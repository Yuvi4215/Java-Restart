import java.util.*;
import java.util.stream.*;

public class StreamsDemo {

    public static void main(String[] args) {

        System.out.println("=== Java 8 Stream API Demo ===\n");

        // ----------------------------------------------------
        // 1. Creating Streams
        // ----------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Creating Streams *");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Stream<Integer> stream1 = numbers.stream();          // From List
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);  // From values
        IntStream stream3 = Arrays.stream(new int[]{1, 2, 3}); // From array

        System.out.println("Stream created successfully.");


        // ----------------------------------------------------
        // 2. filter(), map(), forEach()
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. filter(), map(), forEach() *");

        numbers.stream()
               .filter(n -> n > 20)
               .map(n -> n * 2)
               .forEach(n -> System.out.println("Filtered & Mapped: " + n));


        // ----------------------------------------------------
        // 3. collect() -> List
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. collect() to List *");

        List<Integer> squared =
                numbers.stream()
                       .map(n -> n * n)
                       .collect(Collectors.toList());

        System.out.println("Squared List: " + squared);


        // ----------------------------------------------------
        // 4. sorted(), distinct(), limit(), skip()
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. sorted(), distinct(), limit(), skip() *");

        List<Integer> mix = Arrays.asList(5, 2, 2, 9, 1, 7, 7, 3);

        List<Integer> processed = mix.stream()
                                     .distinct()
                                     .sorted()
                                     .skip(1)
                                     .limit(4)
                                     .collect(Collectors.toList());

        System.out.println("Processed List: " + processed);


        // ----------------------------------------------------
        // 5. reduce() - Sum, Max, Min
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. reduce() Examples *");

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int max = numbers.stream().reduce(Integer::max).orElse(-1);
        int min = numbers.stream().reduce(Integer::min).orElse(-1);

        System.out.println("Sum = " + sum);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);


        // ----------------------------------------------------
        // 6. findFirst(), findAny(), anyMatch()
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. findFirst(), findAny(), anyMatch() *");

        System.out.println("First > 25: " +
                numbers.stream().filter(n -> n > 25).findFirst().orElse(null));

        System.out.println("Any even number? " +
                numbers.stream().anyMatch(n -> n % 2 == 0));


        // ----------------------------------------------------
        // 7. Streams on Strings
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 7. Stream with Strings *");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alex");

        List<String> startsWithA = names.stream()
                                        .filter(name -> name.startsWith("A"))
                                        .collect(Collectors.toList());

        System.out.println("Names starting with A: " + startsWithA);


        // ----------------------------------------------------
        // 8. Working with Map using Streams
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 8. Streams with Maps *");

        Map<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 72);
        studentMarks.put("Charlie", 90);

        List<String> passedStudents =
                studentMarks.entrySet().stream()
                            .filter(e -> e.getValue() >= 75)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());

        System.out.println("Students with passing marks: " + passedStudents);


        // ----------------------------------------------------
        // 9. FlatMap Example
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 9. flatMap() Example *");

        List<List<String>> courses = Arrays.asList(
                Arrays.asList("Java", "Python"),
                Arrays.asList("HTML", "CSS"),
                Arrays.asList("AWS", "Docker")
        );

        List<String> flatList = courses.stream()
                                       .flatMap(list -> list.stream())
                                       .collect(Collectors.toList());

        System.out.println("Flattened List: " + flatList);


        // ----------------------------------------------------
        // 10. Real-world Example: Processing Transactions
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 10. Real-world Example: Transaction Sum *");

        class Transaction {
            int amount;
            boolean isCredit;
            Transaction(int amount, boolean isCredit) { this.amount = amount; this.isCredit = isCredit; }
        }

        List<Transaction> txns = Arrays.asList(
                new Transaction(500, true),
                new Transaction(200, false),
                new Transaction(300, true)
        );

        int totalCredits = txns.stream()
                               .filter(t -> t.isCredit)
                               .map(t -> t.amount)
                               .reduce(0, Integer::sum);

        System.out.println("Total credits: " + totalCredits);


        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Stream API simplifies data processing.");
        System.out.println("- Intermediate operations: filter, map, sorted, distinct.");
        System.out.println("- Terminal operations: forEach, collect, reduce, count.");
        System.out.println("- Streams work on collections, arrays, maps, and custom objects.");
        System.out.println("- Streams are functional & do not modify original data.");
    }
}
