package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.multithreading.eventbus.MessageEvent;
import com.example.user.multithreading.eventbus.MyEventThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private static final String TAG = "MainActivity";
    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);

        handler = new Handler(this);

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

            case R.id.btnAsyncTask:

                MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
                myAsyncTask.execute("Download file");
                break;

            case R.id.btnEventBus:

                MyEventThread myEventThread = new MyEventThread();
                myEventThread.start();

                break;
        }

    }

    @Override
    public boolean handleMessage(Message msg) {
        tvMain.setText("" + msg.getData().getInt("value"));

        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event){
        tvMain.setText(event.getData());

    }


}
