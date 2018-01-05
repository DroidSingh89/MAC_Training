package com.example.user.rxjava.data.remote;

import com.example.user.rxjava.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by singh on 10/12/17.
 */

public interface RemoteService {


    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String username);


}
