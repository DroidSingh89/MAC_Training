package com.example.user.multithreading.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 11/15/17.
 */

public class MyEventThread extends Thread {


    @Override
    public void run() {
        super.run();

        //do the job
        MessageEvent messageEvent = new MessageEvent("This is the result");

        //post the results
        EventBus.getDefault().post(messageEvent);

    }


}
