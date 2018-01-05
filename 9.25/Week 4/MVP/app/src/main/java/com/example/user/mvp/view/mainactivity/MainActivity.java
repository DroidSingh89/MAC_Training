package com.example.user.mvp.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp.R;
import com.example.user.mvp.di.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements MainActivityContract.View{


    private TextView textView;
    private EditText editText;

    @Inject
    private MainActivityPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etFirstName);
        textView = (TextView) findViewById(R.id.tvFullName);

        //presenter = new MainActivityPresenter();

        //Dagger[ComponentName] DaggerMain

        //setup dagger annotation
        DaggerMainActivityComponent.create().inject(this);

        presenter.addView(this);
    }

    public void getFullName(View view) {

        String firstName = editText.getText().toString();

        presenter.getFullName(firstName);

    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFullName(String fullName) {

        textView.setText(fullName);
    }
}
