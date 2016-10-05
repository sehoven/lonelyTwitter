package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The interface Tweetable that provides methods to get the message
 * and the date of the tweet.
 */
public interface Tweetable {
    /**
     * Gets message of the tweet.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date of the tweet.
     *
     * @return the date
     */
    public Date getDate();
}
