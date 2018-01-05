package com.example.user.mvp_dagger.view.mainactivity;

import com.example.user.mvp_dagger.BasePresenter;
import com.example.user.mvp_dagger.BaseView;

/**
 * Created by singh on 9/26/17.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void updateView(String str);

    }

    interface Presenter extends BasePresenter<View>{

        void validateInput(String inputString);

    }


}
