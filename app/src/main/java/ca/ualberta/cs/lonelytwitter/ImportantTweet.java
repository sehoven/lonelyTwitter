package ca.ualberta.cs.lonelytwitter;

/**
 * The type Important tweet that extends from tweet to denote a tweet
 * that should be paid special attention.
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet by taking in a String
     * parameter that is the message for the tweet.
     *
     * @param message the message of the tweet
     */
    public ImportantTweet( String message ) {
        super( message );
    }

    /**
     * Informs us whether the tweet is important or not. This class is
     * for important tweets so every tweet is important and will return True.
     *
     * @return True, it is important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * Takes in an Object parameter to compare against this Object.
     *
     * <i><p>This method is not yet implemented.</p></i>
     *
     * @param another another Object to compare
     * @return 0
     */
    public int compareTo(Object another) {
        return 0;
    }
}
