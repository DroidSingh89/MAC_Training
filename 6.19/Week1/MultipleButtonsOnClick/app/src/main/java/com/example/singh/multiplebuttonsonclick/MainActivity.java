package com.example.singh.multiplebuttonsonclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {


        switch (view.getId()){
            case R.id.btn1:

                Log.d(TAG, "doMagic: " + "btn1");
                break;


            case R.id.btn2:
                Log.d(TAG, "doMagic: " + "btn2");
                break;


            case R.id.btn3:
                Log.d(TAG, "doMagic: " + "btn3");
                break;

            case R.id.btn4:
                Log.d(TAG, "doMagic: " + "btn4");
                break;

            case R.id.btnWebView:
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);

                break;


        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        
    }
}
