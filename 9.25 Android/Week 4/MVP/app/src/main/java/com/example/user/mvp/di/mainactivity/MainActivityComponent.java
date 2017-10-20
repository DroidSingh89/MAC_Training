package com.example.user.mvp.di.mainactivity;

import com.example.user.mvp.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 10/20/17.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
