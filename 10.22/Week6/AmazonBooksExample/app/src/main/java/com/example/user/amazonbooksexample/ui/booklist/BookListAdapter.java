package com.example.user.amazonbooksexample.ui.booklist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.user.amazonbooksexample.R;
import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.ui.viewholder.BookImageViewHolder;
import com.example.user.amazonbooksexample.ui.viewholder.BookViewHolder;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = BookListAdapter.class.getSimpleName()+ "_TAG";
    List<Book> bookList;

    public BookListAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int currentLayout = 0;
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        switch (i) {
            case 0:
                currentLayout = R.layout.item_book_list;
                view = LayoutInflater.from(viewGroup.getContext()).inflate(currentLayout, viewGroup, false);
                viewHolder = new BookViewHolder(view);

                break;
            case 1:
                currentLayout = R.layout.item_book_list_image;
                view = LayoutInflater.from(viewGroup.getContext()).inflate(currentLayout, viewGroup, false);
                viewHolder = new BookImageViewHolder(view);
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Book book = bookList.get(i);
        switch (viewHolder.getItemViewType()) {
            case 0:
                //cast the appropriate viewholder
                BookViewHolder bookViewHolder = (BookViewHolder) viewHolder;

                bookViewHolder.tvTitle.setText(book.getTitle());
                //load the image using Glide asynchronously
                Glide.with(viewHolder.itemView.getContext()).load(book.getImageURL()).into(bookViewHolder.ivBook);
                break;
            case 1:

                //cast the appropriate viewholder
                BookImageViewHolder bookImageViewHolder = (BookImageViewHolder) viewHolder;

                //load the image using Glide asynchronously
                Glide.with(viewHolder.itemView.getContext()).load(book.getImageURL()).into(bookImageViewHolder.ivBook);
                break;

        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (bookList.get(position).getTitle().contains("Harry Potter")) return 0;
        else return 1;

    }

    public void addAll(List<Book> books) {
        this.bookList.clear();
        this.bookList.addAll(books);
        notifyDataSetChanged();
    }
}
