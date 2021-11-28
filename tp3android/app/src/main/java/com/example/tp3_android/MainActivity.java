package com.example.tp3_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tp3-android.RESULT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button x;
        x= findViewById(R.id.btn);



        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), Activity2.class);

                TextView e1=findViewById(R.id.texte1);
                TextView e2=findViewById(R.id.texte2);

                RadioButton rb1=findViewById(R.id.r1);
                RadioButton rb2=findViewById(R.id.r2);

                Integer x1 = Integer.parseInt(e1.getText().toString());
                Integer x2 = Integer.parseInt(e2.getText().toString());

                if (rb1.isChecked()) {
                    Integer result = x1 + x2;
                    intent.putExtra("result", result.toString());//EXTRA_MESSAGE,

                } else if(rb2.isChecked()) {
                    Integer result = x1 - x2;

                    intent.putExtra("result", result.toString());

                }
                else {
                    Toast.makeText(getApplicationContext(), "please select one of the radio button", Toast.LENGTH_SHORT).show();

                }
                startActivity(intent);
            }});
    }
}