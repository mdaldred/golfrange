package com.example.maldred.golfrange;

/**
 * Created by maldred on 01/01/17.
 */

public class ClubShots
{
    private Club mClub;
    private Shots mShots;

    public ClubShots(Club club)
    {
        mClub = club;
    }

    public String clubName()
    {
        return mClub.name();
    }

    public boolean addShot(Shot shot)
    {
        return mShots.addShot(shot);
    }

    public boolean addShot(float direction, float distance, Shot.Contact contact, Shot.Tee tee)
    {
        return mShots.addShot(new Shot(direction, distance, contact, tee));
    }

    public boolean removeShot(Shot shot)
    {
        return mShots.removeShot(shot);
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
