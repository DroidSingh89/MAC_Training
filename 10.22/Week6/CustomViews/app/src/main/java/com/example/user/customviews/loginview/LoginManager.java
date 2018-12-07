package com.example.user.customviews.loginview;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public LoginManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void createAccount(String email, String password) {

        editor.putString(email, password);
        editor.commit();

    }

    public boolean checkUser(String email, String password) {

        String savedPassword = sharedPreferences.getString(email, "invalid");
        return savedPassword.equals(password);

    }
}
