package com.example.user.multithreading;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private static final String TAG = "MainActivityTag";
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void creatingThreads(View view) {


        switch (view.getId()) {

            case R.id.btnUsingRunnable:

                MyRunnable myRunnable = new MyRunnable(tvResult);

                Thread thread = new Thread(myRunnable);
                thread.start();

                break;
            case R.id.btnUsingThread:

                //create a handler by using this class as the call back
                Handler handler = new Handler(this);


                //create a handler by creating the callback here
                Handler handler1 = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message message) {
                        int total = message.getData().getInt("total");
                        Toast.makeText(MainActivity.this, String.valueOf(total), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                Toast.makeText(this, "Calculating", Toast.LENGTH_SHORT).show();
                MyThread myThread = new MyThread(handler);
                myThread.start();


                break;

            case R.id.btnUsingAsyncTask:

                MyAsyncTask myAsyncTask = new MyAsyncTask(tvResult);
                myAsyncTask.execute();

                break;
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHelloEvent(HelloEvent helloEvent) {
        Log.d(TAG, "onHelloEvent: " + helloEvent.getData());
        Toast.makeText(this, "Eventbus:" + helloEvent.getData(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean handleMessage(Message message) {

        int total = message.getData().getInt("total");
        tvResult.setText(String.valueOf(total));
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        return false;
    }

    //register this class for Eventbus
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    //unregister this class for Eventbus
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


}
