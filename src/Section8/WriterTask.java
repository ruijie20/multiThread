package Section8;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable{
    private ArrayBlockingQueue<Event> deque;

    public WriterTask(ArrayBlockingQueue<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            System.out.printf("add %d event: %s\n", i, Thread.currentThread().getId());

            deque.add(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
