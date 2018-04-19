package com.example.user.firebase.view.movie;

import com.example.user.firebase.view.base.BasePresenter;
import com.example.user.firebase.view.base.BaseView;

public interface MovieContract {

    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }

}
