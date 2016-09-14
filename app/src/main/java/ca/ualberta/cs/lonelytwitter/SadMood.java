package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public class SadMood extends Mood {
    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public String formatMood() {
        return "Tears. I am sad. :(";
    }
}
