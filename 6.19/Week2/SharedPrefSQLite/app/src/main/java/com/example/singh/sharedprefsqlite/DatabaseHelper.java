package com.example.singh.sharedprefsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

/**
 * Created by singh on 6/26/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "My_DB";
    private static final String TABLE_NAME = "Contacts";
    private static final String CONTACT_NAME = "name";
    private static final String CONTACT_PHONE = "phone";
    private static final String TAG = "DatabaseHelperTag";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                CONTACT_NAME + " TEXT," +
                CONTACT_PHONE + " TEXT PRIMARY KEY" +
                ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public void saveNewContact(String name, String phone) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_NAME, name);
        contentValues.put(CONTACT_PHONE, phone);
        database.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "saveNewContact: value saved");

    }


    public void getContact() {
        SQLiteDatabase database = this.getWritableDatabase();

        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);


        if (cursor.moveToFirst()) {

            do {
                Log.d(TAG, "getContact: " + "Name: " + cursor.getString(0) + ", Phone: " + cursor.getString(1));

            } while (cursor.moveToNext());

        }



    }


}
