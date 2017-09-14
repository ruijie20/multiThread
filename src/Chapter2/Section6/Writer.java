package Chapter2.Section6;

public class Writer implements Runnable{
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
