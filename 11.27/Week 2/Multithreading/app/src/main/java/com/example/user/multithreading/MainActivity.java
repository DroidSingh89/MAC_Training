package com.example.user.multithreading;

import android.app.ProgressDialog;
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
    private TextView tvDisplayData;
    private Handler handler;
    private ProgressDialog progressDialog;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplayData =
                findViewById(R.id.tvDisplayData);

        handler = new Handler(this);
    }

    public void handlingMultithreading(View view) {

        Log.d(TAG, "handlingMultithreading: " + Thread.currentThread());
        switch (view.getId()) {

            case R.id.btnThread:

                MyThread myThread = new MyThread("Start the thread", tvDisplayData);
                myThread.start();

                break;

            case R.id.btnRunnable:

                MyRunnable myRunnable = new MyRunnable(handler);
//                myRunnable.run();
                Thread thread = new Thread(myRunnable);
                thread.start();

//                update the UI
                updateUI("Starting the task");
               break;

            case R.id.btnAsyncTask:
                myAsyncTask = new MyAsyncTask(tvDisplayData);
                myAsyncTask.execute("Data from the main activity");

                break;



        }


    }

    private void updateUI(String s) {
        tvDisplayData.setText(s);
        progressDialog = new ProgressDialog(this);

        progressDialog.setCancelable(false);
        progressDialog.setMessage("Working..");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

    }

    @Override
    public boolean handleMessage(Message msg) {
        tvDisplayData.setText(msg.getData().getString("result"));
        progressDialog.dismiss();


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

        if(myAsyncTask!=null)
        myAsyncTask.cancel(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPersonEvent(PersonEvent personEvent){
        Log.d(TAG, "onPersonEvent: " + personEvent.toString());
        Toast.makeText(this, personEvent.getName(), Toast.LENGTH_SHORT).show();
    }

}
