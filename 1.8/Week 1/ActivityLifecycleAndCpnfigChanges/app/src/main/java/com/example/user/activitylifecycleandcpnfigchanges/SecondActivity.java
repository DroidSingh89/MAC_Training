package com.example.user.activitylifecycleandcpnfigchanges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.activitylifecycleandcpnfigchanges.model.Person;
import com.example.user.activitylifecycleandcpnfigchanges.utils.Constants;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");

        tvSecond = findViewById(R.id.tvSecond);

        String action = getIntent().getAction();

        switch (action) {

            case Constants.ACTION.TEXTVIEW:
                String data = getIntent().getStringExtra(Constants.KEYS.TVMAIN);
                tvSecond.setText(data);
                break;
            case Constants.ACTION.P_SERIAL:
                Person person =
                        (Person) getIntent().getSerializableExtra(Constants.EXTRAS.PERSON);
                Log.d(TAG, "onCreate: "+ person.toString());
                Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();

                break;
            case Constants.ACTION.P_PARCEL:
                Person person1 = getIntent().getParcelableExtra(Constants.EXTRAS.PERSON);
                Toast.makeText(this, person1.toString(), Toast.LENGTH_SHORT).show();
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
