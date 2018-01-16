package com.example.user.listlikeviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.listlikeviews.model.Person;

import java.util.List;

/**
 * Created by singh on 1/16/18.
 */

public class CustomListAdapter extends ArrayAdapter<Person> {


    private static final String TAG = CustomListAdapter.class.getSimpleName();


    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<Person> persons) {
        super(context, resource, persons);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.d(TAG, "getView: " + position);
//         inflate the convert view with the custom layout
        if (convertView == null) {
            convertView =
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.custom_list_item, null);
        }

//        bind the views to set data
        TextView tvPersonName = convertView.findViewById(R.id.tvPersonName);
        TextView tvPersonAge = convertView.findViewById(R.id.tvPersonAge);
        TextView tvPersonGender = convertView.findViewById(R.id.tvPersonGender);

//        get person object and populate the views
        Person person =  getItem(position);
        if (person != null) {
            tvPersonName.setText(person.getName());
            tvPersonAge.setText(person.getAge());
            tvPersonGender.setText(person.getGender());
        }

        return convertView;
    }


}
