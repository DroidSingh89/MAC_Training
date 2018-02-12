package com.example.user.mvp_dagger.di;

import com.example.user.mvp_dagger.view.main.MainActivity;

import dagger.Component;

/**
 * Created by singh on 2/9/18.
 */

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
