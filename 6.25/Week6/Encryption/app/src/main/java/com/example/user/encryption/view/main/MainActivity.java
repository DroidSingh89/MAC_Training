package com.example.user.encryption.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.encryption.MainApplication;
import com.example.user.encryption.R;
import com.example.user.encryption.model.Person;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View{


    @Inject
    MainPresenter presenter;
    private EditText etPersonName;
    private TextView tvEncryptedPerson;
    private TextView tvDecryptedPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPersonName = findViewById(R.id.etPersonName);
        tvEncryptedPerson = findViewById(R.id.tvEncryptedPerson);
        tvDecryptedPerson = findViewById(R.id.tvDecryptedPerson);

    }

    @Override
    protected void onStart() {
        super.onStart();
        MainApplication.get(this)
                .getMainComponent().inject(this);
        presenter.attachView(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        MainApplication.get(this).clearMainComponent();
        presenter.detachView();

    }

    public void encryptPerson(View view) {
        presenter.encryptData(new Person(etPersonName.getText().toString()));
    }

    public void decryptPerson(View view) {
        presenter.decryptData(tvEncryptedPerson.getText().toString());
    }

    @Override
    public void onEncrytion(String encryptedData) {
        tvEncryptedPerson.setText(encryptedData);
    }

    @Override
    public void onDecryption(Person person) {
        tvDecryptedPerson.setText(person.getName());
    }

    @Override
    public void showError(String error) {

    }
}
