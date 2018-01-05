package com.example.singh.mvp_dagger.injection.mainactivity;

import com.example.singh.mvp_dagger.view.activites.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 7/12/17.
 */


@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
