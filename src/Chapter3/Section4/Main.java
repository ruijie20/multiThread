package Chapter3.Section4;

public class Main {
    public static void main(String[] args){
        VideoConference videoConference = new VideoConference(10);
        Thread thread = new Thread(videoConference);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoConference, "participant" + i);
            Thread participantThread = new Thread(participant);
            participantThread.start();
        }
    }
}
