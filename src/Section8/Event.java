package Section8;

import java.util.Date;

public class Event {
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {

        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    private String event;
    private Date date;
}
