package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shoven on 9/13/16.
 */
public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet ( String message ) {
        super( message ); // super calls the constructor from the parent class
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
