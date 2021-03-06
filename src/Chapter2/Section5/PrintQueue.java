package Chapter2.Section5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Lock queueLock = new ReentrantLock(false);

    public void printJob(Object document){
        printADocument();
        printADocument();
    }

    private void printADocument() {
        queueLock.lock();

        try {
            Long duration = (long)(Math.random() * 10000);
            System.out.printf("%s : PrintQueue: printing a job during %d seconds\n",
                    Thread.currentThread().getName(), duration/1000);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
