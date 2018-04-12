package com.example.user.contentprovider.manager;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.user.contentprovider.MainActivity;

import static android.content.ContentValues.TAG;

public class PermissionManager {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    Context context;
    IPermissionManager listener;

    public PermissionManager(Context context) {
        this.context = context;
        this.listener = (IPermissionManager) context;
    }

    public void checkPermission() {

        //check permission for using contacts
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "onCreate: Permission is not granted");
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                    Manifest.permission.READ_CONTACTS)) {

                Log.d(TAG, "onCreate: Show an explanation to the user");
                getExplanationDialog().show();
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                requestPermission();
            }
        } else {

            listener.onPermissionResult(true);

            Log.d(TAG, "onCreate: Permission has already been granted");
            // Permission has already been granted
        }


    }

    private void requestPermission() {

        // No explanation needed; request the permission
        Log.d(TAG, "onCreate: No explanation needed; request the permission");
        ActivityCompat.requestPermissions((Activity) context,
                new String[]{Manifest.permission.READ_CONTACTS},
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);

        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }

    private AlertDialog getExplanationDialog() {

        return new AlertDialog.Builder(context)
                .setTitle("Need the permission")
                .setMessage("Can you please allow this permission? I need it.")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(context,
                                "Features disabled",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        requestPermission();
                    }
                }).create();
    }

    public void checkResult(int requestCode,
                            String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d(TAG, "onRequestPermissionsResult: permission was granted");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    listener.onPermissionResult(true);

                } else {

                    listener.onPermissionResult(false);

                    Log.d(TAG, "onRequestPermissionsResult: permission denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public interface IPermissionManager{

        void onPermissionResult(boolean isGranted);

    }

}
