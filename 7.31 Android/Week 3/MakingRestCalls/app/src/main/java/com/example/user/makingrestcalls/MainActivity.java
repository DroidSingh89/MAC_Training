package com.example.user.makingrestcalls;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.makingrestcalls.model.Weather;
import com.example.user.makingrestcalls.model.WeatherData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    //image url for loading in a imageview using Glide
    public static final String Image_Url = "https://static1.squarespace.com/static/54e8ba93e4b07c3f655b452e/t/56c2a04520c64707756f4267/1493764650017/";

    //Url used in okhttp calls
    public static final String BASE_URL = "http://samples.openweathermap.org/data/2.5/forecast?zip=94040&appid=b1b15e88fa797225412429c1c50c122a1";
    private static final String TAG = "MainActivityTag";

    WeatherData weatherData;
    String resultResponse = "";

    TextView textView;
    ImageView imageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        imageView = (ImageView) findViewById(R.id.imageview);

        Glide.with(this).load(Image_Url).into(imageView);
    }

    public void makingRestCalls(View view) throws IOException, InterruptedException {

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

                    }
                });

                break;

            case R.id.btnRetrofit:

                retrofit2.Call<WeatherData> weatherDataCall = RetrofitHelper.getWeatherCall();
                weatherDataCall.enqueue(new retrofit2.Callback<WeatherData>() {
                    @Override
                    public void onResponse(retrofit2.Call<WeatherData> call, retrofit2.Response<WeatherData> response) {

                        textView.setText(response.body().getCity().getName());
                    }

                    @Override
                    public void onFailure(retrofit2.Call<WeatherData> call, Throwable t) {

                        Log.d(TAG, "onFailure: " + t.toString());
                    }
                });

                break;

            // TODO: 8/17/17 Change to Rxjava version 2
            case R.id.btnRetrofitRxJava:

                Observable<WeatherData> weatherDataObservable = RetrofitHelper.getWeatherObs();
                weatherDataObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<WeatherData>() {
                            @Override
                            public void onCompleted() {

                                Log.d(TAG, "onCompleted: ");
                            }

                            @Override
                            public void onError(Throwable e) {

                                Log.d(TAG, "onError: " + e.toString());
                            }

                            @Override
                            public void onNext(WeatherData weatherData) {

                                Log.d(TAG, "onNext: " + weatherData.getList().size());
                            }
                        });
                break;
        }
        waiting();
    }
    public void waiting() throws InterruptedException {

        Thread.sleep(2000);
    }
}
