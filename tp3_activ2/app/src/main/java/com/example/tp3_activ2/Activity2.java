package com.example.tp3_activ2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Set;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button valid;
        valid= findViewById(R.id.valid);

        Button cancel;
        cancel= findViewById(R.id.cancel);


        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //étape1
                Intent intent2 = getIntent();


                TextView e1=findViewById(R.id.texte1);
                // String ch1= e1.getText().toString();

                TextView e2=findViewById(R.id.texte2);
                // String ch2= e2.getText().toString();

                RadioButton rb1=findViewById(R.id.r1);
                RadioButton rb2=findViewById(R.id.r2);

                Integer x1 = Integer.parseInt(intent2.getStringExtra("v1"));
                Integer x2 = Integer.parseInt(intent2.getStringExtra("v2"));

                Integer  op=Integer.parseInt(intent2.getStringExtra("op"));
                //étape2

                Intent intent3 =new Intent();
                Integer result=0;
              if(op>0)
               {
                   result=  x1+x2;
               }
               else
               {
                   result=  x1-x2;
               }

                intent3.putExtra("result",result.toString());//r
                setResult(MainActivity.RESULT_OK,intent3);
                finish();

            }});
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

    }
}