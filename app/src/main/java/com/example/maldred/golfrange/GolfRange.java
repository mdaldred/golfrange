package com.example.maldred.golfrange;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by maldred on 01/01/17.
 */

public class GolfRange
{
    private ClubSet mClubs;
    private Locations mLocations;
    private Sessions mSessions;

    /* Create a singleton of the com.example.maldred.robotinterface.RobotInterface */
    private static GolfRange mInstance = null;
    public static GolfRange getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new GolfRange();
        }

        return mInstance;
    }

    public Locations getLocations()
    {
        return mLocations;
    }

    private GolfRange()
    {
        mLocations = new Locations();
        mClubs = new ClubSet();
        mSessions = new Sessions();
    }

    public void load(File dir)
    {
        mLocations.load(dir);
        mClubs.load(dir);
        mSessions.load(dir);
    }

    public void save(File dir)
    {
        mSessions.save(dir);
        mClubs.save(dir);
        mLocations.save(dir);
    }
}
