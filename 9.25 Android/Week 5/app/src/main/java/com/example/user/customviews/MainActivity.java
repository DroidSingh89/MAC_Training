package com.example.user.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CustomCircle customCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCircle = findViewById(R.id.customCircle);
        TextView textView;

    }

    public void changeRadius(View view) {

        customCircle.setRadius(50);

    }
}
