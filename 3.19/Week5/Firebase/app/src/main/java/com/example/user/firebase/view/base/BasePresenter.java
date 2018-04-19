package com.example.user.firebase.view.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
