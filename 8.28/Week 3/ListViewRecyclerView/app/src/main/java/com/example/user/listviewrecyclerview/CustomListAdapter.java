package com.example.user.listviewrecyclerview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by singh on 9/12/17.
 */

public class CustomListAdapter extends ArrayAdapter<Person> {



    public CustomListAdapter(@NonNull Context context,
                             @LayoutRes int resource,
                             @NonNull List<Person> personList) {
        super(context, resource, personList);

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        //inflate the view
        if(view==null){
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.custom_list_item, null);
        }

        //bind the views in the custom item layout
        TextView tvPersonName = view.findViewById(R.id.tvPersonName);
        TextView tvPersonAge = view.findViewById(R.id.tvPersonAge);
        TextView tvPersonGender = view.findViewById(R.id.tvPersonGender);
        TextView tvPersonHeight = view.findViewById(R.id.tvPersonHeight);

        //set data for each view using the personlist
        Person person = getItem(position);
        if(person!=null){
            tvPersonName.setText(person.getName());
            tvPersonGender.setText(person.getGender());
            tvPersonAge.setText(String.valueOf(person.getAge()));
            tvPersonHeight.setText(String.valueOf(person.getHeight()));

        }
        return view;

    }
}
