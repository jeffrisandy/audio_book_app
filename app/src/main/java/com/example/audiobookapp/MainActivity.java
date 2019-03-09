package com.example.audiobookapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    }
}
