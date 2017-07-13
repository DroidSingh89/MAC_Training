package com.example.singh.mvp_dagger;

/**
 * Created by singh on 7/12/17.
 */

public interface BasePresenter<V extends BaseView> {

    void addView(V view);
    void removeView();


}
