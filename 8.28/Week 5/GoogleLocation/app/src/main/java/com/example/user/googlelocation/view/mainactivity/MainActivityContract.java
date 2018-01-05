package com.example.user.googlelocation.view.mainactivity;

import android.location.Location;

import com.example.user.googlelocation.BasePresenter;
import com.example.user.googlelocation.BaseView;

/**
 * Created by singh on 9/28/17.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void setLocation();
        void setAddress(String address);
        void showToast(String message);

    }

    interface Presenter extends BasePresenter<View>{

        void getLocation();
        void getCurrentAddress(Location location);

    }

}
