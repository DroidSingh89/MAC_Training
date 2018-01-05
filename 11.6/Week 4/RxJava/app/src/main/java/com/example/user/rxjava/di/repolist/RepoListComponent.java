package com.example.user.rxjava.di.repolist;

import com.example.user.rxjava.view.repolist.RepoList;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by singh on 11/29/17.
 */

@Component(modules = RepoListModule.class)
@Singleton
public interface RepoListComponent {


    void inject(RepoList repoList);
}
