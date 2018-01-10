package com.example.user.configuringbuilds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.configuringbuilds.paid.debug.FreeActivity;
import com.example.user.configuringbuilds.sample.SampleMain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SampleMain sampleMain = new SampleMain();
        sampleMain.testMethod();

        Intent intent = new Intent(this, FreeActivity.class);
        startActivity(intent);



    }
}
