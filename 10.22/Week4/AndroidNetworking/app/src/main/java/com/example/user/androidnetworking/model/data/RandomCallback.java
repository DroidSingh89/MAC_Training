package com.example.user.androidnetworking.model.data;

import com.example.user.androidnetworking.model.randomresponse.User;

import java.util.List;

public interface RandomCallback {

    void onSuccess(List<User> userList);

    void onFailure(String error);
}
