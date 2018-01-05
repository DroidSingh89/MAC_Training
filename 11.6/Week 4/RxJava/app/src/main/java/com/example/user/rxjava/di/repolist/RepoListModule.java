package com.example.user.rxjava.di.repolist;

import com.example.user.rxjava.view.repolist.RepoListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 11/29/17.
 */

@Module
public class RepoListModule {

    @Provides
    @Singleton
    RepoListPresenter providesRepoListPresenter() {
        return new RepoListPresenter();
    }
}
