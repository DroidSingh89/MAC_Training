package com.example.user.webviewsandsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private WebView webView;
    EditText etName, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webview);
        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://developer.android.com");


        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);


    }

    public void saveContact(View view) {

        MyContact contact = new MyContact(etName.getText().toString(), etNumber.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveNewContact(contact);


    }

    public void displayContact(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<MyContact> contacts = databaseHelper.getContacts();

        for (MyContact contact : contacts) {
            Log.d(TAG, "displayContact: " + contact.getName() + " " + contact.getNumber());
        }
    }
}

