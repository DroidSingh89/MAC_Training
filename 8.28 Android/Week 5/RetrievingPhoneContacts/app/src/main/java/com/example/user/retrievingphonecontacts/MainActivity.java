package com.example.user.retrievingphonecontacts;

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
import android.view.View;
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

    public void checkPermissions(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                Toast.makeText(this, "Should Show", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "checkPermissions: Should show" );

                AlertDialog  alertDialog  = new AlertDialog.Builder(this)
                        .setTitle("Explaination")
                        .setMessage("Allow this permission")
                        .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Think again", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                requestPermission();
                            }
                        })
                        .create();

                alertDialog.show();




                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                // No explanation needed, we can request the permission.
                Log.d(TAG, "checkPermissions: Requesting oermissions");

                requestPermission();
            }
        }
        else
        {
            Toast.makeText(this, "Already granted", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "checkPermissions:  Permission already granted");

        }

    }

    private void requestPermission() {
        Toast.makeText(this, "Requesting pernissions", Toast.LENGTH_SHORT).show();

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

                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void retrievePhoneContacts(View view) {

        Uri ContentURI = ContactsContract.Contacts.CONTENT_URI;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Cursor cursor = getContentResolver().query(ContentURI, null, null, null, null);

        int hasPhone = 0;

        while(cursor.moveToNext()){

            //GetCoLumnIndex will find the index of the column passing the Column name
            String ContactName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
            hasPhone = Integer.parseInt(cursor.getString(cursor.getColumnIndex(HAS_PHONE_NUMBER)));

            if(hasPhone>0){
                Log.d(TAG, "retrievePhoneContacts: " + ContactName);
                Uri PhoneURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                String[] projection = new String[]{NUMBER};
                String selection = DISPLAY_NAME + "= ?";
                String[] selectionArg = new String[]{ContactName};

                //Select "projection" from TableName where
                // "selection" = "selectionArgs"
                Cursor phoneCursor = getContentResolver().query(PhoneURI
                ,projection
                ,selection
                ,selectionArg
                ,null);

                while(phoneCursor.moveToNext()){
                    String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                    Log.d(TAG, "retrievePhoneContacts: " + phoneNumber);
                }

            }

        }


    }
}


















