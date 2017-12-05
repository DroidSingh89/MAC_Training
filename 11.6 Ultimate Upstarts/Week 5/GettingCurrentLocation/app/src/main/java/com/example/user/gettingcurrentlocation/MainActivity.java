package com.example.user.gettingcurrentlocation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    private static final String TAG = "MainActivityTag";
    @BindView(R.id.tvCurrentLocation)
    TextView tvCurrentLocation;
    @BindView(R.id.tvCurrentAddress)
    TextView tvCurrentAddress;
    @BindView(R.id.btnCheckOnMap)
    Button btnGetCurrentAddress;
    private FusedLocationProviderClient fusedLocationProviderClient;



    LocationCallback locationCallback;
    private LocationRequest locationRequest;
    private Location currentLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this);


        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                for (Location location : locationResult.getLocations())
                    Log.d(TAG, "onLocationResult: " + location.toString());

            }
        };
        checkPermission();





    }

    private void checkPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            getLocation();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    getLocation();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    Log.d(TAG, "onRequestPermissionsResult: denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @SuppressLint("MissingPermission")
    public void getLocation() {
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.d(TAG, "onSuccess: " + location.toString());
                        tvCurrentLocation.setText(location.getLatitude() + ":"
                                + location.getLongitude());
                        currentLocation = location;

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });



    }

    @SuppressLint("MissingPermission")
    private void startLocationRequests() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);

        fusedLocationProviderClient.requestLocationUpdates(locationRequest
                , locationCallback, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationRequests();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopLocationRequests();
    }

    private void stopLocationRequests() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    @OnClick(R.id.btnCheckOnMap)
    public void onViewClicked() {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", currentLocation);
        startActivity(intent);

    }
}
