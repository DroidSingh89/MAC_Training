package com.example.user.rxjava.view.repolist;

import com.example.user.rxjava.model.Repo;
import com.example.user.rxjava.utils.BasePresenter;
import com.example.user.rxjava.utils.BaseView;

import java.util.List;

/**
 * Created by singh on 11/29/17.
 */

public interface RepoListContract {

    //methods for repolist activity

    interface View extends BaseView{
        void setRepos(List<Repo> repos);
        void showProgress(String progress);
    }

    interface Presenter extends BasePresenter<View>{
        void getRepos(String username);

    }
}
