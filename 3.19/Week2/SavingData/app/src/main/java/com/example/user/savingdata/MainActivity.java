package com.example.user.savingdata;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etSharedPref;
    private TextView tvSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        etSharedPref = findViewById(R.id.etSharedPref);
        tvSharedPref = findViewById(R.id.tvSharedPref);
    }

    public void handlingSharedPref(View view) {

        SharedPreferences sharedPreferences
                = getSharedPreferences("mySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch (view.getId()) {
            case R.id.btnSavePref:
                editor.putString("data", etSharedPref.getText().toString());

                boolean isSaved  = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Date saved", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnRestorePref:

                tvSharedPref
                        .setText(sharedPreferences.getString("data", "defaultString"));

                break;
        }
    }

    public void handlingSQLite(View view) {
    }
}
