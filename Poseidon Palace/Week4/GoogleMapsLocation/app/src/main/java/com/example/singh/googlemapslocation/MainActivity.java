package com.example.singh.googlemapslocation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.singh.googlemapslocation.googleaddress.AddressResponse;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements android.location.LocationListener {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    private static final String TAG = "MainActivityTag";

    private FusedLocationProviderClient fusedLocationProviderClient;

    private Location currentLocation;

    EditText etStreet, etCity, etState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "onCreate: permissions not granted");

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                Log.d(TAG, "onCreate: we need this");
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.


            } else {

                // No explanation needed, we can request the permission.

                Log.d(TAG, "onCreate: requesting permissions");
                String[] permissions = new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION
                        , Manifest.permission.ACCESS_FINE_LOCATION};

                ActivityCompat.requestPermissions(this, permissions, MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
                return;
            }

        }
        requestLocation();


        etStreet = (EditText) findViewById(R.id.etStreetAddress);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState);

    }

    private void requestLocation() {

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.d(TAG, "onSuccess: " + location);
                        currentLocation = location;
                        Log.d(TAG, "onSuccess: current" + currentLocation);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this);

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
                    Log.d(TAG, "onRequestPermissionsResult: granted");
                    requestLocation();

                } else {

                    Log.d(TAG, "onRequestPermissionsResult: not granted");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

        String status = "";
        switch (i) {
            case LocationProvider.AVAILABLE:
                status = "Available";
                break;
            case LocationProvider.OUT_OF_SERVICE:
                status = "Out_of_service";
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                status = "Temp out of service";
                break;

        }


        Log.d(TAG, "onStatusChanged: " + s + " " + status);


    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(TAG, "onProviderEnabled: ");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(TAG, "onProviderDisabled: ");
    }

    public void goToMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        Log.d(TAG, "goToMaps: " + currentLocation);
        intent.putExtra("location", currentLocation);
        startActivity(intent);


    }

    public void geocodeAddress(View view) {


        String address = etStreet.getText().toString()
                + " " + etCity.getText().toString()
                + " " + etState.getText().toString();

        Log.d(TAG, "geocodeAddress: "+ address);

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("maps.googleapis.com")
                .addPathSegment("maps")
                .addPathSegment("api")
                .addPathSegment("geocode")
                .addPathSegment("json")
                .addQueryParameter("address", address)
                .addQueryParameter("key", "AIzaSyA-a8S35baJwQTXpzNoQGzqSiL6P3o3D7A")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.d(TAG, "onFailure: "+ e.toString());
            }

            @Override
            public void onResponse(Call call, Response response)  {

                Gson gson = new Gson();


                AddressResponse addressResponse = null;
                try {
                    addressResponse = gson.fromJson(response.body().string(), AddressResponse.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onResponse: latitude " + addressResponse.getResults().get(0).getGeometry().getLocation().getLat());
                Log.d(TAG, "onResponse: longitude " + addressResponse.getResults().get(0).getGeometry().getLocation().getLng());

            }
        });


    }
}
