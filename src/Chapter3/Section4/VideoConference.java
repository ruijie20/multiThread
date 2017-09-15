package Chapter3.Section4;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{
    private final CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: waiting for %d participants\n",
                controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n",
                controller.getCount());

        try {
            controller.await();
            System.out.printf("VideoCOnference: All the participants have come\n");
            System.out.printf("Let's start ...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
