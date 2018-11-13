package com.example.user.androidnetworking.model.data.remote;

import com.example.user.androidnetworking.model.data.RandomCallback;
import com.example.user.androidnetworking.model.randomresponse.RandomResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<RandomResponse> {

    RandomCallback callback;

    public RemoteObserver(RandomCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(RandomResponse randomResponse) {

        callback.onSuccess(randomResponse.getResults());
    }

    @Override
    public void onError(Throwable e) {

        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
