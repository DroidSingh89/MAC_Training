package com.example.user.mvp_dagger.view.repolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvp_dagger.R;
import com.example.user.mvp_dagger.model.Repo;

import java.util.List;

public class RepoList extends AppCompatActivity implements RepoListContract.View{


    private static final String TAG = "RepoListTag";
    private TextView textView;
    private RepoListPresenter presenter;
    private EditText etFirstname;
    private EditText etLastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvFullName);
        etFirstname = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);

        Log.d(TAG, "onCreate: ");
        presenter = new RepoListPresenter();
        presenter.attachView(this);

        presenter.getRepos("manroopsingh");
    }

    public void addNames(View view) {
        Log.d(TAG, "addNames: ");
        String firstName = etFirstname.getText().toString();
        String lastName = etLastname.getText().toString();

        presenter.getFullName(firstName,lastName);



    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: ");
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFullName(String fullName) {

        Log.d(TAG, "setFullName: ");
        textView.setText(fullName);
    }

    @Override
    public void setRepos(List<Repo> repos) {

        for(Repo r: repos)
            Log.d(TAG, "setRepos: " + r.getFullName());

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        presenter.detachView();
    }
}
