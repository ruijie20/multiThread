package Chapter1.Section3;

import Chapter1.Section2.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreadPriorityAndStates {
    public static void main(String[] args) {
        displayThreadPriorityAndStates();
    }
    static void displayThreadPriorityAndStates() {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i %2) == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }
            else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        try(FileWriter fileWriter = new FileWriter("./out/log.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter)

        ) {
            for (int i = 0; i < 10; i++) {
                printWriter.printf("Main: State of Thread " + i + ":" + threads[i].getState() + "\n");
                states[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while(!finish){
                for (int i = 0; i < 10; i++) {
                    if(threads[i].getState() != states[i]){
                        printThreadStatus(threads[i], states[i], printWriter);
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printThreadStatus(Thread thread, Thread.State state, PrintWriter printWriter) {
        printWriter.printf("Main: Id %d  -  %s\n", thread.getId(), thread.getName());
        printWriter.printf("Main: Priority: %d\n", thread.getPriority());
        printWriter.printf("Main: OldState: %s\n", state);
        printWriter.printf("Main: NewState: %s\n", thread.getState());
        printWriter.printf("Main: ***********************************\n");
    }
}
