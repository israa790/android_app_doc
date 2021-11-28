package com.example.tp_android_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> stList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager LM = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(LM);

        Contact s= new Contact("Walt Disney", "123456");
        stList.add(s);

        Contact s2 = new Contact("Bill Gates", "789456");
        stList.add(s2);

        myAdapter = new Adapter(stList);
        recyclerView.setAdapter(myAdapter);

    }}