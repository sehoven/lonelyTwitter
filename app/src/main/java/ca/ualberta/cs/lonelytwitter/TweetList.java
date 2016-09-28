package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shoven on 2016-09-27.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Integer getCount() {
        return tweets.size();
    }
}
