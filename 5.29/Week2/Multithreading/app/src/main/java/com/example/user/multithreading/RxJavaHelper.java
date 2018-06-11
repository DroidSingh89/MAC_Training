package com.example.user.multithreading;

import android.util.Log;

import com.example.user.multithreading.utils.rxjava.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaHelper {


    public static final String TAG = RxJavaHelper.class.getSimpleName() + "_TAG";

    public static void executeTask() {

//        create observable for emissions
        Observable<Integer> integerObservable
                = Observable.just(1, 2, 3, 4, 5);


//        subscribe to emissions
        integerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ObserverFactory.getIntegerObserver());

    }

    private static String getThreadName() {
        return " Thread: " + Thread.currentThread().getName();
    }

}
