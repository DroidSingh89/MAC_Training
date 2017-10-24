package com.example.user.locationandmaps.di;

import com.example.user.locationandmaps.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 10/24/17.
 */

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
