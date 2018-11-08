package com.example.user.mvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainPresenter presenter;
    private EditText etMain;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);


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
