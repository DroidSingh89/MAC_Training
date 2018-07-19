package com.example.user.mvpdagger.view.github;

import com.example.user.mvpdagger.model.data.remote.RemoteDataSource;
import com.example.user.mvpdagger.model.github.Repo;

import java.util.List;

import javax.inject.Inject;

public class GithubPresenter implements GithubContract.Presenter {

    GithubContract.View view;
    RemoteDataSource remoteDataSource;

    @Inject
    public GithubPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }



    @Override
    public void validateName(String name) {

        if (name.equals("something"))
            view.showError("This is not a valid name.");
        else
            view.onValidationResults("Mr/Mrs " + name);


    }

    @Override
    public void getRepos(String username) {

        remoteDataSource.getRepos(username, new RemoteDataSource.Callback() {
            @Override
            public void onRemoteResponse(List<Repo> repos) {
                view.onRepoResult(repos);
            }

            @Override
            public void onRemoteFailure(String error) {
                view.showError(error);

            }
        });
    }

    @Override
    public void attachView(GithubContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
