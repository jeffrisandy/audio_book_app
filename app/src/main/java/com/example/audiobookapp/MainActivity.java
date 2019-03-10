package com.example.audiobookapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    String bookTitle = PlayerActivity.
//    String bookAuthor = bookAuthorPlaying.PlayerActivity;
//    int bookCoverId = bookCoverPlaying.PlayerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the entrepreneurship book category
        TextView entrepreneurship = (TextView) findViewById(R.id.entrepreneurship);

        // Set a click listener on that View
        entrepreneurship.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the entrepreneurship category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent entrepreneurshipIntent = new Intent(MainActivity.this, EntrepreneurActivity.class);

                // Start the new activity
                startActivity(entrepreneurshipIntent);
            }
        });

        // Find the View that shows the investing book category
        TextView investing = (TextView) findViewById(R.id.investing);

        // Set a click listener on that View
        investing.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the investing category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent investingIntent = new Intent(MainActivity.this, InvestingActivity.class);

                // Start the new activity
                startActivity(investingIntent);
            }
        });

        // Find the View that shows the leadership category
        TextView acoustic = (TextView) findViewById(R.id.leadership);

        // Set a click listener on that View
        acoustic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the leadership category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent leadershipIntent = new Intent(MainActivity.this, LeadershipActivity.class);

                // Start the new activity
                startActivity(leadershipIntent);
            }
        });



        // setting onclick listener to the button "Now Playing"
        Button nowPlayingButton = (Button) findViewById(R.id.library_now_playing_button);

        nowPlayingButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public  void onClick(View v) {
                // get data for currently playing in PlayerActivity
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String bookTitlePlaying = prefs.getString("title", null);
                String bookAuthorPlaying = prefs.getString("author", null);
                int bookCoverPlaying = prefs.getInt("cover_id", 0);

                //create intent to PlayerActivity
                Intent nowPlayingIntent = new Intent(MainActivity.this, PlayerActivity.class);
                nowPlayingIntent.putExtra("title", bookTitlePlaying);
                nowPlayingIntent.putExtra("author", "By " + bookAuthorPlaying);
                nowPlayingIntent.putExtra("cover_id", bookCoverPlaying);
                startActivity(nowPlayingIntent);

            }
        });


    }
}
