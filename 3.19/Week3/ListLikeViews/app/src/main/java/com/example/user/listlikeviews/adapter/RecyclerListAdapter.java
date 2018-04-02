package com.example.user.listlikeviews.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.listlikeviews.R;
import com.example.user.listlikeviews.model.Animal;

import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {

    List<Animal> animals;

    public RecyclerListAdapter(List<Animal> animals) {
        this.animals = animals;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.simple_recycler_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal animal = animals.get(position);

        //bind the views with data
        if (animal != null) {
            holder.tvName.setText(animal.getName());
            holder.tvWeight.setText(animal.getWeight());
            holder.tvType.setText(animal.getType());
        }

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvWeight;
        private final TextView tvType;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvType = itemView.findViewById(R.id.tvType);
        }
    }
}
