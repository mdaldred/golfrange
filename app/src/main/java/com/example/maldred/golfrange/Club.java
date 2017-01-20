package com.example.maldred.golfrange;

import android.content.SharedPreferences;

/**
 * Created by maldred on 01/01/17.
 */

public class Club
{
    String mName;
    float mDist;
    float mRange;

    public Club(String name, float dist, float range)
    {
        mName = name;
        mDist = dist;
        mRange = range;
    }

    public String name()
    {
        return mName;
    }

    public float dist()
    {
        return mDist;
    }

    public float minDist()
    {
        return (mDist - mRange);
    }

    public float maxDist()
    {
        return (mDist + mRange);
    }

    public boolean load()
    {
        return true;
    }

    public boolean save()
    {

        return true;
    }
}
