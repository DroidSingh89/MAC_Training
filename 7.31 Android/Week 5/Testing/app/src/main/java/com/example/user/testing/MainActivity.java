package com.example.user.testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final String KEY_RESULT = "KEY_FOR_RESULT";
    private static final String TAG = "MainActivityTag";
    @BindView(R.id.etNumber1)
    EditText etNumber1;

    @BindView(R.id.etNumber2)
    EditText etNumber2;

    @BindView(R.id.btnAddition)
    Button btnAddition;

    @BindView(R.id.btnSubtraction)
    Button btnSubtraction;

    @BindView(R.id.btnMultiplication)
    Button btnMultiplication;

    @BindView(R.id.btnDivision)
    Button btnDivision;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnAddition, R.id.btnSubtraction, R.id.btnMultiplication, R.id.btnDivision})

    public void doCalculations(View view) {


        int number1 = Integer.parseInt(etNumber1.getText().toString());
        int number2 = Integer.parseInt(etNumber2.getText().toString());
        int result = 0;

        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();
        Calculation calculation = new Calculation(addition, subtraction, multiplication, division);
        calculation.setVal1(number1);
        calculation.setVal2(number2);

        switch (view.getId()) {

            case R.id.btnAddition:
                result = calculation.addition();

                break;
            case R.id.btnSubtraction:

                result = calculation.subtraction();
                break;
            case R.id.btnMultiplication:

                result = calculation.multiply();

                break;
            case R.id.btnDivision:

                result = calculation.divide();

                break;
        }

        tvResult.setText(String.valueOf(result));
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        Log.d(TAG, "goToSecond: " + tvResult.getText().toString());
        intent.putExtra(KEY_RESULT, tvResult.getText().toString());
        startActivity(intent);

    }
}
