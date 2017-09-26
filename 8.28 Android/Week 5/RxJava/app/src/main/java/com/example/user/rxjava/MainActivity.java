package com.example.user.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integerObserver);



    }
}
