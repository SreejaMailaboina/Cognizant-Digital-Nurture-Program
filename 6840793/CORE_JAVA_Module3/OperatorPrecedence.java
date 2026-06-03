public class OperatorPrecedence {

    public static void main(String[] args) {

        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 20 / 2 + 3 * 4;
        int result4 = 50 - 10 + 5 * 2;

        System.out.println("Expression 1: 10 + 5 * 2 = " + result1);
        System.out.println("Expression 2: (10 + 5) * 2 = " + result2);
        System.out.println("Expression 3: 20 / 2 + 3 * 4 = " + result3);
        System.out.println("Expression 4: 50 - 10 + 5 * 2 = " + result4);

        System.out.println("\nOrder of Operations:");

        System.out.println("10 + 5 * 2");
        System.out.println("= 10 + 10");
        System.out.println("= 20");

        System.out.println("\n(10 + 5) * 2");
        System.out.println("= 15 * 2");
        System.out.println("= 30");
    }
}