package com.example.user.containers.model;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataCreator {

    public static List<String> getSimpleStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("String 1");
        strings.add("String 2");
        strings.add("String 3");
        strings.add("String 4");
        return strings;
    }

    public static List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));


        return bookList;
    }

    public static List<Book> getLongBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "Something"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));
        bookList.add(new Book("AKF-234", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("IH-32", "Some Doe Chronicles", "John Doe"));
        bookList.add(new Book("89-234", "John Something Chronicles", "John Doe"));
        bookList.add(new Book("009-332", "Something Chronicles", "John Doe"));


        return bookList;
    }




}
