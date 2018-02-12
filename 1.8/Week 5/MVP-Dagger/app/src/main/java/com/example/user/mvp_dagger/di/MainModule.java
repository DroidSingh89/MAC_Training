package com.example.user.mvp_dagger.di;

import com.example.user.mvp_dagger.view.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 2/9/18.
 */

@Module
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }
}
