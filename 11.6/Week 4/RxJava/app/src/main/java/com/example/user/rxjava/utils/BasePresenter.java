package com.example.user.rxjava.utils;

/**
 * Created by singh on 11/29/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
