package com.example.user.mvp.di;

import com.example.user.mvp.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

//Contract that connects the Source(Dependencies) and the Target(Dependent)
@Component(modules = MainModule.class)
@Singleton
public interface MainComponent {

//    method to pass the instance of the target for the dependencies
    void inject(MainActivity mainActivity);
}
