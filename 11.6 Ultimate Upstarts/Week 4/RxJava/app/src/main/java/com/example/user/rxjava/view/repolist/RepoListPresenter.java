package com.example.user.rxjava.view.repolist;

import android.util.Log;

import com.example.user.rxjava.data.remote.RemoteDataSource;
import com.example.user.rxjava.model.Repo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 11/29/17.
 */

public class RepoListPresenter implements RepoListContract.Presenter{

    private static final String TAG = "RepoListPresenterTag";
    RepoListContract.View view;
    List<Repo> repoList = new ArrayList<>();


    @Override
    public void attachView(RepoListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void getRepos(String username) {



        RemoteDataSource.getUserRepos(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showProgress("Downloading repos..");
                    }

                    @Override
                    public void onNext(List<Repo> repos) {

                        Log.d(TAG, "onNext: "  + repos.size());
                        repoList.addAll(repos);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        view.showProgress("Check your logs");
                        view.setRepos(repoList);
                        view.showProgress("Downloaded all repos");

                    }
                });



    }
}
