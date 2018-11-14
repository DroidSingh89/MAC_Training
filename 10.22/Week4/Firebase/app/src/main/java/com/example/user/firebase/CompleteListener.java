package com.example.user.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CompleteListener implements OnCompleteListener<AuthResult> {

    private static final String TAG = CompleteListener.class.getSimpleName()+ "_TAG";
    int type;

    UserAuthenticator.Callback callback;

    public CompleteListener(UserAuthenticator.Callback callback) {
        this.callback = callback;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        switch (type) {
            case 0:

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    callback.onUserValidated(FirebaseAuth.getInstance().getCurrentUser());
//                            updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());

//                            updateUI(null);
                    callback.onUserInvalidated();
                }

                break;
            case 1:

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createWithEmail:success");
                    callback.onUserValidated(FirebaseAuth.getInstance().getCurrentUser());
//                            updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createWithEmail:failure", task.getException());

//                            updateUI(null);
                    callback.onUserInvalidated();
                }

                break;
        }



    }
}
