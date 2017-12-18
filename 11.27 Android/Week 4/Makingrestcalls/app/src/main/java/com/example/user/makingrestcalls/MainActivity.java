package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.makingrestcalls.data.remote.RemoteDataSource;
import com.example.user.makingrestcalls.model.github.GithubResponse;
import com.example.user.makingrestcalls.model.mocky.Menuitem;
import com.example.user.makingrestcalls.model.mocky.MockyResponse;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements Handler.Callback {


    public static final String BASE_URL = "http://www.mocky.io/v2/5a381762320000ad27eb6bc8";
    private static final String TAG = "MainActivityTag";
    private Handler handler;
    private TextView textView;
    private OkHttpClient okHttpClient;
    private Request request;
    private Handler githubHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tvResponse);

        handler = new Handler(this);

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(BASE_URL)
                .build();


//        create a handler for github
        githubHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                textView.setText(MessageUtil.getResponse(msg));
                return false;
            }
        });

    }

    @Override
    public boolean handleMessage(Message msg) {

        String response = MessageUtil.getResponse(msg);
        textView.setText(response);

//        using json parser
        try {
            MyParser.parseUsingJSON(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }


//        using gson parser
        MockyResponse mockyResponse = MyParser.parseUsingGson(response);
        List<Menuitem> menuitems = mockyResponse.getMenu().getPopup().getMenuitem();
        for (Menuitem menuitem : menuitems) {

            Log.d(TAG, "handleMessage: " + menuitem.getValue()
                    + ":" + menuitem.getOnclick());
        }

        return false;

    }

    //    Http native call
    public void OnHttpNative(View view) {


        MyHttpThread myHttpThread = new MyHttpThread(BASE_URL, handler);
        myHttpThread.start();

    }

    //    Using OkHttp for REST call synchronous
    public void OnOkHttpSync(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    String response = okHttpClient.newCall(request)
                            .execute()
                            .body()
                            .string();

                    handler.sendMessage(MessageUtil.getMessage(response));
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }

    public void OnOkHttpAsync(View view) {

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                handler.sendMessage(MessageUtil.getMessage(response.body().string()));
            }
        });


    }

    public void OnRetrofitSync(View view) {


    }


    public void OnRetrofitAsync(View view) {

        RemoteDataSource.getUser("manroopsingh")
                .enqueue(new retrofit2.Callback<GithubResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<GithubResponse> call, retrofit2.Response<GithubResponse> response) {
                        
                        githubHandler
                                .sendMessage(MessageUtil.getMessage(response.body().getName()));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<GithubResponse> call, Throwable t) {

                    }
                });


    }
}
