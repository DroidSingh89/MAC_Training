package com.example.user.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button btnUpdateValue;
    TextView tvUpdatedValue;
    private EditText etUpdateValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUpdateValue = (EditText) findViewById(R.id.etInputValue);
        btnUpdateValue= (Button) findViewById(R.id.btnUpdateTextView);
        tvUpdatedValue= (TextView) findViewById(R.id.tvUpdatedValue);

        btnUpdateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvUpdatedValue.setText(etUpdateValue.getText().toString());

            }
        });


    }
}
