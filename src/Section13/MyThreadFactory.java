package Section13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private ArrayList<String> stats;
    private String name;

    public MyThreadFactory(String name) {

        this.name = name;
        counter = 0;
        stats = new ArrayList<>();
    }

    public String getStats() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();
        while(iterator.hasNext()){
            stringBuffer.append(iterator.next());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread" + counter);
        counter++;
        stats.add(String.format("created thread %d with name %s at %s\n",
                thread.getId(), thread.getName(), new Date()));
        return thread;
    }
}
