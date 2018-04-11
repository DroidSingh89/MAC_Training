package com.example.user.makingrestcalls;

import android.util.Log;

import com.example.user.makingrestcalls.model.GithubProfile;

import static android.content.ContentValues.TAG;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainObserver implements Observer<GithubProfile> {

    onObserverInteraction listener;

    public static final String TAG = MainObserver.class.getSimpleName();
    public MainObserver(onObserverInteraction listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(GithubProfile githubProfile) {

        Log.d(TAG, "onNext: ");
        listener.onResult(githubProfile);
    }

    @Override
    public void onError(Throwable e) {

        Log.d(TAG, "onError: ");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");

    }


    interface onObserverInteraction{
        void onResult(GithubProfile githubProfile);
    }
}
