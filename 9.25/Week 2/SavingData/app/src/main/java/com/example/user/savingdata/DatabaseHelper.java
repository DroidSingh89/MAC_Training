package com.example.user.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 10/2/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Persons.db";


    public static final String TABLE_NAME = "Persons";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_AGE = "Age";
    public static final String COLUMN_GENDER = "Gender";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_AGE + " TEXT, " +
                COLUMN_GENDER + " TEXT " +
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE ID EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public long savePerson(Person person) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, person.getName());
        contentValues.put(COLUMN_AGE, person.getAge());
        contentValues.put(COLUMN_GENDER, person.getGender());

        long isSaved = database.insert(TABLE_NAME, null, contentValues);

        return isSaved;

    }

    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Person person = new Person(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2));
                personList.add(person);
            } while (cursor.moveToNext());
        }

        return personList;
    }


}
