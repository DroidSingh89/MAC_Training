package com.example.user.locationandmaps.view.mainactivity;

import android.view.View;

import com.example.user.locationandmaps.BasePresenter;
import com.example.user.locationandmaps.BaseView;

/**
 * Created by singh on 10/24/17.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void updateLocation();

    }

    interface Presenter extends BasePresenter<View>{

        void getLocation();


    }

}
