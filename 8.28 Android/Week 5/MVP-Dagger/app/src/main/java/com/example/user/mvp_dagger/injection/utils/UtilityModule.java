package com.example.user.mvp_dagger.injection.utils;

import com.example.user.mvp_dagger.utils.DatabaseHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 9/26/17.
 */

@Module
public class UtilityModule {

    @Provides
    DatabaseHelper getDatabaseHelper() {
        return new DatabaseHelper();
    }

}
