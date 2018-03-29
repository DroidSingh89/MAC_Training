package com.example.user.multithreading.threads;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.user.multithreading.MyTasks;

import static android.content.ContentValues.TAG;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    TextView tvMain;

    public MyAsyncTask(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //main
        tvMain.setText("Setting up task");
        Log.d(TAG, "onPreExecute: "+ Thread.currentThread().getName());

    }

    @Override
    protected String doInBackground(String... strings) {
        MyTasks.startJob(this.getClass().getSimpleName());

        Log.d(TAG, "doInBackground: input:"+ strings[0]);
        Log.d(TAG, "doInBackground: " + Thread.currentThread().getName());
        return "Job done";
        //worker
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //main
        tvMain.setText(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread().getName());

    }
}
