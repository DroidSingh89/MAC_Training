package com.example.user.firebase.utils;

/**
 * Created by singh on 12/20/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    void signOut();
}
