package com.example.user.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.customviews.customviews.CustomButton;

public class MainActivity extends AppCompatActivity implements CustomButton.onClickListener{

    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomButton customButton = findViewById(R.id.btnCustom);

        customButton.setCustomClickListener(this);

    }

    @Override
    public void customOnClick(String customValue) {
        Log.d(TAG, "customOnClick: "+ customValue);
        Toast.makeText(this, customValue, Toast.LENGTH_SHORT).show();
    }
}
