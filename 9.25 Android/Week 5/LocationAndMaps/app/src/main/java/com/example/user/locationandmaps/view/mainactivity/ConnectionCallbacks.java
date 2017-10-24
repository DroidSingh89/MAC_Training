package com.example.user.locationandmaps.view.mainactivity;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 10/24/17.
 */

public class ConnectionCallbacks
        implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    public static final String TAG = "ConnectionCallbacks";
    GoogleApiClient googleApiClient;
    private Location location;


    public ConnectionCallbacks(GoogleApiClient googleApiClient) {
        this.googleApiClient = googleApiClient;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if(googleApiClient==null)
            Log.d(TAG, "onConnected: is null");
        //location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            Log.d(TAG, "onConnected: " + location.toString());
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Log.d(TAG, "onConnectionFailed: "+ connectionResult.getErrorMessage());
    }
}
