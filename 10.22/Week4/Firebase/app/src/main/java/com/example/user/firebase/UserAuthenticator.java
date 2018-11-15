package com.example.user.firebase;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserAuthenticator {


    private static final String TAG = UserAuthenticator.class.getSimpleName()+ "_TAG";
    FirebaseAuth auth;
    Callback callback;
    Activity activity;
    CompleteListener completeListener;

    public UserAuthenticator() {

        auth = FirebaseAuth.getInstance();
    }

    public UserAuthenticator(Activity activity, CompleteListener completeListener) {
        auth = FirebaseAuth.getInstance();
        this.callback = (Callback) activity;
        this.activity = activity;
        this.completeListener = completeListener;
    }


    public void signIn(String userEmail, String password) {

        completeListener.setType(0);
        auth.signInWithEmailAndPassword(userEmail, password)
                .addOnCompleteListener(activity, completeListener);


    }


    public void signUp(String userEmail, String password) {

        completeListener.setType(1);
        auth.createUserWithEmailAndPassword(userEmail, password)
                .addOnCompleteListener(activity,completeListener);
    }


    public boolean checkSession() {

        FirebaseUser user = auth.getCurrentUser();
        return (user != null);

    }

    public void signOut() {

        auth.signOut();
    }


    interface Callback{


        void onUserValidated(FirebaseUser user);


        void onUserInvalidated();
    }
}
