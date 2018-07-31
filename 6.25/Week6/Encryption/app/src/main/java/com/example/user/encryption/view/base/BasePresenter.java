package com.example.user.encryption.view.base;


public interface BasePresenter<V extends BaseView> {


    void attachView(V view);

    void detachView();
}
