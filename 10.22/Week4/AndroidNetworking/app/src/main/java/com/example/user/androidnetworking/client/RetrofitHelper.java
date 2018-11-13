package com.example.user.androidnetworking.client;

import com.example.user.androidnetworking.model.RandomResponse;
import com.example.user.androidnetworking.utils.NetworkHelper;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {


    private static Retrofit createInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_RANDOM_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }



    //use call object
    public static Call<RandomResponse> getRandomUser(String gender, int results) {

        Retrofit retrofit = createInstance();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getRandomUser(gender, results);
    }

    //using rxjava


}
