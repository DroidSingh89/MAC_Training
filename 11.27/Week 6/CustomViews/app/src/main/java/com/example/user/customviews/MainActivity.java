package com.example.user.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyCircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleView = findViewById(R.id.nyCircleView);

        Button button;


    }

    public void onNewRadius(View view) {
        int currentRadius = circleView.getRadius();
        circleView.setRadius(currentRadius + 10);
    }
}
