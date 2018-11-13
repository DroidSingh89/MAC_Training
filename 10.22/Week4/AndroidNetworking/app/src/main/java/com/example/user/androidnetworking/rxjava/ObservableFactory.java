package com.example.user.androidnetworking.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ObservableFactory {


    public static Observable<Integer> getIntegerObservable() {

        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6);
        return integerObservable;
    }

    public static Observable<Long> getIntervalObservable() {

        Observable<Long> intervalObservable = Observable.interval( 1, TimeUnit.SECONDS);
        return intervalObservable;
    }
}
