package com.example.user.makingrestcalls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.makingrestcalls.model.Weather;
import com.example.user.makingrestcalls.model.WeatherData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    public static final String BASE_URL = "http://samples.openweathermap.org/data/2.5/forecast?zip=94040&appid=b1b15e88fa797225412429c1c50c122a1";
    private static final String TAG = "MainActivityTag";

    WeatherData weatherData;
    String resultResponse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makingRestCalls(View view) throws IOException {


        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(BASE_URL)
                .build();


        switch (view.getId()) {


            case R.id.btnHttp:

                Intent intent = new Intent(this, HttpIntentService.class);
                startService(intent);
                break;

            //make synchronous calls using okhttp
            case R.id.btnOkHttp:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String result = client.newCall(request).execute().body().string();
                            Log.d(TAG, "run: " + result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(this, "Check your logs", Toast.LENGTH_SHORT).show();

                break;

            //make asynchronous calls using okHttp
            case R.id.btnOkHttpAsync:

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        resultResponse = response.body().string();

                        Gson gson = new Gson();
                        weatherData = gson.fromJson(resultResponse, WeatherData.class);
                        Log.d(TAG, "onResponse: " + weatherData.getCity().getName());
                        

                    }
                });

                break;

            case R.id.btnRetrofit:



                break;
        }


    }
}
