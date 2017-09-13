package Chapter1.Section12;

public class Main {
    public static void main(String[] args){
        MyThreadGroup myThreadGroup = new MyThreadGroup("myThreadGroup");
        MyTask myTask = new MyTask();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(myThreadGroup, myTask);
            thread.start();
        }
    }
}
