package com.example.user.locationandmaps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationManager {

    Context context;
    Callback callback;
    FusedLocationProviderClient client;
    private boolean requestingLocationUpdates;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;


    public LocationManager(Context context) {
        this.context = context;
        this.callback = (Callback) context;
        client = LocationServices.getFusedLocationProviderClient(context);

    }


    @SuppressLint("MissingPermission")
    public void getCurrentLocation() {

        client.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        callback.onLocationResults(location);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        callback.onLocationResults(null);

                    }
                });

    }

    public void getLocationUpdates() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(500);
        locationRequest.setFastestInterval(500);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(context);

        settingsClient.checkLocationSettings(builder.build())
                .addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                        requestingLocationUpdates = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        requestingLocationUpdates = false;

                    }
                });

    }

    @SuppressLint("MissingPermission")
    public void startLocationUpdates() {
        getLocationUpdates();

        if (true) {

            locationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                    for (Location location : locationResult.getLocations()) {
                        callback.onLocationResults(location);
                    }
                }
            };
            client.requestLocationUpdates(locationRequest, locationCallback, null);

        }
    }

    public void stopLocationUpdates() {
        client.removeLocationUpdates(locationCallback);
    }


    public interface Callback {
        void onLocationResults(Location location);

    }
}
