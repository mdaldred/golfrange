package com.example.maldred.golfrange;

/**
 * Created by maldred on 01/01/17.
 */

public class Shot
{
    public enum Contact
    {
        CLEAN,
        TOP,
        DIVOT
    }

    public enum Tee
    {
        GRASS,
        TEE,
        MAT
    }

    private float mDirection;
    private float mDistance;
    private Contact mContact;
    private Tee mTee;

    public Shot(float direction, float distance, Contact contact, Tee tee)
    {
        mDirection = direction;
        mDistance = distance;
        mContact = contact;
        mTee = tee;
    }

    public float getDirection()
    {
        return mDirection;
    }

    public float getDistance()
    {
        return mDistance;
    }

    public Contact getContact()
    {
        return mContact;
    }

    public Tee getTee()
    {
        return mTee;
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
