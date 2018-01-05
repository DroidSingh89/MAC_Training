package com.example.user.listandrecyclerviews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 11/14/17.
 */

public class CelebrityRecyclerAdapter extends RecyclerView.Adapter<CelebrityRecyclerAdapter.ViewHolder> {

    private static final String TAG = "CelebrityRcAdapter";
    List<Celebrity> celebrityList = new ArrayList<>();

    public CelebrityRecyclerAdapter(List<Celebrity> celebrityList) {
        this.celebrityList = celebrityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.celebrity_reycler_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        Celebrity celebrity = celebrityList.get(position);
        if(celebrity!= null){
            holder.tvCelebrityName.setText(celebrity.getName());
            holder.tvCelebrityAge.setText("" + celebrity.getAge());
            holder.tvCelebrityWeight.setText("" + celebrity.getWeight());
        }
    }

    @Override
    public int getItemCount() {
        return celebrityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCelebrityName;
        private final TextView tvCelebrityAge;
        private final TextView tvCelebrityWeight;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCelebrityName = itemView.findViewById(R.id.tvCelebName);
            tvCelebrityAge = itemView.findViewById(R.id.tvCelebAge);
            tvCelebrityWeight = itemView.findViewById(R.id.tvCelebWeight);

        }
    }
}
