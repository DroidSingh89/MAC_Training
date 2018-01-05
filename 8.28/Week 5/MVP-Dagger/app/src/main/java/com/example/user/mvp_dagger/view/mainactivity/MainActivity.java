package com.example.user.mvp_dagger.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp_dagger.R;
import com.example.user.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;
import com.example.user.mvp_dagger.injection.mainactivity.MainActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivityTag";
    @BindView(R.id.etInputString)
    EditText etInputString;
    @BindView(R.id.btnUpdateView)
    Button btnUpdateView;
    @BindView(R.id.tvOutputString)
    TextView tvOutputString;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupDaggerComponent();

        presenter.attachView(this);


    }

    private void setupDaggerComponent() {
        DaggerMainActivityComponent.create().inject(this);

//        $Dependencies needed by the module
//        DaggerMainActivityComponent.builder()
//                .mainActivityModule(new MainActivityModule($Dependencies))
//                .build().inject(this);
    }

    @Override
    public void showError(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateView(String str) {

        tvOutputString.setText(str);
    }


    @OnClick(R.id.btnUpdateView)
    public void onViewClicked() {
        presenter.validateInput(etInputString.getText().toString());
    }
}
