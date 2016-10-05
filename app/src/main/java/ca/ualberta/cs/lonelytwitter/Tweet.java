package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * The type Tweet that contains the message, date, and mood array for each tweet
 * entered by the user.
 */
public abstract class Tweet implements Comparable {
    private String message;
    private Date date;
    private ArrayList<Mood> moods;

    /**
     * Instantiates a new Tweet by taking in a message string. The date is set
     * to now and the mood list is instantiated to empty.
     *
     * @param message the tweet message
     */
    public Tweet ( String message ) {
        this.message = message;
        this.date = new Date();
        this.moods = new ArrayList<Mood>();
    }

    /**
     * Instantiates a new Tweet by taking in a message string and a date. The
     * mood list is instantiated to empty.
     *
     * @param message the tweet message
     * @param date    the tweet date
     */
    public Tweet ( String message, Date date ) {
        this.message = message;
        this.date = date;
        this.moods = new ArrayList<Mood>();
    }

    /**
     *  Informs us whether the tweet is important or not. This abstract
     *  method forces all subclasses to identify whether its tweets are
     *  important or not.
     *
     * @return boolean to signify tweet importance
     */
    public abstract Boolean isImportant();

    /**
     * Sets message of the tweet
     *
     * @param message the tweet message
     * @throws TweetTooLongException tweet is over 140 characters
     */
    public void setMessage( String message ) throws TweetTooLongException {
        if ( message.length() > 140 ) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date of the tweet
     *
     * @param date the tweet date
     */
    public void setDate( Date date ) {
        this.date = date;
    }

    /**
     * Sets array of moods for the tweet
     *
     * @param moods the mood array
     */
    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    /**
     * Gets message of the tweet.
     *
     * @return the tweet message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date of the tweet.
     *
     * @return the tweet date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets mood array of the tweet.
     *
     * @return the mood arry
     */
    public ArrayList<Mood> getMoods() {
        return moods;
    }

    /**
     * Converts tweet to a string by concatenating the date and message.
     *
     * @return String
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
