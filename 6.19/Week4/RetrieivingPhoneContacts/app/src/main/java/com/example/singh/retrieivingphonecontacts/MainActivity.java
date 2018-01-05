package com.example.singh.retrieivingphonecontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getPhoneContacts(View view) {


        Uri ContentURI = ContactsContract.Contacts.CONTENT_URI;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Cursor cursor = getContentResolver().query(ContentURI, null, null, null, null);

        int hasPhone = 0;
        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                Log.d(TAG, "getPhoneContacts: " + cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)));

                String contactName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
                hasPhone = Integer.parseInt(cursor.getString(cursor.getColumnIndex((HAS_PHONE_NUMBER))));

                if (hasPhone > 0) {
                    Uri PhoneURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                    String Number = ContactsContract.CommonDataKinds.Phone.NUMBER;

                    String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
                    String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "=?";
                    String[] selectionArgs = new String[]{contactName};

                    Cursor phoneCursor = getContentResolver().query(PhoneURI
                            , projection
                            , selection
                            , selectionArgs
                            , null);

                    while (phoneCursor.moveToNext()) {
                        Log.d(TAG, "getPhoneContacts: " + phoneCursor.getString(phoneCursor.getColumnIndex(Number)));
                    }

                }


            }


        }

    }
}
