package com.example.user.makingrestcalls.clients.okhttp;

import com.example.user.makingrestcalls.utils.HandlerUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    OkHttpClient client;
    Request request;
    String baseUrl;


    public void init(String baseUrl) {

        client = new OkHttpClient();
        request = new Request.Builder()
                .url(baseUrl)
                .build();

    }

    public void executeSync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();

                    HandlerUtils.getDefault().sendMessage(response.body().string(), HandlerUtils.Mode.NATIVE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void executeAsync() {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                HandlerUtils.getDefault().sendMessage(response.body().string(), HandlerUtils.Mode.NATIVE);

            }
        });

    }
}
