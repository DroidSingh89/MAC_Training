package com.example.user.retreivingphonecontacts;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions();


    }

    private void checkPermissions() {

        Log.d(TAG, "checkPermissions: checking permission");
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "checkPermissions: not granted");

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                Log.d(TAG, "checkPermissions: should show explanation");
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                showExplanation();

            } else {
                requestPermission();

            }
        } else {
            Log.d(TAG, "checkPermissions: granted");

            retrieveContacts();
        }
    }


    public void retrieveContacts() {

        Uri ContactsUri = ContactsContract.Contacts.CONTENT_URI;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Cursor cursor = getContentResolver().query(ContactsUri
                , null
                , null
                , null
                , DISPLAY_NAME + " DESC");

        int hasPhone = 0;

        while (cursor.moveToNext()) {

            String contactName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
            hasPhone = cursor.getInt(cursor.getColumnIndex(HAS_PHONE_NUMBER));

            if (hasPhone > 0) {
                Log.d(TAG, "retrieveContacts: " + contactName);

                Uri PhoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                String[] projection = new String[]{NUMBER};
                String selection = DISPLAY_NAME + " = ?";
                String[] selectionArgs = new String[]{contactName};


                Cursor phoneCursor = getContentResolver().query(
                        PhoneUri,
                        projection,
                        selection,
                        selectionArgs,
                        null);


                while (phoneCursor.moveToNext()){
                    String phoneNumber = phoneCursor.getString(
                            phoneCursor.getColumnIndex(NUMBER));
                    Log.d(TAG, "retrieveContacts: "+ phoneNumber);
                }

            }


        }


    }


    private void showExplanation() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage("I need this permission. Please allow this permission. Can you allow this permission?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestPermission();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Boo hoo, I hate you!"
                                , Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }

    private void requestPermission() {
        // No explanation needed, we can request the permission.

        Log.d(TAG, "checkPermissions: requesting permission");
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);

        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d(TAG, "onRequestPermissionsResult: granted");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    retrieveContacts();

                } else {

                    Log.d(TAG, "onRequestPermissionsResult: not granted");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
