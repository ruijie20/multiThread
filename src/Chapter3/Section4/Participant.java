package Chapter3.Section4;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{
    private final VideoConference videoConference;
    private final String name;

    public Participant(VideoConference videoConference, String name) {
        this.videoConference = videoConference;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("Wait for %s %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            videoConference.arrive(name);
        }

    }
}
