package com.example.singh.multithreadingandroid;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by singh on 6/28/17.
 */

public class TestAsynctask extends AsyncTask<String,Integer,String>{

    TextView tvResultAsynctask;

    public TestAsynctask(TextView tvResultAsynctask) {
        this.tvResultAsynctask = tvResultAsynctask;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        tvResultAsynctask.setText("Starting asynctask");
        System.out.println(" onPreExecute" + Thread.currentThread());


    }

    @Override
    protected String doInBackground(String... strings) {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
            System.out.println("Params:" + strings[0]);
            System.out.println("doInBackground " + Thread.currentThread());
        }

        return "Task Done";
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        System.out.println("onProgressUpdate " + Thread.currentThread());
        tvResultAsynctask.setText(String.valueOf(values[0]));

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        tvResultAsynctask.setText(s);
        System.out.println( "PostExecute " + Thread.currentThread());


    }



}
