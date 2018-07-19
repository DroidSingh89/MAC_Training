package com.example.user.mvpdagger.view.base;

//common method for the presenter
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
