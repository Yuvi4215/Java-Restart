/**
 * GENERIC CLASSES IN JAVA
 * ------------------------
 * ✅ A generic class allows defining a class with type parameters.
 * Example: class Box<T>
 *
 * ✅ Benefits:
 * - Compile-time type safety
 * - Code reusability
 * - No need for casting
 *
 * Topics Covered:
 * 1. Simple Generic Class (Box<T>)
 * 2. Multiple Type Parameters (Pair<K, V>)
 * 3. Generic Methods inside Generic Classes
 * 4. Using Wrapper Types in Generic Class
 */

import java.util.*;

public class GenericClassesDemo {

    /** ==========================================
     *  1. Simple Generic Class
     *     Box<T> can store any type
     * ========================================== */
    static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Box{" + "value=" + value + '}';
        }
    }

    /** ==========================================
     *  2. Generic Class with Multiple Type Parameters
     *     Pair<K, V> (Key, Value)
     * ========================================== */
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }

        @Override
        public String toString() {
            return "Pair{" + key + " = " + value + '}';
        }
    }

    /** ==========================================
     *  3. Generic Method inside Generic Class
     * ========================================== */
    static class Printer<T> {
        public void print(T item) {
            System.out.println("Printing item: " + item);
        }

        // Generic method with its own type <E>
        public <E> void printTwo(E item1, E item2) {
            System.out.println("Two items: " + item1 + ", " + item2);
        }
    }

    /** ==========================================
     *  4. Real Example: Storage<T> using List<T>
     * ========================================== */
    static class Storage<T> {
        private List<T> list = new ArrayList<>();

        void add(T item) {
            list.add(item);
        }

        T get(int index) {
            return list.get(index);
        }

        @Override
        public String toString() {
            return "Storage" + list;
        }
    }

    /** ==========================================
     *  Main Method — Demo
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Generic Classes Demo ===\n");

        // ✅ 1. Using Box<T> with different types
        System.out.println("------------------------------------");
        System.out.println("* 1. Simple Generic Class (Box<T>) *");

        Box<Integer> intBox = new Box<>(100);
        Box<String> strBox = new Box<>("Hello Generics");

        System.out.println(intBox);
        System.out.println(strBox);

        intBox.setValue(200);
        System.out.println("Updated intBox: " + intBox.getValue());

        // ✅ 2. Using Pair<K, V>
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Generic Class with Multiple Types (Pair<K,V>) *");

        Pair<String, Integer> personAge = new Pair<>("Alice", 25);
        Pair<Integer, String> codeName = new Pair<>(101, "Project-X");

        System.out.println(personAge);
        System.out.println(codeName);

        // ✅ 3. Generic method inside generic class
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Generic Methods Inside Class *");

        Printer<String> printer = new Printer<>();
        printer.print("Hello World");
        printer.printTwo("A", "B");
        printer.printTwo(10, 20); // works for any type

        // ✅ 4. Storage<T> example
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Using Generic Storage Class *");

        Storage<Double> doubleStorage = new Storage<>();
        doubleStorage.add(3.14);
        doubleStorage.add(9.81);
        System.out.println("Storage: " + doubleStorage);
        System.out.println("First element: " + doubleStorage.get(0));

        Storage<String> stringStorage = new Storage<>();
        stringStorage.add("Java");
        stringStorage.add("Generics");
        System.out.println("Storage: " + stringStorage);

        System.out.println("\n------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Generic classes make reusable, type-safe code.");
        System.out.println("- <T> for single type, <K, V> for multiple types.");
        System.out.println("- No casting required when retrieving values.");
        System.out.println("- Generic methods allow flexibility inside classes.");
    }
}
