package com.example.user.amazonbooksexample.ui.booklist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.amazonbooksexample.R;
import com.example.user.amazonbooksexample.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity implements Observer<List<Book>>{

    private static final String TAG = BookListActivity.class.getSimpleName()+ "_TAG";
    private BookListViewModel viewModel;
    private RecyclerView rvBook;
    private BookListAdapter bookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        viewModel = ViewModelProviders.of(this).get(BookListViewModel.class);
        viewModel.getBooks().observe(this, this);

    }

    private void bindViews() {
        rvBook = findViewById(R.id.rvBooks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        bookListAdapter = new BookListAdapter(new ArrayList<Book>());
        rvBook.setLayoutManager(layoutManager);
        rvBook.setAdapter(bookListAdapter);
    }

    @Override
    public void onChanged(@Nullable List<Book> books) {
        bookListAdapter.addAll(books);

    }
}
