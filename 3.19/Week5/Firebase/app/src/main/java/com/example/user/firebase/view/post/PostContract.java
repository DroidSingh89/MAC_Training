package com.example.user.firebase.view.post;

import com.example.user.firebase.view.base.BasePresenter;
import com.example.user.firebase.view.base.BaseView;

public interface PostContract {

    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }

}
