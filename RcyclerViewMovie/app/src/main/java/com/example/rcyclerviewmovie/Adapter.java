package com.example.rcyclerviewmovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> movieList;
    public Adapter(List<Movie> movieList) {

        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie s= movieList.get(position);
        holder.n.setText(s.getName());
        holder.y.setText(s.getYear());
        holder.g.setText(s.getGenre());
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView n, y,g;
        public MyViewHolder(View view) {
            super(view);
            n= view.findViewById(R.id.name);
            y= view.findViewById(R.id.year);
            g= view.findViewById(R.id.genre);
        }

    }
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
