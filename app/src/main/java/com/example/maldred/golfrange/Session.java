package com.example.maldred.golfrange;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maldred on 01/01/17.
 */

public class Session
{
    private Date mDate;
    private Location mLocation;
    private Conditions mConditions;
    private List<ClubShots> mClubShots;

    public Session(Date date, Location location, Conditions conditions)
    {
        mDate = date;
        mLocation = location;
        mConditions = conditions;

        mClubShots = new ArrayList<ClubShots>();
    }

    public Date date()
    {
        return mDate;
    }

    public Location location()
    {
        return mLocation;
    }

    public Conditions conditions()
    {
        return mConditions;
    }

    public int numClubsUsed()
    {
        return mClubShots.size();
    }

    public boolean addShot(Club club, Shot shot)
    {
        boolean ret_val=false;
        int index = findClub(club);

        if (index == -1)
        {
            mClubShots.add(new ClubShots(club));
            index = findClub(club);
        }

        if (index!=-1)
        {
            ret_val = mClubShots.get(index).addShot(shot);
        }

        return ret_val;
    }

    public ClubShots getClubShots(int index)
    {
        ClubShots c = null;

        if ((index >=0) && (index < numClubsUsed()))
        {
            c = mClubShots.get(index);
        }

        return c;
    }

    public boolean load()
    {
        return true;
    }

    public boolean save()
    {
        return true;
    }

    private int findClub(Club club)
    {
        int i=0;
        boolean found = false;

        while ((i<numClubsUsed()) && (found==false))
        {
            if (mClubShots.get(i).clubName() == club.name())
            {
                found = true;
            }
            else
            {
                i++;
            }
        }

        if (found==false)
        {
            i=-1;
        }

        return i;
    }
}