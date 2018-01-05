package com.example.singh.sharingdataviaintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SerialiazablePersonActivity extends AppCompatActivity {

    TextView tvPersonName, tvPersonAge, tvPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Intent intent = getIntent();
        SerializablePerson person = (SerializablePerson) intent.getSerializableExtra("serializablePerson");

        tvPersonAge = (TextView) findViewById(R.id.tvPersonAge);
        tvPersonName= (TextView) findViewById(R.id.tvPersonName);
        tvPersonGender = (TextView) findViewById(R.id.tvPersonGender);

        tvPersonName.setText(person.getName());
        tvPersonAge.setText(String.valueOf(person.getAge()));
        tvPersonGender.setText(person.getGender());

    }


    public void sendParcelablePerson(View view) {

        ParcelablePerson person = new ParcelablePerson("Johnny depp", 50, "Male");
        Intent intent = new Intent(SerialiazablePersonActivity.this, ParcelablePersonActivity.class);
        intent.putExtra("parcelablePerson", person);
        startActivity(intent);


    }
}
