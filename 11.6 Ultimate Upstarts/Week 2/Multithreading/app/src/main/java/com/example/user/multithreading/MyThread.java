package com.example.user.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by singh on 11/14/17.
 */

public class MyThread extends Thread {

    private static final String TAG = "MyThread";

    Handler handler;

    public MyThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: " + Thread.currentThread() + " : " + i);

            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("value", i);
            message.setData(bundle);
            handler.sendMessage(message);

        }



    }

}
