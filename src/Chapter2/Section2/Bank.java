package Chapter2.Section2;

public class Bank implements Runnable{
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
            System.out.printf("sub ammount %d : %f\n", i, account.getBalance());
        }
    }
}
