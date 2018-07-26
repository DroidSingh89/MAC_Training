package com.example.user.locationandmaps;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements
        PermissionManager.Callback,
        LocationManager.Callback {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private LocationManager locationManager;
    private PermissionManager permissionManager;
    private TextView tvLocation;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tvLocation);
        permissionManager = new PermissionManager(this);
        permissionManager.setPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        locationManager = new LocationManager(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        permissionManager.checkPermission();
        locationManager.startLocationUpdates();

    }

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.stopLocationUpdates();
    }

    @Override
    public void onPermissionResults(int requestCode, boolean isGranted) {

        if (isGranted) {

            locationManager.getCurrentLocation();

        }

    }

    @Override
    public void onLocationResults(Location location) {
        this.location = location;

        Log.d(TAG, "onLocationResults: " + location.toString());
        String latLng = String.valueOf(location.getLatitude())
                + ","
                + String.valueOf(location.getLongitude());
        tvLocation.setText(latLng);
        Toast.makeText(this, "Location updated", Toast.LENGTH_SHORT).show();

    }

    public void onMapsActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);

    }
}
