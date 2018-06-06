package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.multithreading.tasks.MyRunnable;
import com.example.user.multithreading.tasks.MyThread;

public class MainActivity extends AppCompatActivity
        implements
        Handler.Callback {

    private TextView tvResult;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        handler = new Handler(this);
    }

    public void onHandleWorkers(View view) {

        Log.d(MainActivity.class.getSimpleName() + "+TAG"
                , "onHandleWorkers: "
                        + Thread.currentThread().getName());
        switch (view.getId()) {

            case R.id.btnThread:
                MyThread myThread = new MyThread(tvResult);
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
    public boolean handleMessage(Message message) {
        tvResult.setText(message.getData().getString("data"));
        return false;

    }
}
