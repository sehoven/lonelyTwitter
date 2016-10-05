package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The type Mood that specifies the mood on a certain date.
 */
public abstract class Mood {
    /**
     * This denotes the date of this mood.
     */
    private Date date;

    /**
     * Instantiates a new Mood by setting its date to be right now.
     */
    public Mood () { // sets date to a default
        this.date = new Date();
    }

    /**
     * Instantiates a new Mood by taking in a date parameter and
     * setting its date to be the date passed in.
     *
     * @param date the date of the mood occurrence
     */
    public Mood ( Date date ) { // date passed as an argument
        this.date = date;
    }

    /**
     * Format mood string with a message that describes the mood.
     *
     * @return the mood string
     */
    public abstract String formatMood();

    /**
     * Gets the date of this mood.
     *
     * @return the date of mood occurrence
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date of this mood.
     *
     * @param date the date of mood occurrence
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
