package com.example.user.androidnetworking.ui.user;

import com.example.user.androidnetworking.model.data.RandomCallback;
import com.example.user.androidnetworking.model.data.RandomRepository;
import com.example.user.androidnetworking.model.randomresponse.User;

import java.util.List;

public class UserPresenter implements UserContract.Presenter{

    UserContract.View view;


    RandomRepository repository;

    public UserPresenter(RandomRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getRandomUsers(String gender, int results) {


        repository.getRandomUsers(gender, results, new RandomCallback() {
            @Override
            public void onSuccess(List<User> userList) {
                view.onRandomUsers(userList);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);

            }
        });

    }

    @Override
    public void onAttach(UserContract.View view) {

        this.view = view;
    }

    @Override
    public void onDetach() {

        this.view = null;
    }
}
