package com.example.user.makingrestcalls;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/**
 * Created by singh on 12/18/17.
 */

public class MyHttpThread extends Thread {

    private static final String TAG = "MyHttpThreadTag";
    String BASE_URL;
    Handler handler;

    public MyHttpThread(String BASE_URL, Handler handler) {
        this.BASE_URL = BASE_URL;
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();


        try {
            URL url = new URL(BASE_URL);

//            open the connection using the HttpUrlConnection class
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

//            get the response using the input stream
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

//            read the response from the input stream
            Scanner scanner = new Scanner(inputStream);

            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                //Log.d(TAG, "run: " + scanner.nextLine());
            }


            handler.sendMessage(
                    MessageUtil.getMessage(stringBuilder.toString()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
