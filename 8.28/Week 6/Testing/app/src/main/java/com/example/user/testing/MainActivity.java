package com.example.user.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText etFirstNumber;
    private EditText etSecondNumber;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
        tvResult = (TextView) findViewById(R.id.tvResult);

    }

    public void addTheNumbers(View view) {

        int first = Integer.parseInt(etFirstNumber.getText().toString());
        int second = Integer.parseInt(etSecondNumber.getText().toString());

        int result = first + second;

        tvResult.setText(String.valueOf(result));


    }
}
