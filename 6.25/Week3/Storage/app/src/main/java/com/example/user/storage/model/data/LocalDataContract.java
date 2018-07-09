package com.example.user.storage.model.data;

import android.provider.BaseColumns;

public class LocalDataContract {

    public static final String NAME = "Person.db";
    public static final int VERSION = 1;

    public static final String TABLE_PERSON = "person";

    public static class DDL {

        public static final String CREATE_PERSON_TABLE
                = "CREATE TABLE " + TABLE_PERSON + "(" +
                Person.NAME + " TEXT, " +
                Person.AGE + " TEXT, " +
                Person.GENDER + " TEXT)";

    }

    public static class DML{
        public static final String GET_ALL_PERSON = "SELECT * FROM " +
                TABLE_PERSON;
    }

    public static class Person implements BaseColumns {

        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String GENDER = "gender";

    }


}
