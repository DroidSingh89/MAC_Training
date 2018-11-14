package com.example.user.mvp.di;

import com.example.user.mvp.ui.main.MainPresenter;
import com.example.user.mvp.util.StringManipulator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//provides dependencies to the components
@Module
public class MainModule {


//    since the MainPresenter is dependent on the StringManipulator class, it will
//    be passed as the argument of the method
    @Provides
    @Singleton
    MainPresenter providesMainPresenter(StringManipulator stringManipulator) {
        return new MainPresenter(stringManipulator);
    }

    @Provides
    StringManipulator providesStringManipulator() {
        return new StringManipulator();
    }




}
