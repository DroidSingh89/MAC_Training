package com.example.user.locationandmaps.di;

import com.example.user.locationandmaps.data.DatabaseHelper;
import com.example.user.locationandmaps.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 10/24/17.
 */

@Module
public class MainModule {

    DatabaseHelper databaseHelper;

    public MainModule(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){

        return new MainActivityPresenter(databaseHelper);
    }

    @Provides
    DatabaseHelper providesDatabaseHelper(){
        return new DatabaseHelper();
    }

}
