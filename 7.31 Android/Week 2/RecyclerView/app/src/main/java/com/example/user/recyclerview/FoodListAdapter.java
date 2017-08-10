package com.example.user.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {


    private static final String TAG = "FoodListAdapter";
    List<Food> foodList = new ArrayList<>();
    Context context;

    public FoodListAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDishName;
        TextView tvCalories;
        TextView tvPrice;
        TextView tvRating;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDishName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvRating = (TextView) itemView.findViewById(R.id.tvFoodRating);
            tvPrice = (TextView) itemView.findViewById(R.id.tvFoodPrice);
            tvCalories = (TextView) itemView.findViewById(R.id.tvFoodCalories);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.foodlist_item, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //adding animation to the itemviews
        if(position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setInterpolator(context, android.R.interpolator.bounce);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }


        Log.d(TAG, "onBindViewHolder: " + position);
        final Food food = foodList.get(position);
        holder.tvDishName.setText(food.getDishName());
        holder.tvCalories.setText(String.valueOf(food.getCalories()));
        holder.tvRating.setText(String.valueOf(food.getRating()));
        holder.tvPrice.setText(String.valueOf(food.getPrice()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("food", food);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
