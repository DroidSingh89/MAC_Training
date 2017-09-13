package com.example.user.listviewrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToActivities(View view) {


        switch (view.getId()) {

            case R.id.btnListActivity:

                Intent listIntent = new Intent(this, ListViewActivity.class);
                startActivity(listIntent);
                break;

            case R.id.btnRecyclerActivity:
                Intent recyclerIntent = new Intent(this, RecyclerViewActivity.class);
                startActivity(recyclerIntent);
                break;
        }
    }
}
