package com.example.tp3_activ2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tp3-android.RESULT";
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
                // String ch1= e1.getText().toString();

                TextView e2=findViewById(R.id.texte2);
                // String ch2= e2.getText().toString();

                RadioButton rb1=findViewById(R.id.r1);
                RadioButton rb2=findViewById(R.id.r2);

               // Integer x1 = Integer.parseInt(e1.getText().toString());
              //  Integer x2 = Integer.parseInt(e2.getText().toString());
                intent.putExtra("v1",e1.getText().toString());
                intent.putExtra("v2",e2.getText().toString());

                if (rb1.isChecked()) {
                    intent.putExtra("op","1");
                } else if(rb2.isChecked()) {

                    intent.putExtra("op","-1");
                }

                startActivityForResult(intent,120);
            }});


    }
    @Override
    public void onActivityResult(int requestCode , int resultCode, Intent data ) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120) {
            // get String data from Intent
            if (resultCode == RESULT_OK) {
                String returnString = data.getStringExtra("result");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.res);
                textView.setText(returnString);
            }

        if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
            TextView textView = (TextView) findViewById(R.id.res);
            textView.setText("operation canceled");
        }
        }
    }
    //onActivityResult
}