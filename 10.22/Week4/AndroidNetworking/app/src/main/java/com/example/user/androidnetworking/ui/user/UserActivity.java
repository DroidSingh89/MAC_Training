package com.example.user.androidnetworking.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.user.androidnetworking.R;
import com.example.user.androidnetworking.client.OkhttpHelper;
import com.example.user.androidnetworking.model.data.RandomRepository;
import com.example.user.androidnetworking.model.data.local.LocalDataSource;
import com.example.user.androidnetworking.model.data.remote.RemoteDataSource;
import com.example.user.androidnetworking.model.randomresponse.RandomResponse;
import com.example.user.androidnetworking.model.randomresponse.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity implements UserContract.View{

    private static final String TAG = UserActivity.class.getSimpleName()+ "_TAG";
    private OkhttpHelper okhttpHelper;
    private RemoteDataSource remoteDataSource;
    private UserPresenter presenter;
    private EditText etGender;
    private EditText etResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etGender = findViewById(R.id.etGender);
        etResults = findViewById(R.id.etResults);
        okhttpHelper = new OkhttpHelper();
        remoteDataSource = new RemoteDataSource();


        presenter = new UserPresenter(new RandomRepository(new LocalDataSource(), new RemoteDataSource()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }

    public void onOkhttp(View view) {

        switch (view.getId()) {

            case R.id.btnOkhttpExecute:

                okhttpHelper.execute();

                break;

            case R.id.btnOkhttpEnqueue:

                okhttpHelper.enqueue();
                break;
        }

    }

    public void onRetrofit(View view) {

        switch (view.getId()) {
            case R.id.btnRetrofitExecute:

                break;

            case R.id.btnRetrofitEnqueue:


                remoteDataSource.getRandomUser("male", 10).enqueue(new Callback<RandomResponse>() {
                    @Override
                    public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {

                        Log.d(TAG, "onResponse: "+ Thread.currentThread().getName());


                        Log.d(TAG, "onResponse: "+ response.body().getResults().get(0).getGender());
                    }

                    @Override
                    public void onFailure(Call<RandomResponse> call, Throwable t) {

                    }
                });
                break;
        }
    }

    @Override
    public void onRandomUsers(List<User> users) {

        for (User user : users) {
            Log.d(TAG, "onRandomUsers: "+ user.getCell());
        }

    }

    @Override
    public void showError(String error) {

        Log.d(TAG, "showError: " + error);
    }

    public void getRandomUsers(View view) {

        presenter.getRandomUsers(etGender.getText().toString(),
                Integer.parseInt(etResults.getText().toString()));
    }
}
