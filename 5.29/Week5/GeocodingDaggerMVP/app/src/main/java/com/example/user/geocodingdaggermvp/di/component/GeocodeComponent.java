package com.example.user.geocodingdaggermvp.di.component;

import com.example.user.geocodingdaggermvp.di.module.GeocodeModule;
import com.example.user.geocodingdaggermvp.view.geocode.GeocodeActivity;

import dagger.Component;

//Step 2: Create a contract
// for dependencies and dependent

//Component knows the source of
// dependent from the module class
@Component(modules = GeocodeModule.class)
public interface GeocodeComponent {

//    target for dependencies
    void inject(GeocodeActivity geocodeActivity);
}
