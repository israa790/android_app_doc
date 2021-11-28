package com.example.recyclerview_ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private final List<ItemAdapter> mList = new ArrayList<>();
    private ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addList();
        adapter();
    }
    private void init(){
        mRecycleview = findViewById(R.id.listView);
    }
    private void addList(){
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("Tomato");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("butter");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("oranges");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("mango");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("strawberry");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("Apple");
        mList.add(itemAdapter);
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.ic_launcher_background);
        itemAdapter.setText("guava fruit");
        mList.add(itemAdapter);
    }
    private void adapter(){
        mAdapter = new ListAdapter(mList, this);
        mRecycleview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}