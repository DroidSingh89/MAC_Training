package com.example.user.amazonbooksexample.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.user.amazonbooksexample.model.data.remote.RemoteDataSource;

import java.util.List;

public class BookRepository {

    private MutableLiveData<List<Book>> listLiveData;
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public BookRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;

        listLiveData = new MutableLiveData<>();

    }

    public LiveData<List<Book>> getBooks() {

        remoteDataSource.getBooks(new DataCallback() {
            @Override
            public void onSuccess(List<Book> bookList) {
                listLiveData.setValue(bookList);

            }

            @Override
            public void onFailure(String error) {

            }
        });

        return listLiveData;
    }


}
