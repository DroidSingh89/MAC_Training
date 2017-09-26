package com.example.user.mvp_dagger.injection.utils;

import com.example.user.mvp_dagger.view.mainactivity.MainActivityPresenter;

import dagger.Component;

/**
 * Created by singh on 9/26/17.
 */

@Component(modules = UtilityModule.class)
public interface UtilityComponent {

    void injectSecondPresenter(Object object);
    void injectMainPresenter(MainActivityPresenter object);
    void inject(Object object);

}
