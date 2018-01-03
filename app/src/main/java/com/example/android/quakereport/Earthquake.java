package com.example.android.quakereport;

/**
 * Created by Jasmine on 1/2/18.
 */

public class Earthquake {

    String mLocation, mDate;
    double mMagnitude;

    public Earthquake(String location, String date, double magnitude){
        mDate=date;
        mLocation=location;
        mMagnitude=magnitude;

    }


    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mLocation='" + mLocation + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mMagnitude=" + mMagnitude +
                '}';
    }
}
