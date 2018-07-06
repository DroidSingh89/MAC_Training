package com.example.user.geocodingdaggermvp.di.module;

import android.app.Activity;

import com.example.user.geocodingdaggermvp.manager.LocationManager;
import com.example.user.geocodingdaggermvp.view.geocode.GeocodeActivity;
import com.example.user.geocodingdaggermvp.view.geocode.GeocodePresenter;

import dagger.Module;
import dagger.Provides;

//Step 1: add dependencies to module
@Module
public class GeocodeModule {


    @Provides
    GeocodePresenter providesGeocodePresenter(LocationManager locationManager) {
        return new GeocodePresenter(locationManager);

    }

    @Provides
    LocationManager providesLocationManager() {
        return new LocationManager();
    }


}
