package com.example.user.rxjava.data.remote;

import com.example.user.rxjava.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by singh on 11/29/17.
 */

public class RemoteDataSource {

    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //add converter to parse the response
                .addConverterFactory(GsonConverterFactory.create())
                //add call adapter to convert the response to rxjava observable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public static Observable<List<Repo>> getUserRepos(String username){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getRepos(username);

    }


}
