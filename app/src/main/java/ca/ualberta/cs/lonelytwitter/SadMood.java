package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The type Sad mood that extends from mood to specify the details
 * of a sad mood.
 */
public class SadMood extends Mood {
    /**
     * Instantiates a new Sad mood.
     */
    public SadMood() {
        super();
    }

    /**
     * Instantiates a new Sad mood by taking in a date parameter.
     *
     * @param date the date
     */
    public SadMood(Date date) {
        super(date);
    }

    /**
     * Returns a string that describes the mood.
     *
     * @return the mood string
     */
    public String formatMood() {
        return "Tears. I am sad. :(";
    }
}
