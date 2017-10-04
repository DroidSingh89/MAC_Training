package com.example.user.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 10/4/17.
 */

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {


    Context context;
    List<Animal> animalList = new ArrayList<>();

    public AnimalListAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }


    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) return 1;
        else return 2;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType){
            case 1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.animal_list_item, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.animal_list_item2, parent, false);
                break;
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Animal animal = animalList.get(position);

        holder.tvAnimalName.setText(animal.getName());
        holder.tvAnimalType.setText(animal.getType());
        holder.tvAnimalWeight.setText(String.valueOf(animal.getWeight()));

        //use glide to load the image in the imageview
        Glide.with(context).load(animal.getImageUrl()).into(holder.ivAnimal);


    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAnimal;
        TextView tvAnimalName;
        TextView tvAnimalType;
        TextView tvAnimalWeight;


        public ViewHolder(View itemView) {
            super(itemView);

            ivAnimal = itemView.findViewById(R.id.ivAnimal);
            tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
            tvAnimalType = itemView.findViewById(R.id.tvAnimalType);
            tvAnimalWeight = itemView.findViewById(R.id.tvAnimalWeight);
        }
    }
}
