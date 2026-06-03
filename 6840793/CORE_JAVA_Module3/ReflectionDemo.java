import java.lang.reflect.Method;

class Student {

    public void display() {
        System.out.println("Hello from Student class!");
    }

    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            // Load class dynamically
            Class<?> cls = Class.forName("Student");

            System.out.println("Class Name: " + cls.getName());

            System.out.println("\nMethods:");

            // Get all declared methods
            Method[] methods = cls.getDeclaredMethods();

            for (Method method : methods) {

                System.out.print("Method Name: "
                        + method.getName());

                Class<?>[] params =
                        method.getParameterTypes();

                System.out.print(" | Parameters: ");

                if (params.length == 0) {
                    System.out.print("None");
                } else {
                    for (Class<?> param : params) {
                        System.out.print(
                                param.getSimpleName() + " ");
                    }
                }

                System.out.println();
            }

            // Create object dynamically
            Object obj =
                    cls.getDeclaredConstructor()
                            .newInstance();

            // Invoke display() method
            Method displayMethod =
                    cls.getMethod("display");

            System.out.println(
                    "\nInvoking display() method:"
            );

            displayMethod.invoke(obj);

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}