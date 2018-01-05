package com.example.user.multithreadingandroid;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by singh on 8/8/17.
 */

public class TestAsynctask extends AsyncTask<String, Integer, String> {


    private static final String TAG = "Asynctask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());

    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: " + strings[0] + Thread.currentThread());

        publishProgress(1);
        return "result";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d(TAG, "onPostExecute: "+s  + Thread.currentThread());

    }
}
