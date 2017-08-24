package com.example.user.savingdatafirebase;

/**
 * Created by singh on 8/22/17.
 */

public interface BasePresenter<V extends BaseView> {


    void attachView(V view);
    void detachView();


}
