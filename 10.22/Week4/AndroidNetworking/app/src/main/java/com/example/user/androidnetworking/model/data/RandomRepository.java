package com.example.user.androidnetworking.model.data;

import com.example.user.androidnetworking.CacheManager;
import com.example.user.androidnetworking.model.data.local.LocalDataSource;
import com.example.user.androidnetworking.model.data.remote.RemoteDataSource;
import com.example.user.androidnetworking.model.data.remote.RemoteObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RandomRepository {

    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;

    public RandomRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }


    public void getRandomUsers(String gender, int results, final RandomCallback callback){

//        if cache is dirty make the network call
        if (CacheManager.isCacheDirty()) {
            remoteDataSource.getRandomUserObs(gender, results)
//                    make the network call on the worker thread
                    .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RemoteObserver(callback));
        }


    }
}
