package com.example.user.androidnetworking.client;

import android.util.Log;

import com.example.user.androidnetworking.utils.NetworkHelper;
import com.example.user.androidnetworking.utils.RandomParser;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkhttpHelper {

    private static final String TAG = OkhttpHelper.class.getSimpleName() + "_TAG";

    OkHttpClient client;

    public OkhttpHelper() {

        client = new OkHttpClient();

    }

    public void execute() {


        final Request request = new Request.Builder()
                .url(NetworkHelper.RANDOM_USER_URL)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    String response = client.newCall(request).execute().body().string();

                    Log.d(TAG, "execute: " + RandomParser.parseName(response));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }


    public void enqueue() {

    }
}
