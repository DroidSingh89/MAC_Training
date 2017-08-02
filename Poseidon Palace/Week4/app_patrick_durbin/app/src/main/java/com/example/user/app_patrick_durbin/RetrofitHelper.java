package com.example.user.app_patrick_durbin;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by singh on 7/31/17.
 */

public class RetrofitHelper {


    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    public static Retrofit create() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


    }


    public static Call<List<Book>> getBooksCall() {

        Retrofit retrofit = create();
        BookService bookService = retrofit.create(BookService.class);
        return bookService.getBooks();

    }

    public static Observable<List<Book>> getBooksObservable(){
        Retrofit retrofit = create();
        BookService bookService = retrofit.create(BookService.class);
        return bookService.getBooksObs();


    }


    interface BookService {

        @GET("books.json")
        Call<List<Book>> getBooks();

        @GET("books.json")
        Observable<List<Book>> getBooksObs();


    }
}
