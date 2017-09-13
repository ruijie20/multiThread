package Chapter1.Section7;

import java.util.Date;

public class ThreadManagement {
    public static void main(String[] args) {
        manageThreads();
    }

    static public void manageThreads(){
        DataSourceLoader dataSourceLoader = new DataSourceLoader();
        Thread dataSourceThread = new Thread(dataSourceLoader, "DataSourceThread");
        NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
        Thread networkConnectionThread = new Thread(networkConnectionsLoader, "NetworkConnectionThread");

        dataSourceThread.start();
        networkConnectionThread.start();

        try {
            dataSourceThread.join();
            networkConnectionThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been set: %s \n", new Date());
    }
}
