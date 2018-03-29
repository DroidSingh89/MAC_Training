package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.multithreading.myEvents.MyMessageEvent;
import com.example.user.multithreading.threads.MyAsyncTask;
import com.example.user.multithreading.threads.MyEventThread;
import com.example.user.multithreading.threads.MyRunnable;
import com.example.user.multithreading.threads.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(this);
        tvMain = findViewById(R.id.tvMain);
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

    public void onStartThread(View view) {

        Log.d(MainActivity.class.getSimpleName(), "onStartThread: "
                + Thread.currentThread());

        MyThread myThread = new MyThread(tvMain);
        myThread.start();

    }

    public void onStartRunnable(View view) {

        MyRunnable myRunnable = new MyRunnable(handler);
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

    public void onStartAsyncTask(View view) {

        MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
        myAsyncTask.execute("Asdf");

    }

    @Override
    public boolean handleMessage(Message message) {

        Toast.makeText(this, message.getData().getString("data"), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageReceived(MyMessageEvent myMessageEvent) {

        Toast.makeText(this, myMessageEvent.getData(), Toast.LENGTH_SHORT).show();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageReceived2(MyMessageEvent myMessageEvent) {

        tvMain.setText(myMessageEvent.getData());

    }

    public void onStartEventThread(View view) {

        MyEventThread myEventThread = new MyEventThread();
        myEventThread.start();
    }
}
