package com.example.application_android_sina_method;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.application_android_sina_methode.R;

public class Activity2 extends AppCompatActivity {
    Button calculateBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        calculateBtn = findViewById(R.id.valid);
        cancelBtn = findViewById(R.id.cancel);

        calculateBtn.setOnClickListener(v -> {
            Integer int1 = Integer.valueOf(intent.getStringExtra("int1"));
            Integer int2 = Integer.valueOf(intent.getStringExtra("int2"));
            String sign = intent.getStringExtra("operation");

            Integer res = 0;
            if(sign.charAt(0) == '+') {
                res = int1 + int2;
            } else if (sign.charAt(0) == '-') {
                res = int1 - int2;
            }

            Intent resIntent = new Intent();
            resIntent.putExtra("res", res.toString());

            setResult(RESULT_OK, resIntent);
            finish();
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resIntent = new Intent();
                setResult(RESULT_CANCELED, resIntent);
                finish();
            }
        });
    }
}