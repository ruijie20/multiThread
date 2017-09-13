package Chapter2.Section2;

public class Main {
    public static void main(String[] args){
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account: Initial Balance: %f\n", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();

            System.out.printf("Account : final balance: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
