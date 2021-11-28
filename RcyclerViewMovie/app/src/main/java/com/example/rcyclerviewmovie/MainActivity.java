package com.example.rcyclerviewmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();
    private Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager LM = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(LM);

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure",
                "2015");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens",
                "Action", "2015");
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
        movie = new Movie("The Martian", "Science Fiction & Fantasy",
                "2015");
        movieList.add(movie);
        movie = new Movie("Mission: Impossible Rogue Nation", "Action",
                "2015");
        movieList.add(movie);
        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);
        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);
        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);
        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);
        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);
        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);
        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure",
                "1981");
        movieList.add(movie);
        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);
        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
        myAdapter = new Adapter(movieList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie =movieList.get(position);
                Toast.makeText(getApplicationContext(),movie.getName()+" is selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}