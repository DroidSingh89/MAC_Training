package com.example.user.multithreading.jobs;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.user.multithreading.utils.ThreadUtils;

public class MyAsynctask extends AsyncTask<String, Integer, String> {

    private static final String TAG = MyAsynctask.class.getSimpleName() + "_TAG";
    private TextView tvMain;

    public MyAsynctask(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + ThreadUtils.print(Thread.currentThread()));
        tvMain.setText("Task starting");
    }

    @Override
    protected String doInBackground(String... strings) {

        Log.d(TAG, "doInBackground: " + ThreadUtils.print(Thread.currentThread()));
        Log.d(TAG, "doInBackground: Params: " + strings[0]);

//        my task
        for (int i = 0; i < 5; i++) {
            publishProgress(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Background task result";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + ThreadUtils.print(Thread.currentThread()));
        Log.d(TAG, "onPostExecute: Result:" + s);
        tvMain.setText("Task completed");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + ThreadUtils.print(Thread.currentThread()));
        tvMain.setText(String.valueOf(values[0]));

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
