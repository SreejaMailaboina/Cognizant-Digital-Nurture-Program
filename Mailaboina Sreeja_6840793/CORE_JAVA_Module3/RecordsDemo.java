import java.util.List;
import java.util.stream.Collectors;

// Record Definition
record Person(String name, int age) {}

public class RecordsDemo {

    public static void main(String[] args) {

        // Creating Record Instances
        Person p1 = new Person("Sreeja", 21);
        Person p2 = new Person("Ramesh", 17);
        Person p3 = new Person("Priya", 25);

        // Printing Records
        System.out.println("Person Records:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Creating a List of Records
        List<Person> people = List.of(p1, p2, p3);

        // Filtering people with age >= 18
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nAdults (Age >= 18):");
        adults.forEach(System.out::println);
    }
}