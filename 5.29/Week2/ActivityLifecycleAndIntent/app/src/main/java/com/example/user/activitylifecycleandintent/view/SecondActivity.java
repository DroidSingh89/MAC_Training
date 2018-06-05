package com.example.user.activitylifecycleandintent.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.user.activitylifecycleandintent.R;
import com.example.user.activitylifecycleandintent.model.Person;
import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.utils.Constants;
import com.example.user.activitylifecycleandintent.utils.TagIt;

public class SecondActivity extends AppCompatActivity {

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TagIt.with(this), "onCreate: ");

        tvMain = findViewById(R.id.tvMain);

        String tvString = getIntent()
                .getStringExtra(Constants.KEY.TV_MAIN);

        //Person person = (Person) getIntent().getSerializableExtra(MainActivity.PERSON);

        PersonP personP = getIntent()
                .getParcelableExtra(MainActivity.PERSON);

        tvMain.setText(personP.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TagIt.with(this), "onStart: ");
    }

    @Override

    protected void onResume() {
        super.onResume();
        Log.d(TagIt.with(this), "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TagIt.with(this), "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagIt.with(this), "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagIt.with(this), "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TagIt.with(this), "onRestart: ");
    }


}
