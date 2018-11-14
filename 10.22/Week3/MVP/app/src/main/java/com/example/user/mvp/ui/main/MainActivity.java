package com.example.user.mvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp.R;
import com.example.user.mvp.di.DaggerMainComponent;
import com.example.user.mvp.util.StringManipulator;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View{


    private EditText etMain;
    private TextView tvMain;

    @Inject
    MainPresenter presenter;

    @Inject
    MainPresenter presenter2;

    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);

        DaggerMainComponent.create().inject(this);

        Log.d(TAG, "onCreate: " + presenter.toString());
        Log.d(TAG, "onCreate: "+ presenter2.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void onManipulationResult(String manipulatedString) {

        tvMain.setText(manipulatedString);

    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    public void onChangeText(View view) {
        presenter.manipulateString(etMain.getText().toString());

    }

}
