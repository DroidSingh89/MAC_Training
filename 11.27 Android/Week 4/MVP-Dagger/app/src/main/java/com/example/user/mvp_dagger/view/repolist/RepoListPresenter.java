package com.example.user.mvp_dagger.view.repolist;

import android.util.Log;

import com.example.user.mvp_dagger.data.remote.RemoteDataSource;
import com.example.user.mvp_dagger.model.Repo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 12/19/17.
 */

public class RepoListPresenter implements RepoListContract.Presenter {


    private static final String TAG = "RepoListPresenterTag";
    RepoListContract.View view;

    @Override
    public void attachView(RepoListContract.View view) {

        Log.d(TAG, "attachView: ");
        this.view = view;
    }

    @Override
    public void detachView() {

        Log.d(TAG, "detachView: ");
        this.view = null;
    }

    @Override
    public void getFullName(String firstName, String lastName) {

        Log.d(TAG, "getFullName: ");
        view.setFullName(firstName + " " + lastName);
    }

    @Override
    public void getRepos(String username) {

        final List<Repo> repos = new ArrayList<>();

        RemoteDataSource.getRepos("manroopsingh")
                .subscribeOn(Schedulers.io())//do the job on a separate thread
                .observeOn(AndroidSchedulers.mainThread())//get the results back on main
                //changing the list observable to a repo observable
                .flatMap(new Function<List<Repo>, Observable<Repo>>() {
                    @Override
                    public Observable<Repo> apply(final List<Repo> repos) throws Exception {

                        Observable<Repo> repoObservable = Observable.create(new ObservableOnSubscribe<Repo>() {
                            @Override
                            public void subscribe(ObservableEmitter<Repo> e) throws Exception {
                                for(Repo r: repos)
                                    e.onNext(r);

                                e.onComplete();
                            }
                        });

                        return repoObservable;

                    }
                })
                .map(new Function<Repo, Repo>() {
                    @Override
                    public Repo apply(Repo repo) throws Exception {

                        String repoName = repo.getFullName();
//                        add My to all the repos in the list
                        repo.setFullName("My" + repoName);

                        return repo;


                    }
                })
                .subscribe(new Observer<Repo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Repo repo) {

                        repos.add(repo);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {

                        view.setRepos(repos);
                    }
                });

    }
}
