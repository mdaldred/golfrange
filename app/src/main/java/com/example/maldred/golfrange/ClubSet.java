package com.example.maldred.golfrange;

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

    public boolean load(File dir)
    {
        boolean success = true;


        // get the directory for the clubs data
        File clubsDir = new File(dir,"clubs");
        if (clubsDir.exists())
        {
            // now create the actual file for the clubs data
            File clubsFile = new File(clubsDir+"/", "clubs.txt");
            if (clubsFile.exists())
            {
                ObjectInputStream input = null;
                try
                {
                    input = new ObjectInputStream(new FileInputStream(clubsFile));
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
                        mClubs = (ArrayList<Club>) input.readObject();
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
                // there is no clubs data file
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

            // get a directory for the clubs data
            File clubsDir = new File(dir,"clubs");
            clubsDir.mkdir();

            if (clubsDir.exists())
            {
                // now create the actual file for the clubs data
                File clubsFile = new File(clubsDir + "/", "clubs.txt");
                clubsFile.createNewFile();

                if (clubsFile.exists())
                {
                    out = new ObjectOutputStream(new FileOutputStream(clubsFile));
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
                out.writeObject(mClubs);
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
}
