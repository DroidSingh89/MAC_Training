package com.example.user.mvp_dagger.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by singh on 12/19/17.
 */

public class RangeOperator {

    public static void main(String[] args) {

        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);

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

        integerObservable
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {

                        integer = integer * 10;
                        return integer;
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if(integer>50)
                            return true;
                        else
                            return false;
                    }
                })
                .take(2)
                .subscribe(integerObserver);



    }
}
