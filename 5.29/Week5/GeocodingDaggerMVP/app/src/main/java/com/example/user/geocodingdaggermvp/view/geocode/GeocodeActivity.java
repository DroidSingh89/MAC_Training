package com.example.user.geocodingdaggermvp.view.geocode;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.geocodingdaggermvp.R;
import com.example.user.geocodingdaggermvp.di.component.DaggerGeocodeComponent;


import javax.inject.Inject;

public class GeocodeActivity extends AppCompatActivity implements GeocodeContract.View {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    private static final String TAG = GeocodeActivity.class.getSimpleName();
    private TextView tvLocation;
    private TextView tvAddress;

    //    Step 4: inject presenter
    @Inject
    GeocodePresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tvLocation);
        tvAddress = findViewById(R.id.tvAddress);

//        Step 3: initialize dagger component
        DaggerGeocodeComponent
                .create()
                .inject(this);


//        presenter = new GeocodePresenter();
        presenter.attachView(this);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "onCreate: permission not granted");
            // Permission is not granted
            // Should we show
            // an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user asynchronously -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Log.d(TAG, "onCreate: Show explaination");
                showExplaination();
            } else {
                // No explanation needed; request the permission
                requestPermission();
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Log.d(TAG, "onCreate: permission already granted");
            presenter.getCurrentLocation();

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
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    presenter.getCurrentLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Log.d(TAG, "onRequestPermissionsResult: permission denied");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


    public void showExplaination() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Explaination")
                .setMessage("I NEED THIS PERMISSION!!")
                .setNegativeButton("Nooo!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Bummer!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Alright", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermission();
                    }
                });

        builder.create().show();
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_LOCATION);
        Log.d(TAG, "onCreate: Request permission");

    }

    @Override
    public void onLocationReceived(Location location) {

        Log.d(TAG, "onLocationReceived: " + location.toString());
        Toast.makeText(getApplicationContext(), location.toString(), Toast.LENGTH_SHORT).show();

        tvLocation.setText(location.toString());
    }

    @Override
    public void onAddressReceived(String address) {

        tvAddress.setText(address);

    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void onButtonClicked(View view) {
        presenter.getAddress();
    }
}
