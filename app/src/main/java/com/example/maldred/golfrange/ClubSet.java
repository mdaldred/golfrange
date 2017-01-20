package com.example.maldred.golfrange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maldred on 01/01/17.
 */

public class ClubSet
{
    private List<Club> mClubs;

    public ClubSet()
    {
        mClubs = new ArrayList<Club>();
    }

    public int numClubs()
    {
        return mClubs.size();
    }

    public Club getClub(int index)
    {
        Club c = null;

        if ((index >= 0) && (index<mClubs.size()))
        {
            c = mClubs.get(index);
        }

        return c;
    }

    public boolean addClub(Club club)
    {
        return mClubs.add(club);
    }

    public boolean addClub(String name, float dist, float range)
    {
        Club c = new Club(name, dist, range);
        return mClubs.add(c);
    }

    public boolean removeClub(Club club)
    {
        return mClubs.remove(club);
    }

    public boolean removeClub(String name)
    {
        boolean found = false;
        int i=0;

        while ((i<numClubs()) && (found==false))
        {
            if (mClubs.get(i).name() == name)
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
            mClubs.remove(i);
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
