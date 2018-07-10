package com.example.user.storage.model.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Book.class, version = 1)
public abstract class BookDatabase extends RoomDatabase{
    public abstract BookDao bookDao();
}
