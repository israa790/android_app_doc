package com.example.tp_android_5;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Contact> myList;
    public Adapter(List<Contact> x) {

        this.myList = x;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact s= myList.get(position);
        holder.n.setText(s.getName());
        holder.p.setText(s.getPhone());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView n, p;
        public MyViewHolder(View view) {
            super(view);
            n= view.findViewById(R.id.name);
            p= view.findViewById(R.id.phone);
        }

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}