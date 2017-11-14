package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                tvMain.setText("" + msg.getData().getInt("value"));
                return true;
            }
        });

    }

    public void handleMultithreading(View view) {

        Log.d(TAG, "handleMultithreading: " + Thread.currentThread());
        switch (view.getId()){

            case R.id.btnRunnable:

                MyRunnable myRunnable = new MyRunnable(tvMain);
                Thread thread = new Thread(myRunnable);
                thread.start();

                break;
            case R.id.btnThread:

                MyThread myThread = new MyThread(handler);
                myThread.start();

                break;
        }


        //using RunOnUIThread
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                tvMain.setText("asdf");
//            }
//        }).start();

    }
}
