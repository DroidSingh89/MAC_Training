package com.example.singh.makingrestcalls;

import android.util.Log;

import com.example.singh.makingrestcalls.model.googleplaces.ClosePlacesPojo;
import com.example.singh.makingrestcalls.model.weather.Weather;
import com.example.singh.makingrestcalls.model.weather.Weatherdata;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by singh on 7/11/17.
 */

public class RetrofitHelper {


    private static String Base_URL = "http://samples.openweathermap.org/";
    private static String Base_URL_Google = "https://maps.googleapis.com/maps/";
    public static final String QUERY_ZIP = "92591";
    public static final String QUERY_APPID = "b1b15e88fa797225412429c1c50c122a1";

    public static final String QUERY_SENSOR = "true";
    public static final String QUERY_KEY_GOOGLE = "AIzaSyCZbgGY4IMPsS20u_dVlhZUy-MTq0TWlss";
    public static final String QUERY_LOCATION = "33.9896094,-84.45333540000001";
    public static final String QUERY_RADIUS = "500";

    public static Retrofit create() {

        //create an interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //create a client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        //create retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;


    }

    public static Retrofit createGoogle() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL_Google)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;


    }


    public static Call<Weatherdata> callWeatherData() {
        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherData(QUERY_ZIP, QUERY_APPID);

    }



    public static Observable<Weatherdata> getWeatherDataObs(){
        Retrofit retrofit = create();
        WeatherService service = retrofit.create(WeatherService.class);
        return service.getWeatherDataObsv(QUERY_ZIP, QUERY_APPID);

    }


    public static Call<ClosePlacesPojo> callGooglePlaces() {
        Retrofit retrofit = createGoogle();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getGooglePlaces(QUERY_SENSOR, QUERY_KEY_GOOGLE, QUERY_LOCATION, QUERY_RADIUS);

    }




    public interface WeatherService {

        @GET("data/2.5/forecast")
        Call<Weatherdata> getWeatherData( @Query("zip") String zip, @Query("appid") String appid);


        @GET("data/2.5/forecast")
        Observable<Weatherdata> getWeatherDataObsv(@Query("zip") String zip, @Query("appid") String appid);

        @GET("api/place/nearbysearch/json")
        Call<ClosePlacesPojo> getGooglePlaces(
                @Query("sensor") String sensor,
                @Query("key") String key,
                @Query("location") String location,
                @Query("radius") String radius
        );
    }


}
