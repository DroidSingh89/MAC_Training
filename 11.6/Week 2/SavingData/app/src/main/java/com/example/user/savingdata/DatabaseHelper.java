package com.example.user.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 11/13/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Person";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Persons";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_GENDER = "Gender";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY," +
                COLUMN_GENDER + " TEXT " +
                ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long savePerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, person.getName());
        contentValues.put(COLUMN_GENDER, person.getGender());

        long row = db.insert(TABLE_NAME, null, contentValues);
        return row;
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        String QUERY = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Person person = new Person(
                        cursor.getString(0),
                        cursor.getString(1));

                personList.add(person);
            } while (cursor.moveToNext());
        }

        return personList;
    }

}
