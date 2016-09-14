package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public abstract class Tweet {
    // attributes for our tweet
    private String message;
    private Date date;
    private ArrayList<Mood> moods;

    public Tweet ( String message ) { // will be called if we only pass in a string
        this.message = message;
        this.moods = new ArrayList<Mood>();
    }

    public Tweet ( String message, Date date ) { // will be called if we pass in a string and a date
        this.message = message;
        this.date = date;
        this.moods = new ArrayList<Mood>();
    }

    public abstract Boolean isImportant();

    public void setMessage( String message ) throws TweetTooLongException {
        if ( message.length() > 140 ) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }
}
