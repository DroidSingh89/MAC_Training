package com.example.user.mvp_dagger.injection.mainactivity;

import android.hardware.fingerprint.FingerprintManager;

import com.example.user.mvp_dagger.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 8/21/17.
 */


@Module
public class MainActivityModule {


    @Provides
    MainActivityPresenter providesMainActivityPresenter(){

        return new MainActivityPresenter();
    }

}
