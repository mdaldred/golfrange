package com.example.maldred.golfrange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maldred on 01/01/17.
 */
public class Shots
{
    private List<Shot> mShots;

    public Shots()
    {
        mShots = new ArrayList<Shot>();
    }

    public int getNumShots()
    {
        return mShots.size();
    }

    public boolean addShot(Shot shot)
    {
        return mShots.add(shot);
    }

    public boolean removeShot(Shot shot)
    {
        return mShots.remove(shot);
    }

    public Shot getShot(int index)
    {
        Shot s = null;

        if ((index>=0) && (index<getNumShots()))
        {
            s = mShots.get(index);
        }

        return s;
    }

    public float avgDir()
    {
        float sum=0;

        for (int i=0; i<getNumShots(); i++)
        {
            sum += mShots.get(i).getDirection();
        }

        return (sum/getNumShots());
    }

    public float stdDir()
    {
        float mean = avgDir();
        float sum = 0;

        for (int i=0; i<getNumShots(); i++)
        {
            float diff = (mShots.get(i).getDirection() - mean);
            sum += (diff * diff);
        }

        return (float)Math.sqrt((double)sum / (double)getNumShots());
    }

    public float avgDist()
    {
        float sum=0;

        for (int i=0; i<getNumShots(); i++)
        {
            sum += mShots.get(i).getDistance();
        }

        return (sum/getNumShots());
    }

    public float stdDist()
    {
        float mean = avgDist();
        float sum = 0;

        for (int i=0; i<getNumShots(); i++)
        {
            float diff = (mShots.get(i).getDistance() - mean);
            sum += (diff * diff);
        }

        return (float)Math.sqrt((double)sum / (double)getNumShots());
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
