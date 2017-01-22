package com.example.maldred.golfrange;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maldred on 19/01/17.
 */

public class Sessions
{
    private List<Session> mSessions;

    public Sessions()
    {
        mSessions = new ArrayList<Session>();
    }

    public int numSessions()
    {
        return mSessions.size();
    }

    public Session getSession(int index)
    {
        Session s = null;

        if ((index >= 0) && (index<mSessions.size()))
        {
            s = mSessions.get(index);
        }

        return s;
    }

    public boolean addSession(Session session)
    {
        return mSessions.add(session);
    }

    public boolean addSession(Date date, Location location, Conditions conditions)
    {
        Session s = new Session(date, location, conditions);
        return mSessions.add(s);
    }

    public boolean removeSession(Session session)
    {
        return mSessions.remove(session);
    }

    public boolean removeClub(Date date, Location location)
    {
        boolean found = false;
        int i=0;

        while ((i<numSessions()) && (found==false))
        {
            if ((mSessions.get(i).date() == date) && (mSessions.get(i).location() == location))
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
            mSessions.remove(i);
        }

        return found;
    }

    public boolean load(File dir)
    {
        return true;
    }

    public boolean save(File dir)
    {
        return true;
    }

}
