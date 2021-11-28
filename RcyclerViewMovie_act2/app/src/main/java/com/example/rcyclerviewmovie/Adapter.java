package com.example.rcyclerviewmovie;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcyclerviewmovie.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Movie>moviesList;
    public Adapter(List<Movie> moviesList){
        this.moviesList=moviesList;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie s= moviesList.get(position);
        holder.t.setText(s.getTitle());
        // holder.i.setText(s.getImgURL());
        holder.i.setImageResource(s.getImgURL());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView t;
        public ImageView i;
        public MyViewHolder(View view) {
            super(view);
            t= view.findViewById(R.id.title);
            i= view.findViewById(R.id.imgURL);

        }

    }
}
