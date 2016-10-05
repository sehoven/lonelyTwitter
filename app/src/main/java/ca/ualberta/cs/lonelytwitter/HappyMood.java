package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The type Happy mood that extends from mood to specify the details
 * of a happy mood.
 */
public class HappyMood extends Mood {
    /**
     * Instantiates a new Happy mood.
     */
    public HappyMood() {
        super();
    }

    /**
     * Instantiates a new Happy mood by taking in a date parameter.
     *
     * @param date the date
     */
    public HappyMood(Date date) {
        super(date);
    }

    /**
     * Returns a string that describes the mood.
     *
     * @return the mood string
     */
    public String formatMood() {
        return "YAY! I am happy! :)";
    }
}
