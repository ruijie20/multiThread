package Chapter1.Section10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Thread %s start at %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread %s finished at %s\n", Thread.currentThread().getId(), startDate);
    }
}
