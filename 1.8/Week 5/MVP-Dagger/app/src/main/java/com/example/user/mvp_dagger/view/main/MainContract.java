package com.example.user.mvp_dagger.view.main;

import com.example.user.mvp_dagger.model.StringBean;
import com.example.user.mvp_dagger.utils.BasePresenter;
import com.example.user.mvp_dagger.utils.BaseView;

import java.util.List;

/**
 * Created by singh on 2/8/18.
 */

public interface MainContract {


    interface View extends BaseView {
        void onUpdateTextView(StringBean stringBean);

        void onStringAdded(boolean isAdded);

        void onListReceived(List<String> strings);
    }

    interface Presenter extends BasePresenter<View> {

        void updateTextView(String string);

        void addToList(String s);

        void getStringList();
    }

}

