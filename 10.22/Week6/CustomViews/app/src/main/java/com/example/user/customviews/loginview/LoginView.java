package com.example.user.customviews.loginview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.user.customviews.R;

public class LoginView extends LinearLayout implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignIn;
    private Button btnSignUp;
    private LoginManager loginManager;
    private OnLoginResults mListener;

    public LoginView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        this.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.login_view, this, true);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        loginManager = new LoginManager(context);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSignIn:

                boolean loginResult = loginManager.checkUser(etEmail.getText().toString(), etPassword.getText().toString());

                if(loginResult) mListener.onSuccess(etEmail.getText().toString());
                else mListener.onFailure("Invalid password");

                break;
            case R.id.btnSignUp:

                loginManager.createAccount(etEmail.getText().toString(), etPassword.getText().toString());
                mListener.onSuccess(etEmail.getText().toString());

                break;
        }
    }

    public void setOnLoginResultsListener(OnLoginResults onLoginResults) {
        this.mListener = onLoginResults;
    }

    public interface OnLoginResults{
        void onSuccess(String email);

        void onFailure(String error);

    }
}
