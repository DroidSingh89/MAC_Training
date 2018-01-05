package com.example.user.customviews;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.customviews.customviews.CustomCircle;

public class MainActivity extends AppCompatActivity {

    private CustomCircle customCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCircle = findViewById(R.id.myCustomCircle);

    }

    public void onRadiusChange(View view) {

        int changedRadius = 200;
        customCircle.setRadius(changedRadius);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onColorChange(View view) {
        int changedColor = getColor(R.color.colorBlue);
        customCircle.setFillColor(changedColor);
        int backgroundColor = getColor(android.R.color.holo_red_light);
        customCircle.setBackgroundColor(backgroundColor);
    }
}
