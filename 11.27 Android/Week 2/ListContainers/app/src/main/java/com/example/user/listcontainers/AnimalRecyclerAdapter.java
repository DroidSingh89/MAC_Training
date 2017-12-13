package com.example.user.listcontainers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.listcontainers.model.Animal;

import java.util.List;

/**
 * Created by singh on 12/6/17.
 */

public class AnimalRecyclerAdapter extends RecyclerView.Adapter<AnimalRecyclerAdapter.AnimalViewHolder>
{


    private static final String TAG = "AnimalRecyclerAdpTag";



    List<Animal> animalList;
    Context context;

    public AnimalRecyclerAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view  = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.animal_list_item, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Animal animal = animalList.get(position);

        //Bind the view items with the data
        if(animal!=null){
            holder.tvAnimalType.setText(animal.getType());
            holder.tvAnimalCategory.setText(animal.getCategory());
            holder.tvAnimalWeight.setText(animal.getWeight());
        }




    }


    @Override
    public int getItemCount() {
        return animalList.size();
    }


    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        private final TextView tvAnimalType;
        private final TextView tvAnimalCategory;
        private final TextView tvAnimalWeight;

        public AnimalViewHolder(View itemView) {
            super(itemView);

            //Bind the view in the animal list item with view
            tvAnimalType = itemView.findViewById(R.id.animalType);
            tvAnimalCategory = itemView.findViewById(R.id.animalCategory);
            tvAnimalWeight = itemView.findViewById(R.id.animalWeight);

            //add click listeners
            itemView.setOnClickListener(this);
            tvAnimalType.setOnClickListener(this);
            tvAnimalCategory.setOnClickListener(this);
            tvAnimalWeight.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.animalType:
                    Log.d(TAG, "onClick: Type");
                    break;
                case R.id.animalCategory:
                    Log.d(TAG, "onClick: Category");
                    break;
                case R.id.animalWeight:
                    Log.d(TAG, "onClick: Weight");
                    break;
                case -1:
                    Log.d(TAG, "onClick: Item");

                    break;
            }
            Toast.makeText(context, "ItemClicked check logs", Toast.LENGTH_SHORT).show();

        }
    }
}
