package Section4;

public class ThreadInterrupt {
    public static void main(String[] args) {
        threadInterrupted();
    }

    static void threadInterrupted() {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        primeGenerator.start();

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        primeGenerator.interrupt();
    }
}
