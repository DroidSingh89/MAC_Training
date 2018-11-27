package com.example.user.amazonbooksexample.ui.booklist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.ui.viewholder.BookImageViewHolder;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookImageViewHolder> {

    List<Book> bookList;

    public BookListAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BookImageViewHolder bookImageViewHolder, int i) {



    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


}
