package com.example.user.customviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.customviews.customviews.CustomButton;
import com.example.user.customviews.customviews.CustomCircle;
import com.example.user.customviews.loginview.LoginView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements CustomButton.onClickListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private CustomCircle customCircle;
    private LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom button
        CustomButton customButton = findViewById(R.id.btnCustom);
        customButton.setCustomClickListener(this);

        //custom circle
        customCircle = findViewById(R.id.customCircle);

        //login view implementation
        loginView = findViewById(R.id.loginView);
        loginView.setOnLoginResultsListener(new LoginView.OnLoginResults() {
            @Override
            public void onSuccess(String email) {

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);


            }

            @Override
            public void onFailure(String error) {

                Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void customOnClick(String customValue) {
        Log.d(TAG, "customOnClick: " + customValue);
        Toast.makeText(this, customValue, Toast.LENGTH_SHORT).show();
    }

    public void onChangeRadius(View view) {
        int randomRadius = (new Random().nextInt(10) + 5) * 10;
        customCircle.setRadius(randomRadius);
    }
}
