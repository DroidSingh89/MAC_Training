package com.example.user.androidnetworking.client;

import android.util.Log;

import com.example.user.androidnetworking.model.RandomResponse;
import com.example.user.androidnetworking.model.ResultsItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpHelper {

    private static final String TAG = OkhttpHelper.class.getSimpleName() + "_TAG";

    OkHttpClient client;
    private Request request;

    public OkhttpHelper() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("randomuser.me")
                .addPathSegment("api")
                .addQueryParameter("results", "10")
                .addQueryParameter("gender", "male")
                .build();

        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        request = new Request.Builder()
                .url(url)
                .build();

    }

    public void execute() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    String response = client.newCall(request).execute().body().string();


                    Gson gson = new Gson();

                    RandomResponse randomResponse = gson.fromJson(response, RandomResponse.class);


                    for (ResultsItem resultsItem : randomResponse.getResults()) {
                        Log.d(TAG, "run: " + resultsItem.getGender());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }


    public void enqueue() {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                RandomResponse randomResponse = gson.fromJson(response.body().string(), RandomResponse.class);

                Log.d(TAG, "onResponse: Thread:" + Thread.currentThread().getName());
                Log.d(TAG, "onResponse: "+ randomResponse.getResults().size());
            }
        });


    }
}
