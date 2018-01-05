package com.example.user.makingrestcalls;

import com.example.user.makingrestcalls.model.WeatherData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by singh on 8/17/17.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://samples.openweathermap.org/";

    public static final String PATH = "data/2.5/forecast";
    public static final String QUERY_ZIP = "94040";
    public static final String QUERY_APPID = "b1b15e88fa797225412429c1c50c122a1";



    public static Retrofit create(){

        //create a logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //create a custom client to add the interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Call<WeatherData> getWeatherCall(){

        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherdata(QUERY_ZIP, QUERY_APPID);

    }

    public static Observable<WeatherData> getWeatherObs(){

        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherObservable(QUERY_ZIP, QUERY_APPID);

    }

    public interface WeatherService{

        @GET(PATH)
        Call<WeatherData> getWeatherdata(@Query("zip") String zipcode, @Query("appid") String appid);


        @GET(PATH)
        Observable<WeatherData> getWeatherObservable(@Query("zip") String zipcode, @Query("appid") String appid);
    }

}
