package com.example.audiobookapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LeadershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book( "Dare to Lead", "Breme Brown", R.drawable.dare_to_leand_brene_brown));
        books.add(new Book( "Emotional Intelligence 2.0", "Travis Bradberry & Jean Greaves", R.drawable.emotional_intelligence_travis_bradberry_jean_greaves));
        books.add(new Book( "Extreme Ownership", "Jocko Willink & Leif Bain", R.drawable.extreme_ownership_jocko_willink_leif_bain));
        books.add(new Book( "Good to Great", "Jim Collins", R.drawable.good_to_great_jim_collins));
        books.add(new Book( "Leaders Eat Last", "Simon Sinek", R.drawable.leaders_eat_last_simon_sinek));
        books.add(new Book( "Leader Shift", "John C Maxwell", R.drawable.leader_shift_john_c_maxwell));
        books.add(new Book( "Power", "Robert Greene", R.drawable.power_robert_greene));
        books.add(new Book( "Principles", "Ray Dalio", R.drawable.principles_ray_dalio));
        books.add(new Book( "Radical Candor", "Kim Scott", R.drawable.radical_candor_kim_scott));
        books.add(new Book( "The 7 Habits of Highly Effective People", "Stephen R Covey", R.drawable.the_7_habits_stephen_r_covey));
        books.add(new Book( "Start With Why", "Simon Sinek", R.drawable.start_with_why_simon_sinek));
        books.add(new Book( "The Hard Thing about Hard Things", "Ben Horowitz", R.drawable.the_hard_thing_about_hard_things_ben_horowitz));

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
                Intent bookIntent = new Intent(LeadershipActivity.this, PlayerActivity.class);
                bookIntent.putExtra("title", bookTitle);
                bookIntent.putExtra("author", "By " + bookAuthor);
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
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LeadershipActivity.this);
                String bookTitlePlaying = prefs.getString("title", null);
                String bookAuthorPlaying = prefs.getString("author", null);
                int bookCoverPlaying = prefs.getInt("cover_id", 0);

                //create intent to PlayerActivity
                Intent nowPlayingIntent = new Intent(LeadershipActivity.this, PlayerActivity.class);
                nowPlayingIntent.putExtra("title", bookTitlePlaying);
                nowPlayingIntent.putExtra("author", "By " + bookAuthorPlaying);
                nowPlayingIntent.putExtra("cover_id", bookCoverPlaying);
                startActivity(nowPlayingIntent);


            }
        });


    }
}
