package Chapter1.Section4;

public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 3L;
        while(true){
            if(isPrime(number)){
                System.out.printf("Number %d is Prime\n", number);
            }

            if(isInterrupted()){
                System.out.printf("The Prime Generator has been Interrupted.");
                return;
            }

            number++;
        }
    }

    private boolean isPrime(long number){
        if(number <= 2){
            return true;
        }

        for (int i = 2; i < number; i++) {
            if((number % i) == 0){
                return false;
            }
        }
        return true;
    }
}
