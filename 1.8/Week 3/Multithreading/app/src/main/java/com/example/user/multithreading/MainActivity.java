package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.multithreading.threads.MyRunnable;
import com.example.user.multithreading.threads.MyThread;

public class MainActivity extends AppCompatActivity
        implements Handler.Callback{

    private TextView tvmain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvmain = findViewById(R.id.tvMain);

        handler = new Handler(this);

    }

    public void onHandlingThreads(View view) {

        switch (view.getId()) {

            case R.id.btnThread:

                MyThread myThread = new MyThread(tvmain);
                myThread.start();

                break;

            case R.id.btnRunnable:

                MyRunnable myRunnable = new MyRunnable(handler);
                Thread thread = new Thread(myRunnable);
                thread.start();

                break;

            case R.id.btnAsyncTask:

                break;


        }
    }

    @Override
    public boolean handleMessage(Message msg) {

        tvmain.setText(msg.getData().getString("KEY"));

        return false;

    }
}
