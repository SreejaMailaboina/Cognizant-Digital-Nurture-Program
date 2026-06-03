import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Sreeja");
        names.add("Abhinaya");
        names.add("Priya");
        names.add("Meghana");
        names.add("Pandu");

        System.out.println("Original List:");
        System.out.println(names);

        // Sorting using Lambda Expression
        Collections.sort(names, (name1, name2) -> name1.compareTo(name2));

        System.out.println("\nSorted List:");
        System.out.println(names);
    }
}