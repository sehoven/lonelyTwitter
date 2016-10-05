package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of the lonelyTwitter project.
 * <p>It handles all user interactions, which includes saving and
 * clearing the data, displaying the data, and file manipulations.</p>
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the file name that is being saved / loaded and contains all the tweets.
	 * @see #saveInFile()
	 * @see #loadFromFile()
	 */
	private static final String FILE_NAME = "file.sav";
	/**
	 * This is the text box where the user enters the new tweets to be added.
	 */
	private EditText bodyText;
	/**
	 * This is where the previously entered tweets are displayed.
	 */
	private ListView oldTweetsList;
	/**
	 * This is where all the tweets that are created by the user are stored.
	 */
	private	ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	/**
	 * This is the array adapter that handles the list of all the tweets.
	 */
	private ArrayAdapter<Tweet> adapter;

	/**
	 * This method is called every time the activity is created during the
	 * lifetime of the app.
	 * <p>This method initializes the text save and clear buttons, as well as
	 * the views for the main content and tweet list and the edit text box where
	 * new tweets are entered.</p>
	 * <p>All the files are stored as "json" files in the Emulator, which are
	 * accessible from Android Device Monitor.</p>
	 * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet( text, new Date() );

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				bodyText.setText(null);
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				clearScreen();
				clearData();
			}
		});
	}

	/**
	 * This method is called every time the activity is started during
	 * the lifetime of the app.
	 * <p>This method sets the array adapter for the tweet list view and
	 * loads all app data that is stored in memory.</p>
	 */
	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the tweets from FILE_NAME (file.sav).
	 * <p>All the files are stored as "json" files in the Emulator, which are
	 * accessible from Android Device Monitor.</p>
	 * <p>If the file cannot be found, the tweet list is initialized to an
	 * empty tweet list</p>
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			// code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// Create a brand new tweet list if we can't find the file.
			tweetList = new ArrayList<Tweet>();
		}
	}

	/**
	 * This method saves the tweets to FILE_NAME (file.sav).
	 * <p>All the files are stored as "json" files in the Emulator, which are
	 * accessible from Android Device Monitor.</p>
	 * @throws RuntimeException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// rethrow
			throw new RuntimeException(e);
		} catch (IOException e) {
			// rethrow
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method clears the screen of all tweets.
	 */
	private void clearScreen() {
		tweetList.clear();
		adapter.notifyDataSetChanged();
	}

	/**
	 * This method clears all app data from the device memory by deleting
	 * the FILE_NAME (file.sav) file.
	 * @throws RuntimeException
	 */
	private void clearData() {
		File dir = getFilesDir();
		File file = new File(dir, FILE_NAME);
		try {
			boolean deleted = file.delete();
		} catch (SecurityException e) {
			throw new RuntimeException();
		}
	}
}