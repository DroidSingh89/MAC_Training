package com.example.user.multithreading.threads;

import com.example.user.multithreading.MyTasks;
import com.example.user.multithreading.myEvents.MyMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyEventThread extends Thread {


    @Override
    public void run() {
        super.run();
        MyTasks.startJob(this.getClass().getSimpleName());

        String result = "Job completed";

        //send the result back
        EventBus.getDefault().post(new MyMessageEvent(result));

    }
}
