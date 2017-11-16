package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.makingrestcalls.model.MyResponse;
import com.example.user.makingrestcalls.model.github.GithubProfile;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    public static final String URL = "http://www.mocky.io/v2/5a0db78d2e00009c3c3a2ff2";
    private static final String TAG = "MainActivity";
    private OkHttpClient client;
    private Request request;
    private TextView tvResults;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        using strict mode to make network calls on the main thread
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//        .permitNetwork()
//        .build());

        tvResults = findViewById(R.id.tvResults);

    }


    public void makingRestCalls(View view) throws IOException {

        client = new OkHttpClient();

        request = new Request.Builder()
                .url(URL)
                .build();

        switch (view.getId()) {

            case R.id.btnNativeHttp:
                final MyHttpThread myHttpThread = new MyHttpThread(URL);
                myHttpThread.start();

                break;

            case R.id.btnOkHttpSync:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response = client
                                    .newCall(request)
                                    .execute()
                                    .body()
                                    .string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tvResults.setText(response);
                            }
                        });
                    }
                }).start();


                break;

            case R.id.btnOkHttpAsync:

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Log.d(TAG, "onResponse: " + Thread.currentThread().getName());
                        String newResponse = response.body().string();

//                        parsing the response
                        Gson gson = new Gson();
                        MyResponse myResponse
                                = gson.fromJson(newResponse, MyResponse.class);

//                        print the response
                        Log.d(TAG, "onResponse: " + myResponse.getName());

                    }
                });


                break;

            case R.id.btnRetrofitSync:




                break;

            case R.id.btnRetrofitAsync:

                RetrofitHelper.getMyProfile("manroopsingh")
                        .enqueue(new retrofit2.Callback<GithubProfile>() {
                            @Override
                            public void onResponse(retrofit2.Call<GithubProfile> call, retrofit2.Response<GithubProfile> response) {

                                Log.d(TAG, "onResponse: " + response.body().getName());
                            }

                            @Override
                            public void onFailure(retrofit2.Call<GithubProfile> call, Throwable t) {

                            }
                        });

                break;


        }
    }
}
