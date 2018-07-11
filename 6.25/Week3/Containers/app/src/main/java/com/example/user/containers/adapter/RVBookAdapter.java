package com.example.user.containers.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.containers.R;
import com.example.user.containers.model.Book;

import java.util.List;

public class RVBookAdapter extends RecyclerView.Adapter<RVBookAdapter.ViewHolder> {

    List<Book> books;
    public static final String TAG = RVBookAdapter.class.getSimpleName() + "_TAG";

    public RVBookAdapter(List<Book> books) {
        this.books = books;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view;
        int currentLayout;


        if (viewType == 1) {
            currentLayout = R.layout.book_list_item_something;
        } else currentLayout = R.layout.book_list_item;

        view = LayoutInflater.from(parent.getContext())
                .inflate(currentLayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: " + holder.toString());

        Book book = books.get(position);

        holder.tvISBN.setText(book.getISBN());
        holder.tvName.setText(book.getName());
        holder.tvAuthor.setText(book.getAuthor());


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public int getItemViewType(int position) {

        Book book = books.get(position);

        if (book.getAuthor().equals("Something"))
            return 1;
        else return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvISBN;
        private final TextView tvName;
        private final TextView tvAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            tvISBN = itemView.findViewById(R.id.tvISBN);
            tvName = itemView.findViewById(R.id.tvName);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);


        }
    }


}
