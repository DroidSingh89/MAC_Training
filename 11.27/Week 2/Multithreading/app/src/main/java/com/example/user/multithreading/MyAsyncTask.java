package com.example.user.multithreading;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 12/5/17.
 */

public class MyAsyncTask extends AsyncTask<String,Integer, String> {

    private static final String TAG = "MyAsyncTaskTag";

    TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
        textView.setText("Starting the task");
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: " + strings[0]);
        Log.d(TAG, "doInBackground: " + Thread.currentThread());


        delayTask();

        publishProgress(10);

        delayTask();


        return "Task Completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());

        textView.setText("Doing task no: " + values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());

        textView.setText(s);

    }

    private void delayTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onCancelled: ");

    }
}
