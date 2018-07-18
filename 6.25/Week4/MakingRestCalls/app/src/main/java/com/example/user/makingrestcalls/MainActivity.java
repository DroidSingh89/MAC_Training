package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.makingrestcalls.client.NativeCallHelper;
import com.example.user.makingrestcalls.client.OkhttpHelper;
import com.example.user.makingrestcalls.client.RetrofitHelper;
import com.example.user.makingrestcalls.model.CustomUser;
import com.example.user.makingrestcalls.model.Result;
import com.example.user.makingrestcalls.utils.HandlerUtils;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private static final String TAG = MainActivity.class.getSimpleName();

    private NativeCallHelper callHelper;
    private TextView tvResult;
    private OkhttpHelper okhttpHelper;
    private RetrofitHelper retrofitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResults);

//        Enable StrictMode
//        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(threadPolicy);

        initClients();
    }


    @Override
    protected void onStart() {
        super.onStart();
        HandlerUtils.getDefault().registerOwner(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        HandlerUtils.getDefault().unregisterOwner(this);

    }

    private void initClients() {
        callHelper = new NativeCallHelper();
        okhttpHelper = new OkhttpHelper();
        retrofitHelper = new RetrofitHelper();
    }

    public void onNativeCall(View view) {

        callHelper.makeCall();
    }


    public void onOkhttp(View view) throws IOException {

        switch (view.getId()) {

            case R.id.btnOkhttpSync:

                okhttpHelper.executeSyncCall();

                break;

            case R.id.btnOkhttpAsync:


                okhttpHelper.executeAsyncCall();
                okhttpHelper.executeAsyncCall2(this);

                break;
        }

    }


    public void onRetrofit(View view) {

        String results = "20";
        switch (view.getId()) {

            case R.id.btnRetroSync:

                 retrofitHelper.makeCallSync(results);

                break;

            case R.id.btnRetroAsync:


                retrofitHelper.makeCallAsync(results);

                break;

            case R.id.btnRetroRxJava:

                retrofitHelper.makeCallRxJava(results);

                break;

            case R.id.btnRetroRxCustom:

                retrofitHelper.makeCallCustomRx(results, new RetrofitHelper.RetrofitCallBack() {
                    @Override
                    public void onResults(CustomUser customUser) {
                        tvResult.setText(customUser.getDepartment());
                    }
                });
                break;

            case R.id.btnRetroRxCustomUserName:


                retrofitHelper.makeCallAppendUser(results, new RetrofitHelper.ListCallBack() {
                    @Override
                    public void onResults(List<Result> resultList) {

                        for (Result result : resultList) {
                            Log.d(TAG, "onResults: " + result.getName().getLast());
                        }

                    }
                });

                break;
        }
    }


    @Override
    public boolean handleMessage(Message message) {

        tvResult.setText(HandlerUtils.getDefault().parseMessage(message));
        return false;
    }
}
