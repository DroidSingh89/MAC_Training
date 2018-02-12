package com.example.user.mvp_dagger.view.main;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp_dagger.BuildConfig;
import com.example.user.mvp_dagger.R;
import com.example.user.mvp_dagger.di.DaggerMainComponent;
import com.example.user.mvp_dagger.model.StringBean;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private TextView tvMain;
    private EditText etMain;

    @Inject
    public MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        //initialize the dagger component
        DaggerMainComponent
                .create()
                .inject(this);

        presenter.attachView(this);


    }

    private void bindViews() {
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
    }

    public void onTextViewUpdate(View view) {

        presenter.updateTextView(etMain.getText().toString());

    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdateTextView(StringBean stringBean) {
        tvMain.setText(stringBean.getData());

    }

    @Override
    public void onStringAdded(boolean isAdded) {

        String message = null;
        if (isAdded) {
            message = "Added";
        } else message = "Not Added";

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListReceived(List<String> strings) {

        Toast.makeText(this, strings.toString(), Toast.LENGTH_SHORT).show();

    }

    public void onStringAdded(View view) {
        presenter.addToList(etMain.getText().toString());
    }

    public void onPrintList(View view) {

        presenter.getStringList();
    }


}
