/**
 * MAP INTERFACE IN JAVA
 * ----------------------
 * - A Map stores data as key-value pairs (Key → Value).
 * - Keys must be unique; values can be duplicated.
 *
 * ✅ Common Implementations:
 * - HashMap: Fast, unordered, allows null keys/values.
 * - LinkedHashMap: Maintains insertion order.
 * - TreeMap: Sorted by key (natural order or custom comparator).
 *
 * ✅ Key Methods:
 * - put(key, value)
 * - get(key)
 * - remove(key)
 * - containsKey(key), containsValue(value)
 * - keySet(), values(), entrySet()
 *
 * Topics Covered:
 * 1. Creating Maps
 * 2. Adding, Accessing, and Removing Elements
 * 3. Iterating through Maps
 * 4. Sorting with TreeMap
 * 5. LinkedHashMap and Order
 * 6. Nested Maps
 * 7. Key Takeaways
 */

import java.util.*;

public class MapDemo {

    /** ==========================================
     *  1. Creating Maps
     * ========================================== */
    static void createMaps() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Creating Maps *");

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(101, "Alice");
        hashMap.put(102, "Bob");
        hashMap.put(103, "Charlie");

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(hashMap);
        Map<Integer, String> treeMap = new TreeMap<>(hashMap);

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap (ordered): " + linkedHashMap);
        System.out.println("TreeMap (sorted): " + treeMap);
    }

    /** ==========================================
     *  2. Adding, Accessing, and Removing Elements
     * ========================================== */
    static void crudOperations() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Adding, Accessing, and Removing Elements *");

        Map<String, Integer> scores = new HashMap<>();

        // Add entries
        scores.put("Java", 90);
        scores.put("Python", 85);
        scores.put("C++", 75);

        System.out.println("Original Map: " + scores);

        // Access elements
        System.out.println("Score in Java: " + scores.get("Java"));
        System.out.println("Contains key 'Python'? " + scores.containsKey("Python"));
        System.out.println("Contains value 100? " + scores.containsValue(100));

        // Update value
        scores.put("Python", 88);
        System.out.println("Updated Python score: " + scores.get("Python"));

        // Remove element
        scores.remove("C++");
        System.out.println("After removing 'C++': " + scores);

        // Default values
        System.out.println("Score for Go (default): " + scores.getOrDefault("Go", 0));
    }

    /** ==========================================
     *  3. Iterating through Maps
     * ========================================== */
    static void iterationDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Iterating through Maps *");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        // Using keySet()
        System.out.print("Iterating keys: ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Using values()
        System.out.print("Iterating values: ");
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Using entrySet()
        System.out.println("Iterating key-value pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // Using forEach (Java 8+)
        System.out.println("Using forEach (lambda):");
        map.forEach((k, v) -> System.out.println(k + " → " + v));
    }

    /** ==========================================
     *  4. Sorting with TreeMap
     * ========================================== */
    static void treeMapDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Sorting with TreeMap *");

        Map<String, Integer> unsorted = new HashMap<>();
        unsorted.put("Banana", 2);
        unsorted.put("Apple", 5);
        unsorted.put("Mango", 3);

        System.out.println("Unsorted Map: " + unsorted);

        // TreeMap sorts by keys (alphabetically by default)
        Map<String, Integer> sorted = new TreeMap<>(unsorted);
        System.out.println("Sorted by key: " + sorted);

        // Custom comparator (reverse order)
        Map<String, Integer> reverseSorted = new TreeMap<>(Comparator.reverseOrder());
        reverseSorted.putAll(unsorted);
        System.out.println("Sorted in reverse order: " + reverseSorted);
    }

    /** ==========================================
     *  5. LinkedHashMap - Maintains Insertion Order
     * ========================================== */
    static void linkedHashMapDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. LinkedHashMap - Insertion Order *");

        Map<Integer, String> linked = new LinkedHashMap<>();
        linked.put(3, "Three");
        linked.put(1, "One");
        linked.put(2, "Two");

        System.out.println("Insertion Order Maintained: " + linked);
    }

    /** ==========================================
     *  6. Nested Maps
     * ========================================== */
    static void nestedMapDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Nested Maps *");

        Map<String, Map<String, Integer>> studentGrades = new HashMap<>();

        Map<String, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put("Math", 85);
        aliceGrades.put("Science", 90);

        Map<String, Integer> bobGrades = new HashMap<>();
        bobGrades.put("Math", 78);
        bobGrades.put("Science", 88);

        studentGrades.put("Alice", aliceGrades);
        studentGrades.put("Bob", bobGrades);

        System.out.println("Student Grades: " + studentGrades);

        // Access nested values
        System.out.println("Alice's Science grade: " + studentGrades.get("Alice").get("Science"));
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Map Interface Demo ===\n");

        createMaps();
        crudOperations();
        iterationDemo();
        treeMapDemo();
        linkedHashMapDemo();
        nestedMapDemo();

        System.out.println("\n------------------------------------");
        System.out.println("* 7. Key Takeaways *");
        System.out.println("- Map stores key-value pairs (unique keys).");
        System.out.println("- HashMap: unordered, fastest.");
        System.out.println("- LinkedHashMap: maintains insertion order.");
        System.out.println("- TreeMap: sorted by key (natural or custom order).");
        System.out.println("- Use entrySet() or forEach for easy traversal.");
        System.out.println("- Nested Maps are useful for representing structured data (e.g., student → subject → marks).");
    }
}
