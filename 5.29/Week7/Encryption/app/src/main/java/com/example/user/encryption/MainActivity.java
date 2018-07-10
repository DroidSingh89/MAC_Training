package com.example.user.encryption;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREF = "mySharedPref";
    private EditText etMain;
    private TextView tvMain;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);


//        get shared preferences
        sharedPreferences = getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);
    }

    public void onSavePreference(View view) {

//        get data from the edittext
        String data = etMain.getText().toString();

//        write data to the preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data", data);

        boolean isSaved = editor.commit();

        if (isSaved) {
            Toast.makeText(this, "Value saved", Toast.LENGTH_SHORT).show();

        }


    }

    public void onGetPreference(View view) {

        String data = sharedPreferences.getString("data", "default value");
        tvMain.setText(data);



    }
}
