package com.example.user.listviewrecyclerview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by singh on 9/12/17.
 */

public class CustomVHListAdapter extends ArrayAdapter<Person> {


    public class ViewHolder {
        private TextView tvPersonName;
        private TextView tvPersonAge;
        private TextView tvPersonGender;
        private TextView tvPersonHeight;
    }


    public class ViewHolder1 {
        private TextView tvPersonName;
        private TextView tvPersonAge;

    }

    public CustomVHListAdapter(@NonNull Context context,
                               @LayoutRes int resource,
                               @NonNull List<Person> personList) {
        super(context, resource, personList);

    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        Person person = getItem(position);

        if (person.getAge() > 40)
            return 1;
        else return 2;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        int viewType = getItemViewType(position);

        //inflate the view
        if (view == null) {

            switch (viewType){
                case 1:
                    view = LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.custom_list_item, null);

                    ViewHolder holder = new ViewHolder();
                    holder.tvPersonName = view.findViewById(R.id.tvPersonName);
                    holder.tvPersonAge = view.findViewById(R.id.tvPersonAge);
                    holder.tvPersonGender = view.findViewById(R.id.tvPersonGender);
                    holder.tvPersonHeight = view.findViewById(R.id.tvPersonHeight);

                    view.setTag(holder);
                    break;


                case 2:
                    view = LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.custom_list_item, null);

                    ViewHolder1 holder1 = new ViewHolder1();
                    holder1.tvPersonName = view.findViewById(R.id.tvPersonName);
                    holder1.tvPersonAge = view.findViewById(R.id.tvPersonAge);
                    view.setTag(holder1);

                    break;

            }


        }

        //bind the views in the custom item layout

        ViewHolder holder = new ViewHolder();
        holder.tvPersonName = view.findViewById(R.id.tvPersonName);
        holder.tvPersonAge = view.findViewById(R.id.tvPersonAge);
        holder.tvPersonGender = view.findViewById(R.id.tvPersonGender);
        holder.tvPersonHeight = view.findViewById(R.id.tvPersonHeight);

        //set data for each view using the personlist
        Person person = getItem(position);
        if (person != null) {
            holder.tvPersonName.setText(person.getName());
            holder.tvPersonGender.setText(person.getGender());
            holder.tvPersonAge.setText(String.valueOf(person.getAge()));
            holder.tvPersonHeight.setText(String.valueOf(person.getHeight()));
            view.setTag(holder);

        }
        return view;

    }
}
