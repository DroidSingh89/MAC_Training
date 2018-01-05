package com.example.user.mvp_dagger.data.remote;

import com.example.user.mvp_dagger.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by singh on 12/19/17.
 */

public interface RemoteService {

    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);
}
