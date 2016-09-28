package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {

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
        long tweetTime = (((Tweet) another).getDate()).getTime();
        long difference = tweetTime - this.getDate().getTime();
        return (int)difference;
    }
}
