package com.example.user.customviews;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.customviews.customview.MyCircleView;

public class MainActivity extends AppCompatActivity {

    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircleView = findViewById(R.id.myCircleView);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onColorChanged(View view) {
        myCircleView.setFillColor(getColor(R.color.colorAccent));

    }

    public void onRadiusChanged(View view) {
        myCircleView.setRadius(50);

    }
}
