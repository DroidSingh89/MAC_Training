package com.example.user.mvpdagger.di;

import com.example.user.mvpdagger.view.github.GithubActivity;

import dagger.Component;

//contract for dependencies and dependent
@Component(modules = GithubModule.class)
public interface GithubComponent {

    void inject(GithubActivity activity);

}
