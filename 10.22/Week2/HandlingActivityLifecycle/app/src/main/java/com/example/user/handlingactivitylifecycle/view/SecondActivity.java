package com.example.user.handlingactivitylifecycle.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.handlingactivitylifecycle.Constants;
import com.example.user.handlingactivitylifecycle.R;
import com.example.user.handlingactivitylifecycle.model.Person;
import com.example.user.handlingactivitylifecycle.model.PersonParcel;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName() + "_TAG";
    private TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");

        tvSecond = findViewById(R.id.tvSecond);

//        retrieve the value from the main intent
        String tvSecondText = getIntent().getStringExtra(Constants.KEYS.ET_MAIN);
        tvSecond.setText(tvSecondText);


        

        String personType = getIntent().getStringExtra(Constants.KEYS.PERSON_TYPE);
        Toast.makeText(this, personType, Toast.LENGTH_SHORT).show();

        switch (personType) {

            case "parcelable":
                PersonParcel personParcel = getIntent().getParcelableExtra(Constants.KEYS.Person);
                tvSecond.setText(personParcel.toString());

                break;
            case "serializable":
                Person person = (Person) getIntent().getSerializableExtra(Constants.KEYS.Person);
                tvSecond.setText(person.toString());

                break;

        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
