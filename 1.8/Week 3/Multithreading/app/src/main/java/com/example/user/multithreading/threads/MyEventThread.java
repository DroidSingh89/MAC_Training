package com.example.user.multithreading.threads;

import android.arch.lifecycle.Lifecycle;
import android.content.res.Resources;

import com.example.user.multithreading.MyEvent;
import com.example.user.multithreading.MyTasks;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 1/25/18.
 */

public class MyEventThread extends Thread {

    @Override
    public void run() {
        super.run();

        EventBus.getDefault().post(new MyEvent("Task in progress"));

        //do the task
        MyTasks.startSimpleJob(MyEventThread.class.getSimpleName());


        EventBus.getDefault().post(new MyEvent("Task Completed"));


    }
}
