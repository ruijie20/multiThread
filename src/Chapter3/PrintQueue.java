package Chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Semaphore semaphore;
    private final int permits;

    private boolean freePrinters[];

    private Lock lockPrinters;

    public PrintQueue() {
        permits = 3;
        semaphore = new Semaphore(permits);
        freePrinters = new boolean[permits];

        for (int i = 0; i < permits; i++) {
            freePrinters[i] = true;
        }

        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();

            int assignedPrinter = getPrinter();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: printqueue: printing a job in Printer%d during %d seconds\n",
                    Thread.currentThread().getName(), assignedPrinter, duration);

            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }

        return ret;
    }
}
