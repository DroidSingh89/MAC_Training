package com.example.user.mvp.di.mainactivity;

import com.example.user.mvp.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 10/20/17.
 */


//denote the module with @module annotation
@Module
public class MainActivityModule {


    //provides the MainActivityPresenter object by this method
    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }





}
