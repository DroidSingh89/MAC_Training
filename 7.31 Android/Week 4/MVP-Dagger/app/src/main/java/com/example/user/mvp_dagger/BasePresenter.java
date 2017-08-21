package com.example.user.mvp_dagger;

/**
 * Created by singh on 8/21/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void removeView();


}
