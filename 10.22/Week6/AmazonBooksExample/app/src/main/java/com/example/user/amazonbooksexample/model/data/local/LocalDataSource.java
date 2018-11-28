package com.example.user.amazonbooksexample.model.data.local;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.BookDao;
import com.example.user.amazonbooksexample.model.data.BookDatabase;
import com.example.user.amazonbooksexample.model.data.DataCallback;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource {


    private Context context;
    private BookDatabase bookDatabase;
    private BookDao bookDao;


    public LocalDataSource(Context context) {
        this.context = context;
        bookDatabase = Room.databaseBuilder(context, BookDatabase.class, "Book-Database").build();
        bookDao = bookDatabase.bookDao();

    }


    @SuppressLint("CheckResult")
    public void getBooks(final DataCallback callback) {

        bookDao.getAllBooks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Book>>() {
                    @Override
                    public void accept(List<Book> books) throws Exception {
                        callback.onSuccess(books);
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void saveBook(final Book book) {


        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                bookDao.saveBook(book);
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe();;
    }

    @SuppressLint("CheckResult")
    public void saveAllBook(final List<Book> bookList) {


        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                bookDao.saveAllBook(bookList);
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }


}
