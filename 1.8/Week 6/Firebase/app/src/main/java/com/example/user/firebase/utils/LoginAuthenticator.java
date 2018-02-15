package com.example.user.firebase.utils;

import android.app.Activity;
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
 * Created by singh on 2/13/18.
 */

public class LoginAuthenticator {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Activity activity;
    onLoginInteraction listener;

    public LoginAuthenticator(Activity activity) {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.activity = activity;
        listener = (onLoginInteraction) activity;
    }

    public void createUser(String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            firebaseUser = firebaseAuth.getCurrentUser();


                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                        }
                    }
                });

        listener.onUserCreation(firebaseUser);
    }

    public void authenticateUser(String email, String password) {


        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            firebaseUser = firebaseAuth.getCurrentUser();

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                            //updateUI(null);
                        }

                        // ...
                    }
                });

        listener.onUserAuthenticated(firebaseUser);
    }

    public FirebaseUser getUser() {
        return firebaseUser;
    }

    public FirebaseUser checkSession() {
        firebaseUser = firebaseAuth.getCurrentUser();
        return firebaseUser;
    }

    public void signOut() {

        firebaseAuth.signOut();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null)
            listener.onSignOut(true);
        else listener.onSignOut(false);
    }


    public interface onLoginInteraction {

        void onUserCreation(FirebaseUser firebaseUser);

        void onUserAuthenticated(FirebaseUser firebaseUser);

        void onSignOut(boolean isSignedOut);
    }
}
