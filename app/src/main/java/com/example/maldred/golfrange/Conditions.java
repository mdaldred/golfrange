package com.example.maldred.golfrange;

import java.io.Serializable;

/**
 * Created by maldred on 02/01/17.
 */

public class Conditions implements Serializable
{
    public enum WindDir
    {
        N,
        NE,
        E,
        SE,
        S,
        SW,
        W,
        NW
    }

    public enum WindStr
    {
        NONE,
        LIGHT,
        MEDIUM,
        STRONG
    }

    private WindDir mWindDir;
    private WindStr mWindStr;
    private boolean mRaining;

    public Conditions(WindDir dir, WindStr str, boolean raining)
    {
        mWindDir = dir;
        mWindStr = str;
        mRaining = raining;
    }

    public WindDir windDir()
    {
        return mWindDir;
    }

    public WindStr windStr()
    {
        return mWindStr;
    }

    public boolean raining()
    {
        return mRaining;
    }
}
