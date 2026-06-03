public class TypeCastingExample {

    public static void main(String[] args) {

        // Double to Int (Narrowing)
        double doubleValue = 99.99;
        int intValue = (int) doubleValue;

        System.out.println("Original Double Value: " + doubleValue);
        System.out.println("Converted Int Value: " + intValue);

        // Int to Double (Widening)
        int number = 100;
        double convertedDouble = number;

        System.out.println("Original Int Value: " + number);
        System.out.println("Converted Double Value: " + convertedDouble);
    }
}