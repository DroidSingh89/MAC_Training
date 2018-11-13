package com.example.user.androidnetworking.rxjava;


import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Main {


    public static void main(String[] args) {

        startIntegerObservable();
        startIntervalObservable();

    }

    private static void startIntegerObservable() {
        ObservableFactory
                .getIntegerObservable()
                .map(RxUtils.getMultiplyFunc())
                .filter(RxUtils.getGreaterThan30Predicate())
                .take(2)
                .map(RxUtils.getDivideBy2Func())
                .subscribe(ObserverFactory.getIntegerObserver());
    }

    private static void startIntervalObservable() {


        ObservableFactory.getIntervalObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(ObserverFactory.getLongObserver());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
