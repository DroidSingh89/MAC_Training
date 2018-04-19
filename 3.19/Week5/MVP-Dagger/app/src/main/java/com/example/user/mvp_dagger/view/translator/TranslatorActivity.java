package com.example.user.mvp_dagger.view.translator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp_dagger.R;

import com.example.user.mvp_dagger.di.component.DaggerTranslatorComponent;
import com.example.user.mvp_dagger.di.module.TranslatorModule;
import com.example.user.mvp_dagger.model.Sentence;

import javax.inject.Inject;

public class TranslatorActivity extends AppCompatActivity implements TranslatorContract.View{


    private EditText etInput;
    private TextView tvResults;

    @Inject
    TranslatorPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupDaggerComponent();

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);


    }

    private void setupDaggerComponent() {
        DaggerTranslatorComponent.builder().translatorModule(new TranslatorModule(this)).build().inject(this);
    }

    private void bindViews() {
        etInput = findViewById(R.id.etInput);
        tvResults = findViewById(R.id.tvResult);
    }

    public void translateSentence(View view) {

        presenter.translate(new Sentence(etInput.getText().toString()));

    }

    @Override
    public void onTranslation(Sentence sentence) {
        tvResults.setText(sentence.getSentence());
    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
