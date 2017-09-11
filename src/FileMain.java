import java.util.concurrent.TimeUnit;

public class FileMain {
    static public void thredaInterrupteSleep(){
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
