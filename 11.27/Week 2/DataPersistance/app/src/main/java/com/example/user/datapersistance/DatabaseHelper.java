package com.example.user.datapersistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.session.PlaybackState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 12/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String name = "myDb";
    public static final int version = 1;

    //create statements
    public static final String CREATE_PERSON_TABLE =
            "CREATE TABLE " + DatabaseContract.PersonEntry.TABLE_NAME + "(" +
                    DatabaseContract.PersonEntry.NAME + " TEXT PRIMARY KEY, " +
                    DatabaseContract.PersonEntry.GENDER + " TEXT, " +
                    DatabaseContract.PersonEntry.AGE + " TEXT) ";


    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PERSON_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long savePerson(Person person) {

        SQLiteDatabase database = this.getWritableDatabase();

        //create content values for saving person
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.PersonEntry.NAME, person.getName());
        contentValues.put(DatabaseContract.PersonEntry.AGE, person.getAge());
        contentValues.put(DatabaseContract.PersonEntry.GENDER, person.getGender());

        long rowId = database.insert(
                DatabaseContract.PersonEntry.TABLE_NAME, null, contentValues);


        return rowId;

    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor personCursor = db.rawQuery(
                "SELECT * FROM " + DatabaseContract.PersonEntry.TABLE_NAME
                , null);


        if (personCursor.moveToFirst()) {
            do {
                Person person = new Person(
                        personCursor.getString(0),
                        personCursor.getString(1),
                        personCursor.getString(2)
                );
                personList.add(person);

            } while (personCursor.moveToNext());
        }

        return personList;

    }
}
