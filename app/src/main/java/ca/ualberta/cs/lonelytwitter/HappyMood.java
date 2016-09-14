package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public class HappyMood extends Mood {
    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    public String formatMood() {
        return "YAY! I am happy! :)";
    }
}
