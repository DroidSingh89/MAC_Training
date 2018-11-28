package com.example.user.amazonbooksexample.ui.booklist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.data.BookRepository;
import com.example.user.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.user.amazonbooksexample.model.data.remote.RemoteDataSource;
import com.example.user.amazonbooksexample.utils.CacheManager;

import java.util.List;

public class BookListViewModel extends AndroidViewModel {

    private BookRepository bookRepository;

    public BookListViewModel(@NonNull Application application) {
        super(application);
        bookRepository = new BookRepository(
                new RemoteDataSource(),
                new LocalDataSource(application.getApplicationContext()),
                new CacheManager(application.getApplicationContext()));

    }


    public LiveData<List<Book>> getBooks() {
        return bookRepository.getBooks();
    }

}
