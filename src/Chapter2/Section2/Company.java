package Chapter2.Section2;

public class Company implements Runnable{
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
            System.out.printf("add amount %d : %f\n", i, account.getBalance());
        }
    }
}
