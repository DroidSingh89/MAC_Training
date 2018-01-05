package com.example.user.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    TextView tvCounter;
    TextView tvAsyncTask;
    TextView tvThreadHandlerMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + Thread.currentThread());

        tvCounter = (TextView) findViewById(R.id.tvCounter);
        tvAsyncTask= (TextView) findViewById(R.id.tvAsyncTask);
        tvThreadHandlerMessage= (TextView) findViewById(R.id.tvThreadHandlerMessage);


    }

    public void executeThreads(View view) {


        Log.d(TAG, "executeThreads: " + Thread.currentThread());

        switch (view.getId()) {

            case R.id.btnThread:

                TestThread testThread = new TestThread(tvCounter);
                testThread.start();


                break;

            case R.id.btnRunnable:


                TestRunnable testRunnable = new TestRunnable(tvCounter);
                Thread thread = new Thread(testRunnable);
                thread.start();

                break;

            case R.id.btnMultipleRunnables:

//                Running multiple runnables in a single thread using the thread executor
//                It will run the task in a sequence
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                TestRunnable testRunnable1 = new TestRunnable(tvCounter);
                TestRunnable testRunnable2 = new TestRunnable(tvCounter);
                TestRunnable testRunnable3 = new TestRunnable(tvCounter);
                executorService.submit(testRunnable1);
                executorService.submit(testRunnable2);
                executorService.submit(testRunnable3);


                break;

            case R.id.btnThreadHandlerMessage:


                Handler handler = new Handler(new Handler.Callback() {

                    @Override
                    public boolean handleMessage(Message message) {
                        tvThreadHandlerMessage.setText(message.getData().getString("data"));
                        return false;

                    }
                });

                TestThreadHandlerMessage testThreadHandlerMessage = new TestThreadHandlerMessage(handler);
                testThreadHandlerMessage.start();


                break;

            case R.id.btnAsyncTask:

                TestAsyncTask testAsyncTask = new TestAsyncTask(tvAsyncTask);
                testAsyncTask.execute("Starting AsyncTask");


                break;

        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){

        Log.d(TAG, "onMessageEvent: " + messageEvent.getMessage() + " " + Thread.currentThread());

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
