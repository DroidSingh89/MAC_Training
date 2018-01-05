package com.example.singh.listreccardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 6/27/17.
 */

public class ContactListAdapter  extends RecyclerView.Adapter<ContactListAdapter.ViewHolder>{


    private static final String TAG = "ContactListAdapterTAG";
    List<Contact> contactList = new ArrayList<>();
    Context context;

    public ContactListAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvContactName;
        TextView tvContactPhone;
        LinearLayout linearLayout;



        public ViewHolder(View itemView) {
            super(itemView);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvContactPhone = (TextView) itemView.findViewById(R.id.tvContactPhone);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.llContact);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Contact contact = contactList.get(position);

        Log.d(TAG, "onBindViewHolder: " + contact.getName() + ":" + position);
        holder.tvContactName.setText(contact.getName());
        holder.tvContactPhone.setText(contact.getPhone());

        holder.tvContactPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, contact.getPhone(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Whole item", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

}
