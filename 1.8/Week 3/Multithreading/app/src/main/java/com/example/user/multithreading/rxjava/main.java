package com.example.user.multithreading.rxjava;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 1/25/18.
 */

public class main {

    private static final String TAG = main.class.getSimpleName();


    public static void main(String[] args) {


        //create an observable using the range operator
        Observable<Integer> integerObservable
                = Observable.range(1, 10);


        //create an observer to subscribe the emitted values
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: "
                        + integer
                        + " Thread:" + Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: ");

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: ");

            }
        };


        integerObservable
                .observeOn(Schedulers.newThread())
                .map(getMapper())
                .filter(getPredicate())
                .take(2)
                .subscribe(integerObserver);


    }

    @NonNull
    private static Function<Integer, Integer> getMapper() {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                integer = integer * 10;
                return integer;

            }
        };
    }

    @NonNull
    private static Predicate<Integer> getPredicate() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                if (integer > 50) {
                    return true;
                } else {

                    return false;
                }
            }
        };
    }
}
