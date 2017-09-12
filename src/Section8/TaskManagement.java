package Section8;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskManagement {

    public static void main(String[] args) {
        manageTask();
    }

     public static void manageTask(){
        ArrayBlockingQueue<Event> events = new ArrayBlockingQueue<>(100);
        WriterTask writerTask = new WriterTask(events);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(events);
        cleanerTask.start();
    }
}
