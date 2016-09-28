package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by shoven on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
        try {
            list.addTweet(tweet);
            fail();
        } catch ( IllegalArgumentException e ) {
        }
    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        assertFalse(list.hasTweet(a));
        list.addTweet(a);
        assertTrue(list.hasTweet(a));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.addTweet(a);
        list.addTweet(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        list.addTweet(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        Tweet c = new NormalTweet("Hey!");
        Tweet d = new NormalTweet("Howdy!");

        list.addTweet(a);
        list.addTweet(b);
        list.addTweet(c);
        list.addTweet(d);

        assertEquals(a, list.getTweets().get(0));
        assertEquals(b, list.getTweets().get(1));
        assertEquals(c, list.getTweets().get(2));
        assertEquals(d, list.getTweets().get(3));
    }

    public void testCountTweets() {
        TweetList list = new TweetList();
        assertTrue(list.getCount().equals(0));

        Tweet a = new NormalTweet("Hello!");
        list.addTweet(a);
        assertTrue(list.getCount().equals(1));

        Tweet b = new NormalTweet("Hey");
        list.addTweet(b);
        assertTrue(list.getCount().equals(2));

        list.removeTweet(b);
        assertTrue(list.getCount().equals(1));

        list.removeTweet(a);
        assertTrue(list.getCount().equals(0));
    }
}
