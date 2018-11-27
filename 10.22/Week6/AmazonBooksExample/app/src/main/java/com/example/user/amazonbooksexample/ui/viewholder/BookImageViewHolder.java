package com.example.user.amazonbooksexample.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.user.amazonbooksexample.R;

public class BookImageViewHolder extends RecyclerView.ViewHolder {

    ImageView ivBook;
    public BookImageViewHolder(@NonNull View itemView) {
        super(itemView);

        ivBook = itemView.findViewById(R.id.ivBook);
    }
}
