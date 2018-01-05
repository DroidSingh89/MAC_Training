package com.example.user.mvp_dagger.view.mainactivity;

import android.content.Context;

import com.example.user.mvp_dagger.BasePresenter;
import com.example.user.mvp_dagger.BaseView;

/**
 * Created by singh on 8/21/17.
 */

public interface MainActivityContract {


    interface View extends BaseView{

        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);


    }

    interface Presenter extends BasePresenter<View>{

        void savePerson(String person);
        void getPerson();
        void setContext(Context context);

    }



}
