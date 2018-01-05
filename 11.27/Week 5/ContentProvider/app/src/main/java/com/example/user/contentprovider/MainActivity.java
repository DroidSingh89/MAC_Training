package com.example.user.contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "onCreate: Permission not granted");

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Log.d(TAG, "onCreate: Should show explanation");

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                Log.d(TAG, "onCreate: Asking for permission");

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            getContacts();
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
            // permissions this app might request
        }
    }

    public void getContacts() {

        Uri ContactUri = ContactsContract.Contacts.CONTENT_URI;

        //Column names for contact provider
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Cursor contactCursor = getContentResolver().query(ContactUri,
                null,
                null,
                null,
                DISPLAY_NAME + " DESC");

        //iterate with all the cursor items
        while (contactCursor.moveToNext()) {

            //value for each contact
            String contactName =
                    contactCursor.getString(contactCursor.getColumnIndex(DISPLAY_NAME));
            int hasPhone =
                    Integer.parseInt(contactCursor.getString(contactCursor.getColumnIndex(HAS_PHONE)));

            if (hasPhone > 0) {
                Log.d(TAG, "getContacts: " + contactName);

                //get phone for this contact from other content provider
                Uri PhoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                String[] projection = new String[]{NUMBER};
                String selection = DISPLAY_NAME + "=?";
                String[] selectionArgs = new String[]{contactName};

                Cursor phoneCursor = getContentResolver().query(PhoneUri,
                        projection,
                        selection,
                        selectionArgs,
                        null);


                while (phoneCursor.moveToNext()) {
                    String phoneNumber =
                            phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));

                    Log.d(TAG, "getContacts: " + phoneNumber);
                }


            }

        }


    }
}
