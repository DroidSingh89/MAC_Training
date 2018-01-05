package com.example.user.listviewrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    /**
     * Created by singh on 9/13/17.
     */

    List<Person> personList = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPersonName;
        private final TextView tvPersonAge;
        private final TextView tvPersonGender;
        private final TextView tvPersonHeight;

        public ViewHolder(View itemView) {
            super(itemView);
            //bind the views in the custom item layout
            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonGender = itemView.findViewById(R.id.tvPersonGender);
            tvPersonHeight = itemView.findViewById(R.id.tvPersonHeight);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.rv_list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        Person person = personList.get(position);

        holder.tvPersonName.setText(person.getName());
        holder.tvPersonGender.setText(person.getGender());
        holder.tvPersonAge.setText(String.valueOf(person.getAge()));
        holder.tvPersonHeight.setText(String.valueOf(person.getHeight()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "asda", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");


        return personList.size();
    }
}
