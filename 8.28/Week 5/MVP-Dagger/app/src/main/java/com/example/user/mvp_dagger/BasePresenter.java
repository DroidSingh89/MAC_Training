package com.example.user.mvp_dagger;

/**
 * Created by singh on 9/26/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();


}
