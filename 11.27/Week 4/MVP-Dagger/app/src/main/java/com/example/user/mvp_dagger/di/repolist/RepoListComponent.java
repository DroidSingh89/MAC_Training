package com.example.user.mvp_dagger.di.repolist;

import com.example.user.mvp_dagger.view.repolist.RepoList;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by singh on 12/21/17.
 */

@Singleton
@Component(modules = RepoListModule.class)
public interface RepoListComponent {

    void inject(RepoList repoList);
}
