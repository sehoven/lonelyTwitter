package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by shoven on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!", new Date());
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

        Tweet a = new NormalTweet("Hello!", new Date());
        assertFalse(list.hasTweet(a));
        list.addTweet(a);
        assertTrue(list.hasTweet(a));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!", new Date());
        Tweet b = new NormalTweet("Hi!", new Date());

        list.addTweet(a);
        list.addTweet(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello", new Date());
        list.addTweet(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Date dateA = new GregorianCalendar(2016,1,5,10,11).getTime();
        Date dateD = new GregorianCalendar(2016,1,5,10,12).getTime();
        Date dateC = new GregorianCalendar(2016,1,5,10,13).getTime();
        Date dateB = new GregorianCalendar(2016,1,5,10,14).getTime();

        Tweet a = new NormalTweet("Hello!", dateA);
        Tweet d = new NormalTweet("Hi!", dateD);
        Tweet c = new NormalTweet("Hey!", dateC);
        Tweet b = new NormalTweet("Howdy!", dateB);

        list.addTweet(a);
        list.addTweet(b);
        list.addTweet(c);
        list.addTweet(d);

        assertEquals(a, list.getTweets().get(3));
        assertEquals(d, list.getTweets().get(2));
        assertEquals(c, list.getTweets().get(1));
        assertEquals(b, list.getTweets().get(0));
    }

    public void testCountTweets() {
        TweetList list = new TweetList();
        assertTrue(list.getCount().equals(0));

        Tweet a = new NormalTweet("Hello!", new Date());
        list.addTweet(a);
        assertTrue(list.getCount().equals(1));

        Tweet b = new NormalTweet("Hey", new Date());
        list.addTweet(b);
        assertTrue(list.getCount().equals(2));

        list.removeTweet(b);
        assertTrue(list.getCount().equals(1));

        list.removeTweet(a);
        assertTrue(list.getCount().equals(0));
    }
}
