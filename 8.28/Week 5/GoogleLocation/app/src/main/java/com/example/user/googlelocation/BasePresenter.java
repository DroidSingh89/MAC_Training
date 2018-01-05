package com.example.user.googlelocation;

/**
 * Created by singh on 9/28/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
