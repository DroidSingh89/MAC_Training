package com.example.user.mvp_dagger.utils.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
