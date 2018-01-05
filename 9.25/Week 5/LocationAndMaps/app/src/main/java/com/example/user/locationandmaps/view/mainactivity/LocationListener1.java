package com.example.user.locationandmaps.view.mainactivity;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by singh on 10/24/17.
 */

public class LocationListener1 implements LocationListener {

    private static final String TAG = "LocationListener1";

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: "+ location.toString());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
