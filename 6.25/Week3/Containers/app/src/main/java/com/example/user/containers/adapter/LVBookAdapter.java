package com.example.user.containers.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.containers.R;
import com.example.user.containers.model.Book;

import java.util.List;

public class LVBookAdapter extends ArrayAdapter<Book> {



    public LVBookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.book_list_item, null);

        }

//        initialize the views
        TextView tvISBN = convertView.findViewById(R.id.tvISBN);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);

//        bind the views with the data
        Book book = getItem(position);
        if (book != null) {
            tvISBN.setText(book.getISBN());
            tvName.setText(book.getName());
            tvAuthor.setText(book.getAuthor());
        }

        return convertView;

    }
}
