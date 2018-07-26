package com.example.user.contentprovider;

import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;

public class ProviderContract {

    public static class Contacts{


        public static Uri URI = ContactsContract.Contacts.CONTENT_URI;
        public static final String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        public static final String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

    }

    public static class Phone{

        public static Uri URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        public static final String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

    }

}
