package com.example.user.androidnetworking.di;


import com.example.user.androidnetworking.model.data.RandomRepository;
import com.example.user.androidnetworking.model.data.local.LocalDataSource;
import com.example.user.androidnetworking.model.data.remote.RemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    LocalDataSource providesLocalDataSource() {
        return new LocalDataSource();
    }

    @Provides
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    RandomRepository providesRandomRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new RandomRepository(localDataSource, remoteDataSource);
    }

}
