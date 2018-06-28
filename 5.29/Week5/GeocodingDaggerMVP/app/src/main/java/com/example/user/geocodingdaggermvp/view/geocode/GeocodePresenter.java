package com.example.user.geocodingdaggermvp.view.geocode;

import android.location.Location;
import android.widget.Toast;

import com.example.user.geocodingdaggermvp.manager.LocationManager;
import com.example.user.geocodingdaggermvp.model.datasource.RemoteDataSource;
import com.example.user.geocodingdaggermvp.model.response.GeocodeResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeocodePresenter implements GeocodeContract.Presenter, LocationManager.LocationListener{

    GeocodeContract.View view;
    LocationManager locationManager;
    Location location;


    @Override
    public void getCurrentLocation() {

//       get current location
        locationManager.getLocation();

    }

    @Override
    public void getAddress() {

        RemoteDataSource
                .getResponse(getFormattedLocation())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GeocodeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GeocodeResponse geocodeResponse) {

                        view.onAddressReceived(geocodeResponse.getResults().get(0).getFormattedAddress());

                    }

                    @Override
                    public void onError(Throwable e) {

                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private String getFormattedLocation() {
        String lat = String.valueOf(location.getLatitude());
        String lng = String.valueOf(location.getLongitude());
        String latLng = lat + "," + lng;
        return latLng;
    }

    @Override
    public void attachView(GeocodeContract.View view) {
        this.view = view;
        locationManager = new LocationManager(view, this);


    }

    @Override
    public void detachView() {
        this.view = null;
    }

//    implemented from locationManager
    @Override
    public void onLocationResults(Location location) {
        this.location = location;
        view.onLocationReceived(location);
    }
}
