package Chapter1.Section13;

public class Main {
    public static void main(String[] args){
        MyThreadFactory myFactory = new MyThreadFactory("myFactory");
        Sleep1Second sleep1Second = new Sleep1Second();
        Thread thread;
        System.out.printf("starting the threads\n");
        for (int i = 0; i < 10; i++) {
            thread = myFactory.newThread(sleep1Second);
            thread.start();
        }

        System.out.println("Factory statistics:");
        System.out.printf("%s\n", myFactory.getStats());
    }
}
