package Chapter1.Section7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Start network connecting: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Network has been connected: %s\n", new Date());
    }
}
