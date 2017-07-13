package com.example.singh.makingrestcalls;

import android.util.Log;

import com.example.singh.makingrestcalls.model.weather.Weather;
import com.example.singh.makingrestcalls.model.weather.Weatherdata;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by singh on 7/11/17.
 */

public class RetrofitHelper {


    private static String Base_URL = "http://samples.openweathermap.org/";
    public static final String QUERY_ZIP = "92591";
    public static final String QUERY_APPID = "b1b15e88fa797225412429c1c50c122a1";

    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;


    }

    public static Call<Weatherdata> callWeatherData() {
        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherData(QUERY_ZIP, QUERY_APPID);

    }


    public interface WeatherService {

        @GET("data/2.5/forecast")
        Call<Weatherdata> getWeatherData(@Query("zip") String zip, @Query("appid") String appid);


    }


}
