package com.example.user.makingrestcalls;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by singh on 8/16/17.
 */

public class HttpIntentService extends IntentService {


    public static final String BASE_URL = "http://www.mocky.io/v2/599495951100009403723127";
    private static final String TAG = "HttpsIntServiceTag";

    URLConnection urlConnection = null;
    public HttpIntentService() {
        super("HttpIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d(TAG, "onHandleIntent: ");
        try {

            URL url = new URL(BASE_URL);
            urlConnection = url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            Scanner scanner = new Scanner(in);
            while(scanner.hasNext()){
                Log.d(TAG, "onHandleIntent: "  + scanner.nextLine());

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
