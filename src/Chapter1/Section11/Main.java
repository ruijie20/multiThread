package Chapter1.Section11;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadGroup searcher = new ThreadGroup("searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(searcher, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of threads: %d\n", searcher.activeCount());
        System.out.println("Info about threads");
        searcher.list();

        Thread[] threads = new Thread[searcher.activeCount()];
        searcher.enumerate(threads);

        for (int i = 0; i < searcher.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        waitFinished(searcher);

        searcher.interrupt();

        System.out.println("main thread end");

    }

    private static void waitFinished(ThreadGroup threadGroup){
        while(threadGroup.activeCount() > 8){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
