package com.example.user.mvp_dagger.utils;

/**
 * Created by singh on 2/8/18.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
