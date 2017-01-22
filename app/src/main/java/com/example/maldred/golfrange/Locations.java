package com.example.maldred.golfrange;

import android.os.Environment;
import android.util.Log;

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

/**
 * Created by maldred on 02/01/17.
 */

public class Locations
{
    ArrayList<Location> mLocations;

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

    public boolean load(File dir)
    {
        boolean success = true;


        // get the directory for the locations data
        File locationsDir = new File(dir,"locations");
        if (locationsDir.exists())
        {
            // now create the actual file for the locations data
            File locationsFile = new File(locationsDir+"/", "locations.txt");
            if (locationsFile.exists())
            {
                ObjectInputStream input = null;
                try
                {
                    input = new ObjectInputStream(new FileInputStream(locationsFile));
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
                        mLocations = (ArrayList<Location>) input.readObject();
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
                // there is no locations data file
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

            // get a directory for the locations data
            File locationsDir = new File(dir,"locations");
            locationsDir.mkdir();

            // now create the actual file for the locations data
            File locationsFile = new File(locationsDir+"/", "locations.txt");
            if (locationsFile.exists())
            {
                out = new ObjectOutputStream(new FileOutputStream(locationsFile));
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
                out.writeObject(mLocations);
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
