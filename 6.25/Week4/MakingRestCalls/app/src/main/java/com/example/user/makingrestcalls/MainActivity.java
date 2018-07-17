package com.example.user.makingrestcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.makingrestcalls.client.NativeCallHelper;

public class MainActivity extends AppCompatActivity {

    private NativeCallHelper callHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callHelper = new NativeCallHelper();
    }

    public void onNativeCall(View view) {


        callHelper.makeCall();

    }
}
