package com.example.user.firebase.manager;

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

public class AuthManager {


    private static FirebaseAuth auth;
    private static Activity activity;
    private static Callback callback;

    private FirebaseUser user;

    private AuthManager() {
//     defeat initialization
    }

    private AuthManager(Activity activity) {
        updateOwner(activity);

    }

    private static AuthManager authManager = null;

    public static AuthManager getInstance(Activity activity) {

        if (authManager == null) {
            authManager = new AuthManager(activity);
        }
        updateOwner(activity);
        return authManager;

    }

    private static void updateOwner(Activity activity) {
        AuthManager.activity = activity;
        callback = (Callback) activity;
        auth = FirebaseAuth.getInstance();

    }

    public void createAccount(String email, String password) {

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            user = auth.getCurrentUser();
                            callback.onLoginResults(user);

//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            callback.onLoginResults(null);

//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void signIn(String email, String password) {

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            user = auth.getCurrentUser();
                            callback.onLoginResults(user);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            callback.onLoginResults(null);

//                            updateUI(null);
                        }

                        // ...
                    }
                });

    }

    public boolean checkSession() {
        FirebaseUser user = auth.getCurrentUser();
        return user != null;
    }

    public FirebaseUser getUser() {
        FirebaseUser user = auth.getCurrentUser();
        return user;
    }

    public void signOut() {
        auth.signOut();
        callback.onSignedOut();

    }


    public interface Callback {

        void onLoginResults(FirebaseUser user);
        void onSignedOut();

    }

}
