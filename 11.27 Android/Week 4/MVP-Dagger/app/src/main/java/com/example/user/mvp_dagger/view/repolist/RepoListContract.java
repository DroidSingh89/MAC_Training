package com.example.user.mvp_dagger.view.repolist;

import com.example.user.mvp_dagger.model.Repo;
import com.example.user.mvp_dagger.utils.base.BasePresenter;
import com.example.user.mvp_dagger.utils.base.BaseView;

import java.util.List;

/**
 * Created by singh on 12/19/17.
 */

public interface RepoListContract {

//    specific methods as per the view/presenter

    interface View extends BaseView{

        void setFullName(String fullName);
        void setRepos(List<Repo> repos);


    }

    interface Presenter extends BasePresenter<View>{

        void getFullName(String firstName, String lastName);

        void getRepos(String username);

    }
}
