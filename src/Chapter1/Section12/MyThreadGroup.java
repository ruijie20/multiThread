package Chapter1.Section12;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("System has throw an exception %s\n", t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminate the rest of the threads\n");
        interrupt();
    }
}
