package com.example.user.mvp_dagger.injection.mainactivity;

import com.example.user.mvp_dagger.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 9/26/17.
 */

@Module
public class MainActivityModule {


    //add the dependencies using the @provides for each method
    @Provides
    MainActivityPresenter getMainActivityPresenter() {
        return new MainActivityPresenter();
    }



}
