package com.example.user.parcelableandserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.parcelableandserializable.utils.CONSTANTS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;
    private EditText etPersonAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etPersonAge = (EditText) findViewById(R.id.etPersonAge);
        etPersonGender = (EditText) findViewById(R.id.etPersonGender);
        etPersonAddress = (EditText) findViewById(R.id.etPersonAddress);


    }

    public void sendPerson(View view) {

        String personName = etPersonName.getText().toString();
        String personAge = etPersonAge.getText().toString();
        String personGender = etPersonGender.getText().toString();
        String personAddress = etPersonAddress.getText().toString();

        PersonSerializable personSerializable = new PersonSerializable(personName, personAge, personGender, personAddress);
        PersonParcelable personParcelable = new PersonParcelable(personName, personAge, personGender, personAddress);


        Intent intent = new Intent(this, PersonActivity.class);

        switch (view.getId()) {

            case R.id.btnPersonSerializable:

                sendPersonToPersonActivity(personParcelable, intent, CONSTANTS.Action.ACTION_PERSON_PARCELABLE);

                break;
            case R.id.btnPersonParcelable:

                sendPersonToPersonActivity(personSerializable, intent, CONSTANTS.Action.ACTION_PERSON_SERIALIZABLE);

                break;

            case R.id.btnSharePerson:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This person's name is " + personName);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                break;

        }


    }

    private void sendPersonToPersonActivity(Object person, Intent intent, String action) {

        if (person instanceof PersonParcelable)
            intent.putExtra(action, (PersonParcelable) person);
        else
            intent.putExtra(action, (PersonSerializable) person);

        intent.setAction(action);
        startActivity(intent);
    }
}





