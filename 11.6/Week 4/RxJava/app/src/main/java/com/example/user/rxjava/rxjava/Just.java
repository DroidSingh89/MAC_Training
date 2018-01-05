package com.example.user.rxjava.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 11/28/17.
 */

public class Just {

    public static void main(String[] args) {

        Observable<String> stringObservable = Observable.just(
                "first",
                "Second",
                "third",
                "fourth");


        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe: " + Thread.currentThread().getName());

            }

            @Override
            public void onNext(String s) {

                System.out.println("OnNext: "+ Thread.currentThread().getName());
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("OnError: "+ Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {

                System.out.println("OnComplete: "+ Thread.currentThread().getName());
            }
        };


        stringObservable
                .observeOn(Schedulers.newThread())
                .subscribe(stringObserver);



    }


}
