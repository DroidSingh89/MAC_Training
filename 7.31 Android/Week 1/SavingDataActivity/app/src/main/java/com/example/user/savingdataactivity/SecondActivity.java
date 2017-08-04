package com.example.user.savingdataactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        List<Person> personList = new ArrayList<>();
        personList = getIntent().getParcelableArrayListExtra("person");

        Toast.makeText(this, personList.size(), Toast.LENGTH_SHORT).show();

//        Person person = getIntent().getParcelableExtra("person");
//        Log.d(TAG, "onCreate: " + person.getName());
//
//
//        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();

    }
}
