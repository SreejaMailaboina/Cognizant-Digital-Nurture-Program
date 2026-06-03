class MyThread extends Thread {

    private String message;

    public MyThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class ThreadCreationDemo {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread("Thread 1 Running");
        MyThread thread2 = new MyThread("Thread 2 Running");

        thread1.start();
        thread2.start();

        System.out.println("Main Thread Finished");
    }
}