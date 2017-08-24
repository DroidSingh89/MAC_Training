package com.example.user.myapplication234234;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by singh on 8/24/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    List<Person> persons = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(List<Person> persons) {
        this.persons = persons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewAge, textViewGender;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textviewName);
            textViewAge = itemView.findViewById(R.id.textviewAge);
            textViewGender = itemView.findViewById(R.id.textviewGender);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Person person = persons.get(position);
        holder.textViewName.setText(person.getName());
        holder.textViewAge.setText(String.valueOf(person.getAge()));
        holder.textViewGender.setText(person.getGender());

        Log.d(TAG, "onBindViewHolder: "+ person.getImageUrl());
        Glide.with(context).load(person.getImageUrl()).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return persons.size();

    }

}
