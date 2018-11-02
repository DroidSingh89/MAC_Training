package com.example.user.listlikeviews.view.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.listlikeviews.R;
import com.example.user.listlikeviews.model.Person;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<Person> personList;
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName() + "_TAG";

    RecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        int itemViewLayout = getItemViewLayout(viewType);

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout, viewGroup, false);

        return new ViewHolder(view);
    }

    private int getItemViewLayout(int viewType) {
        int itemViewLayout;

        if (viewType == 1) itemViewLayout = R.layout.person_item_male;
        else itemViewLayout = R.layout.person_item_female;
        return itemViewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person person = personList.get(position);

        viewHolder.tvPersonName.setText(person.getName());
        viewHolder.tvPersonAge.setText(person.getAge());
        viewHolder.tvPersonGender.setText(person.getGender());

        Log.d(TAG, "onBindViewHolder: " + viewHolder.toString());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public int getItemViewType(int position) {

        String gender = personList.get(position).getGender();

        if (gender.equals("Male")) return 1;
        else return 2;

    }

    public void add(Person person) {
        personList.add(person);
        notifyDataSetChanged();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvPersonName;
        private final TextView tvPersonAge;
        private final TextView tvPersonGender;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonGender = itemView.findViewById(R.id.tvPersonGender);

        }
    }
}
