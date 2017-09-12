package Section2;

public class CreateAThread {

    public static void main(String[] args) {
        calculateMultiple1To10();
    }

    static void calculateMultiple1To10() {
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
