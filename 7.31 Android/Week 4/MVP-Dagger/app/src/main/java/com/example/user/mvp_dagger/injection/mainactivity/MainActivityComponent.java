package com.example.user.mvp_dagger.injection.mainactivity;

import com.example.user.mvp_dagger.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 8/21/17.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
