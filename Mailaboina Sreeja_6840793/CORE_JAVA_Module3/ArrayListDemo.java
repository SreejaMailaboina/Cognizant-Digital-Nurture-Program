import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("How many student names do you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name " + i + ": ");
            String name = sc.nextLine();
            studentNames.add(name);
        }

        System.out.println("\nStudent Names:");

        for (String name : studentNames) {
            System.out.println(name);
        }

        sc.close();
    }
}