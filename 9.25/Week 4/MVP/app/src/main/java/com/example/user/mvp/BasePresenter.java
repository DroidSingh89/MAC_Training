package com.example.user.mvp;

/**
 * Created by singh on 10/18/17.
 */

public interface BasePresenter<V extends BaseView> {

    void addView(V View);
    void removeView();


}
