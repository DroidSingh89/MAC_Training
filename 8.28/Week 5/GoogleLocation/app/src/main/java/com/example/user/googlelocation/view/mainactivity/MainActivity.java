package com.example.user.googlelocation.view.mainactivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.googlelocation.view.mapsactivity.MapsActivity;
import com.example.user.googlelocation.R;
import com.example.user.googlelocation.data.remote.ApiProvider;
import com.example.user.googlelocation.model.GeocodeResponse;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements LocationListener, MainActivityContract.View {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 12;
    private static final String TAG = "MainActivityTag";

    FusedLocationProviderClient fusedLocationProviderClient;

    Location currentLocation;
    private TextView tvCurrentLocation;
    private MainActivityPresenter presenter;
    private TextView tvCurrentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        presenter = new MainActivityPresenter();
        presenter.attachView(this);

        bindViews();
        checkPermissions();

    }

    private void bindViews() {
        tvCurrentAddress = findViewById(R.id.tvAddress);
        tvCurrentLocation = findViewById(R.id.tvLocation);
    }

    private void checkPermissions() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            }
        } else {
            presenter.getLocation();
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

                    presenter.getLocation();

                } else {

                    Toast.makeText(this, "Need this location", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.d(TAG, "onLocationChanged: " + location.toString());
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

    public void goToMaps(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", currentLocation);
        startActivity(intent);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void setLocation() {

        fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this);

        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        Log.d(TAG, "onSuccess: " + location.toString());
                        tvCurrentLocation.setText(location.toString());
                        currentLocation = location;

                        presenter.getCurrentAddress(location);
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });

        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000, 100, this);


    }

    @Override
    public void setAddress(String address) {
        tvCurrentAddress.setText(address);
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
