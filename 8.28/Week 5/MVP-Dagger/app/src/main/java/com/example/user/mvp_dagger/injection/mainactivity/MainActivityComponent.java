package com.example.user.mvp_dagger.injection.mainactivity;

import android.app.Activity;

import com.example.user.mvp_dagger.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 9/26/17.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    //inject the activity reference for the object graph
    void inject(MainActivity mainActivity);

}
