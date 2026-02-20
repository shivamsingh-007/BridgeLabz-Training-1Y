public class BackgroundJobExecution {

    public static void main(String[] args) throws InterruptedException {
        Runnable emailJob = () -> System.out.println("Sending email in background thread: " + Thread.currentThread().getName());

        Runnable reportJob = () -> {
            System.out.println("Generating report in background thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Report generation complete");
        };

        Runnable cleanupJob = () -> System.out.println("Running cleanup in background thread: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(emailJob);
        Thread thread2 = new Thread(reportJob);
        Thread thread3 = new Thread(cleanupJob);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("All background jobs completed");
    }
}
