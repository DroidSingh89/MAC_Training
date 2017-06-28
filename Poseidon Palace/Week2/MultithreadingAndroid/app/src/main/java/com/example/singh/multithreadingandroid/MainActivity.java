package com.example.singh.multithreadingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvResultPost, tvResultDelayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvResultPost = (TextView) findViewById(R.id.tvResultPost);
        tvResultDelayed = (TextView) findViewById(R.id.tvResultDelayed);




    }

    public void testRunnable(View view) {


        TestRunnable testRunnable = new TestRunnable(tvResultPost, tvResultDelayed);
        Thread thread = new Thread(testRunnable);
        thread.start();



    }

    public void testThread(View view) {

        TestThread testThread = new TestThread(tvResultPost, tvResultDelayed);
        testThread.start();


    }

    public void testAsynctask(View view) {




    }
}
