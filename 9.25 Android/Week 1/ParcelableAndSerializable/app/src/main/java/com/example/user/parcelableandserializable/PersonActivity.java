package com.example.user.parcelableandserializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.user.parcelableandserializable.utils.CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        String action = getIntent().getAction();

        String personName;

        switch (action){


            case CONSTANTS.Action.ACTION_PERSON_PARCELABLE:

                PersonParcelable personParcelable = getIntent()
                        .getParcelableExtra("personParcelable");
                personName = personParcelable.getName();
                showToast(personName);
                break;

            case CONSTANTS.Action.ACTION_PERSON_SERIALIZABLE:

                PersonSerializable personSerializable = (PersonSerializable) getIntent()
                        .getSerializableExtra("personSerializable");
                personName = personSerializable.getName();
                showToast(personName);
                break;


        }


    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
