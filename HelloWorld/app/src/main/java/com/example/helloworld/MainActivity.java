package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.FitWindowsViewGroup;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button x;
    x= findViewById(R.id.btn);

        TextView e1;
        e1=findViewById(R.id.texte1);
        String ch1= e1.getText().toString();

        TextView e2;
        e2=findViewById(R.id.texte2);
        String ch2= e2.getText().toString();

        TextView a;
        a=findViewById(R.id.res);

        RadioButton rb1;
        rb1=findViewById(R.id.r1);
        RadioButton rb2;
        rb2=findViewById(R.id.r2);
        RadioButton rb3;
        rb3=findViewById(R.id.r3);
        RadioButton rb4;
        rb4=findViewById(R.id.r4);



        x.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Integer x1=Integer.parseInt(e1.getText().toString());
           Integer x2=Integer.parseInt(e2.getText().toString());

        if(rb1.isChecked())
          {
              Integer  result= x1+x2;
              a.setText(result.toString());
          }
           else if(rb2.isChecked())
           {
               Integer  result= x1-x2;
               a.setText(result.toString());
           }
        else if(rb3.isChecked())
           {
               Integer result= x1*x2;
               a.setText(result.toString());
           }
        else if(rb4.isChecked())
           {
               Integer  result= x1/x2;
               if(result==0)
               {
                   a.setText("forme indeterminer");
               }
               else
               {  a.setText(result.toString());}
           }
        else  if(ch1.isEmpty())
           {
               Toast.makeText(getApplicationContext(),"Entier 1 est vide",Toast.LENGTH_LONG).show();
           }
           else
           {
               Toast.makeText(getApplicationContext(),"Entier 2 est vide",Toast.LENGTH_LONG).show();
           }





       }
   });

    }

    public void afficher(View view) {
       // Toast.makeText(this,"hello isra ",Toast.LENGTH_LONG).show();
        //android:onClick="afficher"
    }
}