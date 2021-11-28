package com.example.rcyclerviewmovie;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
public class Movie {

        //Attributes
        private String Name, Year,Genre;
        //Constructor
        public Movie(String n, String p,String g)
        {
            this.Name = n;
            this.Year = p;
            this.Genre= g;
        }
        //Getters
        public String getName() {
            return Name;
        }
        public String getYear() {
             return Year;
        }

         public String getGenre() {
               return Genre;
            }



}
