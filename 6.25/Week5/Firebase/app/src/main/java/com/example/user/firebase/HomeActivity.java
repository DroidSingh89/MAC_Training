package com.example.user.firebase;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.manager.AuthManager;
import com.example.user.firebase.manager.RemoteDatabaseManager;
import com.example.user.firebase.model.Person;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class HomeActivity extends AppCompatActivity implements AuthManager.Callback{

    private static final String TAG = HomeActivity.class.getSimpleName() + "_TAG";

    private AuthManager authManager;
    private RemoteDatabaseManager remoteDatabaseManager;
    private EditText etData;
    private MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etData = findViewById(R.id.etData);
        authManager = AuthManager.getInstance(this);
        FirebaseUser user = authManager.getUser();
        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();

        remoteDatabaseManager = RemoteDatabaseManager.getInstance();
    }


    @Override
    public void onLoginResults(FirebaseUser user) {

    }

    @Override
    public void onSignedOut() {

        Log.d(TAG, "onSignedOut: ");
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void onSignOut(View view) {
        authManager.signOut();
    }

    public void onUploadData(View view) {

        remoteDatabaseManager.uploadData(etData.getText().toString());

    }


    public void onUploadPerson(View view) {

        String firstName = "John" + getRandomValue();
        String lastName = "Doe" + getRandomValue();

        remoteDatabaseManager.uploadPerson(new Person(firstName, lastName));
    }

    private String getRandomValue() {
        return String.valueOf(new Random().nextInt(100));
    }

    public void onReadPeople(View view) {

        remoteDatabaseManager.readPeople();
    }

    private void showDialog(final String postId, final String postMessage) {

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("New Incoming post")
                .setMessage("New post: " + postMessage)
                .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Open", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                        intent.putExtra("postId", postId);
                        intent.putExtra("postMessage", postMessage);
                        startActivity(intent);

                    }
                })
                .create();

        alertDialog.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        myBroadCastReceiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("firebaseMessaging");
        registerReceiver(myBroadCastReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCastReceiver);

    }

    public class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String postId = intent.getStringExtra("postId");
            String postMessage = intent.getStringExtra("postMessage");

            Log.d(TAG, "onReceive: "+ postId);
            showDialog(postId, postMessage);

        }
    }
}
