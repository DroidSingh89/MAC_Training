package com.example.user.makingrestcalls;

import com.example.user.makingrestcalls.model.github.GithubRepo;
import com.example.user.makingrestcalls.model.github.Owner;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by singh on 9/18/17.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://api.github.com/";

    //create and initialize the retrofit instance
    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    //create a static method to use the interface verbs
    public static Call<List<GithubRepo>> createCall(String user) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getGithubRepos(user);
    }

    public static Call<Owner> createCallUser(String user) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getGithubProfile(user);
    }



    //create an interface to have all the paths and verbs for the REST api to use
    interface ApiService {

        @GET("users/{user}/repos")
        Call<List<GithubRepo>> getGithubRepos(@Path("user") String user);

        @GET("users/{user}")
        Call<Owner> getGithubProfile(@Path("user") String user);

    }

}
