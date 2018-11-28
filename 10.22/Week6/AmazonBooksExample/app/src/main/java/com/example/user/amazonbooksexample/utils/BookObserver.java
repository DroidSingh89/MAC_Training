package com.example.user.amazonbooksexample.utils;

import com.example.user.amazonbooksexample.model.Book;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BookObserver implements Observer<List<Book>> {

    Callback callback;

    public static BookObserver addCallback(Callback callback) {

        BookObserver bookObserver = new BookObserver();
        bookObserver.setCallback(callback);
        return bookObserver;
    }

    private void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<Book> books) {

        callback.onNext(books);

    }

    @Override
    public void onError(Throwable e) {

        callback.onError(e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public interface Callback{
        void onNext(List<Book> books);
        void onError(String error);
    }
}
