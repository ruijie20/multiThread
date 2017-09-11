package Section7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Start data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Data sources has been loaded: %s\n", new Date());
    }
}
