package com.example.maldred.golfrange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    File mDataDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the data directory for the dataset
        mDataDirectory = getFilesDir();
        GolfRange.getInstance().load(mDataDirectory);

        // add a new location into the database
        //GolfRange.getInstance().getLocations().addLocation("Whitely");
        //GolfRange.getInstance().getClubs().addClub("Sand Wedge", 80, 20);
        //GolfRange.getInstance().getClubs().addClub("Pitching Wedge", 90, 20);
        //GolfRange.getInstance().getClubs().addClub("9 iron", 100, 20);
        //GolfRange.getInstance().getClubs().addClub("8 iron", 110, 20);
        //GolfRange.getInstance().getClubs().addClub("7 iron", 120, 20);
        //GolfRange.getInstance().getClubs().addClub("6 iron", 130, 20);
        //GolfRange.getInstance().getClubs().addClub("5 iron", 140, 20);
        //GolfRange.getInstance().getClubs().addClub("4 iron", 150, 20);
        //GolfRange.getInstance().getClubs().addClub("3 iron", 160, 20);
        //GolfRange.getInstance().getClubs().addClub("Rescue", 175, 20);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        GolfRange.getInstance().save(mDataDirectory);
    }
}
