package com.example.td_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=findViewById(R.id.taill);;
        Button btn1 =findViewById(R.id.r1);
        Button btn2 =findViewById(R.id.r2);
        btn1.setOnClickListener (new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Integer l = Integer.parseInt(e1.getText().toString());
            String strRandom = "";
            for (int i = 0; i < l; i++) {
                Random rand = new Random();
                strRandom += (char) (rand.nextInt(26) + 97);
            }
            Intent intent1 = new Intent(getApplicationContext(), Activity2.class);
            intent1.putExtra("result",strRandom);
            startActivity(intent1);
        }
        });

        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
            }
        });

    }
}