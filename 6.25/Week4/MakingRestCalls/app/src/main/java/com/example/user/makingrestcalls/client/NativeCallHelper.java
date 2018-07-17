package com.example.user.makingrestcalls.client;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NativeCallHelper {



    private static final String TAG = NativeCallHelper.class.getSimpleName();



    public void makeCall() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    String BaseUrl = "http://www.mocky.io/v2/5b4cc67231000055005eba26";
                    URL url = new URL(BaseUrl);


                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    InputStream stream = httpURLConnection.getInputStream();

                    Scanner scanner = new Scanner(stream);

                    while (scanner.hasNext()) {
                        Log.d(TAG, "run: " + scanner.nextLine());
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
