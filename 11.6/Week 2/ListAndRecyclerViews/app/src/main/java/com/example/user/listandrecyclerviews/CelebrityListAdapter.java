package com.example.user.listandrecyclerviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 11/14/17.
 */

public class CelebrityListAdapter  extends ArrayAdapter<Celebrity>{

    //List<Celebrity> celebrityList = new ArrayList<>();

    public CelebrityListAdapter(@NonNull Context context, int resource, @NonNull List<Celebrity> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.celebrity_list_item, null);


        //bind the views
        TextView tvCelebrityName = convertView.findViewById(R.id.tvCelebName);
        TextView tvCelebrityAge = convertView.findViewById(R.id.tvCelebAge);
        TextView tvCelebrityWeight = convertView.findViewById(R.id.tvCelebWeight);

        //set data to the views
        Celebrity celebrity = getItem(position);
        if(celebrity!= null){
            tvCelebrityName.setText(celebrity.getName());
            tvCelebrityAge.setText("" + celebrity.getAge());
            tvCelebrityWeight.setText("" + celebrity.getWeight());

        }

        return  convertView;

    }
}
