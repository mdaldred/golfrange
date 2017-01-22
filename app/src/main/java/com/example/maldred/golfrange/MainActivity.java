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
    }

    @Override
    public void onStop()
    {
        super.onStop();
        GolfRange.getInstance().save(mDataDirectory);
    }
}
