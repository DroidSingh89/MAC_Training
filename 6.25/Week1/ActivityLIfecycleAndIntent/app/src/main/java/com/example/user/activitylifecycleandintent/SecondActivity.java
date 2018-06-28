package com.example.user.activitylifecycleandintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.user.activitylifecycleandintent.model.Person;
import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.utils.Constants;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Person person = (Person) getIntent()
                .getSerializableExtra(Constants.KEY.PERSON);

        PersonP personP = getIntent().getParcelableExtra(Constants.KEY.PERSON_P);

        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, personP.getAge(), Toast.LENGTH_SHORT).show();

    }
}
