package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 9/13/16.
 */
public abstract class Tweet {
    // attributes for our tweet
    private String message;
    private Date date;

    public Tweet( String message ) { // will be called if we only pass in a string
        this.message = message;
    }

    public Tweet( String message, Date date ) { // will be called if we pass in a string and a date
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant ();

    public void setMessage(String message) throws TweetTooLongException {
        if ( message.length() > 140 ) {
            // do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
