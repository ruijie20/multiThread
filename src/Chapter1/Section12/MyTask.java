package Chapter1.Section12;

import java.util.Random;

public class MyTask implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true){
            result = 1000/((int) (random.nextDouble() * 1000));
            System.out.printf("%s: %d\n", Thread.currentThread().getId(), result);
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d: interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
