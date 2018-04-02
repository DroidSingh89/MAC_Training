package com.example.user.listlikeviews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.listlikeviews.R;
import com.example.user.listlikeviews.model.Animal;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CustomListAdapter extends ArrayAdapter<Animal> implements View.OnClickListener, AdapterView.OnItemClickListener{

    OnClickInteraction listener;
    public CustomListAdapter(@NonNull Context context, int resource, List<Animal> animalList) {
        super(context, resource, animalList);
        this.listener = (OnClickInteraction) context;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.simple_list_item, null);
            convertView.setOnClickListener(this);

//            View parent1 = (View) convertView.getParent();
//            ListView listView  = (ListView) parent.getParent().getParent();
//            listView.setOnItemClickListener(this);
        }

        //Bind views
        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setOnClickListener(this);
        TextView tvWeight = convertView.findViewById(R.id.tvWeight);
        TextView tvType = convertView.findViewById(R.id.tvType);

        //bind the views with data
        Animal animal = getItem(position);

        if (animal != null) {
            tvName.setText(animal.getName());
            tvWeight.setText(animal.getWeight());
            tvType.setText(animal.getType());
        }
        convertView.setTag(position);

        return convertView;
    }

    @Nullable
    @Override
    public Animal getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public void onClick(View view) {

        View parent = (View) view.getParent();
        ListView listView  = (ListView) parent.getParent();
        int postion = listView.getPositionForView(view);


        switch (view.getId()) {
            case R.id.tvName:
                Log.d(TAG, "onClick: NAME"+ String.valueOf(postion));
                listener.onItemClick(getItem(postion));

                break;
            default:
                Log.d(TAG, "onClick: VIEW");
                break;

        }


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemClick: " + i);
    }

    public interface OnClickInteraction{


        void onItemClick(Animal animal);

    }
}
