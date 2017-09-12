package Section11;

import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable{
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    private void doTask() throws InterruptedException {
        int time = (int)Math.rint(Math.random() * 30);
        System.out.printf("Thread %s: %d \n", Thread.currentThread().getName(), time);
        TimeUnit.SECONDS.sleep(time);

    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        System.out.printf("Thread %s start\n", name);

        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s interrupted\n", name);
        }

        System.out.printf("Thread %s end\n", name);
    }
}
