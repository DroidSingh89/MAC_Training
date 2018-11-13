package com.example.user.androidnetworking.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverFactory {

    public static Observer<Integer> getIntegerObserver() {

        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("ObserverFactory.onSubscribe"+ Thread.currentThread().getName());

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println("ObserverFactory.onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("ObserverFactory.onError " + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("ObserverFactory.onComplete");
            }
        };
    }


    public static Observer<Long> getLongObserver() {

        return new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("ObserverFactory.onSubscribe"+ Thread.currentThread().getName());

            }

            @Override
            public void onNext(Long aLong) {

                System.out.println("ObserverFactory.onNext " + aLong);
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("ObserverFactory.onError " + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("ObserverFactory.onComplete");
            }
        };
    }
}
