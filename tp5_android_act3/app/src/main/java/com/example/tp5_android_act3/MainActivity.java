package com.example.tp5_android_act3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView L=findViewById(R.id.list);
        registerForContextMenu(L);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

                getMenuInflater().inflate(R.menu.menu1, menu);


        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.call:{
               // L.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            }
            case R.id.send:{
              //  L.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            }
            case R.id.edit:{
              //  texte.setTextSize(12);
                break;
            }
            case R.id.delete:{
             //   texte.setTextSize(14);
                break;
            }

        }

        return super.onContextItemSelected(item);
    }
}