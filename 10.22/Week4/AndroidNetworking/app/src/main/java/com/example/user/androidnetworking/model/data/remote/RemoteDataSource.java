package com.example.user.androidnetworking.model.data.remote;

import com.example.user.androidnetworking.model.randomresponse.RandomResponse;
import com.example.user.androidnetworking.utils.NetworkHelper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {


    private  Retrofit createInstance() {

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_RANDOM_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }

    //use call object
    public  Call<RandomResponse> getRandomUser(String gender, int results) {

        return getRemoteService().getRandomUser(gender, results);
    }

    //using rxjava
    public  Observable<RandomResponse> getRandomUserObs(String gender, int results) {
        return getRemoteService().getRandomUserObs(gender, results);
    }



}
