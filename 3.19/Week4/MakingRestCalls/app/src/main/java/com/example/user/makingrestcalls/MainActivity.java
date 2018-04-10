package com.example.user.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.makingrestcalls.clients.OkHttpHelper;
import com.example.user.makingrestcalls.clients.nativeclient.NativeClient;
import com.example.user.makingrestcalls.model.GithubProfile;
import com.example.user.makingrestcalls.utils.parser.CustomParser;
import com.example.user.makingrestcalls.utils.parser.GsonParser;
import com.example.user.makingrestcalls.utils.HandlerUtils;
import com.example.user.makingrestcalls.utils.MessageUtils;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

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
}
