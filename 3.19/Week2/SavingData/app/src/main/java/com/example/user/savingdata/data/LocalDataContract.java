package com.example.user.savingdata.data;

import android.provider.BaseColumns;

public class LocalDataContract {

    public static final String NAME = "Person.db";
    public static final int VERSION = 1;

    public static final String CREATE_PERSON_TABLE
            = "CREATE TABLE " + Person.TABLE + "(" +
            Person.FIRST_NAME + " TEXT, " +
            Person.LAST_NAME + " TEXT, " +
            Person.GENDER + " TEXT)";


    public static class Person implements BaseColumns {

        public static final String TABLE = "person";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String GENDER = "gender";
        public static final String GET_ALL = "SELECT * FROM " + Person.TABLE;
    }
}
