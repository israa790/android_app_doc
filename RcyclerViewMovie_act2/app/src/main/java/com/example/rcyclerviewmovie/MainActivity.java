package com.example.rcyclerviewmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();
    private Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      //  StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);recyclerView.setLayoutManager(staggeredGridLayoutManager);
        LinearLayoutManager LM = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);recyclerView.setLayoutManager(LM);

//Déclaration de la liste
        List<Movie> movieList = new ArrayList<>();
//Ajout des données à la liste
        Movie movie = new Movie("Mad Max: Fury Road",R.drawable.madmax);
        movieList.add(movie);
        movie = new Movie("The Martian", R.drawable.themartian);
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep",R.drawable.shaun);
        movieList.add(movie);
        movie = new Movie("Star Wars",R.drawable.starwars);
        movieList.add(movie);
        movie = new Movie("Inside Out",R.drawable.insideout);
        movieList.add(movie);
        myAdapter = new Adapter(movieList);
        recyclerView.setAdapter((RecyclerView.Adapter) myAdapter);
    }
}