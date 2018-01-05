package com.example.user.makingrestcalls;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by singh on 11/16/17.
 */

public class MyHttpThread extends Thread {


    private static final String TAG = "MyHttpThread";
    String MyUrl;
    private HttpURLConnection urlConnection;

    public MyHttpThread(String URL) {
        this.MyUrl = URL;
    }

    @Override
    public void run() {
        super.run();


        try {
            URL url = new URL(MyUrl);

            //open connection to the URL
            urlConnection = (HttpURLConnection) url.openConnection();

            //read the response
            InputStream inputStream
                    = new BufferedInputStream(urlConnection.getInputStream());

            //print the response
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()){
                Log.d(TAG, "run: " + scanner.nextLine());
            }

            //close the connection
            urlConnection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
