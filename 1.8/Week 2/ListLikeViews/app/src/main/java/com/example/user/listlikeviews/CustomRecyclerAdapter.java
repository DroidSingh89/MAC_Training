package com.example.user.listlikeviews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.listlikeviews.model.Person;

import java.util.List;

/**
 * Created by singh on 1/18/18.
 */

public class CustomRecyclerAdapter  extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>{


    private static final String TAG = CustomRecyclerAdapter.class.getSimpleName();

    List<Person> personList;

    public CustomRecyclerAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        //inflate the view holder with custom layout resource
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_recycler_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + holder.toString());
        //bind the view with the person
        Person person = personList.get(position);

        holder.tvPersonName.setText(person.getName());
        holder.tvPersonAge.setText(person.getAge());
        holder.tvPersonGender.setText(person.getGender());


    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        private final TextView tvPersonName;
        private final TextView tvPersonAge;
        private final TextView tvPersonGender;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonGender = itemView.findViewById(R.id.tvPersonGender);
            tvPersonName.setOnClickListener(this);
            tvPersonAge.setOnClickListener(this);
            tvPersonGender.setOnClickListener(this);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case -1:
                    Log.d(TAG, "onClick: ItemView");
                    break;
                case R.id.tvPersonName:
                    Log.d(TAG, "onClick: PersonName");
                    break;
            }
        }
    }
}
