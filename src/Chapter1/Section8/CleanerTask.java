package Chapter1.Section8;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CleanerTask extends Thread {
    private ArrayBlockingQueue<Event> deque;

    public CleanerTask(ArrayBlockingQueue<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            clean();
        }
    }

    private void clean(){
        Date date = new Date();
        boolean delete;
        if(deque.size() == 0){
            return;
        }

        delete = false;

        while (getDifference(date) > 10000){
            System.out.printf("Cleaner: %s\n", deque.poll().getEvent());
            delete = true;
        }

        if(delete){
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long getDifference(Date date) {
        return date.getTime() - deque.peek().getDate().getTime();
    }

}
