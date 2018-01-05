package com.example.user.savingdatafirebase.injection.mainactivity;

import com.example.user.savingdatafirebase.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by singh on 8/22/17.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void insert(MainActivity mainActivity);


}
