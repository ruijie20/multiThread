package Section9;

import java.util.concurrent.TimeUnit;

public class ExceptionMangement {
    public static void main(String[] args){
        TaskForException taskForException = new TaskForException();
        Thread thread = new Thread(taskForException);
        thread.setUncaughtExceptionHandler(new ExceptonHandler());
        thread.start();


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
