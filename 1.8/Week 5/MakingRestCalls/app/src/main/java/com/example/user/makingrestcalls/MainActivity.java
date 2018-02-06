package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private TextView tvResult;
    String BASE_URL = "http://www.mocky.io/v2/5a7a03402e000028009a5d40";
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


                break;

            case R.id.btnRetrofitAsync:

                break;
        }

    }

    @Override
    public boolean handleMessage(Message msg) {

        String responseData = null;
        switch (msg.what) {
            case HandlerUtils.MODE_HTTP:
                responseData = msg.getData().getString("data");
                break;

            case HandlerUtils.MODE_OKHTTP:
                responseData = msg.getData().getString("okhttpSync");
                break;
        }

        tvResult.setText(responseData);

        return false;
    }
}
