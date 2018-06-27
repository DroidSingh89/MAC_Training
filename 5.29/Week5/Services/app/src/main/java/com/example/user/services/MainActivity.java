package com.example.user.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlingServices(View view) {

//        normal intent
        Intent normalIntent = new Intent(this, MyNormalService.class);
        normalIntent.putExtra("data", "some Data");

//        intentService intent
        Intent intIntent = new Intent(this, MyIntentService.class);
        intIntent.putExtra("iterations", 5);

        switch (view.getId()) {
//Normal Service
            case R.id.btnStartNormal:
                startService(normalIntent);

                break;

            case R.id.btnStopNormal:
                stopService(normalIntent);

                break;
//Intent Service
            case R.id.btnStartIntent:
                startService(intIntent);
                break;

        }
    }
}
