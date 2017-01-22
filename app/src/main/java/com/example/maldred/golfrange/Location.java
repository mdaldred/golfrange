package com.example.maldred.golfrange;

import java.io.Serializable;

/**
 * Created by maldred on 02/01/17.
 */

public class Location implements Serializable
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
