package com.example.tp3_activity3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button x;
        x= findViewById(R.id.btn1);

       // TextView e1=findViewById(R.id.texteEdit);
        // String ch1= e1.getText().toString();

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView e1=findViewById(R.id.texteEdit);
                String ch1= e1.getText().toString();

               // String phone = "+34666777888";
                //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                //startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0987654321"));
                startActivity(intent);
            } });
    }




}