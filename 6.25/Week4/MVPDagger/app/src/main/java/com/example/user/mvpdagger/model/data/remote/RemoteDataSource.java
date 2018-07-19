package com.example.user.mvpdagger.model.data.remote;

import com.example.user.mvpdagger.model.github.Repo;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String BASE_URL = "https://api.github.com/";

    private Retrofit createInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }


    private Observable<List<Repo>> getReposFromNetwork(String username) {

        return createInstance().create(RemoteService.class).getRepos(username);
    }

    public void getRepos(String username, final Callback callback) {


        getReposFromNetwork(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Repo> repos) {

                        callback.onRemoteResponse(repos);

                    }

                    @Override
                    public void onError(Throwable e) {

                        callback.onRemoteFailure(e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface Callback{

        void onRemoteResponse(List<Repo> repos);
        void onRemoteFailure(String error);
    }

}
