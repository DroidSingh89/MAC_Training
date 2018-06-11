package com.example.user.multithreading.tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    public static final String TAG = MyAsyncTask.class.getSimpleName() + "_TAG";


    TextView tvResult;

    public MyAsyncTask(TextView tvResult) {
        this.tvResult = tvResult;
    }

    //main
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvResult.setText("Starting task");
        Log.d(TAG, "onPreExecute: Thread: " + Thread.currentThread().getName());
    }

    //worker
    @Override
    protected String doInBackground(String... strings) {
        //start task
        Log.d(TAG, "doInBackground: " + strings[0]);
        //publish progress


        for (int i = 0; i < 4; i++) {

            try {
                Thread.sleep(500);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d(TAG, "doInBackground: Thread: " + Thread.currentThread().getName());
        return "Task result";
    }

    //main
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tvResult.setText("" + values[0]);
        Log.d(TAG, "onProgressUpdate: Thread: " + Thread.currentThread().getName());
    }

    //main
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //update ui
        Log.d(TAG, "onPostExecute: Thread: " + Thread.currentThread().getName());
        Log.d(TAG, "onPostExecute: Result" + s);
        tvResult.setText(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onCancelled: Thread: " + Thread.currentThread().getName());

    }
}
