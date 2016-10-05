package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type Tweet list that stores the list of all the tweets entered by
 * the user.
 */
public class TweetList {
    /**
     * The list of all the tweets
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add tweet to the tweet list if the list does not contain it
     *
     * @param tweet the tweet
     * @throws IllegalArgumentException
     */
    public void addTweet(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    /**
     * Remove tweet from the tweet list.
     *
     * @param tweet the tweet
     */
    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Gets tweet from the tweet list based on the index passed in.
     *
     * @param i the index of the tweet
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Gets the sorted list of tweets.
     *
     * @return the tweets
     */
    public List<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    /**
     * Returns True if the tweet exists in the list or False if the tweet
     * does not exist in the list.
     *
     * @param tweet the tweet
     * @return boolean for existence of the tweet in the list
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets count of tweets in the tweet list.
     *
     * @return the count of tweets in the tweet list.
     */
    public Integer getCount() {
        return tweets.size();
    }
}
