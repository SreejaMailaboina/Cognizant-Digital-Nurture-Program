public class VirtualThreadsDemo {

    static Runnable task = () -> {
        int x = 1 + 1; // lightweight work (better than printing 100k lines)
    };

    public static void main(String[] args) throws Exception {

        int count = 100_000;

        // ================= VIRTUAL THREADS =================
        long startVirtual = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[count];

        for (int i = 0; i < count; i++) {
            virtualThreads[i] = Thread.startVirtualThread(task);
        }

        for (Thread t : virtualThreads) {
            t.join();
        }

        long endVirtual = System.currentTimeMillis();

        System.out.println("Virtual Threads Time: " + (endVirtual - startVirtual) + " ms");


        // ================= PLATFORM THREADS =================
        long startPlatform = System.currentTimeMillis();

        Thread[] platformThreads = new Thread[count];

        for (int i = 0; i < count; i++) {
            platformThreads[i] = new Thread(task);
            platformThreads[i].start();
        }

        for (Thread t : platformThreads) {
            t.join();
        }

        long endPlatform = System.currentTimeMillis();

        System.out.println("Platform Threads Time: " + (endPlatform - startPlatform) + " ms");
    }
}