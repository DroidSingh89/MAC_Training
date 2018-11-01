package com.example.user.multithreading.jobs;

import com.example.user.multithreading.model.MyMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyEventHandler extends Thread {

    @Override
    public void run() {
        super.run();

        MyMessageEvent myMessageEvent = new MyMessageEvent("Default data");

        EventBus.getDefault().post(myMessageEvent);

//        task running
        myMessageEvent.setData("Task Running");
        EventBus.getDefault().post(myMessageEvent);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        task completed
        myMessageEvent.setData("Task completed");
        EventBus.getDefault().post(myMessageEvent);

    }
}
