package com.example.user.multithreading;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Created by singh on 9/7/17.
 */

public class TestAsyncTask extends AsyncTask<String, Integer, String> {

    TextView tvAsyncTask;

    public TestAsyncTask(TextView tvAsyncTask) {
        this.tvAsyncTask = tvAsyncTask;
    }

    private static final String TAG = "AsyncTaskTag";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());

        tvAsyncTask.setText("Preparing the AsyncTask");
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());
        Log.d(TAG, "doInBackground: Parameter : " + strings[0]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        String result = "Task is completed";
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + values[0] + Thread.currentThread());

        tvAsyncTask.setText(String.valueOf(values[0]));

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());

        tvAsyncTask.setText(s);

    }
}
