package com.example.user.storage.model.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void saveBook(Book book);

    @Query("SELECT * FROM Book")
    List<Book> getAllBooks();
}
