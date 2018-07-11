package com.example.user.roomdatabase.model.data.local.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.user.roomdatabase.model.Person;

@Database(entities = Person.class, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
