package com.example.user.makingrestcalls;

import com.example.user.makingrestcalls.model.MyResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by singh on 10/11/17.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://www.mocky.io/";

    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<MyResponse> getCall() {

        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getResponse();
    }

    public static Call<MyResponse> getCallV3(String version) {

        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getResponseForV3(version);
    }


    public interface RetrofitService {

        @GET("v2/59de720c100000fc12a8514a")
        Call<MyResponse> getResponse();

        @GET("{version}/59de720c100000fc12a8514a")
        Call<MyResponse> getResponseForV3(@Path("version") String version);


    }


}
