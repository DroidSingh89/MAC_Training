package com.example.user.makingrestcalls;

import com.example.user.makingrestcalls.model.SampleResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by singh on 2/7/18.
 */

public class RetrofitHelper {


    public static class Factory{

        //create the retrofit instance
        public static Retrofit createRetrofit() {
            return new Retrofit.Builder()
                    .baseUrl(MainActivity.BASE_URL_RETRO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //create the retrofit instance with RxJava
        public static Retrofit createRetrofitWithRxJava() {
            return new Retrofit.Builder()
                    .baseUrl(MainActivity.BASE_URL_RETRO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

    }

    //get the service call using interface
    public static Call<SampleResponse> getResponse() {
        RetrofitService retrofitService
                = Factory.createRetrofit().create(RetrofitService.class);
        return retrofitService.getResponse();
    }


    //rxjava
    public static Observable<SampleResponse> getResponseRxJava() {
        RetrofitService retrofitService
                = Factory.createRetrofitWithRxJava().create(RetrofitService.class);
        return retrofitService.getResponseWithRxJava();
    }


    //    create the interface to use the http verbs
    interface RetrofitService {

        //using call object
        @GET("v2/5a7a03402e000028009a5d40")
        Call<SampleResponse> getResponse();

        @GET("v2/5a7a03402e000028009a5d40")
        Observable<SampleResponse> getResponseWithRxJava();

    }
}


