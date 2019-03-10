package com.example.audiobookapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Get extras from Intent.
        android.content.Intent bookIntent = getIntent();

        // Set the book title for playing.
        TextView titleTextView = findViewById(R.id.player_title);
        String bookTitlePlaying = bookIntent.getStringExtra("title");
        titleTextView.setText(bookTitlePlaying);

        // Set the book author for playing.
        TextView authorTextView = findViewById(R.id.player_author);
        String bookAuthorPlaying = bookIntent.getStringExtra("author");
        authorTextView.setText(bookAuthorPlaying);

        // Set the book cover id for playing.
        ImageView coverImageView = findViewById(R.id.player_book_cover_image_view);
        int bookCoverPlaying = bookIntent.getIntExtra("cover_id",0);
        coverImageView.setImageResource(bookCoverPlaying);

        // sent data to MainActivity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putString("title", bookTitlePlaying).apply();
        prefs.edit().putString("author", bookAuthorPlaying).apply();
        prefs.edit().putInt("cover_id", bookCoverPlaying).apply();


        // setting onclick listener to the button "Library"
        Button nowPlayingButton = (Button) findViewById(R.id.player_library_button);

        nowPlayingButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public  void onClick(View v) {
                Intent libraryIntent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(libraryIntent);

            }
        });




        //startActivity(nowPlayingIntent);

    }
}
