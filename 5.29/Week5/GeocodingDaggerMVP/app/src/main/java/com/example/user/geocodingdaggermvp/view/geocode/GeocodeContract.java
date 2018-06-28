package com.example.user.geocodingdaggermvp.view.geocode;

import android.location.Location;

import com.example.user.geocodingdaggermvp.view.base.BasePresenter;
import com.example.user.geocodingdaggermvp.view.base.BaseView;

public interface GeocodeContract {

    interface View extends BaseView{

        void onLocationReceived(Location location);

        void onAddressReceived(String address);

    }


    interface Presenter extends BasePresenter<View>{

        void getCurrentLocation();

        void getAddress();

    }
}

