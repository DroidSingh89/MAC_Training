package com.example.user.makingrestcalls.client;

import android.app.ActivityManager;
import android.util.Log;

import com.example.user.makingrestcalls.model.APIResponse;
import com.example.user.makingrestcalls.model.CustomUser;
import com.example.user.makingrestcalls.model.Result;
import com.example.user.makingrestcalls.utils.HandlerUtils;
import com.example.user.makingrestcalls.utils.RxUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelper {


    private static final String BASE_URL = "https://randomuser.me/";

    private Retrofit createClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //retrofit
                .build();

        return retrofit;
    }


    //    using call interface
    private Call<APIResponse> getUsers(String results) {
        Retrofit retrofit = createClient();
        Service service = retrofit.create(Service.class);
        return service.getUsers(results);


    }

    //    using rxjava observable
    private Observable<APIResponse> getUserRx(String results) {

        return createClient().create(Service.class).getUsersRx(results);
    }


    public void makeCallSync(final String results) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    APIResponse apiResponse = getUsers(results).execute().body();
                    Log.d(TAG, "run: " + apiResponse.getResults().size());
                    HandlerUtils.getDefault().sendMessage(String.valueOf(apiResponse.getResults().size()));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void makeCallAsync(String results) {

        getUsers(results).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                APIResponse apiResponse = response.body();

                Log.d(TAG, "onResponse: " + apiResponse.getResults().size());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.toString());
            }
        });


    }


    public void makeCallRxJava(String results) {

        getUserRx(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<APIResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(APIResponse apiResponse) {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName());
                        Log.d(TAG, "onNext: Response:" + apiResponse.getResults().size());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + Thread.currentThread().getName());

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: " + Thread.currentThread().getName());

                    }
                });

    }

    public void makeCallCustomRx(String results, final RetrofitCallBack callBack) {

        getUserRx(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(RxUtils.getMappingFunction())

                .subscribe(new Observer<CustomUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CustomUser customUser) {

                        callBack.onResults(customUser);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void makeCallAppendUser(String results, final ListCallBack callBack) {

        final List<Result> resultList = new ArrayList<>();

        getUserRx(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(RxUtils.getResultMapper())
                .map(RxUtils.tranformResult())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {

                        resultList.add(result);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        callBack.onResults(resultList);


                    }
                });


    }


    public interface ListCallBack{

        void onResults(List<Result> resultList);
    }

    public interface RetrofitCallBack {

        void onResults(CustomUser customUser);

    }

    //    interface to use Http verbs
    interface Service {


        @GET("api")
        Call<APIResponse> getUsers(@Query("results") String results);


        @GET("api")
        Observable<APIResponse> getUsersRx(@Query("results") String results);


    }


}
