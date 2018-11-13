package com.example.user.androidnetworking.model.data.remote;

import com.example.user.androidnetworking.model.randomresponse.RandomResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

//    using the call object
    @GET("/api")
    Call<RandomResponse> getRandomUser(@Query("gender") String gender, @Query("results") int results);


    //    using the rxjava observable
    @GET("/api")
    Observable<RandomResponse> getRandomUserObs(@Query("gender") String gender, @Query("results") int results);
}
