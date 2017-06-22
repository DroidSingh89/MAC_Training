package com.example.singh.sharingdataviaintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ParcelablePersonActivity extends AppCompatActivity {

    TextView tvPersonName, tvPersonAge, tvPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_person);

        Intent intent = getIntent();
        ParcelablePerson person = (ParcelablePerson) intent.getParcelableExtra("parcelablePerson");

        tvPersonAge = (TextView) findViewById(R.id.tvPersonAge);
        tvPersonName= (TextView) findViewById(R.id.tvPersonName);
        tvPersonGender = (TextView) findViewById(R.id.tvPersonGender);

        tvPersonName.setText(person.getName());
        tvPersonAge.setText(String.valueOf(person.getAge()));
        tvPersonGender.setText(person.getGender());


    }
}
