package Chapter1.Section9;

public class ExceptonHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An exception has been caught.");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass(), e.getMessage());
        System.out.printf("Stack Trace:\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread Status: %s\n", t.getState());
    }
}
