package com.example.user.multithreading.threads;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 1/25/18.
 */

public class MyRxJavaHelper {

    private static final String TAG = MyRxJavaHelper.class.getSimpleName();


    public static Observable<Long> getLongObs() {

        return Observable.interval(1,TimeUnit.SECONDS);
    }


    public static Observer<Long> getLongObserver() {

        return new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: "
                        + Thread.currentThread().getName());

            }

            @Override
            public void onNext(Long aLong) {
                Log.d(TAG, "onNext: " + aLong
                        + Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: "
                        + Thread.currentThread().getName());

            }
        };
    }

}
