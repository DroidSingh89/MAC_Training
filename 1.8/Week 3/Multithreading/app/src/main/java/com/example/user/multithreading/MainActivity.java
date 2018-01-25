package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.multithreading.threads.MyAsyncTask;
import com.example.user.multithreading.threads.MyEventThread;
import com.example.user.multithreading.threads.MyRunnable;
import com.example.user.multithreading.threads.MyRxJavaHelper;
import com.example.user.multithreading.threads.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements Handler.Callback {

    private TextView tvmain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvmain = findViewById(R.id.tvMain);

        handler = new Handler(this);

    }

    public void onHandlingThreads(View view) throws InterruptedException {

        switch (view.getId()) {

            case R.id.btnThread:

                MyThread myThread = new MyThread(tvmain);
                myThread.setName("Ironman");
                myThread.start();

                break;

            case R.id.btnRunnable:

                MyRunnable myRunnable = new MyRunnable(handler);
                Thread thread = new Thread(myRunnable);

                thread.start();

                break;

            case R.id.btnAsyncTask:
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute("Init parameters");

                break;

            case R.id.btnRxJava:

                MyRxJavaHelper.getLongObs()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(MyRxJavaHelper.getLongObserver());

                break;

            case R.id.btnEventbus:

                MyEventThread myEventThread = new MyEventThread();
                myEventThread.start();

                break;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {

        tvmain.setText(msg.getData().getString("KEY"));

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
    public void onMyEvent(MyEvent myEvent) {

        Toast.makeText(this, myEvent.getData(), Toast.LENGTH_SHORT).show();

    }
}
