package com.example.user.rxjava.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by singh on 10/12/17.
 */

public class RxJavaRange {

    public static void main(String[] args) {


        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("OnSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("OnNext" + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

                System.out.println("OnComplete");
            }
        };



        integerObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        if (integer > 5)
                            return true;
                        else
                            return false;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer*10;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer*20;
                    }
                })
                .take(3)
                .subscribe(integerObserver);


    }
}
