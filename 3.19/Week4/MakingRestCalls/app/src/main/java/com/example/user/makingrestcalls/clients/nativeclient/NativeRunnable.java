package com.example.user.makingrestcalls.clients.nativeclient;

import com.example.user.makingrestcalls.utils.HandlerUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NativeRunnable implements Runnable {


    String BASE_URL;

    public NativeRunnable(String BASE_URL) {
        this.BASE_URL = BASE_URL;

    }

    @Override
    public void run() {


        try {
            URL url = new URL(BASE_URL);

            HttpURLConnection httpURLConnection
                    = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);

            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {

                stringBuilder.append(scanner.nextLine());

            }

            HandlerUtils.getDefault().sendMessage(stringBuilder.toString(), HandlerUtils.Mode.NATIVE);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
