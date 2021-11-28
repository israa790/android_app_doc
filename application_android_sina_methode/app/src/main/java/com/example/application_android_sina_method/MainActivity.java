package com.example.application_android_sina_method;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.application_android_sina_methode.Activity2;
import com.example.application_android_sina_methode.R;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText inp1;
        EditText inp2;
        RadioGroup radioGroup;
        Button calcBtn;
        TextView resText;
        inp1 = findViewById(R.id.texte1);
        inp2 = findViewById(R.id.texte2);
        radioGroup = findViewById(R.id.radio);
        calcBtn = findViewById(R.id.r1);
        TextView resText3 = findViewById(R.id.res);

        calcBtn.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if(selectedId == -1 || inp1.getText().toString().isEmpty() || inp1.getText().toString().isEmpty()) return;

            RadioButton selectedBtn = findViewById(selectedId);

            Intent myIntent = new Intent(getApplicationContext(), Activity2.class);
            myIntent.putExtra("int1", inp1.getText().toString());
            myIntent.putExtra("int2", inp2.getText().toString());
            myIntent.putExtra("operation", selectedBtn.getText().toString());

            startActivityForResult(myIntent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView resText3 = findViewById(R.id.res);
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    resText3.setText(data.getStringExtra("res"));
                } else {

                    resText3.setText("Operation cancelled!");
                }
                break;
            default:
                break;
        }
    }
}
