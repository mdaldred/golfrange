package com.example.maldred.golfrange;

import java.io.Serializable;

/**
 * Created by maldred on 01/01/17.
 */

public class ClubShots implements Serializable
{
    private String mClub;
    private Shots mShots;

    public ClubShots(String club)
    {
        mClub = club;
        mShots = new Shots();
    }

    public String clubName()
    {
        return mClub;
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

    public boolean removeShot(int index) { return mShots.removeShot(index); }

    public int numShots() { return mShots.getNumShots(); }

    public Shot getShot(int index) { return mShots.getShot(index); }
}
