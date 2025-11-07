/**
 * BOUNDED TYPES IN GENERICS
 * --------------------------
 * Generics can restrict what types are allowed.
 *
 * ✅ 1. Upper Bounded (extends)
 *    <T extends Number>  -> Only Number or its subclasses (Integer, Double, etc.)
 *
 * ✅ 2. Lower Bounded (super)
 *    <? super Integer>   -> Any type that is Integer or its parent classes (Number, Object)
 *
 * ✅ 3. Multiple Bounds
 *    <T extends Number & Comparable<T>>
 *
 * ✅ Why use bounded types?
 * - To restrict accepted types
 * - To enable using certain methods (e.g., Number methods)
 * - Compile-time safety
 */

import java.util.*;

public class BoundedTypesDemo {

    /** =================================================
     *  1. Upper Bounded Type <T extends Number>
     *     Only numeric types allowed
     * ================================================= */
    static class SumUtil<T extends Number> {
        private List<T> numbers;

        SumUtil(List<T> numbers) {
            this.numbers = numbers;
        }

        double sum() {
            double result = 0;
            for (T n : numbers) {
                result += n.doubleValue();  // allowed because T extends Number
            }
            return result;
        }
    }

    /** =================================================
     *  2. Generic Method with Upper Bound
     * ================================================= */
    static <T extends Number> double max(T a, T b) {
        return (a.doubleValue() > b.doubleValue()) ? a.doubleValue() : b.doubleValue();
    }

    /** =================================================
     *  3. Lower Bounded Types (<? super Integer>)
     *     Accepts Integer, Number, Object
     * ================================================= */
    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        // list.add(10.5); ❌ Not allowed (Double not allowed)
    }

    /** =================================================
     *  4. Multiple Bounds (extends Class & Interface)
     * ================================================= */
    static class ComparableBox<T extends Number & Comparable<T>> {
        private T value;

        ComparableBox(T value) {
            this.value = value;
        }

        boolean isGreater(T other) {
            return value.compareTo(other) > 0;
        }
    }

    /** =================================================
     *  Main Method — Demo
     * ================================================= */
    public static void main(String[] args) {
        System.out.println("=== Java Generics: Bounded Types Demo ===\n");

        // ✅ 1. Using upper bounded generic class
        System.out.println("------------------------------------");
        System.out.println("* 1. Upper Bounded Type (extends Number) *");

        List<Integer> intList = Arrays.asList(10, 20, 30);
        SumUtil<Integer> sumInt = new SumUtil<>(intList);
        System.out.println("Sum of Integer list = " + sumInt.sum());

        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        SumUtil<Double> sumDouble = new SumUtil<>(doubleList);
        System.out.println("Sum of Double list = " + sumDouble.sum());


        // ✅ 2. Using upper bounded generic method
        System.out.println("\n------------------------------------");
        System.out.println("* 2. Generic Method with Bound *");
        System.out.println("Max of 5 and 7.5 = " + max(5, 7.5));


        // ✅ 3. Lower bounded example
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Lower Bounded Type (super Integer) *");

        List<Number> numList = new ArrayList<>();
        addNumbers(numList);
        System.out.println("Numbers added to List<Number>: " + numList);

        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
        System.out.println("Numbers added to List<Object>: " + objList);


        // ✅ 4. Multiple bounds
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Multiple Bounds (extends Number & Comparable) *");

        ComparableBox<Integer> box1 = new ComparableBox<>(20);
        System.out.println("20 > 10 ? " + box1.isGreater(10));

        ComparableBox<Double> box2 = new ComparableBox<>(5.5);
        System.out.println("5.5 > 7.7 ? " + box2.isGreater(7.7));

        System.out.println("\n------------------------------------");
        System.out.println("* 5. Key Takeaways *");
        System.out.println("- <T extends Number> restricts to numeric types.");
        System.out.println("- <? super Integer> allows Integer and its parents.");
        System.out.println("- Multiple bounds: class first, then interfaces.");
        System.out.println("- Bounded generics allow safer, more powerful code.");
    }
}
