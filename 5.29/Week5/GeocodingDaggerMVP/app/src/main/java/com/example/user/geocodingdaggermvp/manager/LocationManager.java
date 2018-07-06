package com.example.user.geocodingdaggermvp.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationManager {

    FusedLocationProviderClient fusedLocationProviderClient;
    LocationListener locationListener;


    public void initialize(Object component, Object listener) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) component);
        this.locationListener = (LocationListener) listener;
    }

    @SuppressLint("MissingPermission")
    public void getLocation() {
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        locationListener.onLocationResults(location);
                    }
                });
    }

    public interface LocationListener {
        void onLocationResults(Location location);
    }


}
