package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shoven on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {

    public NormalTweet ( String message ) {
        super( message );
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
