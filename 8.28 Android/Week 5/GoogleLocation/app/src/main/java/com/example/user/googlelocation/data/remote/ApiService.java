package com.example.user.googlelocation.data.remote;

import com.example.user.googlelocation.model.GeocodeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by singh on 9/27/17.
 */

public interface ApiService {

    String QUERY_PARAM_LATLNG = "latlng";
    String QUERY_PARAM_KEY = "key";

    @GET("maps/api/geocode/json")
    Observable<GeocodeResponse> getGeocodeResponse(
            @Query(QUERY_PARAM_LATLNG) String location
            , @Query(QUERY_PARAM_KEY) String key);


}
