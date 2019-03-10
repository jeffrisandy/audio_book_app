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
import android.widget.Toast;

import java.util.ArrayList;

public class InvestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book( "Guide to Investing", "Robert T. Kiyozaki", R.drawable.guide_to_investing_robert_t_kiyozaki));
        books.add(new Book( "Rule #1 Investing", "Phil Town", R.drawable.rule_1_investing_phil_town));
        books.add(new Book( "Smart Women Finish Rich", "David Bach", R.drawable.smart_women_finish_rich_david_bach));
        books.add(new Book( "The Boglehead Guide to Investing", "Mel Lindauer, Taylor Larimore, and Michael LeBoeuf", R.drawable.the_boglehead_guide_to_investing_mel_lindauer_taylor_larimore_michael_lebouef));
        books.add(new Book( "The Intelligent Investor", "Benjamin Graham", R.drawable.the_intelligent_investor_benjamin_graham));
        books.add(new Book( "The Millionaire Next Door", "Thomas J Stanley & William D Danko", R.drawable.the_millionaire_next_door_thomas_j_stanley_william_d_danko));
        books.add(new Book( "The Total Money Makeover", "Dave Ramsey", R.drawable.the_total_money_makeover_dave_ramsey));
        books.add(new Book( "University of Berkshire Hathaway","Daniel Precaut & Corey Wrenn", R.drawable.university_of_berkshire_hathaway_daniel_pecaut_corey_wrenn));
        books.add(new Book( "You are Badass at Making Money", "Jen Sincero", R.drawable.you_are_badass_at_making_money_jen_sincero));

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
                Intent bookIntent = new Intent(InvestingActivity.this, PlayerActivity.class);
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
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(InvestingActivity.this);
                String bookTitlePlaying = prefs.getString("title", null);
                String bookAuthorPlaying = prefs.getString("author", null);
                int bookCoverPlaying = prefs.getInt("cover_id", 0);

                if (bookTitlePlaying != null) {

                    //create intent to PlayerActivity
                    Intent nowPlayingIntent = new Intent(InvestingActivity.this, PlayerActivity.class);
                    nowPlayingIntent.putExtra("title", bookTitlePlaying);
                    nowPlayingIntent.putExtra("author", bookAuthorPlaying);
                    nowPlayingIntent.putExtra("cover_id", bookCoverPlaying);
                    startActivity(nowPlayingIntent);
                } else {
                    Toast.makeText(InvestingActivity.this, "You don't have any audiobook that is currently playing", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
