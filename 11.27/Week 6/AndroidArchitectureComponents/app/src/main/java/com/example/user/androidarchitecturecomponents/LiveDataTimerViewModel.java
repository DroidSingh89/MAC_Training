package com.example.user.androidarchitecturecomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by singh on 1/11/18.
 */

public class LiveDataTimerViewModel extends ViewModel {


    MutableLiveData<Long> elapsedTime = new MutableLiveData<>();

    public LiveDataTimerViewModel() {
        final long initialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        //update the time every second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                long newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;

                elapsedTime.postValue(newValue);
            }
        },1000, 1000);

    }

    public LiveData<Long> getElapsedTime() {
        return elapsedTime;
    }
}
