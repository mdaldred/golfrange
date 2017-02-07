package com.example.maldred.golfrange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

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

        //Conditions condition = new Conditions(Conditions.WindDir.N, Conditions.WindStr.NONE, false );
        //Calendar cal  = Calendar.getInstance();
        //cal.set(2016, 5, 21);
        //GolfRange.getInstance().getSessions().addSession(cal, "Whitely", condition);

        //Session session = GolfRange.getInstance().getSessions().getSession(0);
        //Shot shot = new Shot(-2, 90, Shot.Contact.CLEAN, Shot.Tee.MAT);
        //session.addShot("Sand Wedge", shot);

        //GolfRange.getInstance().getSessions().removeSession(cal, "Whitely");

        //cal.set(2017, 1, 14);
        //GolfRange.getInstance().getSessions().removeSession(cal, "Whitely");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        GolfRange.getInstance().save(mDataDirectory);
    }
}
