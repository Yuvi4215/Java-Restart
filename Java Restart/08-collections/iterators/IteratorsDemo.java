/**
 * ITERATORS IN JAVA
 * -----------------
 * The Iterator interface is used to traverse (iterate) over elements of a collection.
 *
 * ✅ Key Methods in Iterator:
 * - hasNext() → returns true if there are more elements
 * - next() → returns the next element
 * - remove() → removes the last element returned by next()
 *
 * ✅ ListIterator (used with List types like ArrayList, LinkedList)
 * - hasNext(), next()
 * - hasPrevious(), previous()
 * - add(), set() → modify during iteration
 *
 * ✅ Enhanced For Loop (for-each) is a simpler way to iterate,
 *   but does not allow removal or backward iteration.
 *
 * Topics Covered:
 * 1. Iterator with List
 * 2. Iterator with Set
 * 3. ListIterator (Forward & Backward)
 * 4. Removing Elements via Iterator
 * 5. Difference: Iterator vs ListIterator vs For-Each
 */

import java.util.*;

public class IteratorsDemo {

    /** ==========================================
     *  1. Iterator with List
     * ========================================== */
    static void iteratorWithList() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Iterator with List *");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        System.out.println("Original List: " + names);

        Iterator<String> it = names.iterator();
        System.out.print("Iterating using Iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  2. Iterator with Set
     * ========================================== */
    static void iteratorWithSet() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Iterator with Set *");

        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original Set: " + numbers);

        Iterator<Integer> it = numbers.iterator();
        System.out.print("Iterating using Iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  3. ListIterator (Forward & Backward)
     * ========================================== */
    static void listIteratorDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. ListIterator (Forward & Backward) *");

        List<String> cities = new ArrayList<>(Arrays.asList("London", "Paris", "New York", "Tokyo"));

        System.out.println("Original List: " + cities);

        ListIterator<String> listIt = cities.listIterator();

        System.out.print("Forward iteration: ");
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + " ");
        }
        System.out.println();

        System.out.print("Backward iteration: ");
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  4. Removing Elements via Iterator
     * ========================================== */
    static void removeWithIterator() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Removing Elements via Iterator *");

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Original List: " + nums);

        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (num % 2 == 0) {
                it.remove(); // Safe removal during iteration
            }
        }

        System.out.println("After removing even numbers: " + nums);
    }

    /** ==========================================
     *  5. Difference: Iterator vs ListIterator vs For-Each
     * ========================================== */
    static void differenceDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Difference: Iterator vs ListIterator vs For-Each *");

        List<String> animals = new ArrayList<>(Arrays.asList("Cat", "Dog", "Rabbit", "Horse"));

        // Using Iterator
        System.out.print("Iterator → ");
        Iterator<String> it = animals.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Using ListIterator (forwards + modify)
        System.out.print("ListIterator (forwards, modify) → ");
        ListIterator<String> listIt = animals.listIterator();
        while (listIt.hasNext()) {
            String a = listIt.next();
            if (a.equals("Dog")) listIt.set("Wolf");
        }
        System.out.println(animals);

        // Using Enhanced For Loop
        System.out.print("For-Each → ");
        for (String a : animals) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Iterators Demo ===\n");

        iteratorWithList();
        iteratorWithSet();
        listIteratorDemo();
        removeWithIterator();
        differenceDemo();

        System.out.println("\n------------------------------------");
        System.out.println("* 6. Key Takeaways *");
        System.out.println("- Iterator works with all Collection types.");
        System.out.println("- ListIterator works only with List types (can go backward).");
        System.out.println("- Enhanced For Loop is easiest but cannot remove elements.");
        System.out.println("- Always use Iterator.remove() for safe modification.");
    }
}
// Java example 

