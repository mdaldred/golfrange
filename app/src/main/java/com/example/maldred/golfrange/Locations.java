package com.example.maldred.golfrange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maldred on 02/01/17.
 */

public class Locations
{
    List<Location> mLocations;

    public Locations()
    {
        mLocations = new ArrayList<Location>();
    }

    public int numLocations()
    {
        return mLocations.size();
    }

    public boolean addLocation(String name)
    {
        return mLocations.add(new Location(name));
    }

    public boolean removeLocation(String name)
    {
        int i=0;
        boolean found = false;

        while ((i<numLocations()) && (found==false))
        {
            if (mLocations.get(i).getName() == name)
            {
                found = true;
            }
            else
            {
                i++;
            }
        }

        if (found==true)
        {
            mLocations.remove(i);
        }

        return found;
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
