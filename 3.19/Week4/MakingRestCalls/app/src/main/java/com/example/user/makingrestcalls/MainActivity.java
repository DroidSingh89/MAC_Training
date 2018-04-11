package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.makingrestcalls.clients.okhttp.OkHttpHelper;
import com.example.user.makingrestcalls.clients.nativeclient.NativeClient;
import com.example.user.makingrestcalls.clients.retrofit.RetrofitHelper;
import com.example.user.makingrestcalls.model.GithubProfile;
import com.example.user.makingrestcalls.rxjava.RxjavaUtils;
import com.example.user.makingrestcalls.utils.parser.CustomParser;
import com.example.user.makingrestcalls.utils.parser.GsonParser;
import com.example.user.makingrestcalls.utils.HandlerUtils;
import com.example.user.makingrestcalls.utils.MessageUtils;

import org.json.JSONException;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Handler.Callback, MainObserver.onObserverInteraction{

    private static final String TAG = MainActivity.class.getSimpleName();

    String Base_URL = "https://api.github.com/users/manroopsingh";
    String BASEURL = "http://www.mocky.io/v2/5accc44a3200005e0077650a";
    private TextView tvResults;
    private OkHttpHelper okHttpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResults = findViewById(R.id.tvResults);
        HandlerUtils.getDefault().setReceiver(new Handler(this));
        okHttpHelper = new OkHttpHelper();
        okHttpHelper.init(BASEURL);

    }

    public void makingRestCalls(View view) {

        switch (view.getId()) {

            case R.id.btnNative:

                NativeClient.getResults(BASEURL);

                break;

            case R.id.btnOkHttpSync:

                okHttpHelper.executeSync();

                break;

            case R.id.btnOkHttpAsync:

                okHttpHelper.executeAsync();

                break;

            case R.id.btnRetrofitSync:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //                            Log.d(TAG, "run: "+
//                                    RetrofitHelper.getProfileWithMocky().execute().body().getFollowers());;
                    }
                }).start();
                break;

            case R.id.btnRetrofitAsync:

                RetrofitHelper retrofitHelper = new RetrofitHelper(getApplicationContext());
//                retrofitHelper.getProfileWithGithub("manroopsingh")
//                        .enqueue(new Callback<GithubProfile>() {
//                            @Override
//                            public void onResponse(Call<GithubProfile> call, Response<GithubProfile> response) {
//                                Log.d(TAG, "onResponse: " + response.body().getFollowers());

//                            }
//
//                            @Override
//                            public void onFailure(Call<GithubProfile> call, Throwable t) {
//
//                            }
//                        });

                retrofitHelper.getProfileObs("manroopsingh")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .map(RxjavaUtils.getGithubFunction())
                        .subscribe(new MainObserver(this));


                break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {


        GithubProfile githubProfile = (GithubProfile) GsonParser
                .parse(MessageUtils.getMessage(message), GithubProfile.class);

        try {
            CustomParser.parse("GITHUBPROFILE", MessageUtils.getMessage(message));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        tvResults.setText(githubProfile.getName());
        return false;

    }

    @Override
    public void onResult(GithubProfile githubProfile) {
        tvResults.setText(githubProfile.getName());

    }
}
