package com.example.user.amazonbooksexample.model.data.remote;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.utils.BookObserver;
import com.example.user.amazonbooksexample.model.data.DataCallback;
import com.example.user.amazonbooksexample.utils.NetworkAPI;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createClient() {

        return new Retrofit.Builder()
                .baseUrl(NetworkAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    private Observable<List<Book>> getBooksObs(){
        return createClient().create(RemoteService.class).getBooks();
    }


    public void getBooks(final DataCallback callback) {

        getBooksObs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BookObserver.addCallback(new BookObserver.Callback() {
                    @Override
                    public void onNext(List<Book> books) {
                        callback.onSuccess(books);
                    }

                    @Override
                    public void onError(String error) {
                        callback.onFailure(error);
                    }
                }));



    }


}
