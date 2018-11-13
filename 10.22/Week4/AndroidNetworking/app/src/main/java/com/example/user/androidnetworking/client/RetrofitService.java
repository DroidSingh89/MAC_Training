package com.example.user.androidnetworking.client;

import com.example.user.androidnetworking.model.RandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("/api")
    Call<RandomResponse> getRandomUser(@Query("gender") String gender, @Query("results") int results);

}
