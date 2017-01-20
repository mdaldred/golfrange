package com.example.maldred.golfrange;

/**
 * Created by maldred on 02/01/17.
 */

public class Location
{
    private String mName;

    public Location(String name)
    {
        mName = name;
    }

    public String getName()
    {
        return mName;
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
