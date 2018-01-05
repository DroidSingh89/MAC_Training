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
 * Created by singh on 10/11/17.
 */

public class MyHttpThread implements Runnable {


    private static final String TAG = "HttpThread";
    String BaseURL;
    HttpURLConnection urlConnection;

    public MyHttpThread(String URL) {
        this.BaseURL = URL;
    }

    @Override
    public void run() {

        //make the network call using given url

        try {
//            convert the string url to the URL object
            URL url = new URL(BaseURL);

//            open connection with the passed url
            urlConnection = (HttpURLConnection) url.openConnection();

//            get the response in the input stream
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

//            read the response using scanner and then print
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()){
                Log.d(TAG, "run: " + scanner.nextLine());
            }

            urlConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
