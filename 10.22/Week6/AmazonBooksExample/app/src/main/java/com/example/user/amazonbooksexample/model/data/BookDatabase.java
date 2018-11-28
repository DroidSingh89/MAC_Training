package com.example.user.amazonbooksexample.model.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.BookDao;

@Database(entities = Book.class, version = 1)
public abstract class BookDatabase extends RoomDatabase{
    public abstract BookDao bookDao();
}
