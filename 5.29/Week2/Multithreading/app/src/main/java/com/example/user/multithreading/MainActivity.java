package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.multithreading.model.MyEvent;
import com.example.user.multithreading.tasks.MyAsyncTask;
import com.example.user.multithreading.tasks.MyRunnable;
import com.example.user.multithreading.tasks.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity
        implements
        Handler.Callback {

    private TextView tvResult;
    Handler handler;
    private TextView tvEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        
        //use this handler for using messages
        handler = new Handler(this);
    }

    private void bindViews() {
        tvResult = findViewById(R.id.tvResult);
        tvEventBus = findViewById(R.id.tvEventBus);
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
                MyAsyncTask myAsyncTask = new MyAsyncTask(tvResult);
                myAsyncTask.execute("Task parameters");

                break;

            case R.id.btnRxjava:

                RxJavaHelper.executeTask();

                break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        tvResult.setText(message.getData().getString("data"));
        return false;

    }


    //subscribe for eventbus results
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived(MyEvent myEvent) {
        tvEventBus.setText(myEvent.getData());

    }

    //subscribe for eventbus results
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventToast(MyEvent myEvent) {
        Toast.makeText(this, myEvent.getData(), Toast.LENGTH_SHORT).show();

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
}
