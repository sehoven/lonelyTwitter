/*
(THIS IS JUST AN EXAMPLE - to develop in our own team)
Copyright (c) 2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved
You may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the Code of Student Behaviour.
You can find a copy of the licence at http://www.github.com/Team20/...
For further information, contact me@domain.ca
 */

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
 * This is the main view class of the lonelyTwitter project. <p>It handles all
 * user interactions as well as file manipulations.</p>
 * <pre> All the files are stores in the form of "json" files stored in Emulator,
 * accessible from Android Device Monitor. </pre>
 * <code> Pseudo code sample:
 * <br>open some file ...
 * <br>attach some text ...
 * <br>close the file.
 * </code>
 * <ul>
 *     <li>an item</li>
 *     <li>another item</li>
 *     <li>and another item</li>
 *     <li>yet another item</li>
 * </ul>
 * <ol>
 *     <li>an item</li>
 *     <li>another item</li>
 *     <li>and another item</li>
 *     <li>yet another item</li>
 * </ol>
 * @since 1.0
 * @see NormalTweet
 * @see java.io.FileNotFoundException
 * @author Sarah
 * @deprecated
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the file name that is being saved / loaded and contains all the tweets.
	 * @see #saveInFile()
	 * @see #loadFromFile()
	 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private	ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

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

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the tweets rom FILE_NAME (file.sav), and ...
	 * @throws FileNotFoundException
	 * @exception RuntimeException
	 */
	// explain behaviour, input, output, parameters
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
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
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
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

	private void clearScreen() {
		tweetList.clear();
		adapter.notifyDataSetChanged();
	}

	private void clearData() {
		File dir = getFilesDir();
		File file = new File(dir, FILENAME);
		try {
			boolean deleted = file.delete();
		} catch (SecurityException e) {
			throw new RuntimeException();
		}
	}
}