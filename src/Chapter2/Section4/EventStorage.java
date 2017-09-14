package Chapter2.Section4;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void setStorage() {
        while (storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.offer(new Date());

        System.out.printf("set: %d\n", storage.size());
        notifyAll();
    }

    public synchronized void getStorage(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("get: %d: %s\n", storage.size(), ((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
