package com.example.user.mvp_dagger.view.mainactivity;

import android.hardware.fingerprint.FingerprintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.mvp_dagger.R;
import com.example.user.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivityTag";


    @Inject
    MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaggerMainActivityComponent.create().inject(this);
        
        presenter.attachView(this);
        presenter.setContext(this);

    }


    public void doMagic(View view) {

        presenter.savePerson("John Doe");
        presenter.getPerson();

    }


    @Override
    public void showerror(String s) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {

        Log.d(TAG, "isPersonSaved: " + isSaved);
    }

    @Override
    public void sendPerson(String person) {

        Log.d(TAG, "sendPerson: " + person);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.removeView();
    }
}
