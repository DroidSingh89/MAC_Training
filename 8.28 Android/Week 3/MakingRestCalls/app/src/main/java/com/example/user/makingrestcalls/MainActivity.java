package com.example.user.makingrestcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.makingrestcalls.model.MyResponse;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    public static final String BASE_URL = "http://www.mocky.io/v2/59bbf3fb0f0000b903ff87e4";
    private static final String TAG = "MainActOkSyncTag";
    private TextView tvResult;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);

        //create the okhttp client
        client = new OkHttpClient();
    }

    public void makingRestCalls(View view) {

        //create a request object to use the url
        final Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        switch (view.getId()) {

            case R.id.btnNativeHttp:
                HttpNativeThread httpNativeThread = new HttpNativeThread(BASE_URL);
                httpNativeThread.start();

                break;

            case R.id.btnOkHttpSync:

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            String response = client.newCall(request)
                                    .execute()
                                    .body()
                                    .string();

                            Gson gson = new Gson();
                            MyResponse myResponse =
                                    gson.fromJson(response, MyResponse.class);

                            Log.d(TAG, "run: " + myResponse.getTitle());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(this, "Check your logs", Toast.LENGTH_SHORT).show();


                break;

            case R.id.btnOkHttpAsync:

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String responseAsync = response.body().string();
                        Gson gson = new Gson();
                        MyResponse myResponse =
                                gson.fromJson(responseAsync, MyResponse.class);

                        Log.d(TAG, "onResponse: "
                                + myResponse.getProperties()
                                .getAge().getDescription());

                    }
                });


                break;

            case R.id.btnRetrofitSync:

                break;

            case R.id.btnRetrofitAsync:

                break;
        }


    }
}
