package com.example.user.datapersistance;

import android.provider.BaseColumns;
import android.provider.ContactsContract;

/**
 * Created by singh on 12/4/17.
 */

public final class DatabaseContract {

    private DatabaseContract(){}


    public static class PersonEntry implements BaseColumns{

        public static final String TABLE_NAME = "person";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String GENDER = "gender";


    }
}
