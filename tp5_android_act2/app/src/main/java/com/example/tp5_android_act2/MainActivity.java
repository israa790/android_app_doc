package com.example.tp5_android_act2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
LinearLayout L;
TextView texte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        L=findViewById(R.id.first);
        texte=findViewById(R.id.texte);
        registerForContextMenu(L);
        registerForContextMenu(findViewById(R.id.second));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {


       switch (v.getId()) {
           case R.id.first:{
                getMenuInflater().inflate(R.menu.menu1, menu);
                break;
            }
           case R.id.second:{
               getMenuInflater().inflate(R.menu.menu2, menu);
               break;
           }
        }

     super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

  switch (item.getItemId()) {
            case R.id.YELLOW:{
                L.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            }
             case R.id.RED:{
                 L.setBackgroundColor(getResources().getColor(R.color.red));
                 break;
             }
             case R.id.s12:{
                 texte.setTextSize(12);
                 break;
              }
             case R.id.s14:{
                 texte.setTextSize(14);
                 break;
             }

        }

    return super.onContextItemSelected(item);
    }

}