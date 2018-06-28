package com.example.user.geocodingdaggermvp.view.base;


public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
