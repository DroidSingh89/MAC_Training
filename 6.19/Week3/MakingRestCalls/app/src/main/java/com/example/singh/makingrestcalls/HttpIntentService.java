package com.example.singh.makingrestcalls;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class HttpIntentService extends IntentService {

    public static final String BASEURL = "http://www.mocky.io/v2/59638d8b1000004d128f1304";
    private static final String TAG = "HttpIntentService";
    HttpURLConnection urlConnection = null;

    public HttpIntentService() {
        super("HttpIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        try {
            URL url = new URL(BASEURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                Log.d(TAG, "onHandleIntent: " + scanner.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }


    }

}
