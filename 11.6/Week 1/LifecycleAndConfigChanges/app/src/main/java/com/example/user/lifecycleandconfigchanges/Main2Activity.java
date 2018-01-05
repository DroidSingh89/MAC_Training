package com.example.user.lifecycleandconfigchanges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.user.lifecycleandconfigchanges.utils.Constants;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2ActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d(TAG, "onCreate: ");
        TextView tvmain = findViewById(R.id.tvMain);

        DataSerializable dataSerializable = (DataSerializable) getIntent()
                .getSerializableExtra(Constants.KEY.EXTRA_DATA_S);

        DataParcelable dataParcelable =  getIntent()
                .getParcelableExtra(Constants.KEY.EXTRA_DATA_P);


        tvmain.setText(dataSerializable.toString()
                + "\n" + dataParcelable.toString());

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
