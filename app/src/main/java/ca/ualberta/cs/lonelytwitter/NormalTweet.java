package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The type Normal tweet that extends from tweet to denote a typical tweet.
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * Instantiates a new Normal tweet by taking in a message, which is the
     * text of the tweet, and a date parameter, which is the date of the tweet
     * occurrence.
     *
     * @param message the message of the tweet
     * @param date    the date the tweet occurred
     */
    public NormalTweet ( String message, Date date ) {
        super( message, date );
    }

    /**
     * Informs us whether the tweet is important or not. This class is
     * not for important tweets so every tweet is not important and will
     * return False.
     *
     * @return False, it is not important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    /**
     * Compares the dates of two tweets to determine which should be ordered first.
     *
     * @param another another Object to compare
     * @return integer that denotes whether the other Object is larger or
     * smaller based on the date
     * @throws ClassCastException
     */
    public int compareTo(Object another) throws ClassCastException {
        if(!(another instanceof Tweet)) {
            throw new ClassCastException("A Tweet object expected");
        }
        return ((Tweet) another).getDate().compareTo(this.getDate());
    }
}
