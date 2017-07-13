package com.example.singh.googlemapslocation;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivityTag";
    private GoogleMap mMap;

    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        currentLocation = getIntent().getParcelableExtra("location");
        Log.d(TAG, "onCreate: " + currentLocation);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        Log.d(TAG, "onMapReady: " + currentLocation);
        LatLng sydney = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

        LatLng location1 = new LatLng(33.422, -127.085);
        LatLng location2 = new LatLng(34.422, -128.085);


        mMap.setMyLocationEnabled(true);


        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(location1).title("Marker in Location1"));
        mMap.addMarker(new MarkerOptions().position(location2).title("Marker in Location2"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
