package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.multithreading.model.event.HelloEvent;
import com.example.user.multithreading.utils.Tagger;
import com.example.user.multithreading.workers.MyAsyncTask;
import com.example.user.multithreading.workers.MyRunnable;
import com.example.user.multithreading.workers.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity
        implements Handler.Callback{

    private TextView tvMain;
    private Handler handler;
    private TextView tvEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Tagger.get(this), "onCreate: " + Thread.currentThread().getName());

        tvMain = findViewById(R.id.tvMain);
        tvEventBus = findViewById(R.id.tvEventBus);
        handler = new Handler(this);

    }

    public void onMultithreading(View view) {

        Log.d(Tagger.get(this), "onMultithreading: " + Thread.currentThread().getName());

        switch (view.getId()) {
            case R.id.btnThread:

                MyThread myThread = new MyThread(tvMain);
                myThread.start();
                break;

            case R.id.btnRunnable:
                MyRunnable myRunnable = new MyRunnable(handler);
//                myRunnable.run(); Dont start a new thread

                Thread thread = new Thread(myRunnable);
                thread.start(); //run runnable in a new thread
                break;

            case R.id.btnAsyncTask:
                MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
                myAsyncTask.execute("Params passed from main");
                break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {

        tvMain.setText(message.getData().getString("data"));

        return false;
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
    public void onEventReceived(HelloEvent event) {

        tvEventBus.setText(event.getData());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHelloEventReceived(HelloEvent event) {

        Toast.makeText(this, event.getData(), Toast.LENGTH_SHORT).show();
    }

}

