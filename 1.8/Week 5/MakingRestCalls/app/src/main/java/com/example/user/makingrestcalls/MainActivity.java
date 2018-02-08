package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.makingrestcalls.model.SampleResponse;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private TextView tvResult;
    public static String BASE_URL = "http://www.mocky.io/v2/5a7a03402e000028009a5d40";
    public static String BASE_URL_RETRO = "http://www.mocky.io/";
    private OkHttpHelper okHttpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerUtils.getDefault().setReceiver(new Handler(this));

        tvResult = findViewById(R.id.tvResults);
        okHttpHelper = new OkHttpHelper(BASE_URL);

    }

    public void onMakingRestCall(View view) {

        switch (view.getId()) {

            case R.id.btnNative:

                MyHttpThread myHttpThread = new MyHttpThread(BASE_URL);
                myHttpThread.start();

                break;

            case R.id.btnOkHttpSync:

                okHttpHelper.getResponseSync();

                break;

            case R.id.btnOkHttpAsync:

                okHttpHelper.getResponseAsync();
                break;

            case R.id.btnRetrofitSync:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response<SampleResponse> response
                                    = RetrofitHelper.getResponse().execute();
                            Log.d("SomeTAG",
                                    "run: " + response.body().getMenu().getValue());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

            case R.id.btnRetrofitAsync:

                RetrofitHelper.getResponse().enqueue(new Callback<SampleResponse>() {
                    @Override
                    public void onResponse(Call<SampleResponse> call, Response<SampleResponse> response) {
                        Toast.makeText(MainActivity.this,
                                response.body().getMenu().getValue(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SampleResponse> call, Throwable t) {

                    }
                });

                break;

            case R.id.btnRetrofitRxJava:

                RetrofitHelper.getResponseRxJava()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .map(new Function<SampleResponse, SampleResponse>() {
                            @Override
                            public SampleResponse apply(SampleResponse sampleResponse) throws Exception {

                                String value = sampleResponse.getMenu().getValue();
                                sampleResponse.getMenu().setValue(value + "Something else");

                                return sampleResponse;
                            }
                        })
                        .subscribe(new Observer<SampleResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(SampleResponse sampleResponse) {

                                Toast.makeText(MainActivity.this,
                                        sampleResponse.getMenu().getValue(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                            }
                        });


                break;

        }

    }

    @Override
    public boolean handleMessage(Message msg) {

        Gson gson = new Gson();

        String responseData = null;
        switch (msg.what) {
            case HandlerUtils.MODE_HTTP:
                responseData = msg.getData().getString("data");
                break;

            case HandlerUtils.MODE_OKHTTP:
                responseData = msg.getData().getString("okhttpSync");
                break;
        }

        SampleResponse sampleResponse
                = gson.fromJson(responseData, SampleResponse.class);

        tvResult.setText(sampleResponse.getMenu().getValue());

        return false;
    }
}
