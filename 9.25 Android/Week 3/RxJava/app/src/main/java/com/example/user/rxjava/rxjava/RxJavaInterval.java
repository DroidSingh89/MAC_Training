package com.example.user.rxjava.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 10/12/17.
 */

public class RxJavaInterval {


    public static void main(String[] args) throws InterruptedException {

        Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS);


        Observer<Long> longObserver = new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long aLong) {

                System.out.println("onNext"+ aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        };

        longObservable.subscribe(longObserver);

        Thread.sleep(5000);







    }
}
