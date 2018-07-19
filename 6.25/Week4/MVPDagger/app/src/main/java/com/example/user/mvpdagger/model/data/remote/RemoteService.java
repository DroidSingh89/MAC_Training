package com.example.user.mvpdagger.model.data.remote;

import com.example.user.mvpdagger.model.github.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RemoteService {

    @GET("users/{username}/repos")
    Observable<List<Repo>> getRepos(@Path("username") String username);


}
