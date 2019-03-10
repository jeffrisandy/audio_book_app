package com.example.audiobookapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EntrepreneurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book( "Bad Blood", "John Carreyrou", R.drawable.bad_blood_john_carreyrou));
        books.add(new Book( "Rework", "Jason Fried and David Heinemeir", R.drawable.rework_jason_fried_david_heinemeier_hansson));
        books.add(new Book( "Measure What Matters", "John Doerr", R.drawable.measure_what_matters_john_doerr));
        books.add(new Book( "Sprint", "Jake Knapp", R.drawable.sprint_jake_knapp));
        books.add(new Book( "Steal Like An Artist", "Austin Kleon", R.drawable.steal_like_an_artist_austin_kleon));
        books.add(new Book( "The $100 Startup", "Chris Guillebeau", R.drawable.the_100_startup_chris_guillebeau));
        books.add(new Book( "The Lean Startup", "Eric Ries", R.drawable.the_lean_startup_eric_ries));
        books.add(new Book( "The Personal MBA", "John Kaufman", R.drawable.the_personal_mba_john_kaufman));
        books.add(new Book( "Think and Grow Rich", "Rich Napoleon", R.drawable.think_and_grow_rich_napoleon_hill));
        books.add(new Book( "Zero to One", "Peter Thiel", R.drawable.zero_to_one_peter_thiel));

        // create custom adapter and attach it to ListView list
        BookAdapter booksAdapter = new BookAdapter(this, books);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(booksAdapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlayerActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected opus.
                Book currentBook = (Book) adapterView.getItemAtPosition(position);

                // Extract strings from Opus object.
                int bookCoverId = currentBook.getCoverId();
                String bookTitle = currentBook.getTitle();
                String bookAuthor = currentBook.getAuthor();

                // Sending the name of song and author to PlayerActivity.
                Intent bookIntent = new Intent(EntrepreneurActivity.this, PlayerActivity.class);
                bookIntent.putExtra("title", bookTitle);
                bookIntent.putExtra("author",  bookAuthor);
                bookIntent.putExtra("cover_id", bookCoverId);

                startActivity(bookIntent);
            }
        });

        // setting onclick listener to the button "Now Playing"
        Button nowPlayingButton = (Button) findViewById(R.id.category_now_playing_button);
        nowPlayingButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public  void onClick(View v) {
                // get data for currently playing in PlayerActivity
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(EntrepreneurActivity.this);
                String bookTitlePlaying = prefs.getString("title", null);
                String bookAuthorPlaying = prefs.getString("author", null);
                int bookCoverPlaying = prefs.getInt("cover_id", 0);

                if (bookTitlePlaying != null) {

                    //create intent to PlayerActivity
                    Intent nowPlayingIntent = new Intent(EntrepreneurActivity.this, PlayerActivity.class);
                    nowPlayingIntent.putExtra("title", bookTitlePlaying);
                    nowPlayingIntent.putExtra("author",  bookAuthorPlaying);
                    nowPlayingIntent.putExtra("cover_id", bookCoverPlaying);
                    startActivity(nowPlayingIntent);
                } else {
                    Toast.makeText(EntrepreneurActivity.this, "You don't have any audiobook that is currently playing", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
