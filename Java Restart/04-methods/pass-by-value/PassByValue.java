public class PassByValue {

    /** 1. Example with primitive type **/
    public static void modifyPrimitive(int num) {
        System.out.println("Inside modifyPrimitive(), received num = " + num);
        num = 100; // change local copy
        System.out.println("Inside modifyPrimitive(), changed num = " + num);
    }

    /** A simple class for object example **/
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }

    /** 2. Example with object (modifying its fields) **/
    public static void modifyObjectField(Person p) {
        System.out.println("Inside modifyObjectField(), received Person name = " + p.name);
        p.name = "Changed Name"; // modifies same object
        System.out.println("Inside modifyObjectField(), changed Person name = " + p.name);
    }

    /** 3. Example with object (reassigning reference) **/
    public static void reassignObject(Person p) {
        System.out.println("Inside reassignObject(), received Person name = " + p.name);
        p = new Person("New Person"); // creates new object, only local reference changes
        System.out.println("Inside reassignObject(), reassigned Person name = " + p.name);
    }

    public static void main(String[] args) {
        System.out.println("=== Pass By Value Demo ===\n");

        /** 1. Primitive Example **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Primitive Type *");
        int x = 50;
        System.out.println("Before modifyPrimitive(), x = " + x);
        modifyPrimitive(x);
        System.out.println("After modifyPrimitive(), x = " + x); // unchanged
        System.out.println();

        /** 2. Object Example (field modification) **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Object Reference (modify field) *");
        Person p1 = new Person("Original Name");
        System.out.println("Before modifyObjectField(), Person name = " + p1.name);
        modifyObjectField(p1);
        System.out.println("After modifyObjectField(), Person name = " + p1.name); // changed
        System.out.println();

        /** 3. Object Example (reassign reference) **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Object Reference (reassign) *");
        Person p2 = new Person("Second Person");
        System.out.println("Before reassignObject(), Person name = " + p2.name);
        reassignObject(p2);
        System.out.println("After reassignObject(), Person name = " + p2.name); // unchanged
        System.out.println();
    }
}
