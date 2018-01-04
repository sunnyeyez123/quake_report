package com.example.android.quakereport;

/**
 * Created by Jasmine on 1/2/18.
 */

public class Earthquake {

    String mLocation, mUrl;
    long mDate;
    double mMagnitude;

    public Earthquake(String location, long date, double magnitude, String url){
        mDate=date;
        mLocation=location;
        mMagnitude=magnitude;
        mUrl=url;

    }


    public String getLocation() {
        return mLocation;
    }
    public String getUrl() {
        return mUrl;
    }


    public long getDate() {
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
