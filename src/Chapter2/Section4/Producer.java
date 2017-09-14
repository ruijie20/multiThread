package Chapter2.Section4;

public class Producer implements Runnable{
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.setStorage();
            System.out.printf("set -----------------%d\n", i);
        }
    }
}
