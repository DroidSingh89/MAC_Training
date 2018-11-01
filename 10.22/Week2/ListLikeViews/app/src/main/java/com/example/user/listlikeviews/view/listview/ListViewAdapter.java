package com.example.user.listlikeviews.view.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.listlikeviews.R;
import com.example.user.listlikeviews.model.Person;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Person> {

    public ListViewAdapter(@NonNull Context context, int resource, List<Person> personList) {
        super(context, resource, personList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false);

        //bind the textviews
        TextView tvPersonName = convertView.findViewById(R.id.tvPersonName);
        TextView tvPersonAge = convertView.findViewById(R.id.tvPersonAge);
        TextView tvPersonGender = convertView.findViewById(R.id.tvPersonGender);

        Person person = getItem(position);

        if (person != null) {
            tvPersonName.setText(person.getName());
            tvPersonAge.setText(person.getAge());
            tvPersonGender.setText(person.getGender());
        }

        return convertView;
    }



}
