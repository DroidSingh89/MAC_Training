package com.example.user.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 10/3/17.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder>{

    List<Person> personList= new ArrayList<>();
    private static final String TAG = "PersonListAdapterTag";


    public PersonListAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_item1, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Person person = personList.get(position);
        holder.tvPersonName.setText(person.getName());
        holder.tvPersonAge.setText(person.getAge());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvPersonName;
        TextView tvPersonAge;
        public ViewHolder(View itemView) {
            super(itemView);
            tvPersonName = itemView.findViewById(R.id.tvName);
            tvPersonAge = itemView.findViewById(R.id.tvAge);

        }
    }
}
