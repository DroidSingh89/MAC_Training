package com.example.user.roomdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.roomdatabase.model.Person;
import com.example.user.roomdatabase.model.data.local.LocalDataSource;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etPersonName)
    EditText etPersonName;

    @BindView(R.id.etPersonAge)
    EditText etPersonAge;

    @BindView(R.id.etPersonGender)
    EditText etPersonGender;
    private LocalDataSource localDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        localDataSource = new LocalDataSource(this);
    }

    public void onSavePerson(View view) {

        Person person = new Person(etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString());

        localDataSource.savePerson(person);

    }

    public void onGetPersons(View view) {

        localDataSource.getPersonsRx(new LocalDataSource.DatabaseInteractor() {
            @Override
            public void onPersonList(List<Person> personList) {
                Toast.makeText(MainActivity.this, personList.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
