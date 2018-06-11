package com.example.user.multithreading.utils.rxjava;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverFactory {

    public static final String TAG = ObserverFactory.class.getSimpleName()+ "TAG";
    public static Observer getIntegerObserver() {
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe:" + getThreadName());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer + getThreadName());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString() + getThreadName());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: " + getThreadName());
            }
        };

        return integerObserver;
    }

    private static String getThreadName() {
        return " Thread: " + Thread.currentThread().getName();
    }

}
