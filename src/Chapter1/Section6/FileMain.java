package Chapter1.Section6;

import java.util.concurrent.TimeUnit;

public class FileMain {

    public static void main(String[] args) {
        threadInterruptSleep();
    }

    static public void threadInterruptSleep(){
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
