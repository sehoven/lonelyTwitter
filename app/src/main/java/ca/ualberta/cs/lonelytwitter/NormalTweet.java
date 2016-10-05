package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * This constructor makes a NormalTweet given string and date parameters
     * @param message this parameter is the given string for the tweet. If it is set to empty
     *                string, then it will be replaced by ...
     * @param date
     */
    // can define range for values, explain that
    public NormalTweet ( String message, Date date ) {
        super( message, date );
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    public int compareTo(Object another) throws ClassCastException {
        if(!(another instanceof Tweet)) {
            throw new ClassCastException("A Tweet object expected");
        }
        return ((Tweet) another).getDate().compareTo(this.getDate());
    }
}
