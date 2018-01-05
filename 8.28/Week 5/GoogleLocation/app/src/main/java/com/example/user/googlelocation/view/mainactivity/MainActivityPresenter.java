package com.example.user.googlelocation.view.mainactivity;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.example.user.googlelocation.data.remote.ApiProvider;
import com.example.user.googlelocation.model.GeocodeResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by singh on 9/28/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{


    private static final String TAG = "MainPresenterTag";
    MainActivityContract.View view;
    String address;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void getLocation() {

        view.setLocation();

    }


    @Override
    public void getCurrentAddress(Location location) {

        //get data from the api
        //create an observable that will emit the response from the network call
        Observable<GeocodeResponse> responseObservable = ApiProvider.getGeocodeObs(location);

        //create an observer that is going to read the emitted values
        Observer<GeocodeResponse> responseObserver = new Observer<GeocodeResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(@NonNull GeocodeResponse geocodeResponse) {
                address = geocodeResponse.getResults().get(0).getFormattedAddress();
                Log.d(TAG, "onNext: " + address);

                view.showToast(address);


            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                view.setAddress(address);

            }
        };

        //subscribe the oberver to the observable
        responseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseObserver);

    }
}
