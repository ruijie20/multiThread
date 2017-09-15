package Chapter2.Section8;

import java.util.Random;

public class Consumer implements Runnable{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            System.out.printf("lines: %s\n", line);
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
