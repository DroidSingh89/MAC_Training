package com.example.user.mvpdagger.view.github;

import com.example.user.mvpdagger.model.github.Repo;
import com.example.user.mvpdagger.view.base.BasePresenter;
import com.example.user.mvpdagger.view.base.BaseView;

import java.util.List;

public interface GithubContract {

    //    for communication from Presenter to View
    interface View extends BaseView {

        void onValidationResults(String validName);

        void onRepoResult(List<Repo> repoList);

    }


    //    for communication from View to presenter
    interface Presenter extends BasePresenter<View> {

        void validateName(String name);

        void getRepos(String username);
    }

}
