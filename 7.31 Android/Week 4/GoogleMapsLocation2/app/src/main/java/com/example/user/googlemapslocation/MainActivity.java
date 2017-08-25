package com.example.user.googlemapslocation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.location.Criteria;

import com.example.user.googlemapslocation.model.AddressResponse;
import com.google.android.gms.location.FusedLocationProviderClient;
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

public class MainActivity extends AppCompatActivity implements LocationListener{

    private static final String TAG = "MainActivityTag";
    FusedLocationProviderClient fusedLocationProviderClient;
    Location currentLocation;
    public static final String GEO_KEY = "AIzaSyAea75UAZHdYIZ-w1dsQ5dIbh6qiaWRmL8";

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();
    }


    private void checkPermissions() {
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
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.

            }
        } else {

            getLocation();

        }
    }

    public void getLocation() {
        Log.d(TAG, "getLocation: ");

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        currentLocation = location;
                        Log.d(TAG, "onSuccess: " + currentLocation.toString());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,100, this);

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

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void handleButtonClicks(View view) {


        switch (view.getId()) {
            case R.id.btnGoToMaps:


                if (currentLocation != null) {
                    Intent intent = new Intent(this, MapsActivity.class);
                    intent.putExtra("location", currentLocation);
                    startActivity(intent);
                }
                break;
            case R.id.btnGetAddress:
                getGeocodeAddress();

                break;
        }

    }

    public void getGeocodeAddress() {

        String currentLatLng = currentLocation.getLatitude() + "," + currentLocation.getLongitude();
        OkHttpClient client = new OkHttpClient();


        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("maps.googleapis.com")
                .addPathSegment("maps")
                .addPathSegment("api")
                .addPathSegment("geocode")
                .addPathSegment("json")
                .addQueryParameter("latlng", currentLatLng)
                .addQueryParameter("key", GEO_KEY)
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


                Log.d(TAG, "onFailure: " + e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                Gson gson = new Gson();

                AddressResponse addressResponse = gson.fromJson(response.body().string(), AddressResponse.class);
                Log.d(TAG, "onResponse: " + addressResponse.getResults().get(0).getFormattedAddress());


            }
        });

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location.toString());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

        Log.d(TAG, "onStatusChanged: " + s);

        switch (i){
            case LocationProvider.AVAILABLE:
                Log.d(TAG, "onStatusChanged: Available");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d(TAG, "onStatusChanged: Out of service");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d(TAG, "onStatusChanged: Temp unavailable");
                break;
        }


    }

    @Override
    public void onProviderEnabled(String s) {

        Log.d(TAG, "onProviderEnabled: " +s);
    }

    @Override
    public void onProviderDisabled(String s) {

        Log.d(TAG, "onProviderDisabled: " + s);
    }
}
