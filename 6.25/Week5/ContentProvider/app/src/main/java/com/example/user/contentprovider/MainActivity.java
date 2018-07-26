package com.example.user.contentprovider;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.networklib.MyZackClass;

public class MainActivity extends AppCompatActivity implements PermissionManager.Callback{

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private PermissionManager permissionManager;
    private ContactManager contactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new PermissionManager(this);
        Log.d(TAG, "onCreate: Check permission");
        contactManager = new ContactManager(this);
        permissionManager.checkPermission();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult: Check results");
        permissionManager.checkResults(requestCode, permissions, grantResults);


    }

    @Override
    public void onPermissionResults(int requestCode, boolean isGranted) {

        switch (requestCode) {
            case PermissionManager.MY_PERMISSIONS_REQUEST_READ_CONTACTS:

                if (isGranted) {

                    Log.d(TAG, "onPermissionResults: Granted");
                    for (Contact contact : contactManager.getContacts()) {
                        Log.d(TAG, "onPermissionResults: Contact: " + contact.toString());
                    }
                } else {
                    Log.d(TAG, "onPermissionResults: Denied");

                }

                break;

        }

    }
}
