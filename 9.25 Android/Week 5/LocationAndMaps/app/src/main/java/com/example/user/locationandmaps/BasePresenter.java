package com.example.user.locationandmaps;

/**
 * Created by singh on 10/24/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V View);
    void detach();


}
