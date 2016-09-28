package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shoven on 2016-09-13.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet( String message ) {
        super( message );
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public int compareTo(Object another) {
        return 0;
    }
}
