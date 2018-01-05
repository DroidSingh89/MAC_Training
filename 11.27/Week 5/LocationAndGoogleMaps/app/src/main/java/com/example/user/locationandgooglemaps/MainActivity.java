package com.example.user.locationandgooglemaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    private static final String TAG = MainActivity.class.getSimpleName();

    private String[] permissionsToBeAsked;
    private FusedLocationProviderClient providerClient;
    private TextView tvLocation;
    private Location currentLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tvLocation);
        permissionsToBeAsked = new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        checkLocationPermission();
    }

    private void checkLocationPermission() {


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission
                (this, permissionsToBeAsked[0]) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission
                        (this, permissionsToBeAsked[1]) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale
                    (this, permissionsToBeAsked[0]) &&
                    ActivityCompat.shouldShowRequestPermissionRationale
                            (this, permissionsToBeAsked[1])) {

                showExplanation();

            } else {

                // No explanation needed, we can request the permission.
                askPermission();

            }

        } else {
            getLocation();
        }

    }


    @SuppressLint("MissingPermission")
    private void getLocation() {

        //initialize the client
        providerClient = LocationServices.getFusedLocationProviderClient(this);

        //get the location of the device
        providerClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.d(TAG, "onSuccess: " + location.toString());
                        tvLocation.setText(getLocationStr(location));
                        currentLocation = location;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.toString());

                    }
                });


    }

    @NonNull
    private String getLocationStr(Location location) {
        String latitude = String.valueOf(location.getLatitude());
        String longitude = String.valueOf(location.getLongitude());
        return latitude + ":" + longitude;
    }

    private void askPermission() {

        ActivityCompat.requestPermissions(this,
                permissionsToBeAsked,
                MY_PERMISSIONS_REQUEST_LOCATION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                    getLocation();

                } else {

                    Log.d(TAG, "onRequestPermissionsResult: Denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    private void showExplanation() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Location Required")
                .setMessage("You need to allow the location permission otherwise uninstall the app")
                .setNegativeButton("Uninstall", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        uninstallApplication();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        askPermission();
                    }
                })
                .create();
        alertDialog.show();
    }

    private void uninstallApplication() {

        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:com.example.user.locationandgooglemaps"));
        startActivity(intent);
    }

    public void goToMapsActivity(View view) {


        if (currentLocation != null) {

            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("location", currentLocation);
            startActivity(intent);
        } else
            Toast.makeText(this, "No location to show", Toast.LENGTH_SHORT).show();
    }
}
