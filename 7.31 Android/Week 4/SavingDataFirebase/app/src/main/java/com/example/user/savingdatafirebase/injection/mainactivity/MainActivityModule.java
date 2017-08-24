package com.example.user.savingdatafirebase.injection.mainactivity;

import com.example.user.savingdatafirebase.view.mainactivity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 8/22/17.
 */

@Module
public class MainActivityModule {



    @Provides
    MainActivityPresenter providesMainActivityPresenter() {

        return new MainActivityPresenter();
    }
}
