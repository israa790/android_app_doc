package com.example.tp_android_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

        public class Contact {
            //Attributes
            private String Name, Phone;
            //Constructor
            public Contact(String n, String p)
            {
                this.Name = n;
                this.Phone = p;
            }
            //Getters
            public String getName() {
                return Name;
            }
            public String getPhone() {
                return Phone;
            }
        }
