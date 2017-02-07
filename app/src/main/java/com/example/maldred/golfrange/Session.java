package com.example.maldred.golfrange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by maldred on 01/01/17.
 */

public class Session implements Serializable
{
    private Calendar mDate;
    private String mLocation;
    private Conditions mConditions;
    private List<ClubShots> mClubShots;

    public Session(Calendar date, String location, Conditions conditions)
    {
        mDate = date;
        mLocation = location;
        mConditions = conditions;

        mClubShots = new ArrayList<ClubShots>();
    }

    public Calendar date()
    {
        return mDate;
    }

    public String location()
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

    public boolean addShot(String club, float direction, float distance, Shot.Contact contact, Shot.Tee tee)
    {
        Shot shot = new Shot(direction, distance, contact, tee);

        return addShot(club, shot);
    }

    public boolean addShot(String club, Shot shot)
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

    public ClubShots getClubShots(String club)
    {
        ClubShots c = null;

        int index = findClub(club);
        if (index != -1)
        {
            c = getClubShots(index);
        }

        return c;

    }

    private int findClub(String club)
    {
        int i=0;
        boolean found = false;

        while ((i<numClubsUsed()) && (found==false))
        {
            if (mClubShots.get(i).clubName() == club)
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