package com.example.user.customviews;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircle = findViewById(R.id.myCircle);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onChangeFillColor(View view) {

        myCircle.setFillColor(getColor(R.color.colorPrimary));
    }

    public void onChangeRadius(View view) {
        myCircle.setRadius(50);

    }
}
