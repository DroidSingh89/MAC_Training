package com.example.user.makingrestcalls.data.remote;

import com.example.user.makingrestcalls.model.github.GithubResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by singh on 12/18/17.
 */

public class RemoteDataSource {

    public static final String BASE_URL = "https://api.github.com/";
    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<GithubResponse> getUser(String user){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getUser(user);
    }


    //create an interface to use the HTTP verbs for REST
    public interface RemoteService{

        @GET("users/{user}")
        Call<GithubResponse> getUser(@Path("user") String user);
    }


}
