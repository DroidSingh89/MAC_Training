package com.example.user.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by singh on 9/25/17.
 */

public class usingJust {

    public static void main(String[] args) throws InterruptedException {



        Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Integer> integerObservable = Observable.range(1,10);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe : ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: ");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: ");
            }
        };

        integerObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        return integer>2;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer*10;
                    }
                }).take(5)
                .subscribe(integerObserver);



        Observer<Long> longObserver = new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {

                System.out.println("onNext:" + aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        longObservable.subscribe(longObserver);

        Thread.sleep(5000);



    }


}
