package com.example.user.amazonbooksexample.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.user.amazonbooksexample.model.data.remote.RemoteDataSource;
import com.example.user.amazonbooksexample.utils.CacheManager;

import java.util.List;

public class BookRepository {

    private static final String TAG = BookRepository.class.getSimpleName()+ "_TAG";
    private MutableLiveData<List<Book>> listLiveData;
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;
    private CacheManager cacheManager;

    public BookRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, CacheManager cacheManager) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.cacheManager = cacheManager;

        listLiveData = new MutableLiveData<>();

    }

    public LiveData<List<Book>> getBooks() {

        if (cacheManager.isCacheDirty()) {
            cacheManager.saveTime(System.currentTimeMillis());
            remoteDataSource.getBooks(new DataCallback() {
                @Override
                public void onSuccess(List<Book> bookList) {
                    listLiveData.setValue(bookList);
                    localDataSource.saveAllBook(bookList);
                    Log.d(TAG, "onSuccess: Loading from remote");

                }

                @Override
                public void onFailure(String error) {

                    Log.d(TAG, "onFailure: " + error);
                }
            });
        }else {
            localDataSource.getBooks(new DataCallback() {
                @Override
                public void onSuccess(List<Book> bookList) {
                    listLiveData.setValue(bookList);
                    Log.d(TAG, "onSuccess: Loading from local");
                }

                @Override
                public void onFailure(String error) {
                    Log.d(TAG, "onFailure: "+ error);
                }
            });
        }


        return listLiveData;
    }


}
