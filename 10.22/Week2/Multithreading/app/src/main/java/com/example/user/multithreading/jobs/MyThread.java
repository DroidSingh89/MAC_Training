package com.example.user.multithreading.jobs;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.example.user.multithreading.MyTask;
import com.example.user.multithreading.model.MyMessageEvent;
import com.example.user.multithreading.utils.ThreadUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MyThread extends Thread {

    private int iterations;
    private static final String TAG = MyThread.class.getSimpleName()+ "_TAG";

    private Handler handler = new Handler(Looper.getMainLooper());
    private TextView tvMain;

    public MyThread(int iterations, TextView tvMain) {
        this.iterations = iterations;
        this.tvMain = tvMain;


    }

    @Override
    public void run() {
        super.run();
        EventBus.getDefault().register(this);

//        start the task
        try {

            MyTask.start(iterations, Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//        get access to the main thread in the thread class
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + ThreadUtils.print(Thread.currentThread()));
                tvMain.setText("Update from myThread class");
            }
        });


//        use post delayed
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + ThreadUtils.print(Thread.currentThread()));
                tvMain.setText("Delayed Update");
            }
        }, 2000);


    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageEvent(MyMessageEvent myMessageEvent){

        Log.d(TAG, "onMessageEvent: "+ ThreadUtils.print(Thread.currentThread()));
        Log.d(TAG, "onMessageEvent: " + myMessageEvent.getData());

        EventBus.getDefault().unregister(this);
    }
}
