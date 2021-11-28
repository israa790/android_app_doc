package com.example.tp5android_v2_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public boolean onCreateOptionsMenu(Menu menu) {    // Inflate the menu;
        //this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu3, menu);
    return true;}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Title
        switch (item.getItemId()) {
            case R.id.ACT2:{
                Intent int2=new Intent(getApplicationContext(),activite2.class);
                startActivity(int2);
            }
            case R.id.SET:{
                Intent manager= new Intent(Settings.ACTION_SETTINGS);
                startActivity(manager);
            }
            case R.id.LAN:{
                Intent Lang= new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(Lang);
            }
            case R.id.Quit:{
                 finish();
            }
        }


         return super.onOptionsItemSelected(item);
    }


}