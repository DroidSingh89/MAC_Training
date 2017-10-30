package com.example.user.testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_RESULT = "resultKey";
    @BindView(R.id.etFirstNumber)
    EditText etFirstNumber;
    @BindView(R.id.etSecondNumber)
    EditText etSecondNumber;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.btnResult)
    Button btnResult;
    @BindView(R.id.btnSendResult)
    Button btnSendResult;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnResult)
    public void onViewClicked() {
        int first = Integer.parseInt(etFirstNumber.getText().toString());
        int second = Integer.parseInt(etSecondNumber.getText().toString());

        result = first + second;
        tvResult.setText(String.valueOf(result));


    }

    @OnClick(R.id.btnSendResult)
    public void onViewClickedResult() {

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(KEY_RESULT, String.valueOf(result));
        startActivity(intent);

    }
}
