package Chapter3;

import java.util.concurrent.Semaphore;

public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(2);
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: printqueue: printing a job during %d seconds\n",
                    Thread.currentThread().getName(), duration);
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
