package com.example.user.makingrestcalls;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by singh on 2/6/18.
 */

public class OkHttpHelper {

    String BaseUrl;
    OkHttpClient client;
    Request request;

    public OkHttpHelper(String baseUrl) {
        BaseUrl = baseUrl;
        init();
    }

    private void init() {
        client = new OkHttpClient();
        request = new Request.Builder()
                .url(BaseUrl)
                .build();
    }

    public void getResponseSync()  {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Response response = client.newCall(request).execute();
                    HandlerUtils
                            .getDefault()
                            .sendStringToMain(response.body().string(), HandlerUtils.MODE_OKHTTP);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void getResponseAsync() {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                HandlerUtils
                        .getDefault()
                        .sendStringToMain(response.body().string(), HandlerUtils.MODE_OKHTTP);

            }
        });
    }




}
