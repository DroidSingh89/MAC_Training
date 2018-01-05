package com.example.singh.multithreadingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MaintActivityTag";
    TextView tvResultPost, tvResultDelayed, tvResultAsynctask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultPost = (TextView) findViewById(R.id.tvResultPost);
        tvResultDelayed = (TextView) findViewById(R.id.tvResultDelayed);
        tvResultAsynctask = (TextView) findViewById(R.id.tvResultAsyntask);

        Log.d(TAG, "onCreate: ");

    }

    public void testRunnable(View view) {

        TestRunnable testRunnable = new TestRunnable(tvResultPost, tvResultDelayed);
        Thread thread = new Thread(testRunnable);
        thread.start();





    }

    public void testThread(View view) {

        TestThread testThread = new TestThread(tvResultPost, tvResultDelayed);
        testThread.start();

    }

    public void testAsynctask(View view) {

        TestAsynctask testAsynctask = new TestAsynctask(tvResultAsynctask);
        testAsynctask.execute("Starting");


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
    public void onMessageEvent(HelloEvent event){

        Toast.makeText(this, event.getMessage(), Toast.LENGTH_SHORT).show();


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnStuffEvent(StuffEvent event){
        tvResultAsynctask.setText(event.getMessage());
    }







}
