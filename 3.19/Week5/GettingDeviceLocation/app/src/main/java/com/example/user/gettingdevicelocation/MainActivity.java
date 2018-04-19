package com.example.user.gettingdevicelocation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity implements PermissionManager.IPermissionManager {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private PermissionManager permissionManager;
    private FusedLocationProviderClient locationProviderClient;
    private LocationCallback mLocationCallback;
    private boolean isRequestingUpdates = false;
    private Location currentlocation;
    private TextView tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new PermissionManager(this);
        permissionManager.checkPermission();

        tvLocation = findViewById(R.id.tvLocation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isRequestingUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.checkResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionResult(boolean isGranted) {
        Log.d(TAG, "onPermissionResult: " + isGranted);
        if (isGranted) {
            isRequestingUpdates = true;
            getLocation();
        }

    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Log.d(TAG, "getLocation: ");
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        locationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.d(TAG, "onSuccess: " + location.toString());
                        currentlocation = location;
                        String locString = location.getLatitude()
                                + " : " + location.getLongitude();
                        tvLocation.setText(locString);
                    }
                });
    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(100);
        locationRequest.setFastestInterval(100);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    Log.d(TAG, "onLocationResult: is null");
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    Log.d(TAG, "onLocationResult: " + location.toString());
                }
            }
        };

        locationProviderClient.requestLocationUpdates(locationRequest, mLocationCallback, null);

    }

    public void stopLocationUpdates() {
        locationProviderClient.removeLocationUpdates(mLocationCallback);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isRequestingUpdates) {

            stopLocationUpdates();
        }
    }

    public void onMaps(View view) {

        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("location", currentlocation);
        startActivity(intent);
    }
}
