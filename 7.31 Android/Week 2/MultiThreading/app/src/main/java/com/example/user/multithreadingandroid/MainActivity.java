package com.example.user.multithreadingandroid;

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

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private static final String TAG = "MainActivityTag";
    TextView tvTesting;
    TextView tvTestTHM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTesting = (TextView) findViewById(R.id.tvTesting);
        tvTestTHM= (TextView) findViewById(R.id.tvThreadHandlerMessage);

    }

    public void executeThreads(View view) {


        switch (view.getId()){

            case R.id.btnThread:

                TestThread testThread = new TestThread(tvTesting);
                testThread.start();

                break;

            case R.id.btnRunnable:

                TestRunnable testRunnable = new TestRunnable(tvTesting);
                Thread thread = new Thread(testRunnable);
                thread.start();

                break;

            case R.id.btnAsyntask:

                TestAsynctask testAsynctask = new TestAsynctask();
                testAsynctask.execute("Starting") ;
                break;


            case R.id.btnThreadHandlerMessage:

                //creating a new handler with the callback
                Handler handler = new Handler(new Handler.Callback() {

                    @Override
                    public boolean handleMessage(Message message) {
                        Log.d(TAG, "handleMessage: from Handler");
                        tvTestTHM.setText(message.getData().getString("KEY_DATA"));
                        return false;
                    }
                });


                //Using Handler
                TestThreadHandlerMessage testThreadHandlerMessageH = new TestThreadHandlerMessage(handler);
                testThreadHandlerMessageH.start();

                //create the handler by implementing the callback in the class
                Handler handler1 = new Handler(this);

                //Using handler1
                TestThreadHandlerMessage testThreadHandlerMessageH1 = new TestThreadHandlerMessage(handler1);
                testThreadHandlerMessageH1.start();


                //create the handler by implementing the callback in the class
                Handler handler2 = new Handler(new CallbackHandler());

                //Using handler2
                TestThreadHandlerMessage testThreadHandlerMessageH2 = new TestThreadHandlerMessage(handler2);
                testThreadHandlerMessageH2.start();


                break;


        }

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
    public void onMessageEvent(MessageEvent messageEvent){
        Toast.makeText(this, messageEvent.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean handleMessage(Message message) {
        tvTestTHM.setText(message.getData().getString("KEY_DATA"));
        Log.d(TAG, "handleMessage: from Handler1");
        return false;
    }
}
