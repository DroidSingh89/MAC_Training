package com.example.user.savingdata;

import android.content.Context;
import android.support.annotation.IdRes;
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
 * Created by singh on 10/2/17.
 */

public class PersonListAdapter extends ArrayAdapter<Person> {

    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, List<Person> personList) {
        super(context, resource, personList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        //inflate the view with the custom layout xml
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null);
        }

        //bind all the views
        TextView tvPersonName = view.findViewById(R.id.tvPersonName);
        TextView tvPersonGender = view.findViewById(R.id.tvPersonGender);
        TextView tvPersonAge = view.findViewById(R.id.tvPersonAge);

        //set the value to the binded views
        Person person = getItem(position);
        tvPersonName.setText(person.getName());
        tvPersonGender.setText(person.getGender());
        tvPersonAge.setText(person.getAge());

        return view;
    }
}
