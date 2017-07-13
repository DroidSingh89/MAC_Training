package com.example.singh.mvp_dagger.view.activites.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singh.mvp_dagger.R;
import com.example.singh.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;
import com.example.singh.mvp_dagger.model.Person;
import com.example.singh.mvp_dagger.view.activites.secondactivity.SecondActivity;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{


    private EditText etFirstName, etLastName;
    private TextView tvFullName;
    String firstName, lastName;


    @Inject MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        tvFullName = (TextView) findViewById(R.id.tvFullName);

        setupDaggerComponent();


        presenter.addView(this);



    }

    private void setupDaggerComponent() {
        DaggerMainActivityComponent.create().inject(this);
    }



    public void getFullName(View view) {

        firstName = etFirstName.getText().toString();
        lastName = etLastName.getText().toString();

        presenter.getFullName(firstName,lastName);



    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setFullName(String fullName) {

        tvFullName.setText(fullName);

    }

    @Override
    public void sendPersonList(List<Person> personList) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("personList", (Serializable) personList);
        startActivity(intent);


    }

    public void addPerson(View view) {

        firstName = etFirstName.getText().toString();
        lastName = etLastName.getText().toString();

        presenter.addPerson(new Person(firstName,lastName));
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }

    public void GoToSecond(View view) {

        presenter.sendToSecondActivity();
    }
}
