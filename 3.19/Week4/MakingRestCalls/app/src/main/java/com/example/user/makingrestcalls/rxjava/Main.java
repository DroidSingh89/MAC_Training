package com.example.user.makingrestcalls.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;

public class Main {

    public static void main(String[] args) {

        //define an observable

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);



        Observable<Integer> observable = Observable.fromIterable(integers);





        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.
                filter(RxjavaUtils.getPredicate())
                .takeLast(2)
                .map(RxjavaUtils.getFunction())
                .subscribe(integerObserver);


        integers.add(6);

//        PublishSubject<Integer> changeObservable = PublishSubject.create();
//
//        changeObservable.subscribe(integerObserver);
//        changeObservable.onNext(1);
//        changeObservable.onNext(2);
//        changeObservable.onNext(3);
//        changeObservable.onNext(4);

    }


}
