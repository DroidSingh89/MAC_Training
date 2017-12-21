package com.example.user.mvp_dagger.di.repolist;

import com.example.user.mvp_dagger.view.repolist.RepoListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 12/21/17.
 */

@Module
public class RepoListModule {

    @Provides
    @Singleton
    RepoListPresenter providesRepoListPresenter(){
        return new RepoListPresenter();
    }

}
