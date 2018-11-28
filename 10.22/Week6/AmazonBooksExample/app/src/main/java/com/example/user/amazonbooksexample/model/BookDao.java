package com.example.user.amazonbooksexample.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.amazonbooksexample.model.Book;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface BookDao {

    @Insert
    void saveBook(Book book);

    @Insert
    void saveAllBook(List<Book> books);

    @Query("Select * from Book")
    Flowable<List<Book>> getAllBooks();


    // TODO: 11/28/18 Delete table

}
