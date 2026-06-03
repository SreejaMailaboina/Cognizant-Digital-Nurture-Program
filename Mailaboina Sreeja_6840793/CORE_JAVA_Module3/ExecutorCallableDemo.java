import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {

    public static void main(String[] args) {

        // Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Callable task that returns a result
        Callable<Integer> task1 = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) sum += i;
            return sum;
        };

        Callable<Integer> task2 = () -> {
            int product = 1;
            for (int i = 1; i <= 5; i++) product *= i;
            return product;
        };

        Callable<Integer> task3 = () -> {
            int squareSum = 0;
            for (int i = 1; i <= 5; i++) squareSum += (i * i);
            return squareSum;
        };

        try {
            // Submit tasks
            Future<Integer> f1 = executor.submit(task1);
            Future<Integer> f2 = executor.submit(task2);
            Future<Integer> f3 = executor.submit(task3);

            // Get results using Future.get()
            System.out.println("Sum (1-5): " + f1.get());
            System.out.println("Factorial (1-5): " + f2.get());
            System.out.println("Square Sum (1-5): " + f3.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown executor
            executor.shutdown();
        }
    }
}