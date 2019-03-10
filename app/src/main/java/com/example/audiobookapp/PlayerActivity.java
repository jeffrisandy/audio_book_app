package com.example.audiobookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
