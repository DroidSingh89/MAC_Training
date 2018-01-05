package com.example.user.rxjava.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by singh on 11/28/17.
 */

public class Range {

    public static void main(String[] args) {


//        create an observable for integer values
        Observable<Integer> integerObservable = Observable.range(1, 10);

//        create an observer to get the values from the observable
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("OnNext: " + integer);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        integerObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if (integer > 5)
                            return true;
                        else
                            return false;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 10;
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if (integer < 90)
                            return true;
                        else
                            return false;
                    }
                })
                .take(2)
                .subscribe(integerObserver);

    }
}
