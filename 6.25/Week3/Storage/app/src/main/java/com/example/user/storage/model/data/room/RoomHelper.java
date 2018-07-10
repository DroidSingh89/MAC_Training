package com.example.user.storage.model.data.room;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static android.arch.persistence.room.Room.databaseBuilder;
import static android.content.ContentValues.TAG;

public class RoomHelper {

    Context context;
    BookDatabase database;
    BookDao bookDao;

    public RoomHelper(Context context) {
        this.context = context;
        this.database = databaseBuilder(context, BookDatabase.class, "Book-database").build();

        this.bookDao = database.bookDao();

    }

    public void saveBook(final Book book) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                bookDao.saveBook(book);

            }
        }).start();

    }

    public void getBooks() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Book> books = bookDao.getAllBooks();

                Log.d(TAG, "run: " + books.toString());

            }
        }).start();
    }


}
