package com.example.user.geocodingdaggermvp.model.datasource;

import com.example.user.geocodingdaggermvp.model.response.GeocodeResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RemoteDataSource {


    private static final String BASEURL = "https://maps.googleapis.com/";
    public static final String KEY = "AIzaSyBqHzNQSKdx2WkUbVLpfwTgRdtgEgiGlL8";

    public static Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<GeocodeResponse> getResponse(String latlng) {
        RemoteService remoteService = createRetrofit().create(RemoteService.class);
        return remoteService.getGeocodeResponse(latlng, KEY);
    }


    interface RemoteService {

        @GET("maps/api/geocode/json")
        Observable<GeocodeResponse> getGeocodeResponse(@Query("latlng") String latlng, @Query("key") String key);
    }








}
