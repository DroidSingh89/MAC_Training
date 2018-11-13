package com.example.user.androidnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.androidnetworking.client.OkhttpHelper;
import com.example.user.androidnetworking.client.RetrofitHelper;
import com.example.user.androidnetworking.model.RandomResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG";
    private OkhttpHelper okhttpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okhttpHelper = new OkhttpHelper();
    }

    public void onOkhttp(View view) {

        switch (view.getId()) {

            case R.id.btnOkhttpExecute:

                okhttpHelper.execute();

                break;

            case R.id.btnOkhttpEnqueue:

                okhttpHelper.enqueue();
                break;
        }

    }

    public void onRetrofit(View view) {

        switch (view.getId()) {
            case R.id.btnRetrofitExecute:

                break;

            case R.id.btnRetrofitEnqueue:


                RetrofitHelper.getRandomUser("male", 10).enqueue(new Callback<RandomResponse>() {
                    @Override
                    public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {

                        Log.d(TAG, "onResponse: "+ Thread.currentThread().getName());


                        Log.d(TAG, "onResponse: "+ response.body().getResults().get(0).getGender());
                    }

                    @Override
                    public void onFailure(Call<RandomResponse> call, Throwable t) {

                    }
                });
                break;
        }
    }
}
