package Chapter1.Section5;

import java.util.concurrent.TimeUnit;

public class FileSearchMain {
    public static void main(String[] args) {
        searchFile();
    }

    static void searchFile() {
        FileSearch fileSearch = new FileSearch("/fileSearch", "log 3.txt");

        Thread thread = new Thread(fileSearch);
        thread.start();

        try{
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }


}
