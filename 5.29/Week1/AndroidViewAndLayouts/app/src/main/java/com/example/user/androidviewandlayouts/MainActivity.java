package com.example.user.androidviewandlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    private TextView tvFirstView;
    private Button btnFirst;
    private TextView tvSecondView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstView = findViewById(R.id.tvFirstView);
        tvSecondView = findViewById(R.id.tvSecondView);
        btnFirst = findViewById(R.id.btnFirst);

//        First way

//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvFirstView.setText("Value changed");
//            }
//        });


//        Second Way

//        MyClickListener clickListener =
//                new MyClickListener(tvFirstView);
//        btnFirst.setOnClickListener(clickListener);

//        Third Way

        btnFirst.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        tvFirstView.setText("Changed from activity");
    }

    public void onSecondClicked(View view) {

    }
}
