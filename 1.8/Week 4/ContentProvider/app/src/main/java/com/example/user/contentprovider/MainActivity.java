package com.example.user.contentprovider;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Checking permission");
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "onCreate: Does not have permission");
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Log.d(TAG, "onCreate: Please allow this permission");

                showExplanationDialog();
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.
                Log.d(TAG, "onCreate: Asking user for permission");
                askContactPermission();
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            Log.d(TAG, "onCreate: Already have permission");
            getContacts();
        }
    }

    private void askContactPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);
    }

    private void showExplanationDialog() {

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage("Please allow this permission. I need this to work")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        askContactPermission();
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Noooooo", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getContacts() {

        Uri contactUri = ContactsContract.Contacts.CONTENT_URI;

        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Cursor contactsCursor = getContentResolver().query(contactUri,
                null
                , null
                , null
        );

        while (contactsCursor.moveToNext()) {

            //get column index
            int nameColumnIndex = contactsCursor.getColumnIndex(DISPLAY_NAME);
            String contactName = contactsCursor.getString(nameColumnIndex);

            Log.d(TAG, "getContacts: "+ contactName);
            //check if has phone number then print out numbers

            int phoneColumnIndex = contactsCursor.getColumnIndex(HAS_PHONE_NUMBER);
            int hasPhone = contactsCursor.getInt(phoneColumnIndex);

            if (hasPhone > 0) {
                //print all numbers
                Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

                String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                String[] projection = new String[]{NUMBER};
                String selection = DISPLAY_NAME + "= ?";
                String[] selectionArgs = new String[]{contactName};

                /*
                Select {projection} where {selection} {selectionArgs}
                */


                Cursor phoneCursor = getContentResolver().query(
                        phoneUri,
                        projection,
                        selection,
                        selectionArgs,
                        NUMBER + " ASC"
                );


                while (phoneCursor.moveToNext()) {

                    int phoneColIndex = phoneCursor.getColumnIndex(NUMBER);
                    String phoneNumber = phoneCursor.getString(phoneColIndex);

                    Log.d(TAG, "getContacts: " + phoneNumber);

                }


            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    getContacts();

                } else {
                    Log.d(TAG, "onRequestPermissionsResult: Denied");

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
