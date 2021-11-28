package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifeCycle extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DSI3", "appel de la méthode onDestroy ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DSI3", "appel de la méthode onResume ") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DSI3", "appel de la méthode onStop") ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.i("DSI3", "appel de la méthode onCreate: ") ;
        Integer i=6;
        Toast.makeText(this,"i="+i,Toast.LENGTH_LONG).show();
    }
}