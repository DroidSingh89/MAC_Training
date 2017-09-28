package com.example.user.androidviewsandlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();

        String data = intent.getStringExtra("data2");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        WebViewClient client = new WebViewClient();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(client);


        webview.loadUrl("https://developer.android.com");






    }

}
