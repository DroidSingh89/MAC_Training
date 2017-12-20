package com.example.user.mvp_dagger.rxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 12/19/17.
 */

public class JustOperator {


    public static void main(String[] args) {


        Observable<String> stringObservable
                = Observable.just(
                "First",
                "Second",
                "Third",
                "Fourth");

        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");

            }

            @Override
            public void onNext(String s) {

                System.out.println("onNext: " + s +
                        "Thread: " + Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        };

        stringObservable.subscribe(stringObserver);

    }


}

