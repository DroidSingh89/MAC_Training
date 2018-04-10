package com.example.user.makingrestcalls.clients.nativeclient;

public class NativeClient{


    public static void getResults(String baseUrl) {

        NativeRunnable nativeRunnable = new NativeRunnable(baseUrl);
        Thread thread = new Thread(nativeRunnable);
        thread.start();

    }


}
