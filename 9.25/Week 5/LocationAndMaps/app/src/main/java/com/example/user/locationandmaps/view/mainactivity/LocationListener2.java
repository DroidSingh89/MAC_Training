package com.example.user.locationandmaps.view.mainactivity;

import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.LocationListener;

/**
 * Created by singh on 10/24/17.
 */

public class LocationListener2 implements LocationListener{


    private static final String TAG = "LocationListener2";

    @Override
    public void onLocationChanged(Location location) {

        Log.d(TAG, "onLocationChanged: " + location.toString());
    }
}
