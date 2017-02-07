package com.example.maldred.golfrange;

import android.text.format.DateUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Calendar;
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

    public boolean addSession(Calendar date, String location, Conditions conditions)
    {
        Session s = new Session(date, location, conditions);
        return mSessions.add(s);
    }

    public boolean removeSession(Session session)
    {
        return mSessions.remove(session);
    }

    public boolean removeSession(Calendar date, String location)
    {
        boolean found = false;
        int i=0;

        while ((i<numSessions()) && (found==false))
        {
            if ((isSameDay(mSessions.get(i).date(), date)) && (mSessions.get(i).location().equals(location)))
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

        boolean success = true;

        // get the directory for the session data
        File sessionsDir = new File(dir,"sessions");
        if (sessionsDir.exists())
        {
            // now create the actual file for the sessions data
            File sessionsFile = new File(sessionsDir+"/", "sessions.txt");
            if (sessionsFile.exists())
            {
                ObjectInputStream input = null;
                try
                {
                    input = new ObjectInputStream(new FileInputStream(sessionsFile));
                } catch (StreamCorruptedException e)
                {
                    e.printStackTrace();
                    success = false;
                } catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                    success = false;
                } catch (IOException e)
                {
                    e.printStackTrace();
                    success = false;
                }
                if (success == true)
                {
                    try
                    {
                        mSessions = (ArrayList<Session>) input.readObject();
                    } catch (OptionalDataException e)
                    {
                        e.printStackTrace();
                        success = false;
                    } catch (ClassNotFoundException e)
                    {
                        e.printStackTrace();
                        success = false;
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        success = false;
                    }
                    try
                    {
                        input.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        success = false;
                    }
                }
            }
            else
            {
                // there is no sessions data file
                success = false;
            }
        }
        else
        {
            // there is no data directory
            success = false;
        }

        return success;
    }

    public boolean save(File dir)
    {
        boolean success = true;

        ObjectOutput out = null;

        try {

            // get a directory for the sessions data
            File sessionsDir = new File(dir,"sessions");
            sessionsDir.mkdir();

            if (sessionsDir.exists())
            {
                // now create the actual file for the sessions data
                File sessionsFile = new File(sessionsDir + "/", "sessions.txt");
                sessionsFile.createNewFile();

                if (sessionsFile.exists())
                {
                    out = new ObjectOutputStream(new FileOutputStream(sessionsFile));
                }
                else
                {
                    success = false;
                }
            }
            else
            {
                success = false;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            success = false;
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }

        if (success==true)
        {
            try
            {
                out.writeObject(mSessions);
            } catch (IOException e)
            {
                success = false;
                e.printStackTrace();
            }

            try
            {
                out.close();
            } catch (IOException e)
            {
                e.printStackTrace();
                success = false;
            }
        }

        return success;
    }

    private boolean isSameDay(Calendar d1, Calendar d2)
    {
        boolean same = false;

        if ((d1 != null) && (d2 != null))
        {
            if (d1.get(Calendar.YEAR) == d2.get(Calendar.YEAR))
            {
                if (d1.get(Calendar.DAY_OF_YEAR) == d2.get(Calendar.DAY_OF_YEAR))
                {
                    same = true;
                }
            }
        }

        return same;
    }
}
