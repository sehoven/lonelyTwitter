package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public abstract class Mood {
    private Date date;

    public Mood () { // sets date to a default
        this.date = new Date();
    }

    public Mood ( Date date ) { // date passed as an argument
        this.date = date;
    }

    public abstract String formatMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
