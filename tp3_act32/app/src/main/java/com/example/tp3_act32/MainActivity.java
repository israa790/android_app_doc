package com.example.tp3_act32;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL =1;
    EditText txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button x= findViewById(R.id.btn1);
        Button x2=findViewById(R.id.btn2);
        Button x3=findViewById(R.id.btn3);
        Button x4=findViewById(R.id.btn4);
        Button x5=findViewById(R.id.btn5);

        txt=findViewById(R.id.texteEdit);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });


        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= txt.getText().toString();
                //Intent contact=new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts/"+site));
              //  startActivity(contact);
                Intent appel =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+s));
                startActivity(appel);
            }
        });

        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site= txt.getText().toString();

                Intent web= new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+site));
                startActivity(web);

            }
        });

        x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent manager= new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                startActivity(manager);

            }
        });

        x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);

            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
            else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void makePhoneCall() {
        String phone= txt.getText().toString();
        if(phone.isEmpty())
        { Toast.makeText(getApplicationContext(),"please enter phone number here !",Toast.LENGTH_LONG).show(); }
        else{
            if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                Intent appel =new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
                startActivity(appel);
            }
        }
    }
}