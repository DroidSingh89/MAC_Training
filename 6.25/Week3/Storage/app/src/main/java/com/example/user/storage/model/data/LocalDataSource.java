package com.example.user.storage.model.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.storage.model.Person;

import java.util.ArrayList;
import java.util.List;


public class LocalDataSource extends SQLiteOpenHelper {

    public LocalDataSource(Context context) {
        super(context, LocalDataContract.NAME, null, LocalDataContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(LocalDataContract.DDL.CREATE_PERSON_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //
    public long savePerson(Person person) {

        SQLiteDatabase database = getWritableDatabase();

//        save person with content values
        ContentValues contentValues = new ContentValues();
        contentValues.put(LocalDataContract.Person.NAME, person.getName());
        contentValues.put(LocalDataContract.Person.AGE, person.getAge());
        contentValues.put(LocalDataContract.Person.GENDER, person.getGender());

//        insert the person into the database
        long rowNumber = database.insert(LocalDataContract.TABLE_PERSON, null, contentValues);

        database.close();
        return rowNumber;

    }

    public List<Person> getAllPerson() {
        SQLiteDatabase database = getWritableDatabase();


        List<Person> personList = new ArrayList<>();

        Cursor cursor = database.rawQuery(LocalDataContract.DML.GET_ALL_PERSON, null);

        if (cursor.moveToFirst()) {

            do {
                Person person = new Person(
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.NAME)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.AGE)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.GENDER)));

                personList.add(person);
            } while (cursor.moveToNext());

        }

        database.close();
        return personList;

    }
}
