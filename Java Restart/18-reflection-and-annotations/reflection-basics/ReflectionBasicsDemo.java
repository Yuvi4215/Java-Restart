// Demonstrates Java Reflection API fundamentals

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * JAVA REFLECTION BASICS
 * ----------------------
 * Reflection allows a Java program to:
 *  - Inspect classes at runtime
 *  - Access fields, methods, constructors dynamically
 *  - Invoke methods without knowing them at compile time
 *
 * Used heavily in:
 *  - Spring Framework
 *  - Hibernate / JPA
 *  - Dependency Injection
 *  - ORM & Serialization
 */

class Employee {

    private int empId;
    private String name;

    public Employee() {
        this.empId = 0;
        this.name = "Unknown";
    }

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    private void calculateSalary() {
        System.out.println("Calculating salary for " + name);
    }

    public void showDetails() {
        System.out.println("Employee ID: " + empId + ", Name: " + name);
    }
}

public class ReflectionBasicsDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== Java Reflection Basics Demo ===\n");

        // ------------------------------------------------------------
        // 1. Getting Class Object (3 Ways)
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Getting Class Object *");

        Class<Employee> class1 = Employee.class;                     // Compile-time
        Class<?> class2 = Class.forName("Employee");                 // Runtime
        Employee empObj = new Employee();
        Class<?> class3 = empObj.getClass();                          // From object

        System.out.println("Class1 Name: " + class1.getName());
        System.out.println("Class2 Name: " + class2.getName());
        System.out.println("Class3 Name: " + class3.getName());


        // ------------------------------------------------------------
        // 2. Inspecting Constructors
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Constructors *");

        Constructor<?>[] constructors = class1.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }


        // ------------------------------------------------------------
        // 3. Inspecting Fields
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. Fields *");

        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType());
        }


        // ------------------------------------------------------------
        // 4. Inspecting Methods
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Methods *");

        Method[] methods = class1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


        // ------------------------------------------------------------
        // 5. Creating Object Dynamically
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Creating Object Dynamically *");

        Constructor<Employee> constructor =
                Employee.class.getConstructor(int.class, String.class);

        Employee emp = constructor.newInstance(101, "Rahul Sharma");
        emp.showDetails();


        // ------------------------------------------------------------
        // 6. Accessing Private Field
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 6. Accessing Private Field *");

        Field nameField = Employee.class.getDeclaredField("name");
        nameField.setAccessible(true); // bypass private access
        nameField.set(emp, "Amit Verma");

        emp.showDetails();


        // ------------------------------------------------------------
        // 7. Invoking Private Method
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 7. Invoking Private Method *");

        Method privateMethod =
                Employee.class.getDeclaredMethod("calculateSalary");
        privateMethod.setAccessible(true);
        privateMethod.invoke(emp);


        // ------------------------------------------------------------
        // 8. Real-world Note
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Real-world Usage *");
        System.out.println("""
        • Spring uses reflection for dependency injection (@Autowired)
        • Hibernate uses reflection for ORM mapping
        • Frameworks scan classes & annotations at runtime
        • Reflection enables loose coupling
        """);

        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Reflection inspects classes at runtime.");
        System.out.println("- Can access private members using setAccessible(true).");
        System.out.println("- Powerful but should be used carefully.");
        System.out.println("- Slower than direct code (runtime overhead).");
    }
}
