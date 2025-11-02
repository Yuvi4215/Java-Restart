/**
 * LIST INTERFACE IN JAVA
 * -----------------------
 * - The List interface is part of java.util and extends the Collection interface.
 * - It represents an ordered collection (sequence) that can contain duplicate elements.
 *
 * ✅ Common Implementations:
 *    - ArrayList  → Fast random access, resizable array.
 *    - LinkedList → Doubly linked list, faster insert/remove.
 *    - Vector     → Legacy, synchronized version of ArrayList.
 *
 * ✅ Key Features:
 * 1. Maintains insertion order
 * 2. Allows duplicate elements
 * 3. Supports indexed access (get/set)
 *
 * Topics Covered:
 * 1. Creating Lists
 * 2. Adding and Accessing Elements
 * 3. Iterating through Lists
 * 4. Modifying and Removing Elements
 * 5. Sorting and SubLists
 * 6. Comparison of Implementations
 */

import java.util.*;

public class ListDemo {

    /** ==========================================
     *  1. Creating Lists
     * ========================================== */
    static void createLists() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Creating Lists *");

        // Using ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        // Using LinkedList
        List<String> linkedList = new LinkedList<>(arrayList);

        // Using Vector
        List<String> vectorList = new Vector<>(arrayList);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Vector: " + vectorList);
    }

    /** ==========================================
     *  2. Adding and Accessing Elements
     * ========================================== */
    static void addAndAccess() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Adding and Accessing Elements *");

        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(1, 15); // Insert at index 1

        System.out.println("List after additions: " + nums);
        System.out.println("Element at index 2: " + nums.get(2));
        System.out.println("Size of list: " + nums.size());
    }

    /** ==========================================
     *  3. Iterating through Lists
     * ========================================== */
    static void iterateLists() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Iterating through Lists *");

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Mango");

        // Using for loop
        System.out.print("Using for loop: ");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(fruits.get(i) + " ");
        }

        // Using enhanced for loop
        System.out.print("\nUsing for-each loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }

        // Using Iterator
        System.out.print("\nUsing Iterator: ");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Using ListIterator (forward and backward)
        System.out.print("\nUsing ListIterator backward: ");
        ListIterator<String> lit = fruits.listIterator(fruits.size());
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  4. Modifying and Removing Elements
     * ========================================== */
    static void modifyAndRemove() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Modifying and Removing Elements *");

        List<String> animals = new ArrayList<>(Arrays.asList("Dog", "Cat", "Horse", "Elephant"));
        System.out.println("Original List: " + animals);

        animals.set(2, "Tiger"); // Modify
        System.out.println("After modification: " + animals);

        animals.remove("Cat");   // Remove by object
        animals.remove(0);       // Remove by index
        System.out.println("After removals: " + animals);
    }

    /** ==========================================
     *  5. Sorting and SubLists
     * ========================================== */
    static void sortingAndSubList() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Sorting and SubLists *");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2));
        System.out.println("Original List: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);

        List<Integer> subList = numbers.subList(1, 4);
        System.out.println("SubList (index 1–3): " + subList);
    }

    /** ==========================================
     *  6. Comparison of Implementations
     * ========================================== */
    static void compareImplementations() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Comparison of Implementations *");

        List<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C"));
        List<String> vector = new Vector<>(Arrays.asList("A", "B", "C"));

        System.out.println("ArrayList class: " + arrayList.getClass().getName());
        System.out.println("LinkedList class: " + linkedList.getClass().getName());
        System.out.println("Vector class: " + vector.getClass().getName());

        System.out.println("\nPerformance Hints:");
        System.out.println("- ArrayList: Fast random access, slower insert/remove in middle.");
        System.out.println("- LinkedList: Slower random access, faster insert/remove in middle.");
        System.out.println("- Vector: Like ArrayList but synchronized (thread-safe).");
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java List Interface Demo ===\n");

        createLists();
        addAndAccess();
        iterateLists();
        modifyAndRemove();
        sortingAndSubList();
        compareImplementations();

        System.out.println("\n------------------------------------");
        System.out.println("* 7. Key Takeaways *");
        System.out.println("- List is ordered and allows duplicates.");
        System.out.println("- Supports index-based access and modifications.");
        System.out.println("- Common classes: ArrayList, LinkedList, Vector.");
        System.out.println("- Iteration can be done using for-loop, for-each, Iterator, ListIterator.");
        System.out.println("- Use Collections.sort() and Collections.reverse() for sorting utilities.");
    }
}
