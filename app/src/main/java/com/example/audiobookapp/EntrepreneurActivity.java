package com.example.audiobookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EntrepreneurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book( "Bad Blood", "John Carreyrou", R.drawable.bad_blood_john_carreyrou));
        books.add(new Book( "Rework", "Jason Fried and David Heinemeir", R.drawable.rework_jason_fried_david_heinemeier_hansson));

        BookAdapter booksAdapter = new BookAdapter(this, books);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(booksAdapter);

//        // Set OnClickListener on ListView to identify the item on ListView clicked by user
//        // Text on the ListView item clicked is passed on to PlayerActivity
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // Get the selected opus.
//                Book currentBook = (Book) adapterView.getItemAtPosition(position);
//
//                // Extract strings from Opus object.
//                int bookCover = currentBook.getCover();
//                String bookTitle = currentBook.getTitle();
//                String bookAuthor = currentBook.getAuthor();
//
//                // Sending the name of song and author to PlayerActivity.
//                Intent songIntent = new Intent(EntrepreneurActivity.this, PlayerActivity.class);
//                songIntent.putExtra("song", songTitle);
//                songIntent.putExtra("author", songAuthor);
//                startActivity(songIntent);
//            }
//        });

    }
}
