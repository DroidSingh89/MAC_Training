package com.example.user.mvp_dagger.utils.base;

/**
 * Created by singh on 12/19/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
