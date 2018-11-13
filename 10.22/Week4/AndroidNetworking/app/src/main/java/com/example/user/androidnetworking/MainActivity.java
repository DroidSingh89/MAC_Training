package com.example.user.androidnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.androidnetworking.client.OkhttpHelper;

public class MainActivity extends AppCompatActivity {

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

                break;
        }

    }

    public void onRetrofit(View view) {

    }
}
