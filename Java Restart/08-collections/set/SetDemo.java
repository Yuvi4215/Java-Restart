/**
 * SET INTERFACE IN JAVA
 * ----------------------
 * - Stores unique elements (no duplicates)
 * - Does NOT maintain index-based access
 *
 * ✅ Implementations:
 * - HashSet        → Fast, no order
 * - LinkedHashSet  → Maintains insertion order
 * - TreeSet        → Sorted, no duplicates
 *
 * ✅ When to use?
 * - When unique elements are required
 * - Fast search, add, remove
 *
 * Topics Covered:
 * 1. HashSet Basics
 * 2. LinkedHashSet (Ordered)
 * 3. TreeSet (Sorted)
 * 4. Set Operations (Union, Intersection, Difference)
 * 5. Iteration Methods
 * 6. Custom Objects in Set
 */

import java.util.*;

public class SetDemo {

    /** ==========================================
     *  1. HashSet Basics
     * ========================================== */
    static void hashSetDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. HashSet Basics *");

        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Banana"); // duplicate ignored

        System.out.println("HashSet (no order, unique values): " + set);

        System.out.println("Contains 'Apple'? " + set.contains("Apple"));

        set.remove("Mango");
        System.out.println("After removal: " + set);

        System.out.println("Size of set: " + set.size());
    }

    /** ==========================================
     *  2. LinkedHashSet (Maintains Insertion Order)
     * ========================================== */
    static void linkedHashSetDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. LinkedHashSet (Ordered) *");

        Set<Integer> linked = new LinkedHashSet<>();
        linked.add(30);
        linked.add(10);
        linked.add(20);
        linked.add(10);

        System.out.println("LinkedHashSet (insertion order): " + linked);
    }

    /** ==========================================
     *  3. TreeSet (Sorted, No Duplicates)
     * ========================================== */
    static void treeSetDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. TreeSet (Sorted) *");

        Set<Integer> sorted = new TreeSet<>();
        sorted.add(50);
        sorted.add(10);
        sorted.add(40);
        sorted.add(20);
        sorted.add(10);

        System.out.println("TreeSet (sorted, unique): " + sorted);
    }

    /** ==========================================
     *  4. Set Operations (Union, Intersection, Difference)
     * ========================================== */
    static void setOperations() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Set Operations *");

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        // UNION
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // INTERSECTION
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // DIFFERENCE (set1 - set2)
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
    }

    /** ==========================================
     *  5. Iteration Methods
     * ========================================== */
    static void iterationDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Iteration Methods *");

        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));

        // For-each loop
        System.out.print("For-each loop: ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Iterator
        System.out.print("Using Iterator: ");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  6. Custom Objects in Set
     * ========================================== */
    static void customObjectSet() {
        System.out.println("\n------------------------------------");
        System.out.println("* 6. Custom Objects in Set *");

        class Student {
            int id;
            String name;

            Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public String toString() {
                return "(" + id + ", " + name + ")";
            }

            // Needed to avoid duplicate objects with same data
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Student)) return false;
                Student s = (Student) o;
                return id == s.id && Objects.equals(name, s.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, name);
            }
        }

        Set<Student> students = new HashSet<>();
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(1, "Alice")); // duplicate based on equals()/hashCode()

        System.out.println("Students in set (unique by id & name): " + students);
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Set Interface Demo ===\n");

        hashSetDemo();
        linkedHashSetDemo();
        treeSetDemo();
        setOperations();
        iterationDemo();
        customObjectSet();

        System.out.println("\n------------------------------------");
        System.out.println("* 7. Key Takeaways *");
        System.out.println("- Set stores unique elements only.");
        System.out.println("- HashSet: Fastest, no ordering.");
        System.out.println("- LinkedHashSet: Maintains insertion order.");
        System.out.println("- TreeSet: Sorted and unique.");
        System.out.println("- equals() + hashCode() required for custom objects.");
        System.out.println("- Useful for removing duplicates, fast lookup, and mathematical set operations.");
    }
}
