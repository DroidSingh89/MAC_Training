package com.example.user.savingdata.data;

import android.provider.BaseColumns;

/**
 * Created by singh on 1/15/18.
 */

public class DatabaseContract {

    //    ddl statements
//    Create table for person
    public static final String CREATE_PERSON_TABLE
            = "CREATE TABLE " + Person.TABLE_NAME + "(" +
            Person.NAME + " TEXT PRIMARY KEY," +
            Person.AGE + " TEXT," +
            Person.GENDER + " TEXT)";

    public static class Person implements BaseColumns{

        public static final String TABLE_NAME = "person";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String GENDER = "gender";
    }


}
