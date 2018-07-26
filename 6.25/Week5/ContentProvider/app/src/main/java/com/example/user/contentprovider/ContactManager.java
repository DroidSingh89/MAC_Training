package com.example.user.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private static final String TAG = ContactManager.class.getSimpleName() + "_TAG";
    Context context;

    public ContactManager(Context context) {
        this.context = context;
    }

    public List<Contact> getContacts() {

        List<Contact> contacts = new ArrayList<>();

//        query data for contacts
        Cursor contactCursor = context.getContentResolver()
                .query(ProviderContract.Contacts.URI,
                        null, null, null, null);


        Log.d(TAG, "getContacts: " + contactCursor.getCount());
//        loop contacts to get numbers
        while (contactCursor.moveToNext()) {
//            get has_phone column index using the column name
            int has_phone_index = contactCursor.getColumnIndex(ProviderContract.Contacts.HAS_PHONE_NUMBER);
            int has_phone = contactCursor.getInt(has_phone_index);

//            get display_name column index using the column name
            int display_name_index = contactCursor.getColumnIndex(ProviderContract.Contacts.DISPLAY_NAME);
            String contactName = contactCursor.getString(display_name_index);

            Log.d(TAG, "getContacts: "+ contactName);

            if (has_phone > 0) {
                List<String> numbers = new ArrayList<>();

                Cursor phoneCursor = context.getContentResolver()
                        .query(ProviderContract.Phone.URI,//table name
                                new String[]{ProviderContract.Phone.NUMBER},//projection
                                ProviderContract.Contacts.DISPLAY_NAME + "=?", //selection
                                new String[]{contactName}, //selection args
                                null);//sort order

//                equivalent sql query
//                SELECT PROJECTION from URI (SELECTION,SELECTION_ARGS) SORT_ORDER
//                Select Number from PhoneURI where DisplayName = contactName

//                loop through the cursor to get the numbers
                while (phoneCursor.moveToNext()) {
                    int phoneNumberIndex = phoneCursor.getColumnIndex(ProviderContract.Phone.NUMBER);
                    String phoneNumber = phoneCursor.getString(phoneNumberIndex);

                    numbers.add(phoneNumber);
                }

                Contact contact = new Contact(contactName, numbers);
                contacts.add(contact);

            }

        }
        return contacts;
    }


}
