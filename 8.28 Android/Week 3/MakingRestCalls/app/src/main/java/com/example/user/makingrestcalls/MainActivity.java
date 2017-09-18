package com.example.user.makingrestcalls;

import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.makingrestcalls.model.MyResponse;
import com.example.user.makingrestcalls.model.github.GithubRepo;
import com.example.user.makingrestcalls.model.github.Owner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
    private ImageView imageView;

    private String image_url = "https://static1.squarespace.com/static/54e8ba93e4b07c3f655b452e/t/56c2a04520c64707756f4267/1493764650017/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
        imageView = (ImageView) findViewById(R.id.ivTest);

        Glide.with(this).load(image_url).into(imageView);

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

                final retrofit2.Call<List<GithubRepo>> callRepos
                        = RetrofitHelper.createCall("manroopsingh");

                //create a thread to make the rest call on a separate thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            final String repoName = callRepos.execute()
                                    .body().get(0).getName();

                            //use this method tp update the ui views
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvResult.setText(repoName);
                                }
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();


                break;

            case R.id.btnRetrofitAsync:

                retrofit2.Call<Owner> getUserProfile = RetrofitHelper
                        .createCallUser("manroopsingh");

                getUserProfile.enqueue(new retrofit2.Callback<Owner>() {
                    @Override
                    public void onResponse(retrofit2.Call<Owner> call, final retrofit2.Response<Owner> response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResult.setText(response.body().getLogin());
                            }
                        });

                    }

                    @Override
                    public void onFailure(retrofit2.Call<Owner> call, Throwable t) {

                    }
                });

                break;
        }


    }
}
