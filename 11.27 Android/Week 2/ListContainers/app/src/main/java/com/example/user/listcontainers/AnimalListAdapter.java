package com.example.user.listcontainers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.listcontainers.model.Animal;

import java.util.List;

/**
 * Created by singh on 12/6/17.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal> {

    public AnimalListAdapter(@NonNull Context context, int resource, List<Animal> animalList) {
        super(context, resource, animalList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //inflate the view
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.animal_list_item, null);
        }

        //Bind the view in the animal list item with view
        TextView tvAnimalType = convertView.findViewById(R.id.animalType);
        TextView tvAnimalCategory = convertView.findViewById(R.id.animalCategory);
        TextView tvAnimalWeight = convertView.findViewById(R.id.animalWeight);

        //Bind the view items with the data
        Animal animal = getItem(position);
        if(animal!=null){
            tvAnimalType.setText(animal.getType());
            tvAnimalCategory.setText(animal.getCategory());
            tvAnimalWeight.setText(animal.getWeight());
        }


        return convertView;
    }


    @Nullable
    @Override
    public Animal getItem(int position) {
        return super.getItem(position);
    }
}
