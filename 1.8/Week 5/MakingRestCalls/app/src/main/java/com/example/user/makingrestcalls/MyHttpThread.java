package com.example.user.makingrestcalls;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 2/6/18.
 */

public class MyHttpThread extends Thread{

    String BASE_URL;

    public MyHttpThread(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    @Override
    public void run() {
        super.run();

        try {
            URL url = new URL(BASE_URL);

            HttpURLConnection httpURLConnection
                    = (HttpURLConnection) url.openConnection();

            InputStream inputStream
                    = new BufferedInputStream(httpURLConnection.getInputStream());

            Scanner scanner = new Scanner(inputStream);

            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {

                stringBuilder.append(scanner.nextLine());
            }

            HandlerUtils
                    .getDefault()
                    .sendStringToMain(stringBuilder.toString(), HandlerUtils.MODE_HTTP);

            Log.d(TAG, "run: " + stringBuilder.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
