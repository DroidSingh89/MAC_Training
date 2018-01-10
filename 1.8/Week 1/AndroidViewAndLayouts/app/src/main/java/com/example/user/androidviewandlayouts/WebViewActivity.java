package com.example.user.androidviewandlayouts;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://developer.android.com";
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView = findViewById(R.id.wvMain);

        WebSettings webSettings = webView.getSettings();
        WebViewClient client = new WebViewClient();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(client);

//        load the url for the webview
        webView.loadUrl(BASE_URL);
    }


}




