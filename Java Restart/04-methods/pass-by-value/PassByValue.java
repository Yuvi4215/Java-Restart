public class PassByValue {

    /*-------------------------
       Helper Classes
    -------------------------*/

    // Mutable class
    static class Person {
        String name;
        Person(String name) { this.name = name; }
    }

    // Immutable class
    static class ImmutablePerson {
        private final String name;
        ImmutablePerson(String name) { this.name = name; }
        public String getName() { return name; }
    }

    /*-------------------------
       1. Primitive Example
    -------------------------*/
    public static void modifyPrimitive(int num) {
        System.out.println("Inside modifyPrimitive(): received = " + num);
        num = 999;
        System.out.println("Inside modifyPrimitive(): changed = " + num);
    }

    /*-------------------------
       2. String Example (Immutable)
    -------------------------*/
    public static void modifyString(String s) {
        System.out.println("Inside modifyString(): received = " + s);
        s = "Modified String";
        System.out.println("Inside modifyString(): changed = " + s);
    }

    /*-------------------------
       3. Wrapper Example (Integer)
    -------------------------*/
    public static void modifyWrapper(Integer n) {
        System.out.println("Inside modifyWrapper(): received = " + n);
        n = 5000;
        System.out.println("Inside modifyWrapper(): changed = " + n);
    }

    /*-------------------------
       4. Mutable Object: Modify Field
    -------------------------*/
    public static void modifyObjectField(Person p) {
        System.out.println("Inside modifyObjectField(): received name = " + p.name);
        p.name = "Updated Name";
        System.out.println("Inside modifyObjectField(): updated name = " + p.name);
    }

    /*-------------------------
       5. Mutable Object: Reassign Reference
    -------------------------*/
    public static void reassignObject(Person p) {
        System.out.println("Inside reassignObject(): received name = " + p.name);
        p = new Person("New Person Created Inside Method");
        System.out.println("Inside reassignObject(): reassigned name = " + p.name);
    }

    /*-------------------------
       6. Immutable Object Example
    -------------------------*/
    public static void modifyImmutableObject(ImmutablePerson p) {
        System.out.println("Inside modifyImmutableObject(): received name = " + p.getName());
        // p.name can't be changed → class is immutable
        p = new ImmutablePerson("Completely New Immutable");
        System.out.println("Inside modifyImmutableObject(): new object = " + p.getName());
    }

    /*-------------------------
       7. Array Example
    -------------------------*/
    public static void modifyArray(int[] arr) {
        System.out.println("Inside modifyArray(): arr[0] = " + arr[0]);
        arr[0] = 999;
        System.out.println("Inside modifyArray(): arr[0] changed to " + arr[0]);
    }

    public static void reassignArray(int[] arr) {
        System.out.println("Inside reassignArray(): received arr[0] = " + arr[0]);
        arr = new int[]{111, 222, 333};
        System.out.println("Inside reassignArray(): reassigned arr[0] = " + arr[0]);
    }

    /*-------------------------
       8. Collection Example
    -------------------------*/
    public static void modifyList(java.util.List<String> list) {
        System.out.println("Inside modifyList(): " + list);
        list.add("New Item Inside Method");
        System.out.println("Inside modifyList(): After add → " + list);
    }

    public static void reassignList(java.util.List<String> list) {
        System.out.println("Inside reassignList(): received = " + list);
        list = new java.util.ArrayList<>();
        list.add("Brand New List");
        System.out.println("Inside reassignList(): reassigned list = " + list);
    }


    /*-------------------------
       MAIN
    -------------------------*/
    public static void main(String[] args) {

        System.out.println("\n========= PASS BY VALUE DEMO (EXPANDED) =========\n");

        /* 1. Primitive */
        int x = 50;
        System.out.println("Before modifyPrimitive(): x = " + x);
        modifyPrimitive(x);
        System.out.println("After modifyPrimitive(): x = " + x + "\n");

        /* 2. String (Immutable) */
        String str = "Original";
        System.out.println("Before modifyString(): str = " + str);
        modifyString(str);
        System.out.println("After modifyString(): str = " + str + "\n");

        /* 3. Integer Wrapper */
        Integer numObj = 100;
        System.out.println("Before modifyWrapper(): numObj = " + numObj);
        modifyWrapper(numObj);
        System.out.println("After modifyWrapper(): numObj = " + numObj + "\n");

        /* 4. Mutable Object (Modify Field) */
        Person p1 = new Person("Initial");
        System.out.println("Before modifyObjectField(): name = " + p1.name);
        modifyObjectField(p1);
        System.out.println("After modifyObjectField(): name = " + p1.name + "\n");

        /* 5. Mutable Object (Reassign Reference) */
        Person p2 = new Person("Second Person");
        System.out.println("Before reassignObject(): name = " + p2.name);
        reassignObject(p2);
        System.out.println("After reassignObject(): name = " + p2.name + "\n");

        /* 6. Immutable Object */
        ImmutablePerson ip = new ImmutablePerson("Immutable Original");
        System.out.println("Before modifyImmutableObject(): name = " + ip.getName());
        modifyImmutableObject(ip);
        System.out.println("After modifyImmutableObject(): name = " + ip.getName() + "\n");

        /* 7. Array */
        int[] arr = {10, 20, 30};
        System.out.println("Before modifyArray(): arr[0] = " + arr[0]);
        modifyArray(arr);
        System.out.println("After modifyArray(): arr[0] = " + arr[0] + "\n");

        System.out.println("Before reassignArray(): arr[0] = " + arr[0]);
        reassignArray(arr);
        System.out.println("After reassignArray(): arr[0] = " + arr[0] + "\n");

        /* 8. Collection */
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("Item1");

        System.out.println("Before modifyList(): " + list);
        modifyList(list);
        System.out.println("After modifyList(): " + list + "\n");

        System.out.println("Before reassignList(): " + list);
        reassignList(list);
        System.out.println("After reassignList(): " + list + "\n");
    }
}
