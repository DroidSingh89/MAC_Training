package com.example.user.rxjava.view.repolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.user.rxjava.R;
import com.example.user.rxjava.data.remote.RemoteDataSource;

import com.example.user.rxjava.di.repolist.DaggerRepoListComponent;
import com.example.user.rxjava.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepoList extends AppCompatActivity implements RepoListContract.View{

    private static final String TAG = "MainActivityTag";

    @Inject
    RepoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DaggerRepoListComponent
        DaggerRepoListComponent.create().inject(this);


        presenter.attachView(this);
        presenter.getRepos("manroopsingh");


    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRepos(List<Repo> repos) {

        for(Repo repo: repos){
            Log.d(TAG, "setRepos: " + repo.getName());
        }
    }

    @Override
    public void showProgress(String progress) {

        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
