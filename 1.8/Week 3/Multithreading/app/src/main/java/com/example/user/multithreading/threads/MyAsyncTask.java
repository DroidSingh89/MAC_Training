package com.example.user.multithreading.threads;

import android.os.AsyncTask;
import android.util.Log;

import com.example.user.multithreading.MyTasks;

/**
 * Created by singh on 1/24/18.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    private static final String TAG = MyAsyncTask.class.getSimpleName();

    //main thread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
    }

    //worker thread
    @Override
    protected String doInBackground(String... strings) {

        Log.d(TAG, "doInBackground: "
                + strings[0]
                + " Thread:" + Thread.currentThread().getName());

        publishProgress(1);

        //the task
        MyTasks.startSimpleJob(TAG);

        //can do a for loop for the progress

        publishProgress(2);

        String output = "AsyncTask Completed";
        return output;
    }

    //publish the progress on the main thread
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: "
                + values[0]
                + " Thread:" + Thread.currentThread().getName());
    }

    //main thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: "
                + s
                + " Thread:" + Thread.currentThread().getName());
    }
}
