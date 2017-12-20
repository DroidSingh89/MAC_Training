package com.example.user.firebase.view.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 12/20/17.
 */

public class LoginAuthenticator {


    FirebaseAuth auth;
    LoginActivity activity;
    FirebaseUser user;
    OnLoginInteraction onLoginInteraction;

    public LoginAuthenticator(FirebaseAuth auth, LoginActivity activity) {
        this.auth = auth;
        this.activity = activity;
    }

    public void validateUser(String email, String password, LoginPresenter loginPresenter) {

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            user = auth.getCurrentUser();

                            onLoginInteraction.onUserValidation(user);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                            onLoginInteraction.onUserValidation(user);
                        }

                    }
                });
    }


    public void createUser(String email, String password, LoginPresenter loginPresenter) {


        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            user = auth.getCurrentUser();
                            onLoginInteraction.onUserCreation(user);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            onLoginInteraction.onUserCreation(user);

                        }


                    }
                });


    }

    public void initInteractor(LoginPresenter loginPresenter) {
        onLoginInteraction = loginPresenter;
    }

    public void checkUser() {

        user = auth.getCurrentUser();

        if (user != null)
            onLoginInteraction.onSessionValid(true);
        else
            onLoginInteraction.onSessionValid(false);

    }


    interface OnLoginInteraction {

        void onUserCreation(FirebaseUser user);

        void onUserValidation(FirebaseUser user);

        void onSessionValid(boolean isValid);


    }


}
